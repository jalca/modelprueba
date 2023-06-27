package pe.edu.lamolina.model.enums.encuesta;

public enum TipoObjetivoMatriculablesEnum {

    MATRICULABLES("Matriculables"),
    MATRICULADOS("Matriculados");

    private final String value;

    private TipoObjetivoMatriculablesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
