package view;

import controller.CtrlStock;
import entity.Piece;

public class ShowPieceList {

    CtrlStock pieceCtrl;

    public ShowPieceList() {
        this.pieceCtrl = new CtrlStock();
    }

    public void displayStock() {
        for (Piece p : pieceCtrl.afficherPieces()) {
            System.out.println();//TODO
        }
    }
}
