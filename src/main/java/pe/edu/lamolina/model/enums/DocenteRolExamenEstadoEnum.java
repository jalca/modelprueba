package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DocenteRolExamenEstadoEnum {

    ACT("Activo"), EXC("Excluido");

    private final String value;
    private static final Map<String, DocenteRolExamenEstadoEnum> lookup = new HashMap<>();

    static {
        for (DocenteRolExamenEstadoEnum d : DocenteRolExamenEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DocenteRolExamenEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DocenteRolExamenEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DocenteRolExamenEstadoEnum d : DocenteRolExamenEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
