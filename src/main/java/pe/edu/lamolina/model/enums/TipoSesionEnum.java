package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSesionEnum {

    LOGIN("Inicio sesión"), LOGOUT("Sesión cerrada");

    private final String value;
    private static final Map<String, TipoSesionEnum> lookup = new HashMap<>();

    static {
        for (TipoSesionEnum d : TipoSesionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoSesionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoSesionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSesionEnum d : TipoSesionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
