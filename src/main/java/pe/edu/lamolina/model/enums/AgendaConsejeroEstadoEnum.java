package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AgendaConsejeroEstadoEnum {

    AGEN("Agendado", 1l),
    ATEN("Atendido", 2l),
    VEN("Vencido", 3l),
    ANU("Anulado", 4l);

    private final String value;
    private final Long valuePrioridad;
    private static final Map<String, AgendaConsejeroEstadoEnum> lookup = new HashMap<>();

    static {
        for (AgendaConsejeroEstadoEnum d : AgendaConsejeroEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AgendaConsejeroEstadoEnum(String value, Long valuePrioridad) {
        this.value = value;
        this.valuePrioridad = valuePrioridad;
    }

    public String getValue() {
        return value;
    }

    public Long getValuePrioridad() {
        return valuePrioridad;
    }

    public static AgendaConsejeroEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AgendaConsejeroEstadoEnum d : AgendaConsejeroEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
