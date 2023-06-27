package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPreguntaEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoPreguntaEnum> lookup = new HashMap<>();

    static {
        for (EstadoPreguntaEnum d : EstadoPreguntaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoPreguntaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPreguntaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPreguntaEnum d : EstadoPreguntaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoPreguntaEnum e : EstadoPreguntaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
