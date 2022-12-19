package entity;

public class Etagere {
    private String boite;
    private String idEtagere;

    public Etagere(String boite, String etagere) {
        this.boite = boite;
        this.idEtagere = etagere;
    }

    public String getBoite() {
        return boite;
    }

    public String getIdEtagere() {
        return idEtagere;
    }
}
