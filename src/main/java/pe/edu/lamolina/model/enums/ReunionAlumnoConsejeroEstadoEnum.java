package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReunionAlumnoConsejeroEstadoEnum {

    ANU("Anulado"),
    ASIS("Asistió"),
    AGEN("Agendado"),
    NASIS("No Asistió");

    private final String value;
    private static final Map<String, ReunionAlumnoConsejeroEstadoEnum> lookup = new HashMap<>();

    static {
        for (ReunionAlumnoConsejeroEstadoEnum d : ReunionAlumnoConsejeroEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ReunionAlumnoConsejeroEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReunionAlumnoConsejeroEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ReunionAlumnoConsejeroEstadoEnum d : ReunionAlumnoConsejeroEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
