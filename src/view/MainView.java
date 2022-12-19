package view;

import controller.CtrlSaves;
import controller.CtrlStock;

import java.util.Scanner;

public class MainView {

    private SearchView searchFormView;
    private ShowPieceList showPieceListView;
    private StatsView statsView;
    private SavesView savesView;

    private CtrlStock ctrlStock;

    private CtrlSaves ctrlSaves;

    public MainView() {
        ctrlSaves = new CtrlSaves();
        ctrlStock = new CtrlStock(ctrlSaves.getListSaves());
        ctrlSaves.setCtrlStock(ctrlStock);
        searchFormView = new SearchView(this, ctrlStock);
        showPieceListView = new ShowPieceList(this, ctrlStock);
        statsView = new StatsView(this, ctrlStock);
        savesView = new SavesView(this, ctrlSaves);

        showMenu();
    }

    public void showMenu() {
        System.out.println("Bienvenue sur GeStock");
        System.out.println("---------------------");
        System.out.println("1. Gérer le stock");
        System.out.println("2. Effectuer une recherche");
        System.out.println("3. Afficher statistiques du stock");
        System.out.println("4. Gérer sauvegardes du stock");
        System.out.println("5. Quitter");


        menuResult();
    }

    private void menuResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Faites votre choix : ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                showPieceListView.displayStock();
                break;
            case "2":
                searchFormView.search();
                break;
            case "3":
                statsView.displayStats();
                break;
            case "4":
                savesView.displaySaves();
                break;
            default:
                break;
        }

    }
}
