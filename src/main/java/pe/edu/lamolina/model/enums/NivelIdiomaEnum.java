package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NivelIdiomaEnum {

    BASICO("Básico"), INTERMEDIO("Intermedio"), AVANZADO("Avanzado");

    private final String value;
    private static final Map<String, NivelIdiomaEnum> lookup = new HashMap<>();

    static {
        for (NivelIdiomaEnum d : NivelIdiomaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private NivelIdiomaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NivelIdiomaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (NivelIdiomaEnum d : NivelIdiomaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
