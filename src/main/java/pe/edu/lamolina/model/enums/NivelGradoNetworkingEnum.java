package pe.edu.lamolina.model.enums;

public enum NivelGradoNetworkingEnum {

    TEC("Superior Técnico"),
    UNI("Universitario"),
    MAE("Maestría"),
    DOC("Doctorado"),
    OTR("Otros");

    private final String value;

    private NivelGradoNetworkingEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
