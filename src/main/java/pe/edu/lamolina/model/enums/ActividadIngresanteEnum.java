package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActividadIngresanteEnum {

    PEND("Pendiente"),COMP("Completado");

    private final String value;
    private static final Map<String, ActividadIngresanteEnum> lookup = new HashMap<>();

    static {
        for (ActividadIngresanteEnum d : ActividadIngresanteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ActividadIngresanteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ActividadIngresanteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ActividadIngresanteEnum d : ActividadIngresanteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
