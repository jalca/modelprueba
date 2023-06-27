package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MovimientoCajaEstadoEnum {

    PAG("Pagado"), ANU("Anulado"), DEV("Devuelto");

    private final String value;
    private static final Map<String, MovimientoCajaEstadoEnum> lookup = new HashMap<>();

    static {
        for (MovimientoCajaEstadoEnum d : MovimientoCajaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MovimientoCajaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MovimientoCajaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MovimientoCajaEstadoEnum d : MovimientoCajaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
