package entity;

import java.time.LocalDateTime;

public class Save {

    private LocalDateTime dateTime;
    private String lienFichier;
    private Stock savedStock;

    public Save(LocalDateTime dateTime, String lienFichier, Stock savedStock) {
        this.dateTime = dateTime;
        this.lienFichier = lienFichier;
        this.savedStock = savedStock;
    }

    public Stock getSavedStock() {
        return savedStock;
    }
}
