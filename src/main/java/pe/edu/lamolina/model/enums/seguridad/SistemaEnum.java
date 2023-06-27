package pe.edu.lamolina.model.enums.seguridad;

import java.util.HashMap;
import java.util.Map;

public enum SistemaEnum {

    AMAUTA("Amauta"),
    BIEN("Bienestar"),
    EPG("Posgrado"),
    MAIPI("Maipi");

    private final String value;
    private static final Map<String, SistemaEnum> lookup = new HashMap<>();

    static {
        for (SistemaEnum d : SistemaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SistemaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SistemaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SistemaEnum d : SistemaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
