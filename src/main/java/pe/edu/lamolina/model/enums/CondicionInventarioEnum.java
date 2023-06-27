package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CondicionInventarioEnum {

    NUEVO("Nuevo"),
    VIEJO("Viejo"),
    MEDIO("Medionuevo");

    private final String value;
    private static final Map<String, CondicionInventarioEnum> lookup = new HashMap<>();

    static {
        for (CondicionInventarioEnum d : CondicionInventarioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CondicionInventarioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CondicionInventarioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CondicionInventarioEnum d : CondicionInventarioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
