package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoEnfermedadEnum {

    GEN("General"), 
    OFTA("Oftalmologia"), 
    DIS("Discapacidad");

    private final String value;
    private static final Map<String, TipoEnfermedadEnum> lookup = new HashMap<>();

    static {
        for (TipoEnfermedadEnum d : TipoEnfermedadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEnfermedadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEnfermedadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEnfermedadEnum d : TipoEnfermedadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
