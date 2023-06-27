package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoEstadoEnum {

    ACT("Activo"),
    FAPR("Sin Aprobar"),
    FRES("Sin Resolución"),
    // Estado no persistibles
    NO_APTO("No Apto"),
    NO_MATRICULABLE("No Matriculable"),
    NO_MATRICULADO("No Matriculado"),
    NO_EXISTE("No Existe");

    private final String value;
    private static final Map<String, AlumnoEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoEstadoEnum d : AlumnoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoEstadoEnum d : AlumnoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
