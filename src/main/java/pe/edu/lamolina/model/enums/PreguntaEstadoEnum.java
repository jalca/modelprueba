package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PreguntaEstadoEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, PreguntaEstadoEnum> lookup = new HashMap<>();

    static {
        for (PreguntaEstadoEnum d : PreguntaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PreguntaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PreguntaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PreguntaEstadoEnum d : PreguntaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (PreguntaEstadoEnum e : PreguntaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
