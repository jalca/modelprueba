package pe.edu.lamolina.model.enums.encuesta;

public enum TipoConfiguracionTablaColumnaEnum {

    TABLA_REF("Tabla Referenciada"),
    RANGO("Rango de Valores"),
    VALOR("Valor Específico"),
    PERSONAL("Personalizada");

    private final String value;

    private TipoConfiguracionTablaColumnaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
