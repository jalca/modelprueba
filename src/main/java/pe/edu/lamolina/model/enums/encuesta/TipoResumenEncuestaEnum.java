package pe.edu.lamolina.model.enums.encuesta;

public enum TipoResumenEncuestaEnum {

    GENERAL("General"),
    CATEGORIA_PREGUNTA("Categoría Pregunta"),
    MODALIDAD_ESTUDIO("Modalidad Estudio"),
    CICLO_INGRESO("Ciclo Ingreso"),
    FACULTAD("Facultad"),
    CARRERA("Carrera"),
    CURSO("Curso"),
    SECCION("Sección");

    private final String value;

    private TipoResumenEncuestaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
