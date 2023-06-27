package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AtencionExternaEnum {

    INTERC("Interconsulta"), EXAM("Examen auxiliar");

    private final String value;
    private static final Map<String, AtencionExternaEnum> lookup = new HashMap<>();

    static {
        for (AtencionExternaEnum d : AtencionExternaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AtencionExternaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AtencionExternaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AtencionExternaEnum d : AtencionExternaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
