package pe.edu.lamolina.model.enums.medico;

import java.util.HashMap;
import java.util.Map;

public enum TipoRegistroEnum {

    REGULAR("Regular"),
    ADICIONAL("Adicional");

    private final String value;
    private static final Map<String, TipoRegistroEnum> lookup = new HashMap<>();

    static {
        for (TipoRegistroEnum d : TipoRegistroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoRegistroEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoRegistroEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoRegistroEnum d : TipoRegistroEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
