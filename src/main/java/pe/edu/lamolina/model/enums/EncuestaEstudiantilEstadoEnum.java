package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EncuestaEstudiantilEstadoEnum {

    TEO("Encuestado en teoría"),//encuesta docente
    FECH("Sin periodo"),//encuesta docente
    PEND("Pendiente"),//encuesta alumno
    ANU("No Encuestable"),//encuesta docente curso docente retira
    ENC("Encuestado"),//encuesta alumno
    ACT("Encuestada Activa"),//encuesta docente curso
    CER("Cerrada"),//encuesta docente curso
    RET("Retirado");//encuesta alumno retirado

    private final String value;
    private static final Map<String, EncuestaEstudiantilEstadoEnum> lookup = new HashMap<>();

    static {
        for (EncuestaEstudiantilEstadoEnum d : EncuestaEstudiantilEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EncuestaEstudiantilEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EncuestaEstudiantilEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EncuestaEstudiantilEstadoEnum d : EncuestaEstudiantilEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EncuestaEstudiantilEstadoEnum e : EncuestaEstudiantilEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
