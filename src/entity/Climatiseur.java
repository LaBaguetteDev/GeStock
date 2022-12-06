package entity;

public class Climatiseur {
    public enum Famille { INTERIEUR, EXTERIEUR }

    public enum Type { HM, SR, FD, KX }

    private String nom;
    private Famille famille;
    private Type type;

    public Climatiseur(String nom, Famille famille, Type type) {
        this.nom = nom;
        this.famille = famille;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public Famille getFamille() {
        return famille;
    }

    public Type getType() {
        return type;
    }
}
