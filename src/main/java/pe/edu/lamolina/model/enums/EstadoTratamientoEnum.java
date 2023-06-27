package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoTratamientoEnum {

    CONCLUYO("Concluyó Tratamiento"), ABANDONO("Abandonó Tratamiento");

    private final String value;
    private static final Map<String, EstadoTratamientoEnum> lookup = new HashMap<>();

    static {
        for (EstadoTratamientoEnum d : EstadoTratamientoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoTratamientoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoTratamientoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoTratamientoEnum d : EstadoTratamientoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
