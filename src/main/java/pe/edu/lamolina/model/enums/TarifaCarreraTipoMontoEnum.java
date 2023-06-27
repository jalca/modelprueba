package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TarifaCarreraTipoMontoEnum {

    SEM("Semestral"),
    CARR("Carrera");

    private final String value;
    private static final Map<String, TarifaCarreraTipoMontoEnum> lookup = new HashMap<>();

    static {
        for (TarifaCarreraTipoMontoEnum d : TarifaCarreraTipoMontoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TarifaCarreraTipoMontoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TarifaCarreraTipoMontoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TarifaCarreraTipoMontoEnum d : TarifaCarreraTipoMontoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
