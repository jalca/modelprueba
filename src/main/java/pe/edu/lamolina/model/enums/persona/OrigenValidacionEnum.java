package pe.edu.lamolina.model.enums.persona;

import java.util.HashMap;
import java.util.Map;

public enum OrigenValidacionEnum {

    ALUMNO_ANTIGUO("Alumno Antiguo"),
    ALUMNO_ESPECIAL("Alumno Especial"),
    INGRESANTE_POSGRADO("Ingresante Posgrado"),
    INGRESANTE_PREGRADO("Ingresante Pregrado"),
    ALUMNO_POSGRADO("Alumno Posgrado"),
    ALUMNO_AMAUTA("Alumno Amauta"),
    POSTULANTE_PREGRADO("Postulante Pregrado"),
    POSTULANTE_POSGRADO("Postulante Posgrado"),
    DOCENTE("Docente"),
    COLABORADOR("Colaborador"),
    CENTRO_MEDICO("Centro Médico"),
    COMEDOR("Comedor Universitario");

    private final String value;
    private static final Map<String, OrigenValidacionEnum> lookup = new HashMap<>();

    static {
        for (OrigenValidacionEnum d : OrigenValidacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OrigenValidacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrigenValidacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OrigenValidacionEnum d : OrigenValidacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
