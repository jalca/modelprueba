package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TallerEstadoEnum {

    ACT("Activo", 1),
    INA("Inactivo", 3),
    PROX("Proximamente", 2);

    private final String value;
    private final Integer prioridad;
    private static final Map<String, TallerEstadoEnum> lookup = new HashMap<>();

    static {
        for (TallerEstadoEnum d : TallerEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TallerEstadoEnum(String value, Integer prioridad) {
        this.value = value;
        this.prioridad = prioridad;
    }

    public String getValue() {
        return value;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public static TallerEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TallerEstadoEnum d : TallerEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
