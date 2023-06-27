package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoGastoFinancieroEnum {

    CRE("Creado"), DIS("Distribuido");

    private final String value;
    private static final Map<String, EstadoGastoFinancieroEnum> lookup = new HashMap<>();

    static {
        for (EstadoGastoFinancieroEnum d : EstadoGastoFinancieroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoGastoFinancieroEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoGastoFinancieroEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoGastoFinancieroEnum d : EstadoGastoFinancieroEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
