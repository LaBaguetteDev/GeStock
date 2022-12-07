package view;

import controller.CtrlStock;

public class StatsView {

    MainView mainView;
    CtrlStock ctrlStock;

    public StatsView(MainView mainView, CtrlStock ctrlStock) {
        this.mainView = mainView;
        this.ctrlStock = ctrlStock;
    }

    public void displayStats() {
        System.out.println("Nombre de pièces : " + ctrlStock.nombrePieces());
        System.out.println("Nombre de pièces différentes : " + ctrlStock.nombrePiecesDiff());
        System.out.println("Valeur du stock : " + ctrlStock.prixStock() + "€");

        mainView.showMenu();
    }
}
