package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CitaEstadoEnum {

    ESP("Espera"), CAN("Cancelado"), ATEN("Atendido");

    private final String value;
    private static final Map<String, CitaEstadoEnum> lookup = new HashMap<>();

    static {
        for (CitaEstadoEnum d : CitaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CitaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CitaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CitaEstadoEnum d : CitaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
