package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoTicketAyudaEnum {

    ACTIVO("Activo"),
    RESPONDIDO("Respondido"),
    CERRADO("Cerrado");

    private final String value;
    private static final Map<String, EstadoTicketAyudaEnum> lookup = new HashMap<>();

    static {
        for (EstadoTicketAyudaEnum d : EstadoTicketAyudaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoTicketAyudaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoTicketAyudaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
