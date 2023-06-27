package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoHoraEnum {

    H60("Hora de 60 minutos"),
    H30("Hora de 30 minutos");

    private final String value;
    private static final Map<String, TipoHoraEnum> lookup = new HashMap<>();

    static {
        for (TipoHoraEnum d : TipoHoraEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoHoraEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoHoraEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoHoraEnum d : TipoHoraEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
