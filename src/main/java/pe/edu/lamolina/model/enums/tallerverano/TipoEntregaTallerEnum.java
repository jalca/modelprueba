package pe.edu.lamolina.model.enums.tallerverano;

import java.util.HashMap;
import java.util.Map;

public enum TipoEntregaTallerEnum {

    CARNET("Carnet"),
    DIPLOMA("Diploma"),
    REGALO("Regalo Genérico");

    private final String value;
    private static final Map<String, TipoEntregaTallerEnum> lookup = new HashMap<>();

    static {
        for (TipoEntregaTallerEnum d : TipoEntregaTallerEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEntregaTallerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEntregaTallerEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEntregaTallerEnum d : TipoEntregaTallerEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
