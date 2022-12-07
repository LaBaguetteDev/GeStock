package view;

import controller.CtrlStock;
import entity.Piece;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class SearchView {

    MainView mainView;
    CtrlStock ctrlStock;

    public SearchView(MainView mainView, CtrlStock ctrlStock) {
        this.mainView = mainView;
        this.ctrlStock = ctrlStock;
    }

    public void showForm() {

        Scanner scanner = new Scanner(System.in);

        String id; String nom;
        double prixBrutmin; double prixBrutmax; double prixNetmin; double prixNetmax;
        String clims; String fam; String typ;
        String entreesmin; String entreesmax;
        String sortiesmin; String sortiesmax;
        String pInstallateurs; String[] nInstallateurs; String[] oInstallateurs;
        String codes;;
        System.out.print("TYPE : ");
        id = scanner.nextLine();

        System.out.println("PARTS NAME : ");
        nom = scanner.nextLine();

        System.out.println("PB-MHI min : ");
        prixBrutmin = Double.parseDouble(scanner.nextLine());
        System.out.println("PB-MHI max : ");
        prixBrutmax = Double.parseDouble(scanner.nextLine());

        System.out.println("NET-MHI min : ");
        prixNetmin = Double.parseDouble(scanner.nextLine());

        System.out.println("NET-MHI max : ");
        prixNetmax = Double.parseDouble(scanner.nextLine());

        System.out.println("Climatiseur : ");
        clims = scanner.nextLine();

        System.out.println("Famille Climatiseur : ");
        fam = scanner.nextLine();

        System.out.println("Types Climatiseur : ");
        typ = scanner.nextLine();

        System.out.println("Entrees min : ");
        entreesmin = scanner.nextLine();

        System.out.println("Entrees max : ");
        entreesmax = scanner.nextLine();

        System.out.println("Sorties min: ");
        sortiesmin = scanner.nextLine();

        System.out.println("Sorties max: ");
        sortiesmax = scanner.nextLine();

        System.out.println("Codes Erreurs : ");
        codes = scanner.nextLine();

        displayResult(ctrlStock.chercherPieces(id, nom,
                prixBrutmin, prixBrutmax, prixNetmin, prixNetmax,
                clims, fam, typ,
                entreesmin, entreesmax, sortiesmin, sortiesmax, codes));

        mainView.showMenu();

    }

    private void displayResult(List<Piece> pieces) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        System.out.printf("|%-5s|%-5s|%-20s|%-3s|%-3s|%-10s|%-10s|%-25s|%-7s|%-20s|%-7s|%-7s\n",
                "Etag", "Bte", "TYPE", "Stk", "Min", "Entree", "Sortie", "PARTS NAME", "PB-MHI", "SUBSTITUT", "NET-MHI", "TOT-MHI");
        for (Piece p : pieces) {
            ShowPieceList.displayPieces(sdf, p);
        }
    }
}
