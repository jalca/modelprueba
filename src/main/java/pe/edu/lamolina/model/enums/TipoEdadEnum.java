package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoEdadEnum {

    INF("Infancia"), NIN("Niñez"), ADO("Adolescencia"), JUV("Juventud"), ACT("Actualidad");

    private final String value;
    private static final Map<String, TipoEdadEnum> lookup = new HashMap<>();

    static {
        for (TipoEdadEnum d : TipoEdadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEdadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEdadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEdadEnum d : TipoEdadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
