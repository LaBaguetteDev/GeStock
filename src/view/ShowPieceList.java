package view;

import controller.CtrlStock;
import entity.*;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ShowPieceList {

    MainView mainView;
    CtrlStock pieceCtrl;
    public ShowPieceList(MainView mainView) {
        this.mainView = mainView;
        this.pieceCtrl = new CtrlStock();
    }

    public void displayStock() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7s|%-7s\n",
                "Etag", "Bte", "TYPE", "Stk", "Min", "Entree", "Sortie", "PARTS NAME", "PB-MHI", "SUBSTITUT", "NET-MHI", "TOT-MHI");
        for (Piece p : pieceCtrl.afficherPieces()) {

            if(p.getDatesEntree().size() == 0 && p.getDatesSorties().size() == 0) {
                System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                        p.getEtagere().getEtagere(),
                        p.getEtagere().getBoite(),
                        p.getId(),
                        p.getStockActuel(), p.getStockMinimal(),
                        "",
                        "",
                        p.getNom(), p.getPrixBrut(), p.getIdSubstitut(), p.getPrixNet(), p.getPrixTotal());
            } else if(p.getDatesSorties().size() == 0) {
                System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                        p.getEtagere().getEtagere(),
                        p.getEtagere().getBoite(),
                        p.getId(),
                        p.getStockActuel(), p.getStockMinimal(),
                        sdf.format(p.getDatesEntree().get(p.getDatesEntree().size()-1).getDate()),
                        "",
                        p.getNom(), p.getPrixBrut(), p.getIdSubstitut(), p.getPrixNet(), p.getPrixTotal());
            } else if (p.getDatesEntree().size() == 0) {
                System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                        p.getEtagere().getEtagere(),
                        p.getEtagere().getBoite(),
                        p.getId(),
                        p.getStockActuel(), p.getStockMinimal(),
                        "",
                        sdf.format(p.getDatesSorties().get(p.getDatesSorties().size()-1).getDate()),
                        p.getNom(), p.getPrixBrut(), p.getIdSubstitut(), p.getPrixNet(), p.getPrixTotal());
            } else {
                System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7.2f|%-7.2f\n",
                        p.getEtagere().getEtagere(),
                        p.getEtagere().getBoite(),
                        p.getId(),
                        p.getStockActuel(), p.getStockMinimal(),
                        sdf.format(p.getDatesEntree().get(p.getDatesEntree().size()-1).getDate()),
                        sdf.format(p.getDatesSorties().get(p.getDatesSorties().size()-1).getDate()),
                        p.getNom(), p.getPrixBrut(), p.getIdSubstitut(), p.getPrixNet(), p.getPrixTotal());
            }
        }

        displayMenu();
    }

    private void displayMenu() {
        System.out.println("---------------------");
        System.out.println("1. Afficher détails pièce");
        System.out.println("2. Ajouter piece");
        System.out.println("3. Supprimer piece");
        System.out.println("4. Editer piece");
        System.out.println("5. Trier pieces");
        System.out.println("6. Retour au menu principal");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Faites votre choix : ");

        String choice = scanner.nextLine();
        String id; String idSubstitut; String nom;
        Double prixBrut; int stockActuel; int stockMinimal;
        String etag; String bte; String[] clims; String[] fam; String[] typ;
        String[] entrees; String[] qteEntrees;
        String[] sorties; String[] qteSorties;
        String[] pInstallateurs; String[] nInstallateurs; String[] oInstallateurs;
        String[] codes; String[] textes;
        switch (choice) {
            case "1":
                System.out.print("TYPE : ");
                String idd = scanner.nextLine();

                Piece p = pieceCtrl.afficherDetailsPiece(idd);

                System.out.println("TYPE : " + p.getId());
                System.out.println("SUBSTITUT : " + p.getIdSubstitut());
                System.out.println("PARTS NAME : " + p.getNom());
                System.out.println("PB - MHI : " + p.getPrixBrut());
                System.out.println("NET - MHI : " + p.getPrixNet());
                System.out.println("TOT - MHI : " + p.getPrixTotal());
                System.out.println("Stk : " + p.getStockActuel());
                System.out.println("Min : " + p.getStockMinimal());
                System.out.println("Etag : " + p.getEtagere().getEtagere());
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

                displayMenu();

            case "2":
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

                displayStock();
                break;
            case "3":
                System.out.print("TYPE : ");
                String iddd = scanner.nextLine();

                pieceCtrl.supprimerPiece(iddd);
                displayStock();
                break;
            case "4":
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

                pieceCtrl.editPiece(idedit, id, idSubstitut, nom,
                        prixBrut, stockActuel,
                        stockMinimal, etag, bte,
                        clims, fam, typ,
                        entrees, qteEntrees, sorties, qteSorties ,
                        pInstallateurs, nInstallateurs, oInstallateurs, codes, textes);

                displayStock();

                break;
            case "5":
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
            case "6":
                mainView.showMenu();
                break;
        }
    }
}
