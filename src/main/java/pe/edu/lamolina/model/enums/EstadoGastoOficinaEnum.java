package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoGastoOficinaEnum {

    CRE("Creado"), CERR("Cerrado");

    private final String value;
    private static final Map<String, EstadoGastoOficinaEnum> lookup = new HashMap<>();

    static {
        for (EstadoGastoOficinaEnum d : EstadoGastoOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoGastoOficinaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoGastoOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoGastoOficinaEnum d : EstadoGastoOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
