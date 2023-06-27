package pe.edu.lamolina.model.enums.croacia;

public enum HistoTmovEnum {

    ACT("Activo"),
    RET("RET"),
    CEL("CEL");

    private final String value;

    private HistoTmovEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
