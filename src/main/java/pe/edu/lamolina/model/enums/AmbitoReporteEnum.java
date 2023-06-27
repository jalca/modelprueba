package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmbitoReporteEnum {

    ADMISION_EPG("Reportes Admisión Posgrado"),
    PROGRAMACION_OERA("Reportes Programación Horarios"),
    ALUMNO_EPG("Reportes Alumno Posgrado"),
    TARIFA_EPG("Reportes Tarifa");

    private final String value;
    private static final Map<String, AmbitoReporteEnum> lookup = new HashMap<>();

    static {
        for (AmbitoReporteEnum d : AmbitoReporteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmbitoReporteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmbitoReporteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (AmbitoReporteEnum d : AmbitoReporteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
