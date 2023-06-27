package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SolicitudCambioInfoEstadoEnum {

    ACT("Activo"),
    ANU("Anulado"),
    PEND("Pendiente"),
    COMP("Completado"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, SolicitudCambioInfoEstadoEnum> lookup = new HashMap<>();

    static {
        for (SolicitudCambioInfoEstadoEnum d : SolicitudCambioInfoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SolicitudCambioInfoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SolicitudCambioInfoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SolicitudCambioInfoEstadoEnum d : SolicitudCambioInfoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
