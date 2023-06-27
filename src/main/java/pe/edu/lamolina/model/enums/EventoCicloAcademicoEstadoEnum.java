package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EventoCicloAcademicoEstadoEnum {

    ACT("Activo"), CRE("Creado"), ANU("Anulado");

    private final String value;
    private static final Map<String, EventoCicloAcademicoEstadoEnum> lookup = new HashMap<>();

    static {
        for (EventoCicloAcademicoEstadoEnum d : EventoCicloAcademicoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EventoCicloAcademicoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventoCicloAcademicoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EventoCicloAcademicoEstadoEnum d : EventoCicloAcademicoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
