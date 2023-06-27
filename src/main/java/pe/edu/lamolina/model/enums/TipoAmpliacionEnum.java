package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAmpliacionEnum {

    CONS("Consultar posible ampliación"),
    INCR("Incrementar vacantes");

    private final String value;
    private static final Map<String, TipoAmpliacionEnum> lookup = new HashMap<>();

    static {
        for (TipoAmpliacionEnum d : TipoAmpliacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAmpliacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAmpliacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAmpliacionEnum d : TipoAmpliacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
