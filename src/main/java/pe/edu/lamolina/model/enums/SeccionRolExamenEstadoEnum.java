package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SeccionRolExamenEstadoEnum {

    ACT("Activo"), EXC("Excluido"), TRA("Trasladado");

    private final String value;
    private static final Map<String, SeccionRolExamenEstadoEnum> lookup = new HashMap<>();

    static {
        for (SeccionRolExamenEstadoEnum d : SeccionRolExamenEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SeccionRolExamenEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SeccionRolExamenEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SeccionRolExamenEstadoEnum d : SeccionRolExamenEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
