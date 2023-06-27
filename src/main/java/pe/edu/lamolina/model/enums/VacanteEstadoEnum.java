package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum VacanteEstadoEnum {

    PEND("Pendiente"), CONF("Configurando"), DIST("Distribuyendo"), ACT("Activo"), CER("Cerrado");

    private final String value;
    private static final Map<String, VacanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (VacanteEstadoEnum d : VacanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private VacanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VacanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (VacanteEstadoEnum d : VacanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
