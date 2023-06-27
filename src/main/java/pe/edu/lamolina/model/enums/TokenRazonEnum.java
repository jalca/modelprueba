package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TokenRazonEnum {

    OLVIDO("olvido contrasena"), EMAIL("confirma email");

    private final String value;
    private static final Map<String, TokenRazonEnum> lookup = new HashMap<>();

    static {
        for (TokenRazonEnum d : TokenRazonEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TokenRazonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TokenRazonEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TokenRazonEnum d : TokenRazonEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
