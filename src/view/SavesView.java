package view;

import controller.CtrlSaves;
import entity.Save;

import java.util.Scanner;

public class SavesView {

    MainView mainView;
    CtrlSaves ctrlSaves;

    public SavesView(MainView mainView, CtrlSaves ctrlSaves) {
        this.mainView = mainView;
        this.ctrlSaves = ctrlSaves;
    }

    public void displaySaves() {
        for (Save s : ctrlSaves.getListSaves().getSaveList()) {
            System.out.println("1. " + s.getDateTime().toString());
        }

        System.out.println("----------------------------");
        System.out.println("1. Charger sauvegarde");
        System.out.println("2. Sauvegarder stock actuel");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Faites votre choix : ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Faites votre choix : ");

                choice = scanner.nextLine();

                ctrlSaves.loadSave(choice);
                mainView.showMenu();
                break;
            case "2":
                ctrlSaves.save();
                System.out.println("Stock sauvegardé ! ");
                mainView.showMenu();
                break;
        }
    }
}
