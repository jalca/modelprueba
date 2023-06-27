package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoTemaEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoTemaEnum> lookup = new HashMap<>();

    static {
        for (EstadoTemaEnum d : EstadoTemaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoTemaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoTemaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoTemaEnum d : EstadoTemaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoTemaEnum e : EstadoTemaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
