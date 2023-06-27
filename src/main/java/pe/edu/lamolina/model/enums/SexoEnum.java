package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SexoEnum {

    F("Femenino"), M("Masculino");

    private final String value;
    private static final Map<String, SexoEnum> lookup = new HashMap<>();

    static {
        for (SexoEnum d : SexoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SexoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SexoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SexoEnum d : SexoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
