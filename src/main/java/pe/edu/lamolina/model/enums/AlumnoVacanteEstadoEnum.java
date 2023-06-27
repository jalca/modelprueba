package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoVacanteEstadoEnum {

    RESV("Reservado"), LIBE("Liberado");

    private final String value;
    private static final Map<String, AlumnoVacanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoVacanteEstadoEnum d : AlumnoVacanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoVacanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoVacanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoVacanteEstadoEnum d : AlumnoVacanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
