package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoTrasladoTicketEnum {
    
    TOFI("Traslado a otra oficina"), 
    TCOL("Traslado a otro colaborador");

    private final String value;
    private static final Map<String, TipoTrasladoTicketEnum> lookup = new HashMap<>();

    static {
        for (TipoTrasladoTicketEnum d : TipoTrasladoTicketEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTrasladoTicketEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoTrasladoTicketEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoTrasladoTicketEnum d : TipoTrasladoTicketEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
