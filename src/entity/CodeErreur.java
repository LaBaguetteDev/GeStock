package entity;

public class CodeErreur {
    private String code;
    private int id;
    private String texteAffiche;

    public CodeErreur(String code, int id, String texteAffiche) {
        this.code = code;
        this.id = id;
        this.texteAffiche = texteAffiche;
    }
}
