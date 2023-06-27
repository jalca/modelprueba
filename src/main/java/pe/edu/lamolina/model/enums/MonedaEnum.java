package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MonedaEnum {

    PEN("Soles"), USD("Dolares");

    private final String value;
    private static final Map<String, MonedaEnum> lookup = new HashMap<>();

    static {
        for (MonedaEnum d : MonedaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MonedaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MonedaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MonedaEnum d : MonedaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
