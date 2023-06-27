package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CumplimientoValidacionEstadoEnum {

    CUMPLE("Cumple"), NO_CUMPLE("No Cumple"), NO_AUDITABLE("No Auditable");

    private final String value;
    private static final Map<String, CumplimientoValidacionEstadoEnum> lookup = new HashMap<>();

    static {
        for (CumplimientoValidacionEstadoEnum d : CumplimientoValidacionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CumplimientoValidacionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CumplimientoValidacionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CumplimientoValidacionEstadoEnum d : CumplimientoValidacionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
