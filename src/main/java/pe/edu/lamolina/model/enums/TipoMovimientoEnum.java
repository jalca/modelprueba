package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMovimientoEnum {

    ING("Ingreso"),
    SAL("Salida");

    private final String value;
    private static final Map<String, TipoMovimientoEnum> lookup = new HashMap<>();

    static {
        for (TipoMovimientoEnum d : TipoMovimientoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMovimientoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMovimientoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMovimientoEnum d : TipoMovimientoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
