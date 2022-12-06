package entity;

public class Installateur {
    private String nom;
    private String prenom;
    private String organisation;

    public Installateur(String prenom, String nom, String organisation) {
        this.prenom = prenom;
        this.nom = nom;
        this.organisation = organisation;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getOrganisation() {
        return organisation;
    }
}
