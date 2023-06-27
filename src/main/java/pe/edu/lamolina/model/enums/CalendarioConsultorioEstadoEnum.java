package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CalendarioConsultorioEstadoEnum {

    PROG("Programado"), DIS("Disponible"), OCU("Ocupado"), NDIS("No Disponible");

    private final String value;
    private static final Map<String, CalendarioConsultorioEstadoEnum> lookup = new HashMap<>();

    static {
        for (CalendarioConsultorioEstadoEnum d : CalendarioConsultorioEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CalendarioConsultorioEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CalendarioConsultorioEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CalendarioConsultorioEstadoEnum d : CalendarioConsultorioEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
