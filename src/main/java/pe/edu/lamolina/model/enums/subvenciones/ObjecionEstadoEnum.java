package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum ObjecionEstadoEnum {

    PENDIENTE("Pendiente"),
    LEVANTADO("Levantado"),
    RECHAZADO("Rechazado"),
    ACEPTADO("Aceptado");

    private final String value;
    private static final Map<String, ObjecionEstadoEnum> lookup = new HashMap<>();

    static {
        for (ObjecionEstadoEnum d : ObjecionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ObjecionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ObjecionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ObjecionEstadoEnum d : ObjecionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
