package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMensajeTicketAyudaEnum {

    TICKET("Ticket"),
    RESPUESTA("Respuesta"),
    NOTA("Nota");
    
    private final String value;

    private static final Map<String, TipoMensajeTicketAyudaEnum> lookup = new HashMap<String, TipoMensajeTicketAyudaEnum>();

    TipoMensajeTicketAyudaEnum(String value) {
        this.value = value;
    }

    static {
        for (TipoMensajeTicketAyudaEnum d : TipoMensajeTicketAyudaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public String getValue() {
        return value;
    }

    public static TipoMensajeTicketAyudaEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
