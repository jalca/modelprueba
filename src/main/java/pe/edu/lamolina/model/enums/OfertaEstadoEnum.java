package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OfertaEstadoEnum {

    DRAFT("En proceso"), PUB("Publicado"), INA("Inactivo");

    private final String value;
    private static final Map<String, OfertaEstadoEnum> lookup = new HashMap<>();

    static {
        for (OfertaEstadoEnum d : OfertaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OfertaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OfertaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OfertaEstadoEnum d : OfertaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
