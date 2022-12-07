package entity;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String id;
    private String idSubstitut;
    private String nom;
    private double prixBrut;
    private double prixNet;
    private double prixTotal;
    private int stockActuel;
    private int stockMinimal;

    private Etagere etagere;
    private List<Climatiseur> climatiseurs = new ArrayList<>();
    private List<Entree> datesEntree = new ArrayList<>();
    private List<Sortie> datesSorties = new ArrayList<>();
    private List<CodeErreur> codesErreurs = new ArrayList<>();

    public Piece(String id, String idSubstitut, String nom,
                 double prixBrut,
                 int stockActuel, int stockMinimal, Etagere etagere,
                 List<Climatiseur> climatiseurs, List<Entree> datesEntree,
                 List<Sortie> datesSorties, List<CodeErreur> codesErreurs) {
        this.id = id;
        this.idSubstitut = idSubstitut;
        this.nom = nom;
        this.prixBrut = prixBrut;
        this.prixNet = prixBrut * 0.65;
        this.stockActuel = stockActuel;
        this.prixTotal = prixNet * this.stockActuel;
        this.stockMinimal = stockMinimal;
        this.etagere = etagere;
        this.climatiseurs = climatiseurs;
        this.datesEntree = datesEntree;
        this.datesSorties = datesSorties;
        this.codesErreurs = codesErreurs;
    }

    public String getId() {
        return id;
    }

    public String getIdSubstitut() {
        return idSubstitut;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixBrut() {
        return prixBrut;
    }

    public double getPrixNet() {
        return prixNet;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public int getStockActuel() {
        return stockActuel;
    }

    public int getStockMinimal() {
        return stockMinimal;
    }

    public Etagere getEtagere() {
        return etagere;
    }

    public List<Climatiseur> getClimatiseurs() {
        return climatiseurs;
    }

    public List<Entree> getDatesEntree() {
        return datesEntree;
    }

    public List<Sortie> getDatesSorties() {
        return datesSorties;
    }

    public List<CodeErreur> getCodesErreurs() {
        return codesErreurs;
    }

    public void addEntree(Entree e) {
        datesEntree.add(e);
        stockActuel += e.getQuantite();
    }

    public void addSortie(Sortie s) {
        datesSorties.add(s);
        stockActuel -= s.getQuantite();
    }
}
