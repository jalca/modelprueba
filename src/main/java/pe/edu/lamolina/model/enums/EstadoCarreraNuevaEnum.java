package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCarreraNuevaEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoCarreraNuevaEnum> lookup = new HashMap<>();

    static {
        for (EstadoCarreraNuevaEnum d : EstadoCarreraNuevaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCarreraNuevaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCarreraNuevaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCarreraNuevaEnum d : EstadoCarreraNuevaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoCarreraNuevaEnum e : EstadoCarreraNuevaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
