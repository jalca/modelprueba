package pe.edu.lamolina.model.enums.encuesta;

public enum TipoObjetivoFacultadEnum {

    FACULTAD("Facultad"),
    CARRERA("Carrera");

    private final String value;

    private TipoObjetivoFacultadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
