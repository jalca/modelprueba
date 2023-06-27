package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoVentaEnum {

    TRAMO("Tramo"), TODO("Todo");

    private final String value;
    private static final Map<String, TipoVentaEnum> lookup = new HashMap<>();

    static {
        for (TipoVentaEnum d : TipoVentaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoVentaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoVentaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoVentaEnum d : TipoVentaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
