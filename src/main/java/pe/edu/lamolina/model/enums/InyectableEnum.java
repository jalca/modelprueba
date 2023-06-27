package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum InyectableEnum {

    IM("Intramuscular"), EV("Endovenoso");

    private final String value;
    private static final Map<String, InyectableEnum> lookup = new HashMap<>();

    static {
        for (InyectableEnum d : InyectableEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private InyectableEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InyectableEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (InyectableEnum d : InyectableEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
