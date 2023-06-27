package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OpcionFotoEnum {

    A("Voy a llevar una foto a la unidad de registros académicos "),
    B("Voy a subir una fotografía en este momento"),
    C("Voy a subir una fotografía más adelante"),
    D("Quiero tomarme la foto en la unidad de registros académicos ");

    private final String value;
    private static final Map<String, OpcionFotoEnum> lookup = new HashMap<>();

    static {
        for (OpcionFotoEnum d : OpcionFotoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OpcionFotoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OpcionFotoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OpcionFotoEnum d : OpcionFotoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
