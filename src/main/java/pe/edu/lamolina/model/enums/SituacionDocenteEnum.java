package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SituacionDocenteEnum {

    ERR("Error"), COR("Correcto");

    private final String value;
    private static final Map<String, SituacionDocenteEnum> lookup = new HashMap<>();

    static {
        for (SituacionDocenteEnum d : SituacionDocenteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SituacionDocenteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SituacionDocenteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SituacionDocenteEnum d : SituacionDocenteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
