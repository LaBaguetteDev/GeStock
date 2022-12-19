package entity;

import java.time.LocalDateTime;
import java.util.*;

public class ListSaves {

    List<Save> saveList = new ArrayList<>();

    public ListSaves() {
        initSave();
    }

    public List<Save> getSaveList() {
        return saveList;
    }

    public Stock getLastSavedStock() {
        return saveList.get(saveList.size()-1).getSavedStock();
    }

    public Stock loadSavedStock(int index) {
        return saveList.get(index).getSavedStock();
    }

    public void addSave(Stock st) {
        Save s = new Save(LocalDateTime.now(), "jsp", st);
        saveList.add(s);
    }

    private void initSave() {
        // Initialisation des climatieurs
        Climatiseur c0 = new Climatiseur("", null, null);
        Climatiseur c1 = new Climatiseur("HMA HMA100VM1/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c2 = new Climatiseur("HM HM270V/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c3 = new Climatiseur("HMS HMS140V1/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c4 = new Climatiseur("HMA HMA100V2/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c5 = new Climatiseur("HMS HMS140V1/B C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c6 = new Climatiseur("HMS HMS140V2/A C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c7 = new Climatiseur("HMA HMA100V1/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c8 = new Climatiseur("HMS HMS140V1/A C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c9 = new Climatiseur("HMA HMA100V2/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c10 = new Climatiseur("HMS HMS140V2/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c11 = new Climatiseur("HMS HMS140VA1/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c12 = new Climatiseur("HMA HMA100V1/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c13 = new Climatiseur("HMA HMA100VM1/B D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c14 = new Climatiseur("HMS HMS140V2/B C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c15 = new Climatiseur("HMS HMS140VA2/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c16 = new Climatiseur("FDC FDC308HES3 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c17 = new Climatiseur("FDCA FDCA140HKXEN4 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c18 = new Climatiseur("FDCP FDCP508HES3B A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c19 = new Climatiseur("FDCVA FDCVA602HENR A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c20 = new Climatiseur("FDCA FDCA140HKXES4R A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c21 = new Climatiseur("FDCP FDCP508HES3 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c22 = new Climatiseur("FDCA FDCA140HKXEN4A A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c23 = new Climatiseur("FDC FDC308HEN A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c24 = new Climatiseur("FDC FDC258HEN3A_A A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c25 = new Climatiseur("AMS AMS10-8/1 D:",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c26 = new Climatiseur("RBC RBC08NX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c27 = new Climatiseur("SCM SCM100ZJ-S1/1 D:CONTROL",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c28 = new Climatiseur( "SCM SCM125ZJ-S1/1 D:CONTROL",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.SR);
        Climatiseur c29 = new Climatiseur( "DXCA DXCA24VNX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c30 = new Climatiseur( "DXC DXC24VNX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);

        // Initialisation des listes de climatiseurs
        List<Climatiseur> cl0 = new LinkedList<>(Arrays.asList(c0));
        List<Climatiseur> cl1 = new LinkedList<>(Arrays.asList(c1));
        List<Climatiseur> cl2 = new LinkedList<>(Arrays.asList(c2, c3));
        List<Climatiseur> cl5 = new LinkedList<>(Arrays.asList(c6, c7));
        List<Climatiseur> cl6 = new LinkedList<>(Arrays.asList(c8));
        List<Climatiseur> cl7 = new LinkedList<>(Arrays.asList(c9, c10, c5, c11));
        List<Climatiseur> cl9 = new LinkedList<>(Arrays.asList(c12, c13, c4, c1, c24, c25));
        List<Climatiseur> cl10 = new LinkedList<>( Arrays.asList(c14, c26));
        List<Climatiseur> cl11 = new LinkedList<>( Arrays.asList(c15, c16, c17, c18, c19, c20));
        List<Climatiseur> cl15 = new LinkedList<>( Arrays.asList(c21, c22, c23, c24, c14, c25, c28));
        List<Climatiseur> cl17 = new LinkedList<>( Arrays.asList(c27, c30, c29));
        List<Climatiseur> cl21 = new LinkedList<>( Arrays.asList(c1, c2, c3, c4, c5, c6, c30, c27, c29));

        // Initialisation des codes d'erreurs
        CodeErreur ce0 = new CodeErreur("",          "");
        CodeErreur ce1 = new CodeErreur("70",        "Sortie condenseur basse");
        CodeErreur ce2 = new CodeErreur("71",        "Sortie condenseur élevée");
        CodeErreur ce3 = new CodeErreur("72",        "Antigel HX");
        CodeErreur ce4 = new CodeErreur("75",        "Prot. contre le gel");
        CodeErreur ce5 = new CodeErreur("76",        "Limite de courant");
        CodeErreur ce6 = new CodeErreur("77",        "Alarme de com.");
        CodeErreur ce7 = new CodeErreur("78",        "Dégivrage interrompu");
        CodeErreur ce8 = new CodeErreur("3",         "Protection");
        CodeErreur ce9 = new CodeErreur("70",        "Panne électrique UE");
        CodeErreur ce10 = new CodeErreur("3",        "Sortie condenseur basse");
        CodeErreur ce11 = new CodeErreur("5",        "Sortie condenseur élevée");
        CodeErreur ce12 = new CodeErreur("6",        "Antigel HX");
        CodeErreur ce13 = new CodeErreur("7",        "Dégivrage interrompu");
        CodeErreur ce14 = new CodeErreur("14",       "OU non compatible");
        CodeErreur ce15 = new CodeErreur("15",       "Dégivrage interrompu");
        CodeErreur ce16 = new CodeErreur("16",       "Dégivrage interrompu");
        CodeErreur ce17 = new CodeErreur("E36",      "Gaz chaud permanent");
        CodeErreur ce18 = new CodeErreur("E37",      "C. défaillant Tho-R");
        CodeErreur ce19 = new CodeErreur("E38",      "C. défaillant Tho-A");
        CodeErreur ce20 = new CodeErreur("E39",      "C. défaillant Tho-D");
        CodeErreur ce21 = new CodeErreur("E40",      "Alarme HP");
        CodeErreur ce22 = new CodeErreur("E41",      "Transistor de puissance trop chaud");
        CodeErreur ce23 = new CodeErreur("E42",      "Erreur d'inverseur");
        CodeErreur ce24 = new CodeErreur("E45",      "Erreur d'inverseur");
        CodeErreur ce25 = new CodeErreur("E47",      "Erreur d'inverseur");
        CodeErreur ce26 = new CodeErreur("E48",      "Alarme ventilateur");

        // Initialisation des listes d'erreurs
        List<CodeErreur> cel0 = new LinkedList<>(Arrays.asList(ce0));
        List<CodeErreur> cel1 = new LinkedList<>(Arrays.asList(ce1));
        List<CodeErreur> cel2 = new LinkedList<>(Arrays.asList(ce2, ce3, ce10));
        List<CodeErreur> cel3 = new LinkedList<>(Arrays.asList(ce4, ce12));
        List<CodeErreur> cel5 = new LinkedList<>(Arrays.asList(ce6, ce7));
        List<CodeErreur> cel6 = new LinkedList<>(Arrays.asList(ce8));
        List<CodeErreur> cel8 = new LinkedList<>(Arrays.asList(ce5, ce11, ce13, ce14, ce15));
        List<CodeErreur> cel12 =new LinkedList<>(Arrays.asList(ce17, ce20, ce16));
        List<CodeErreur> cel14 =new LinkedList<>(Arrays.asList(ce21, ce9));
        List<CodeErreur> cel15 =new LinkedList<>(Arrays.asList(ce22, ce23));
        List<CodeErreur> cel16 =new LinkedList<>(Arrays.asList(ce24, ce25));
        List<CodeErreur> cel17 =new LinkedList<>(Arrays.asList(ce26, ce7, ce18, ce19));

        // Initialisation des dates d'entrees
        Entree en1 = new Entree(new GregorianCalendar(2022, Calendar.FEBRUARY,  22).getTime(),  1);
        Entree en2 = new Entree(new GregorianCalendar(2022, Calendar.FEBRUARY,  1).getTime(),   2);
        Entree en3 = new Entree(new GregorianCalendar(2022, Calendar.AUGUST,    9).getTime(),   5);
        Entree en4 = new Entree(new GregorianCalendar(2022, Calendar.JULY,      7).getTime(),   2);
        Entree en5 = new Entree(new GregorianCalendar(2022, Calendar.FEBRUARY,  10).getTime(),  1);

        // Initialisation des listes de dates d'entrees
        List<Entree> enl0 = new ArrayList<>();
        List<Entree> enl1 = new LinkedList<>(Arrays.asList(en1, en2));
        List<Entree> enl2 = new LinkedList<>(Arrays.asList(en3, en4));
        List<Entree> enl3 = new LinkedList<>(Arrays.asList(en4, en5));
        List<Entree> enl4 = new LinkedList<>(Arrays.asList(en4));
        List<Entree> enl5 = new LinkedList<>(Arrays.asList(en1, en4));

        // Initialisation des installateurs
        Installateur i1 = new Installateur("Samuel",       "Kouff",        "Coolmark");
        Installateur i2 = new Installateur("Romain",       "Grandbois",    "Duocool");
        Installateur i3 = new Installateur("Luca",         "Fisher",       "Bielen");
        Installateur i4 = new Installateur("Matthias",     "Schneider",    "Qlima");
        Installateur i5 = new Installateur("Dumons",       "Charles",      "Gromet");
        Installateur i6 = new Installateur("Adrien",       "Duval",        "Coelmon");
        Installateur i7 = new Installateur("Franck",       "Dupont",       "Agalix");
        Installateur i8 = new Installateur("Virginie",     "Charrier",     "Normacalor");
        Installateur i9 = new Installateur("Jeanne",       "Gomez",        "Gefroid SPRL");
        Installateur i10 = new Installateur("Léon",         "Besson",       "Technigel");

        // Initialisation des dates de sorties
        Sortie so1 = new Sortie(new GregorianCalendar(2022, Calendar.JULY,      28).getTime(),      i5, 1);
        Sortie so2 = new Sortie(new GregorianCalendar(2022, Calendar.MAY,       3).getTime(),       i4, 1);
        Sortie so3 = new Sortie(new GregorianCalendar(2022, Calendar.AUGUST,    7).getTime(),       i1, 1);
        Sortie so4 = new Sortie(new GregorianCalendar(2022, Calendar.MAY,       5).getTime(),       i7, 1);
        Sortie so5 = new Sortie(new GregorianCalendar(2022, Calendar.JUNE,      30).getTime(),      i8, 1);
        Sortie so6 = new Sortie(new GregorianCalendar(2022, Calendar.JULY,      7).getTime(),       i10, 1);
        Sortie so7 = new Sortie(new GregorianCalendar(2022, Calendar.JUNE,      30).getTime(),      i6, 5);
        Sortie so8 = new Sortie(new GregorianCalendar(2022, Calendar.JULY,      7).getTime(),       i5, 1);
        Sortie so9 = new Sortie(new GregorianCalendar(2022, Calendar.JUNE,      21).getTime(),      i2, 3);
        Sortie so10 = new Sortie(new GregorianCalendar(2022, Calendar.NOVEMBER,  5).getTime(),       i3, 2);
        Sortie so11 = new Sortie(new GregorianCalendar(2022, Calendar.OCTOBER,   10).getTime(),      i9, 1);
        Sortie so12 = new Sortie(new GregorianCalendar(2022, Calendar.JANUARY,   7).getTime(),       i5, 1);

        // Initialisation des listes de dates de sorties
        List<Sortie> sol0 = new ArrayList<>();
        List<Sortie> sol1 = new LinkedList<>(Arrays.asList(so1));
        List<Sortie> sol2 = new LinkedList<>(Arrays.asList(so2));
        List<Sortie> sol3 = new LinkedList<>(Arrays.asList(so3, so4));
        List<Sortie> sol5 = new LinkedList<>(Arrays.asList(so5));
        List<Sortie> sol6 = new LinkedList<>(Arrays.asList(so1, so6));
        List<Sortie> sol7 = new LinkedList<>(Arrays.asList(so7, so12));
        List<Sortie> sol8 = new LinkedList<>(Arrays.asList(so8));
        List<Sortie> sol9 = new LinkedList<>(Arrays.asList(so9, so11));
        List<Sortie> sol10 =new LinkedList<>(Arrays.asList(so10, so2));

        // Initialisation des etageres
        Etagere e1 = new Etagere("Z", "HQ");
        Etagere e2 = new Etagere("", "A01");
        Etagere e3 =  new Etagere("", "A02");
        Etagere e4 =  new Etagere("", "A03");
        Etagere e5 =  new Etagere("", "A04");

        Etagere e6 = new Etagere("Z", "P04");
        Etagere e7 = new Etagere("", "F05");
        Etagere e8 = new Etagere("G01", "GRE");
        Etagere e9 = new Etagere("", "V02");
        Etagere e10 = new Etagere("B02", "F06");

        // Initialisation des pieces
        Piece p1 = new Piece("AGR201A011CA", null, "COMPRESSOR",
                410.00, 1, 0,
                e1, cl0, enl0, sol0, cel0);

        Piece p2 = new Piece("FD-PAC", null, "COOLMARK",
                475.00, 3, 1,
                e2, cl0, enl1, sol1, cel0);

        Piece p3 = new Piece("INTESIS ACX-WIFI", null, "INTESIS-HOME",
                137.54, 40, 2,
                e3, cl21, enl0, sol2, cel0);

        Piece p4 = new Piece("MCD291A002", null, "VCC22 - Cooling",
                180.00, 2, 1,
                e2, cl10, enl0, sol0, cel1);

        Piece p5 = new Piece("MCD291A207", null, "CIRCULATIONS PUMP",
                87.40, 0, 1,
                e10, cl17, enl0, sol0, cel5);

        Piece p6 = new Piece("MCD291A194", p4, "RELAY CARD",
                104.00, 6, 1,
                e4, cl15, enl2, sol3, cel17);

        Piece p7 = new Piece("MCD291A131", null, "CIRCUIT BOARD HMS140V",
                137.54, 3, 1,
                e3, cl7, enl3, sol5, cel6);

        Piece p8 = new Piece("MCD291A334", null, "CPU MODUL (AA21)",
                137.54, 2, 1,
                e4,cl6, enl2, sol6, cel16);

        Piece p9 = new Piece("PCA505A127H", p8, "PWB ASSY",
                179.00, 2, 1,
                e6,cl11, enl4, sol1, cel15);

        Piece p10 = new Piece("AGR201A011C", null, "CPU MODUL (AA21)",
                137.54, 1, 0,
                e1, cl5, enl4, sol6, cel2);

        Piece p11 = new Piece("PCA505A127B", null, "PWB ASSY",
                158.00, 0, 1,
                e9, cl9, enl2, sol10, cel3);

        Piece p12 = new Piece("RKT437A801B", null, "FILTER BIO",
                12.00, 10, 5,
                e5, cl10, enl4, sol9, cel5);

        Piece p13 = new Piece("SSA512T094", null, "SSA512T127D",
                92.00, 3, 1,
                e10,cl15, enl4, sol8, cel14);

        Piece p14 = new Piece("SSA551A216L", p13, "SENSOR ASSY",
                12.00, 4, 1,
                e7, cl1, enl2, sol6, cel12);

        Piece p15 = new Piece("W200G06", null, "WASHER",
                5.50, 3, 1,
                e8, cl2, enl5, sol7, cel8);

        // Initialisation du stock
        Stock stock = new Stock(new LinkedList<>(Arrays.asList(p1, p2, p3, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)));

        // Initialisation d'une sauvegarde
        Save save = new Save(LocalDateTime.now(),"luyten.com/admin/stock1.json", stock);

        // Ajout de la sauvegarde à la liste des sauvegardes
        saveList.add(save);
    }
}
