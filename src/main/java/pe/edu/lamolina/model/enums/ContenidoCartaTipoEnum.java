package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContenidoCartaTipoEnum {

    IMG("Imagen para Header o Footer"),
    CONT("Contenido de Texto");

    private final String value;
    private static final Map<String, ContenidoCartaTipoEnum> lookup = new HashMap<>();

    static {
        for (ContenidoCartaTipoEnum d : ContenidoCartaTipoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContenidoCartaTipoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContenidoCartaTipoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContenidoCartaTipoEnum d : ContenidoCartaTipoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
