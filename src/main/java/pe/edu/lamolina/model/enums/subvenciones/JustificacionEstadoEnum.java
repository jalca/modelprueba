package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum JustificacionEstadoEnum {

    PENDIENTE("Pendiente"),
    ABIERTA("Abierta"),
    CERRADA("Cerrada"),
    ANULADA("Anulada"),
    ACEPTADA("Justificación aceptada"),
    RECHAZADA("Justificación rechazada");

    private final String value;
    private static final Map<String, JustificacionEstadoEnum> lookup = new HashMap<>();

    static {
        for (JustificacionEstadoEnum d : JustificacionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private JustificacionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JustificacionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (JustificacionEstadoEnum d : JustificacionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
