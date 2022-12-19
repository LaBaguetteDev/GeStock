package view;

import controller.CtrlSaves;
import entity.Save;

import java.util.Scanner;

public class SavesView {

    MainView mainView;
    CtrlSaves ctrlSaves;

    Scanner scanner = new Scanner(System.in);

    public SavesView(MainView mainView, CtrlSaves ctrlSaves) {
        this.mainView = mainView;
        this.ctrlSaves = ctrlSaves;
    }

    public void displaySaves() {
        for (Save s : ctrlSaves.getListSaves().getSaveList()) {
            System.out.println("1. " + s.getDateSauvegarde().toString());
        }

        System.out.println("----------------------------");
        System.out.println("1. Charger sauvegarde");
        System.out.println("2. Sauvegarder stock actuel");

        System.out.print("Faites votre choix : ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Faites votre choix : ");

                loadSave();
                mainView.showMenu();
                break;
            case "2":
                save();
                mainView.showMenu();
                break;
        }
    }

    private void save() {
        ctrlSaves.save();
        System.out.println("Stock sauvegardé ! ");
    }

    private void loadSave() {

        String choice = scanner.nextLine();
        int index = Integer.parseInt(choice);
        ctrlSaves.loadSave(index);
    }
}
