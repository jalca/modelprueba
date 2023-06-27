package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActividadPostulanteEscuelaEstadoEnum {

    PEND("Pendiente"),
    FIN("Finalizado"),
    OBSV("Observado"),
    EJEC("Ejecutado"),
    ENV("Enviado"),
    CRE("Creado"),
    DISP("Disponible"),
    DEU("Deuda");

    private final String value;
    private static final Map<String, ActividadPostulanteEscuelaEstadoEnum> lookup = new HashMap<>();

    static {
        for (ActividadPostulanteEscuelaEstadoEnum d : ActividadPostulanteEscuelaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ActividadPostulanteEscuelaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ActividadPostulanteEscuelaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ActividadPostulanteEscuelaEstadoEnum d : ActividadPostulanteEscuelaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
