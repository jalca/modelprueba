package pe.edu.lamolina.model.enums.agrupaciones;

import java.util.HashMap;
import java.util.Map;

public enum AprobacionEventoEstadoEnum {

    PENDIENTE("Pendiente"),
    APROBADO("Aprobado"),
    OBSERVADO("Observado"),
    RECHAZADO("Rechazado");

    private final String value;
    private static final Map<String, AprobacionEventoEstadoEnum> lookup = new HashMap<>();

    static {
        for (AprobacionEventoEstadoEnum d : AprobacionEventoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AprobacionEventoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AprobacionEventoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AprobacionEventoEstadoEnum d : AprobacionEventoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
