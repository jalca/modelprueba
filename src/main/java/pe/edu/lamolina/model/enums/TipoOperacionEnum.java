package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoOperacionEnum {

    VENTA("Venta de Ticket"), ENTRAD("Entrada al Comedor"), RECAR("Recarga");

    private final String value;
    private static final Map<String, TipoOperacionEnum> lookup = new HashMap<>();

    static {
        for (TipoOperacionEnum d : TipoOperacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOperacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoOperacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOperacionEnum d : TipoOperacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
