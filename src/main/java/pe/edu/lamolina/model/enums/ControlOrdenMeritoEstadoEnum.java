package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ControlOrdenMeritoEstadoEnum {

    CRE("Creado"),
    CALC("Calculado"),
    CER("Cerrado");

    private final String value;
    private static final Map<String, ControlOrdenMeritoEstadoEnum> lookup = new HashMap<>();

    static {
        for (ControlOrdenMeritoEstadoEnum d : ControlOrdenMeritoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ControlOrdenMeritoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlOrdenMeritoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ControlOrdenMeritoEstadoEnum d : ControlOrdenMeritoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
