package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TicketLiberadoEstadoEnum {

    LIBERADO("Liberado"), 
    CONSUMIDO("Consumido");

    private final String value;
    private static final Map<String, TicketLiberadoEstadoEnum> lookup = new HashMap<>();

    static {
        for (TicketLiberadoEstadoEnum d : TicketLiberadoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TicketLiberadoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TicketLiberadoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TicketLiberadoEstadoEnum d : TicketLiberadoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
