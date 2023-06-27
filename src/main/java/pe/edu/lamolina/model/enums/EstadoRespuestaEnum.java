package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoRespuestaEnum {

    ERR("Error"),
    MULT("Multiple"),
    OK("OK"),
    VACIO("Vacio");

    private final String value;
    private static final Map<String, EstadoRespuestaEnum> lookup = new HashMap<>();

    static {
        for (EstadoRespuestaEnum d : EstadoRespuestaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoRespuestaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoRespuestaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoRespuestaEnum d : EstadoRespuestaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoRespuestaEnum e : EstadoRespuestaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
