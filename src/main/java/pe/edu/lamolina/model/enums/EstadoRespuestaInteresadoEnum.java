package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoRespuestaInteresadoEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoRespuestaInteresadoEnum> lookup = new HashMap<>();

    static {
        for (EstadoRespuestaInteresadoEnum d : EstadoRespuestaInteresadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoRespuestaInteresadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoRespuestaInteresadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoRespuestaInteresadoEnum d : EstadoRespuestaInteresadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoRespuestaInteresadoEnum e : EstadoRespuestaInteresadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
