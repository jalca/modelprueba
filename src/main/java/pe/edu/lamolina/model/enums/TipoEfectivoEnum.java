package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoEfectivoEnum {

    EFEC("Efectivo");

    private final String value;
    private static final Map<String, TipoEfectivoEnum> lookup = new HashMap<>();

    static {
        for (TipoEfectivoEnum d : TipoEfectivoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEfectivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEfectivoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEfectivoEnum d : TipoEfectivoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
