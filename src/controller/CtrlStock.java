package controller;

import entity.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class CtrlStock {

    Stock stock;

    public CtrlStock() {
        stock = new Stock();
    }

    public List<Piece> afficherPieces() {
        return stock.getPieces();
    }

    public Piece afficherDetailsPiece(String id) {
        return stock.getPiece(id);
    }

    public void ajouterPiece(String id, String idSubstitut,
                             String nom, double prixBrut,
                             int stockActuel, int stockMinimal, String etag, String bte,
                             String[] clims, String[] fam, String[] typ,
                             String[] entrees, String[] qteEntree,
                             String[] sorties, String[] qteSorties,
                             String[] pInstallateurs, String[] nInstallateur, String[] oInstallateur,
                             String[] codes, String[] textes) {
        // Initialisation Etagere
        Etagere et = new Etagere(bte, etag);

        // Initialisation clims
        List<Climatiseur> climsList = new ArrayList<>();
        for(int i = 0; i < clims.length; i++) {
            Climatiseur c = new Climatiseur(clims[i],
                    Climatiseur.Famille.valueOf(fam[i]), Climatiseur.Type.valueOf(typ[i]));

            climsList.add(c);
        }

        // Initialisations dates
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        // Initialisation entrees
        List<Entree> entreeList = new ArrayList<>();
        try {
            for(int i = 0; i < entrees.length; i++) {
                Entree en = new Entree(sdf.parse(entrees[i]), Integer.parseInt(qteEntree[i]));
                entreeList.add(en);
            }
        } catch (Exception ex) {}

        // Initialisation sorties
        List<Sortie> sortiesList = new ArrayList<>();
        try {
            for(int i = 0; i < sorties.length; i++) {
                Installateur in = new Installateur(pInstallateurs[i], nInstallateur[i], oInstallateur[i]);
                Sortie so = new Sortie(sdf.parse(sorties[i]), in, Integer.parseInt(qteSorties[i]));
                sortiesList.add(so);
            }
        } catch (Exception ex) {}

        // Initialisation codes
        List<CodeErreur> codesList = new ArrayList<>();
        for(int i = 0; i < codes.length; i++) {
            CodeErreur ce = new CodeErreur(codes[i], textes[i]);
            codesList.add(ce);
        }

        // Initialisation piece
        Piece p = new Piece(id, idSubstitut, nom,
                prixBrut, stockActuel, stockMinimal,
                et, climsList, entreeList, sortiesList, codesList);

        stock.addPiece(p);

    }

    public void supprimerPiece(String id) {
        stock.deletePiece(id);
    }

    public void editPiece(String idedit, String id, String idSubstitut,
                          String nom, double prixBrut,
                          int stockActuel, int stockMinimal, String etag, String bte,
                          String[] clims, String[] fam, String[] typ,
                          String[] entrees, String[] qteEntree,
                          String[] sorties, String[] qteSorties,
                          String[] pInstallateurs, String[] nInstallateur, String[] oInstallateur,
                          String[] codes, String[] textes) {

        stock.deletePiece(idedit);

        // Initialisation Etagere
        Etagere et = new Etagere(bte, etag);

        // Initialisation clims
        List<Climatiseur> climsList = new ArrayList<>();
        for(int i = 0; i < clims.length; i++) {
            Climatiseur c = new Climatiseur(clims[i],
                    Climatiseur.Famille.valueOf(fam[i]), Climatiseur.Type.valueOf(typ[i]));

            climsList.add(c);
        }

        // Initialisations dates
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        // Initialisation entrees
        List<Entree> entreeList = new ArrayList<>();
        try {
            for(int i = 0; i < entrees.length; i++) {
                Entree en = new Entree(sdf.parse(entrees[i]), Integer.parseInt(qteEntree[i]));
                entreeList.add(en);
            }
        } catch (Exception ex) {}

        // Initialisation sorties
        List<Sortie> sortiesList = new ArrayList<>();
        try {
            for(int i = 0; i < sorties.length; i++) {
                Installateur in = new Installateur(pInstallateurs[i], nInstallateur[i], oInstallateur[i]);
                Sortie so = new Sortie(sdf.parse(sorties[i]), in, Integer.parseInt(qteSorties[i]));
                sortiesList.add(so);
            }
        } catch (Exception ex) {}

        // Initialisation codes
        List<CodeErreur> codesList = new ArrayList<>();
        for(int i = 0; i < codes.length; i++) {
            CodeErreur ce = new CodeErreur(codes[i], textes[i]);
            codesList.add(ce);
        }

        // Initialisation piece
        Piece p = new Piece(id, idSubstitut, nom,
                prixBrut, stockActuel, stockMinimal,
                et, climsList, entreeList, sortiesList, codesList);
    }

    public void trierPieces(String tri) {
        switch(tri) {
            case "1":
                Collections.sort(stock.getPieces(), Comparator.comparing(p -> p.getEtagere().getEtagere()));
                break;
            case "2":
                Collections.sort(stock.getPieces(), Comparator.comparing(Piece::getId));
                break;
            case "3":
                Collections.sort(stock.getPieces(), Comparator.comparing(Piece::getNom));
                break;
            case "4":
                Collections.sort(stock.getPieces(), Comparator.comparing(Piece::getPrixTotal));
                break;
        }
    }
}
