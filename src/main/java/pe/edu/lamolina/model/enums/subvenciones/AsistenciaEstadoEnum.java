package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum AsistenciaEstadoEnum {

    PENDIENTE("Pendiente"),
    CON_ASISTENCIA("Con asistencia"),
    SIN_ASISTENCIA("Sin asistencia");

    private final String value;
    private static final Map<String, AsistenciaEstadoEnum> lookup = new HashMap<>();

    static {
        for (AsistenciaEstadoEnum d : AsistenciaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AsistenciaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AsistenciaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AsistenciaEstadoEnum d : AsistenciaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
