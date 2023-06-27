package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmbitoTarifaEnum {

    NAC("Nacionales"), CAN("Extranjeros de la Comunidad Andina"), EXT("Extranjeros");

    private final String value;
    private static final Map<String, AmbitoTarifaEnum> lookup = new HashMap<>();

    static {
        for (AmbitoTarifaEnum d : AmbitoTarifaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmbitoTarifaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmbitoTarifaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AmbitoTarifaEnum d : AmbitoTarifaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
