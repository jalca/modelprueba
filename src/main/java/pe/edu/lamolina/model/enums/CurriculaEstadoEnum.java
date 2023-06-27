package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CurriculaEstadoEnum {

    ACT("Activo"),
    CAD("Caduco");

    private final String value;
    private static final Map<String, CurriculaEstadoEnum> lookup = new HashMap<>();

    static {
        for (CurriculaEstadoEnum d : CurriculaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CurriculaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CurriculaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CurriculaEstadoEnum d : CurriculaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
