package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAsistenciaEnum {

    PEND("Pendiente"),
    ASIS("Asistió"),
    TAR("Tardanza"),
    FAL("Faltó");

    private final String value;
    private static final Map<String, EstadoAsistenciaEnum> lookup = new HashMap<>();

    static {
        for (EstadoAsistenciaEnum d : EstadoAsistenciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAsistenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAsistenciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAsistenciaEnum d : EstadoAsistenciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
