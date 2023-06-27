package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DescuentoCicloCepreEnum {

    _50("50 %", 50), _30("30 %", 30), _25("25 %", 25);

    private final String value;
    private final Integer intValue;
    private static final Map<String, DescuentoCicloCepreEnum> lookup = new HashMap<>();

    static {
        for (DescuentoCicloCepreEnum d : DescuentoCicloCepreEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DescuentoCicloCepreEnum(String value, Integer intValue) {
        this.value = value;
        this.intValue = intValue;
    }

    public String getValue() {
        return value;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public static DescuentoCicloCepreEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DescuentoCicloCepreEnum d : DescuentoCicloCepreEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
