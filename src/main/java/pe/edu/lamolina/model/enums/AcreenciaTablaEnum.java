package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AcreenciaTablaEnum {

    FIN_DEUDA_INTERESADO("FIN_DEUDA_INTERESADO");

    private final String value;
    private static final Map<String, AcreenciaTablaEnum> lookup = new HashMap<>();

    static {
        for (AcreenciaTablaEnum d : AcreenciaTablaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AcreenciaTablaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcreenciaTablaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AcreenciaTablaEnum d : AcreenciaTablaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
