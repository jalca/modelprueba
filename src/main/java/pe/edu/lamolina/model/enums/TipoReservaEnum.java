package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoReservaEnum {

    PUNT("Puntual"), PERI("Periódica");

    private final String value;
    private static final Map<String, TipoReservaEnum> lookup = new HashMap<>();

    static {
        for (TipoReservaEnum d : TipoReservaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoReservaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoReservaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoReservaEnum d : TipoReservaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
