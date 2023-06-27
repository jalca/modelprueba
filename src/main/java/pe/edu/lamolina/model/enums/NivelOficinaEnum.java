package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NivelOficinaEnum {

    OFI("Oficina"),
    UNA("Unidad Administrativa");

    private final String value;
    private static final Map<String, NivelOficinaEnum> lookup = new HashMap<>();

    static {
        for (NivelOficinaEnum d : NivelOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private NivelOficinaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NivelOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (NivelOficinaEnum d : NivelOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
