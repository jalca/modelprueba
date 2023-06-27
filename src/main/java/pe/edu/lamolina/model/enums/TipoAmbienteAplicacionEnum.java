package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAmbienteAplicacionEnum {
    DESARROLLO("Desarrollo"), TEST("Test"), PRODUCCION("Produccion");

    private final String value;
    private static final Map<String, TipoAmbienteAplicacionEnum> lookup = new HashMap<>();

    static {
        for (TipoAmbienteAplicacionEnum d : TipoAmbienteAplicacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAmbienteAplicacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAmbienteAplicacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAmbienteAplicacionEnum d : TipoAmbienteAplicacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
