package view;

import controller.CtrlStock;
import entity.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ShowPieceList {

    MainView mainView;
    CtrlStock pieceCtrl;
    Scanner scanner = new Scanner(System.in);
    public ShowPieceList(MainView mainView, CtrlStock ctrlStock) {
        this.mainView = mainView;
        this.pieceCtrl = ctrlStock;
    }

    public void displayStock() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7s|%-7s\n",
                "Etag", "Bte", "TYPE", "Stk", "Min", "Entree", "Sortie", "PARTS NAME", "PB-MHI", "SUBSTITUT", "NET-MHI", "TOT-MHI");
        for (Piece p : pieceCtrl.afficherPieces()) {

            displayPieces(sdf, p);
        }

        displayMenu();
    }

    static void displayPieces(SimpleDateFormat sdf, Piece p) {
        if(p.getDatesEntree().size() == 0 && p.getDatesSorties().size() == 0) {
            System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                    p.getEtagere().getIdEtagere(),
                    p.getEtagere().getBoite(),
                    p.getId(),
                    p.getStockActuel(), p.getStockMinimal(),
                    "",
                    "",
                    p.getNom(), p.getPrixBrut(), p.getSubstitut() == null ? "" : p.getSubstitut().getNom(), p.getPrixNet(), p.getPrixTotal());
        } else if(p.getDatesSorties().size() == 0) {
            System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                    p.getEtagere().getIdEtagere(),
                    p.getEtagere().getBoite(),
                    p.getId(),
                    p.getStockActuel(), p.getStockMinimal(),
                    sdf.format(p.getDatesEntree().get(p.getDatesEntree().size()-1).getDate()),
                    "",
                    p.getNom(), p.getPrixBrut(), p.getSubstitut() == null ? "" : p.getSubstitut().getNom(), p.getPrixNet(), p.getPrixTotal());
        } else if (p.getDatesEntree().size() == 0) {
            System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                    p.getEtagere().getIdEtagere(),
                    p.getEtagere().getBoite(),
                    p.getId(),
                    p.getStockActuel(), p.getStockMinimal(),
                    "",
                    sdf.format(p.getDatesSorties().get(p.getDatesSorties().size()-1).getDate()),
                    p.getNom(), p.getPrixBrut(), p.getSubstitut() == null ? "" : p.getSubstitut().getNom(), p.getPrixNet(), p.getPrixTotal());
        } else {
            System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                    p.getEtagere().getIdEtagere(),
                    p.getEtagere().getBoite(),
                    p.getId(),
                    p.getStockActuel(), p.getStockMinimal(),
                    sdf.format(p.getDatesEntree().get(p.getDatesEntree().size()-1).getDate()),
                    sdf.format(p.getDatesSorties().get(p.getDatesSorties().size()-1).getDate()),
                    p.getNom(), p.getPrixBrut(), p.getSubstitut() == null ? "" : p.getSubstitut().getNom(), p.getPrixNet(), p.getPrixTotal());
        }
    }

    private void displayMenu() {
        System.out.println("---------------------");
        System.out.println("1. Afficher détails pièce");
        System.out.println("2. Ajouter piece");
        System.out.println("3. Supprimer piece");
        System.out.println("4. Editer piece");
        System.out.println("5. Ajouter entrée");
        System.out.println("6. Ajouter sortie");
        System.out.println("7. Trier pieces");
        System.out.println("8. Retour au menu principal");

        System.out.print("Faites votre choix : ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                displayPiece();

                displayMenu();

            case "2":
                addPiece();

                displayStock();
                break;
            case "3":
                deletePiece();
                displayStock();
                break;
            case "4":
                editPiece();

                displayStock();

                break;

            case "5":
                addEntree();

                displayStock();
                break;
            case "6":
                addSortie();

                displayStock();

                break;
            case "7":
                System.out.println("Trier en fonction de :");
                System.out.println("1. Etag");
                System.out.println("2. TYPE");
                System.out.println("3. PARTS NAME");
                System.out.println("4. TOT-MHI");
                System.out.print("Faites votre choix : ");
                choice = scanner.nextLine();

                pieceCtrl.trierPieces(choice);
                displayStock();

                break;
            case "8":
                mainView.showMenu();
                break;
        }
    }

    private void addSortie() {
        String idedit;
        System.out.println("TYPE a editer : ");
        idedit = scanner.nextLine();

        System.out.println("Sortie : ");
        String sortie = scanner.nextLine();

        System.out.println("qte Sortie : ");
        int qteSortie = Integer.parseInt(scanner.nextLine());

        System.out.println("Prenom installateurs : ");
        String pInstallateur = scanner.nextLine();

        System.out.println("Nom installateurs : ");
        String nInstallateur = scanner.nextLine();

        System.out.println("Orga installateurs : ");
        String oInstallateur = scanner.nextLine();

        pieceCtrl.addSortie(idedit, sortie, qteSortie, nInstallateur, pInstallateur, oInstallateur);
    }

    private void addEntree() {
        String idedit;
        System.out.println("TYPE a editer : ");
        idedit = scanner.nextLine();

        System.out.println("Entree : ");
        String entree = scanner.nextLine();

        System.out.println("qte Entree : ");
        int qteEntree = Integer.parseInt(scanner.nextLine());

        pieceCtrl.addEntree(idedit, entree, qteEntree);
    }

    private void editPiece() {
        double prixBrut;
        String bte;
        String[] oInstallateurs;
        String[] clims;
        int stockActuel;
        String id;
        String[] typ;
        String[] entrees;
        String[] fam;
        String[] qteSorties;
        int stockMinimal;
        String etag;
        String[] sorties;
        String idSubstitut;
        String[] codes;
        String[] textes;
        String[] nInstallateurs;
        String[] qteEntrees;
        String nom;
        String[] pInstallateurs;
        System.out.println("TYPE a editer : ");
        String idedit = scanner.nextLine();

        System.out.print("TYPE : ");
        id = scanner.nextLine();

        System.out.println("SUBSTITUT : ");
        idSubstitut = scanner.nextLine();

        System.out.println("PARTS NAME : ");
        nom = scanner.nextLine();

        System.out.println("PB-MHI : ");
        prixBrut = Double.parseDouble(scanner.nextLine());

        System.out.println("Stk : ");
        stockActuel = Integer.parseInt(scanner.nextLine());

        System.out.println("Min : ");
        stockMinimal = Integer.parseInt(scanner.nextLine());

        System.out.println("Etag : ");
        etag = scanner.nextLine();

        System.out.println("Bte: ");
        bte = scanner.nextLine();

        System.out.println("Climatiseurs : ");
        clims = scanner.nextLine().split(" ");

        System.out.println("Famille Climatiseurs : ");
        fam = scanner.nextLine().split(" ");

        System.out.println("Types Climatiseurs : ");
        typ = scanner.nextLine().split(" ");

        System.out.println("Entrees : ");
        entrees = scanner.nextLine().split(" ");

        System.out.println("qte Entrees : ");
        qteEntrees = scanner.nextLine().split(" ");

        System.out.println("Sorties : ");
        sorties = scanner.nextLine().split(" ");

        System.out.println("qte Sorties : ");
        qteSorties = scanner.nextLine().split(" ");

        System.out.println("Prenom installateurs : ");
        pInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Nom installateurs : ");
        nInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Orga installateurs : ");
        oInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Codes Erreurs : ");
        codes = scanner.nextLine().split(" ");

        System.out.println("Textes Erreurs : ");
        textes = scanner.nextLine().split(" ");

        pieceCtrl.editerPiece(idedit, id, idSubstitut, nom,
                prixBrut, stockActuel,
                stockMinimal, etag, bte,
                clims, fam, typ,
                entrees, qteEntrees, sorties, qteSorties ,
                pInstallateurs, nInstallateurs, oInstallateurs, codes, textes);
    }

    private void deletePiece() {
        System.out.print("TYPE : ");
        String iddd = scanner.nextLine();

        pieceCtrl.supprimerPiece(iddd);
    }

    private void addPiece() {
        String[] clims;
        String[] sorties;
        String[] typ;
        String etag;
        String[] nInstallateurs;
        String idSubstitut;
        String[] entrees;
        String[] textes;
        String[] oInstallateurs;
        double prixBrut;
        String id;
        String bte;
        String[] pInstallateurs;
        String[] fam;
        int stockMinimal;
        String[] codes;
        String nom;
        String[] qteSorties;
        int stockActuel;
        String[] qteEntrees;
        System.out.print("TYPE : ");
        id = scanner.nextLine();

        System.out.println("SUBSTITUT : ");
        idSubstitut = scanner.nextLine();

        System.out.println("PARTS NAME : ");
        nom = scanner.nextLine();

        System.out.println("PB-MHI : ");
        prixBrut = Double.parseDouble(scanner.nextLine());

        System.out.println("Stk : ");
        stockActuel = Integer.parseInt(scanner.nextLine());

        System.out.println("Min : ");
        stockMinimal = Integer.parseInt(scanner.nextLine());

        System.out.println("Etag : ");
        etag = scanner.nextLine();

        System.out.println("Bte: ");
        bte = scanner.nextLine();

        System.out.println("Climatiseurs : ");
        clims = scanner.nextLine().split(" ");

        System.out.println("Famille Climatiseurs : ");
        fam = scanner.nextLine().split(" ");

        System.out.println("Types Climatiseurs : ");
        typ = scanner.nextLine().split(" ");

        System.out.println("Entrees : ");
        entrees = scanner.nextLine().split(" ");

        System.out.println("qte Entrees : ");
        qteEntrees = scanner.nextLine().split(" ");

        System.out.println("Sorties : ");
        sorties = scanner.nextLine().split(" ");

        System.out.println("qte Sorties : ");
        qteSorties = scanner.nextLine().split(" ");

        System.out.println("Prenom installateurs : ");
        pInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Nom installateurs : ");
        nInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Orga installateurs : ");
        oInstallateurs = scanner.nextLine().split(" ");

        System.out.println("Codes Erreurs : ");
        codes = scanner.nextLine().split(" ");

        System.out.println("Textes Erreurs : ");
        textes = scanner.nextLine().split(" ");

        pieceCtrl.ajouterPiece(id, idSubstitut, nom,
                prixBrut, stockActuel,
                stockMinimal, etag, bte,
                clims, fam, typ,
                entrees, qteEntrees, sorties, qteSorties ,
                pInstallateurs, nInstallateurs, oInstallateurs, codes, textes);
    }

    private void displayPiece() {
        System.out.print("TYPE : ");
        String idd = scanner.nextLine();

        Piece p = pieceCtrl.afficherDetailsPiece(idd);

        System.out.println("TYPE : " + p.getId());
        System.out.println("SUBSTITUT : " + p.getSubstitut() == null ? "" : p.getSubstitut().getNom());
        System.out.println("PARTS NAME : " + p.getNom());
        System.out.println("PB - MHI : " + p.getPrixBrut());
        System.out.println("NET - MHI : " + p.getPrixNet());
        System.out.println("TOT - MHI : " + p.getPrixTotal());
        System.out.println("Stk : " + p.getStockActuel());
        System.out.println("Min : " + p.getStockMinimal());
        System.out.println("Etag : " + p.getEtagere().getIdEtagere());
        System.out.println("Bte : " + p.getEtagere().getBoite());
        System.out.println("Climatiseurs :");
        for (Climatiseur c : p.getClimatiseurs()) {
            System.out.println("- " + c.getNom() + " / " + c.getType() + " / " + c.getFamille());
        }

        System.out.println("Entrees : ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        for (Entree e : p.getDatesEntree()) {
            System.out.println("- " + sdf.format(e.getDate()) + " / qte: " + e.getQuantite());
        }

        System.out.println("Sorties : ");
        for (Sortie s : p.getDatesSorties()) {
            Installateur i = s.getInstallateur();
            System.out.println("- " + sdf.format(s.getDate()) + " / qte: " + s.getQuantite() + " / i: " + i.getPrenom() + " " + i.getNom() + "/" + i.getOrganisation());
        }

        System.out.println("Codes d'erreurs : ");
        for (CodeErreur ce : p.getCodesErreurs()) {
            System.out.println("- " + ce.getCode() + " / " + ce.getTexteAffiche());
        }
    }
}
