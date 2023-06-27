package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCarreraEscuelaEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoCarreraEscuelaEnum> lookup = new HashMap<>();

    static {
        for (EstadoCarreraEscuelaEnum d : EstadoCarreraEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCarreraEscuelaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCarreraEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCarreraEscuelaEnum d : EstadoCarreraEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoCarreraEscuelaEnum e : EstadoCarreraEscuelaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
