package pe.edu.lamolina.model.enums.encuesta;

public enum TipoValorColumnaEnum {

    STRING("Cadena"),
    INTEGER("Entero"),
    DECIMAL("Decimal"),
    DATE("Fecha"),
    DATETIME("Fecha y Hora");

    private final String value;

    private TipoValorColumnaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
