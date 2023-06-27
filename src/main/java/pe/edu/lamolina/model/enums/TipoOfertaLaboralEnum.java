package pe.edu.lamolina.model.enums;

public enum TipoOfertaLaboralEnum {

    OFERTA("Oferta de empleo"),
    PRACTICA("Practica pre profesional"),
    PREPRACTICA("Practicas profesional");

    private final String value;

    private TipoOfertaLaboralEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
