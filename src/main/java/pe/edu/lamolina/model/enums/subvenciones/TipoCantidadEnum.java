package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum TipoCantidadEnum {

    TOTAL("Total"),
    PARCIAL("Parcial");

    private final String value;
    private static final Map<String, TipoCantidadEnum> lookup = new HashMap<>();

    static {
        for (TipoCantidadEnum d : TipoCantidadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCantidadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCantidadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCantidadEnum d : TipoCantidadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
