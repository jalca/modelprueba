package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum IngresanteEstadoEnum {

    ACT("Activo"), PEND("Pendiente"), INC("Incompleto");

    private final String value;
    private static final Map<String, IngresanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (IngresanteEstadoEnum d : IngresanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private IngresanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IngresanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (IngresanteEstadoEnum d : IngresanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
