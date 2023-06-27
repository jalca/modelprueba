package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CategoriaBienestarCodigoEnum {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");

    private final String value;
    private static final Map<String, CategoriaBienestarCodigoEnum> lookup = new HashMap<>();

    static {
        for (CategoriaBienestarCodigoEnum d : CategoriaBienestarCodigoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CategoriaBienestarCodigoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CategoriaBienestarCodigoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CategoriaBienestarCodigoEnum d : CategoriaBienestarCodigoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
