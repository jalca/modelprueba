package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SorteoEstadoEnum {

    PEND("Pendiente"), ACT("Activo"), CER("Cerrado"), FIN("Finalizado");

    private final String value;
    private static final Map<String, SorteoEstadoEnum> lookup = new HashMap<>();

    static {
        for (SorteoEstadoEnum d : SorteoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SorteoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SorteoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SorteoEstadoEnum d : SorteoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
