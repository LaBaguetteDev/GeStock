package entity;

import java.util.List;

public class Stock {
    List<Piece> pieces;
    ListSaves listSaves;

    public Stock() {
        listSaves = new ListSaves();
        pieces = listSaves.getLastSave().getPieces();
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
