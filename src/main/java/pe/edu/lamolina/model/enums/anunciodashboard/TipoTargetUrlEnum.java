package pe.edu.lamolina.model.enums.anunciodashboard;

import java.util.HashMap;
import java.util.Map;

public enum TipoTargetUrlEnum {

    DENTRO("Misma Pestaña"),
    AFUERA("Otra Pestaña");

    private final String value;
    private static final Map<String, TipoTargetUrlEnum> lookup = new HashMap<>();

    static {
        for (TipoTargetUrlEnum d : TipoTargetUrlEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTargetUrlEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoTargetUrlEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoTargetUrlEnum d : TipoTargetUrlEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
