package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoBloqueEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoBloqueEnum> lookup = new HashMap<>();

    static {
        for (EstadoBloqueEnum d : EstadoBloqueEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoBloqueEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoBloqueEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoBloqueEnum d : EstadoBloqueEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoBloqueEnum e : EstadoBloqueEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
