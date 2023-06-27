package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoReciboEnum {

    FAC("Factura"), BOL("Boleta");

    private final String value;
    private static final Map<String, TipoReciboEnum> lookup = new HashMap<>();

    static {
        for (TipoReciboEnum d : TipoReciboEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoReciboEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoReciboEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoReciboEnum d : TipoReciboEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
