package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMigracionEnum {

    NREG("Nuevo Registro"),
    AREG("Actualizacion Registro");

    private final String value;
    private static final Map<String, TipoMigracionEnum> lookup = new HashMap<>();

    static {
        for (TipoMigracionEnum d : TipoMigracionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMigracionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMigracionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMigracionEnum d : TipoMigracionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
