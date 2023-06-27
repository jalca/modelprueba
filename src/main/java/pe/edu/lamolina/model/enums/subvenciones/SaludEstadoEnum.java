package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum SaludEstadoEnum {

    PENDIENTE("Pendiente"),
    SALUD_OK("Buena salud"),
    SALUD_NO_OK("Mala salud"),;

    private final String value;
    private static final Map<String, SaludEstadoEnum> lookup = new HashMap<>();

    static {
        for (SaludEstadoEnum d : SaludEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SaludEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SaludEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SaludEstadoEnum d : SaludEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
