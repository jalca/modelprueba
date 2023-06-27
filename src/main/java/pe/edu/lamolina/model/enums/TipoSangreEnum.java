package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSangreEnum {

    A("Tipo A"), B("Tipo B"), O("Tipo O"), AB("Tipo AB"), PC("Por Confirmar");

    private final String value;
    private static final Map<String, TipoSangreEnum> lookup = new HashMap<>();

    static {
        for (TipoSangreEnum d : TipoSangreEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoSangreEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoSangreEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSangreEnum d : TipoSangreEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
