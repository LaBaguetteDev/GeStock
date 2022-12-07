package controller;

import entity.ListSaves;

public class CtrlSaves {

    ListSaves listSaves;
    CtrlStock ctrlStock;
    public CtrlSaves() {
        listSaves = new ListSaves();
    }

    public void setCtrlStock(CtrlStock ctrlStock) {
        this.ctrlStock = ctrlStock;
    }

    public ListSaves getListSaves() {
        return listSaves;
    }

    public void loadSave(String choice) {
        ctrlStock.setStock(listSaves.getSave(choice));
    }

    public void save() {
        listSaves.addSave(ctrlStock.getStock());
    }
}
