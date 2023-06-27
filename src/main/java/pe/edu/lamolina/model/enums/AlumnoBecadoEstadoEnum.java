package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoBecadoEstadoEnum {

    ACT("Activo"), INA("Inactivo");

    private final String value;
    private static final Map<String, AlumnoBecadoEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoBecadoEstadoEnum d : AlumnoBecadoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoBecadoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoBecadoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoBecadoEstadoEnum d : AlumnoBecadoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
