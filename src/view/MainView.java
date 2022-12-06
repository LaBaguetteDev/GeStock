package view;

import java.util.Scanner;

public class MainView {

    private SearchForm searchFormView;
    private SearchResult searchResultView;
    private ShowPieceList showPieceListView;

    public MainView() {
        searchFormView = new SearchForm();
        searchResultView = new SearchResult();
        showPieceListView = new ShowPieceList(this);
        showMenu();
    }

    public void showMenu() {
        System.out.println("Bienvenue sur GeStock");
        System.out.println("---------------------");
        System.out.println("1. Gérer le stock");
        System.out.println("2. Effectuer une recherche");
        System.out.println("3. Afficher statistiques du stock");
        System.out.println("4. Gérer sauvegardes du stock");

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
                break;
            case "3":
                break;
            case "4":
                break;
        }

    }
}
