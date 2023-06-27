package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContextoEventoEnum {

    EPG("Posgrado"), 
    PRE("Pregrado");

    private final String value;
    private static final Map<String, ContextoEventoEnum> lookup = new HashMap<>();

    static {
        for (ContextoEventoEnum d : ContextoEventoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContextoEventoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContextoEventoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContextoEventoEnum d : ContextoEventoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
