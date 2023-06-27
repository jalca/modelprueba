package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SimboloUnidadMedidaEnum {

    uni("Unidad"), Kg("Kilogramo");

    private final String value;
    private static final Map<String, SimboloUnidadMedidaEnum> lookup = new HashMap<>();

    static {
        for (SimboloUnidadMedidaEnum d : SimboloUnidadMedidaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SimboloUnidadMedidaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SimboloUnidadMedidaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SimboloUnidadMedidaEnum d : SimboloUnidadMedidaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
