package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AprobacionComiteConsejeroEstadoEnum {

    ACP("Aceptado"), PEN("Pendiente");

    private final String value;
    private static final Map<String, AprobacionComiteConsejeroEstadoEnum> lookup = new HashMap<>();

    static {
        for (AprobacionComiteConsejeroEstadoEnum d : AprobacionComiteConsejeroEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AprobacionComiteConsejeroEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AprobacionComiteConsejeroEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AprobacionComiteConsejeroEstadoEnum d : AprobacionComiteConsejeroEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
