package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PerfilEstadoEnum {

    ACT("Activo"), CER("Cerrado"), INA("Inactivo"), CRE("Creado"), BLQ("Bloqueado");

    private final String value;
    private static final Map<String, PerfilEstadoEnum> lookup = new HashMap<>();

    static {
        for (PerfilEstadoEnum d : PerfilEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PerfilEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PerfilEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PerfilEstadoEnum d : PerfilEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
