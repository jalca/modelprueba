package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum FuncionRolEstadoEnum {

    ACT("Activo"), INA("Inactivo");

    private final String value;
    private static final Map<String, FuncionRolEstadoEnum> lookup = new HashMap<>();

    static {
        for (FuncionRolEstadoEnum d : FuncionRolEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private FuncionRolEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FuncionRolEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (FuncionRolEstadoEnum d : FuncionRolEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
