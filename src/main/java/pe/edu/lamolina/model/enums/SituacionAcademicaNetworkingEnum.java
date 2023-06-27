package pe.edu.lamolina.model.enums;

public enum SituacionAcademicaNetworkingEnum {

    EST("Estudiante"),
    EGR("Egresado"),
    GRA("Graduado"),
    TIT("Titulado"),
    DES("Desertado");

    private final String value;

    private SituacionAcademicaNetworkingEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
