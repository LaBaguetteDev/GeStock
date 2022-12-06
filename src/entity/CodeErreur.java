package entity;

public class CodeErreur {
    private String code;
    private String texteAffiche;

    public CodeErreur(String code, String texteAffiche) {
        this.code = code;
        this.texteAffiche = texteAffiche;
    }

    public String getCode() {
        return code;
    }

    public String getTexteAffiche() {
        return texteAffiche;
    }
}
