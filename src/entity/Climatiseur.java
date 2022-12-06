package entity;

public class Climatiseur {
    public enum Famille { INTERIEUR, EXTERIEUR }

    public enum Type { HM, SR, FD, KX }

    private int id;
    private String nom;
    private Famille famille;
    private Type type;

    public Climatiseur(int id, String nom, Famille famille, Type type) {
        this.id = id;
        this.nom = nom;
        this.famille = famille;
        this.type = type;
    }
}
