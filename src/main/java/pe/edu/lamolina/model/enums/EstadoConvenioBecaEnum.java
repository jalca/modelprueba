package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoConvenioBecaEnum {

    ACT("Activo"),
    DES("Desactivado"),
    PEN("Pendiente");

    private final String value;
    private static final Map<String, EstadoConvenioBecaEnum> lookup = new HashMap<>();

    static {
        for (EstadoConvenioBecaEnum d : EstadoConvenioBecaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoConvenioBecaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoConvenioBecaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoConvenioBecaEnum d : EstadoConvenioBecaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoConvenioBecaEnum e : EstadoConvenioBecaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
