package controller;

import entity.Piece;
import entity.Stock;

import java.util.List;

public class CtrlStock {

    Stock stock;

    public CtrlStock() {
        stock = new Stock();
    }

    public List<Piece> afficherPieces() {
        return stock.getPieces();
    }
}
