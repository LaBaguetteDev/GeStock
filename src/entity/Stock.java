package entity;

import java.util.List;

public class Stock {
    List<Piece> pieces;

    public Stock(ListSaves listSaves) {
        pieces = listSaves.getLastSave().getPieces();
    }

    public Stock(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(String id) {
        for (Piece p : pieces) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void addPiece(Piece p) {
        pieces.add(p);
    }

    public void deletePiece(String id) {
        for (Piece p : pieces) {
            if(p.getId().equals(id)) {
                pieces.remove(p);
                break;
            }
        }
    }
}
