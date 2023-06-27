package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoCursoSimultaneoEstadoEnum {

    PMAT("Prematriculado"),
    NMAT("No Matriculado"),
    MAT("Matriculado"),
    NVAV("No consiguió vacante"),
    NREQ("No cumple requisitos");

    private final String value;
    private static final Map<String, AlumnoCursoSimultaneoEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoCursoSimultaneoEstadoEnum d : AlumnoCursoSimultaneoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoCursoSimultaneoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoCursoSimultaneoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoCursoSimultaneoEstadoEnum d : AlumnoCursoSimultaneoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
