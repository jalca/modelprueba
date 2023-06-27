package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TicketComedorEstadoEnum {

    DISPONIBLE("Disponible", "Disponible para comprar"),
    PARA_BECADO("Disponible para becado", "Disponible para becado"), // disponibles pero no reservados
    VENDIDO("Vendido", "Comprado regular"), // para alumnos que pagan
    RESERVADO("Reservado para becado", "Reservado para becado"), // reservado para becados
    PASE_LIBRE("Pase libre", "Reservado por pase libre"), // para alumnos que pagan
    VENTA_LIBRE("Venta libre", "Comprado venta libre"), // para alumnos que pagan
    CONSUMIDO("Consumido", "Consumido"),
    ANULADO("Anulado", "Anulado"),
    // Estados no persistibles
    OCUPADO("Ocupado", "Ocupado"),
    DENEGADO("Denegado", "Denegado"),
    AGOTADO("Agotado", "Agotado");

    private final String value;
    private final String ownerValue;
    private static final Map<String, TicketComedorEstadoEnum> lookup = new HashMap<>();

    static {
        for (TicketComedorEstadoEnum d : TicketComedorEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TicketComedorEstadoEnum(String value, String ownerValue) {
        this.value = value;
        this.ownerValue = ownerValue;
    }

    public String getValue() {
        return value;
    }

    public String getOwnerValue() {
        return ownerValue;
    }

    public static TicketComedorEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TicketComedorEstadoEnum d : TicketComedorEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
