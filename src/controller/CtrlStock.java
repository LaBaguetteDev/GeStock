package controller;

import entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CtrlStock {

    Stock stock;

    public CtrlStock(ListSaves listSaves) {
        stock = new Stock(listSaves);
    }

    public boolean setStock(Stock s) {
        this.stock.updateStock(s);
        return true;
    }

    public Stock getStock() {
        return stock;
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
        // Initialisation substitut
        Piece substitut = stock.getPiece(idSubstitut);

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
        Piece p = new Piece(id, substitut, nom,
                prixBrut, stockActuel, stockMinimal,
                et, climsList, entreeList, sortiesList, codesList);

        stock.addPiece(p);

    }

    public void supprimerPiece(String id) {
        stock.deletePiece(id);
    }

    public void editerPiece(String idedit, String id, String idSubstitut,
                            String nom, double prixBrut,
                            int stockActuel, int stockMinimal, String etag, String bte,
                            String[] clims, String[] fam, String[] typ,
                            String[] entrees, String[] qteEntree,
                            String[] sorties, String[] qteSorties,
                            String[] pInstallateurs, String[] nInstallateur, String[] oInstallateur,
                            String[] codes, String[] textes) {


        // Initialisation substitut
        Piece substitut = stock.getPiece(idSubstitut);

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
        Piece p = new Piece(id, substitut, nom,
                prixBrut, stockActuel, stockMinimal,
                et, climsList, entreeList, sortiesList, codesList);

        stock.editerPiece(idedit, p);
    }

    public void addEntree(String id, String date, int quantite) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        try {
            Date d = sdf.parse(date);

            for (Piece p : stock.getPieces()) {
                if(p.getId().equals(id)) {
                    p.addEntree(new Entree(d, quantite));
                }
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSortie(String id, String date, int quantite, String nom, String prenom, String orga) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        try {
            Date d = sdf.parse(date);

            for (Piece p : stock.getPieces()) {
                if(p.getId().equals(id)) {
                    p.addSortie(new Sortie(d, new Installateur(prenom, nom, orga), quantite));
                }
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public void trierPieces(String tri) {
        switch(tri) {
            case "1":
                Collections.sort(stock.getPieces(), Comparator.comparing(p -> p.getEtagere().getIdEtagere()));
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

    public List<Piece> chercherPieces(String id, String nom,
                               double prixBrutmin, double prixBrutmax,
                               double prixNetmin, double prixNetmax,
                               String clims, String fam, String typ,
                               String entreesmin, String entreemax,
                               String sortiesmin, String sortiesmax, String codes) {

        List<Piece> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        for (Piece p : stock.getPieces()) {
            if(id.equals(p.getId())) {
                result.add(p);
            } else if(nom.equals(p.getNom())) {
                result.add(p);
            } else if(prixNetmin < p.getPrixNet() && p.getPrixNet() > prixNetmax) {
                result.add(p);
            } else if(prixBrutmin < p.getPrixBrut() && p.getPrixBrut() > prixBrutmax) {
                result.add(p);
            } else if(!clims.isEmpty()) {
                for (Climatiseur c : p.getClimatiseurs()) {
                    if(clims.equalsIgnoreCase(c.getNom())
                            && fam.equalsIgnoreCase(c.getFamille().toString())
                            && typ.equalsIgnoreCase(c.getType().toString())) {
                        result.add(p);
                    }
                }
            } else if(!entreesmin.isEmpty() && !entreemax.isEmpty()) {
                try {
                    for (Entree e : p.getDatesEntree()) {
                        if(sdf.parse(entreesmin).after(e.getDate()) && sdf.parse(entreemax).before(e.getDate())) {
                            result.add(p);
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            } else if(!sortiesmin.isEmpty() && !sortiesmax.isEmpty()) {
                try {
                    for (Sortie e : p.getDatesSorties()) {
                        if (sdf.parse(sortiesmin).after(e.getDate()) && sdf.parse(sortiesmax).before(e.getDate())) {
                            result.add(p);
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else if(!codes.isEmpty()) {
                for (CodeErreur ce : p.getCodesErreurs()) {
                    if(codes.equalsIgnoreCase(ce.getCode())) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    public int nombrePieces() {
        int nb = 0;
        for (Piece p : stock.getPieces()) {
            nb += p.getStockActuel();
        }
        return nb;
    }

    public int nombrePiecesDiff() {
        return stock.getPieces().size();
    }

    public double prixStock() {
        double prix = 0;
        for (Piece p : stock.getPieces()) {
            prix += p.getPrixTotal();
        }
        return prix;
    }
}
