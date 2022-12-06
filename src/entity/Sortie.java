package entity;

import java.util.Date;

public class Sortie {

    private Date date;
    private Installateur installateur;
    private int quantite;

    public Sortie(Date date, Installateur installateur, int quantite) {
        this.date = date;
        this.installateur = installateur;
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public Installateur getInstallateur() {
        return installateur;
    }

    public int getQuantite() {
        return quantite;
    }
}
