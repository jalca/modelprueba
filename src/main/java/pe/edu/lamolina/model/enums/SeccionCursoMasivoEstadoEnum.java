package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SeccionCursoMasivoEstadoEnum {

    ACT("Activo"),
    EXC("Excluido");

    private final String value;
    private static final Map<String, SeccionCursoMasivoEstadoEnum> lookup = new HashMap<>();

    static {
        for (SeccionCursoMasivoEstadoEnum d : SeccionCursoMasivoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SeccionCursoMasivoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SeccionCursoMasivoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SeccionCursoMasivoEstadoEnum d : SeccionCursoMasivoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
