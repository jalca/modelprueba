package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoNetworkingEnum {

    ACT("Activo"), INA("Inactivo"), PEND("Pendiente");

    private final String value;
    private static final Map<String, EstadoNetworkingEnum> lookup = new HashMap<>();

    static {
        for (EstadoNetworkingEnum d : EstadoNetworkingEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoNetworkingEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoNetworkingEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoNetworkingEnum d : EstadoNetworkingEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
