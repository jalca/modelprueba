package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPlantillaDocumentoEnum {

    CONT("Contenido"), PARR("Parrafo");

    private final String value;
    private static final Map<String, TipoPlantillaDocumentoEnum> lookup = new HashMap<>();

    static {
        for (TipoPlantillaDocumentoEnum d : TipoPlantillaDocumentoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPlantillaDocumentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPlantillaDocumentoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPlantillaDocumentoEnum d : TipoPlantillaDocumentoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
