package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMatriculaEnum {

    BARRIDO("Barrido"), ONLINE("En línea");

    private final String value;
    private static final Map<String, TipoMatriculaEnum> lookup = new HashMap<>();

    static {
        for (TipoMatriculaEnum d : TipoMatriculaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMatriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMatriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMatriculaEnum d : TipoMatriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
