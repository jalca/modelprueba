package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoLeccionEnum {

    REG("Regular"),
    REP("Reprogramado");

    private final String value;
    private static final Map<String, TipoLeccionEnum> lookup = new HashMap<>();

    static {
        for (TipoLeccionEnum d : TipoLeccionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoLeccionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoLeccionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoLeccionEnum d : TipoLeccionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
