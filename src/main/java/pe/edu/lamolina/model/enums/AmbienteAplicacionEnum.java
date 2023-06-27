package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmbienteAplicacionEnum {

    DESA("Desarrollo"), ALTER("Alternativo"), TEST("Testing"), PROD("Producción");

    private final String value;
    private static final Map<String, AmbienteAplicacionEnum> lookup = new HashMap<>();

    static {
        for (AmbienteAplicacionEnum d : AmbienteAplicacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmbienteAplicacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmbienteAplicacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AmbienteAplicacionEnum d : AmbienteAplicacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
