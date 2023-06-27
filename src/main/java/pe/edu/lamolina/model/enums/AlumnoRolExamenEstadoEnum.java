package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoRolExamenEstadoEnum {

    ACT("Activo"), EXC("Excluido"), TRA("Trasladado");

    private final String value;
    private static final Map<String, AlumnoRolExamenEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoRolExamenEstadoEnum d : AlumnoRolExamenEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoRolExamenEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoRolExamenEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoRolExamenEstadoEnum d : AlumnoRolExamenEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
