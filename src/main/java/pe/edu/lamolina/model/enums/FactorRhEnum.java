package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum FactorRhEnum {

    P("Positivo"), N("Negativo"), PC("Por Confirmar");

    private final String value;
    private static final Map<String, FactorRhEnum> lookup = new HashMap<>();

    static {
        for (FactorRhEnum d : FactorRhEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private FactorRhEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FactorRhEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (FactorRhEnum d : FactorRhEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
