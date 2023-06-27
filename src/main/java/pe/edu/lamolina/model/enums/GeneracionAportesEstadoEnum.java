package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum GeneracionAportesEstadoEnum {

    CRE("Creado"), CONF("Configurando"), GEN("Generado"), BOL("Boleta Generada");

    private final String value;
    private static final Map<String, GeneracionAportesEstadoEnum> lookup = new HashMap<>();

    static {
        for (GeneracionAportesEstadoEnum d : GeneracionAportesEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private GeneracionAportesEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GeneracionAportesEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (GeneracionAportesEstadoEnum d : GeneracionAportesEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
