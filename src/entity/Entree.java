package entity;

import java.util.Date;

public class Entree {
    private Date date;
    private int quantite;

    public Entree(Date date, int quantite) {
        this.date = date;
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantite() {
        return quantite;
    }
}
