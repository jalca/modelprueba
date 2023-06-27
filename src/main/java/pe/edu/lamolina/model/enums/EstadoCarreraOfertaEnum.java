package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCarreraOfertaEnum {

    ACT("Aprobado"), INA("Inactivo"), PEN("Pendiente");

    private final String value;
    private static final Map<String, EstadoCarreraOfertaEnum> lookup = new HashMap<>();

    static {
        for (EstadoCarreraOfertaEnum d : EstadoCarreraOfertaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCarreraOfertaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCarreraOfertaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCarreraOfertaEnum d : EstadoCarreraOfertaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
