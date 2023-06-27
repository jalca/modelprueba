package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConformidadTicketAyudaEnum {

    PENDIENTE("Pendiente"),
    CONFORME("Conforme"),
    INCONFORME("Inconforme"),
    AUTOMATICO("Automatico"),
    AUTOCONFORME("Autoconforme");

    private String value;
    private static final Map<String, ConformidadTicketAyudaEnum> lookup = new HashMap<String, ConformidadTicketAyudaEnum>();

    ConformidadTicketAyudaEnum(String value) {
        this.value = value;
    }

    static {
        for (ConformidadTicketAyudaEnum d : ConformidadTicketAyudaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public String getValue() {
        return value;
    }

    public static ConformidadTicketAyudaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
