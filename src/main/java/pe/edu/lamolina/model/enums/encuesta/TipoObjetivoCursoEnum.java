package pe.edu.lamolina.model.enums.encuesta;

public enum TipoObjetivoCursoEnum {

    CURSO("Curso"),
    SECCION("Sección");

    private final String value;

    private TipoObjetivoCursoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
