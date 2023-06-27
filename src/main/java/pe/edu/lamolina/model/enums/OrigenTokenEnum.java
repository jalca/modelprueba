package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrigenTokenEnum {

    AMAUTA("amauta"),
    BIENESTAR("bienestar"),
    GESTION_EPG("gestion-epg"),
    ADMISION("admision"),
    INTRANET("maipi"),
    PAGOS("pagos");

    private final String value;
    private static final Map<String, OrigenTokenEnum> lookup = new HashMap<>();

    static {
        for (OrigenTokenEnum d : OrigenTokenEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OrigenTokenEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrigenTokenEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OrigenTokenEnum d : OrigenTokenEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
