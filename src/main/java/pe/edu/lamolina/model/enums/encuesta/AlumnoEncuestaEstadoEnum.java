package pe.edu.lamolina.model.enums.encuesta;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoEncuestaEstadoEnum {

    INICIADA("Iniciada"),
    FINALIZADA("Finalizada"),
    PARCIAL("Parcialmente llenada"),
    PENDIENTE("Pendiente"),
    PROCESADO("Procesado");

    private final String value;
    private static final Map<String, AlumnoEncuestaEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoEncuestaEstadoEnum d : AlumnoEncuestaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoEncuestaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoEncuestaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoEncuestaEstadoEnum d : AlumnoEncuestaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (AlumnoEncuestaEstadoEnum e : AlumnoEncuestaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
