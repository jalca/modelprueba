package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoEntrevistaEnum {

    PRESC("Presencial"),
    VIRTUAL("Virtual");

    private final String value;
    private static final Map<String, TipoEntrevistaEnum> lookup = new HashMap<>();

    static {
        for (TipoEntrevistaEnum d : TipoEntrevistaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEntrevistaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEntrevistaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEntrevistaEnum d : TipoEntrevistaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
