package entity;

import java.util.List;

public class Stock {
    List<Piece> pieces;

    public Stock(ListSaves listSaves) {
        pieces = listSaves.getLastSavedStock().getPieces();
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

    public boolean addPiece(Piece p) {
        pieces.add(p);
        return true;
    }

    public boolean deletePiece(String id) {
        for (Piece p : pieces) {
            if(p.getId().equals(id)) {
                pieces.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean editerPiece(String idedit, Piece p) {
        if(deletePiece(idedit)) {
            addPiece(p);
            return true;
        } else {
            return false;
        }

    }

    public boolean updateStock(Stock s) {
        this.pieces = s.getPieces();
        return true;
    }
}
