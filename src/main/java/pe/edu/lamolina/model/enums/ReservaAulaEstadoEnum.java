package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReservaAulaEstadoEnum {

    ACT("Activo"),
    PEND("Pendiente"),
    RES("Reservado"),
    ANU("Anulado"),
    REG("Regularizado") // Es como anulado pero que se llevo acabo
    ;

    private final String value;
    private static final Map<String, ReservaAulaEstadoEnum> lookup = new HashMap<>();

    static {
        for (ReservaAulaEstadoEnum d : ReservaAulaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ReservaAulaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReservaAulaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ReservaAulaEstadoEnum d : ReservaAulaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
