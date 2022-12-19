package entity;

import java.time.LocalDateTime;

public class Save {

    private LocalDateTime dateSauvegarde;
    private String lienFichier;
    private Stock savedStock;

    public Save(LocalDateTime dateTime, String lienFichier, Stock savedStock) {
        this.dateSauvegarde = dateTime;
        this.lienFichier = lienFichier;
        this.savedStock = savedStock;
    }

    public Stock getSavedStock() {
        return savedStock;
    }

    public LocalDateTime getDateSauvegarde() {
        return dateSauvegarde;
    }

    public String getLienFichier() {
        return lienFichier;
    }
}
