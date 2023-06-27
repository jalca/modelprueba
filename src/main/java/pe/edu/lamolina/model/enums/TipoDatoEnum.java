package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDatoEnum {
    INTEGER("Numérico"), STRING("Texto"), BIGDECIMAL("Decimal"), DATE("Fecha");

    private final String value;
    private static final Map<String, TipoDatoEnum> lookup = new HashMap<>();

    static {
        for (TipoDatoEnum d : TipoDatoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoDatoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDatoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDatoEnum d : TipoDatoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
