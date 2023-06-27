package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAprobadorTesisEnum {

    PEND("Pendiente"), APR("Aprobado"), DESAP("Desaprobado");

    private final String value;
    private static final Map<String, EstadoAprobadorTesisEnum> lookup = new HashMap<>();

    static {
        for (EstadoAprobadorTesisEnum d : EstadoAprobadorTesisEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAprobadorTesisEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAprobadorTesisEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAprobadorTesisEnum d : EstadoAprobadorTesisEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
