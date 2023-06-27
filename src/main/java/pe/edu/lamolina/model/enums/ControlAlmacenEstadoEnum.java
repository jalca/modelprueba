package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ControlAlmacenEstadoEnum {

    ABI("Abierto"),
    CER("Cerrado");

    private final String value;
    private static final Map<String, ControlAlmacenEstadoEnum> lookup = new HashMap<>();

    static {
        for (ControlAlmacenEstadoEnum d : ControlAlmacenEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ControlAlmacenEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlAlmacenEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ControlAlmacenEstadoEnum d : ControlAlmacenEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
