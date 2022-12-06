package entity;

import java.lang.reflect.Array;
import java.util.*;

public class ListSaves {

    List<Save> saveList = new ArrayList<>();

    public ListSaves() {
        initSave();
    }

    public Stock getLastSave() {
        return null;
    }

    private void initSave() {
        // Initialisation des climatieurs
        Climatiseur c1 = new Climatiseur(1, "HMA HMA100VM1/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c2 = new Climatiseur(2, "HM HM270V/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c3 = new Climatiseur(3, "HMS HMS140V1/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c4 = new Climatiseur(4, "HMA HMA100V2/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c5 = new Climatiseur(5, "HMS HMS140V1/B C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c6 = new Climatiseur(6, "HMS HMS140V2/A C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c7 = new Climatiseur(7, "HMA HMA100V1/1 D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c8 = new Climatiseur(8, "HMS HMS140V1/A C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c9 = new Climatiseur(9, "HMA HMA100V2/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c10 = new Climatiseur(10, "HMS HMS140V2/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c11 = new Climatiseur(11, "HMS HMS140VA1/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c12 = new Climatiseur(12, "HMA HMA100V1/A D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c13 = new Climatiseur(13, "HMA HMA100VM1/B D:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c14 = new Climatiseur(14, "HMS HMS140V2/B C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c15 = new Climatiseur(15, "HMS HMS140VA2/1 C:CONTROL",
                Climatiseur.Famille.EXTERIEUR, Climatiseur.Type.HM);
        Climatiseur c16 = new Climatiseur(16, "FDC FDC308HES3 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c17 = new Climatiseur(17, "FDCA FDCA140HKXEN4 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c18 = new Climatiseur(18, "FDCP FDCP508HES3B A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c19 = new Climatiseur(19, "FDCVA FDCVA602HENR A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c20 = new Climatiseur(20, "FDCA FDCA140HKXES4R A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c21 = new Climatiseur(21, "FDCP FDCP508HES3 A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c22 = new Climatiseur(22, "FDCA FDCA140HKXEN4A A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c23 = new Climatiseur(23, "FDC FDC308HEN A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c24 = new Climatiseur(24, "FDC FDC258HEN3A_A A:PANEL ASSY",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.FD);
        Climatiseur c25 = new Climatiseur(25, "AMS AMS10-8/1 D:",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c26 = new Climatiseur(26, "RBC RBC08NX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c27 = new Climatiseur(27, "SCM SCM100ZJ-S1/1 D:CONTROL",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c28 = new Climatiseur(28, "SCM SCM125ZJ-S1/1 D:CONTROL",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.SR);
        Climatiseur c29 = new Climatiseur(29, "DXCA DXCA24VNX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);
        Climatiseur c30 = new Climatiseur(20, "DXC DXC24VNX/1 D:CONTROL & PARTS SET",
                Climatiseur.Famille.INTERIEUR, Climatiseur.Type.KX);

        // Initialisation des listes de climatiseurs
        List<Climatiseur> cl0 = new ArrayList<>();
        List<Climatiseur> cl1 = Arrays.asList(c1);
        List<Climatiseur> cl2 = Arrays.asList(c2, c3);
        List<Climatiseur> cl3 = Arrays.asList(c4);
        List<Climatiseur> cl4 = Arrays.asList(c5, c6);
        List<Climatiseur> cl5 = Arrays.asList(c6, c7);
        List<Climatiseur> cl6 = Arrays.asList(c8);
        List<Climatiseur> cl7 = Arrays.asList(c9, c10);
        List<Climatiseur> cl8 = Arrays.asList(c5, c11);
        List<Climatiseur> cl9 = Arrays.asList(c12, c13, c4, c1);
        List<Climatiseur> cl10 = Arrays.asList(c14, c26);
        List<Climatiseur> cl11 = Arrays.asList(c15, c16);
        List<Climatiseur> cl12 = Arrays.asList(c17, c20);
        List<Climatiseur> cl13 = Arrays.asList(c18, c19, c20);
        List<Climatiseur> cl14 = Arrays.asList(c21, c22, c23);
        List<Climatiseur> cl15 = Arrays.asList(c22, c24);
        List<Climatiseur> cl16 = Arrays.asList(c24, c25);
        List<Climatiseur> cl17 = Arrays.asList(c27);
        List<Climatiseur> cl18 = Arrays.asList(c28, c29, c30);
        List<Climatiseur> cl19 = Arrays.asList(c27, c7);
        List<Climatiseur> cl20 = Arrays.asList(c30, c1);

        // Initialisation des codes d'erreurs
        CodeErreur ce1 = new CodeErreur("70",   1,      "Sortie condenseur basse");
        CodeErreur ce2 = new CodeErreur("71",   2,      "Sortie condenseur élevée");
        CodeErreur ce3 = new CodeErreur("72",   3,      "Antigel HX");
        CodeErreur ce4 = new CodeErreur("75",   4,      "Prot. contre le gel");
        CodeErreur ce5 = new CodeErreur("76",   5,      "Limite de courant");
        CodeErreur ce6 = new CodeErreur("77",   6,      "Alarme de com.");
        CodeErreur ce7 = new CodeErreur("78",   7,      "Dégivrage interrompu");
        CodeErreur ce8 = new CodeErreur("3",    8,      "Protection");
        CodeErreur ce9 = new CodeErreur("70",   9,      "Panne électrique UE");
        CodeErreur ce10 = new CodeErreur("3",   10,     "Sortie condenseur basse");
        CodeErreur ce11 = new CodeErreur("5",   11,     "Sortie condenseur élevée");
        CodeErreur ce12 = new CodeErreur("6",   12,     "Antigel HX");
        CodeErreur ce13 = new CodeErreur("7",   13,     "Dégivrage interrompu");
        CodeErreur ce14 = new CodeErreur("14",  14,     "OU non compatible");
        CodeErreur ce15 = new CodeErreur("15",  15,     "Dégivrage interrompu");
        CodeErreur ce16 = new CodeErreur("16",  16,     "Dégivrage interrompu");
        CodeErreur ce17 = new CodeErreur("E36", 17,     "Gaz chaud permanent");
        CodeErreur ce18 = new CodeErreur("E37", 18,     "C. défaillant Tho-R");
        CodeErreur ce19 = new CodeErreur("E38", 19,     "C. défaillant Tho-A");
        CodeErreur ce20 = new CodeErreur("E39", 20,     "C. défaillant Tho-D");
        CodeErreur ce21 = new CodeErreur("E40", 21,     "Alarme HP");
        CodeErreur ce22 = new CodeErreur("E41", 22,     "Transistor de puissance trop chaud");
        CodeErreur ce23 = new CodeErreur("E42", 23,     "Erreur d'inverseur");
        CodeErreur ce24 = new CodeErreur("E45", 24,     "Erreur d'inverseur");
        CodeErreur ce25 = new CodeErreur("E47", 25,     "Erreur d'inverseur");
        CodeErreur ce26 = new CodeErreur("E48", 26,     "Alarme ventilateur");

        // Initialisation des listes d'erreurs
        List<CodeErreur> cel0 = new ArrayList<>();
        List<CodeErreur> cel1 = Arrays.asList(ce1);
        List<CodeErreur> cel2 = Arrays.asList(ce2, ce3);
        List<CodeErreur> cel3 = Arrays.asList(ce4);
        List<CodeErreur> cel4 = Arrays.asList(ce5, ce6);
        List<CodeErreur> cel5 = Arrays.asList(ce6, ce7);
        List<CodeErreur> cel6 = Arrays.asList(ce8);
        List<CodeErreur> cel7 = Arrays.asList(ce9, ce10);
        List<CodeErreur> cel8 = Arrays.asList(ce5, ce11);
        List<CodeErreur> cel9 = Arrays.asList(ce12, ce13, ce4, ce1);
        List<CodeErreur> cel10 = Arrays.asList(ce14, ce26);
        List<CodeErreur> cel11 = Arrays.asList(ce15, ce16);
        List<CodeErreur> cel12 = Arrays.asList(ce17, ce20);
        List<CodeErreur> cel13 = Arrays.asList(ce18, ce19, ce20);
        List<CodeErreur> cel14 = Arrays.asList(ce21, ce9);
        List<CodeErreur> cel15 = Arrays.asList(ce22, ce23);
        List<CodeErreur> cel16 = Arrays.asList(ce24, ce25);
        List<CodeErreur> cel17 = Arrays.asList(ce26, ce7);


        // Initialisation des pièces
        Piece p1 = new Piece("AGR201A011CA", "AGR201A011C", "COMPRESSOR",
                410.00, 1, 0,
                new Etagere("Z", "HQ"),
                cl0, null, null, cel0);








    }
}
