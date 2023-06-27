package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ModoVentaEnum {

    WEB("Web"), VENTANI("Ventanilla");

    private final String value;
    private static final Map<String, ModoVentaEnum> lookup = new HashMap<>();

    static {
        for (ModoVentaEnum d : ModoVentaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ModoVentaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModoVentaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ModoVentaEnum d : ModoVentaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
