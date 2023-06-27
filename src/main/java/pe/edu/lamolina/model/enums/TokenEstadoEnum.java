package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TokenEstadoEnum {

    ACT("Activo"), USO("Usado"), INA("Inactivo");

    private final String value;
    private static final Map<String, TokenEstadoEnum> lookup = new HashMap();

    static {
        for (TokenEstadoEnum d : TokenEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TokenEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TokenEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TokenEstadoEnum d : TokenEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
