package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPrestamoInventarioEnum {

    PRES("Prestado"), DEV("Devuelto"), DEVFALL("Devuelto con fallo"), DISP("Disponible"), MANT("Mantenimiento"), BAJA("De baja");

    private final String value;
    private static final Map<String, EstadoPrestamoInventarioEnum> lookup = new HashMap<>();

    static {
        for (EstadoPrestamoInventarioEnum d : EstadoPrestamoInventarioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoPrestamoInventarioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPrestamoInventarioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPrestamoInventarioEnum d : EstadoPrestamoInventarioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
