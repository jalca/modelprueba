package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoInventarioEnum {

    PRES("Prestado", "badge-info"),
    MANT("Mantenimiento", "badge-warning"),
    BAJA("De baja", "badge-danger"),
    DISP("Disponible", "badge-success");

    private final String value;
    private final String badge;
    private static final Map<String, EstadoInventarioEnum> lookup = new HashMap<>();

    static {
        for (EstadoInventarioEnum d : EstadoInventarioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public static EstadoInventarioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoInventarioEnum d : EstadoInventarioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
