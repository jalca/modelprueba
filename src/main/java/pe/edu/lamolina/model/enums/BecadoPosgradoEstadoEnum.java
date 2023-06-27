package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum BecadoPosgradoEstadoEnum {

    PEND("Pendiente"),
    ACEP("Aceptado"),
    RCHZ("Rechazado");

    private final String value;
    private static final Map<String, BecadoPosgradoEstadoEnum> lookup = new HashMap<>();

    static {
        for (BecadoPosgradoEstadoEnum d : BecadoPosgradoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private BecadoPosgradoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BecadoPosgradoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (BecadoPosgradoEstadoEnum d : BecadoPosgradoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
