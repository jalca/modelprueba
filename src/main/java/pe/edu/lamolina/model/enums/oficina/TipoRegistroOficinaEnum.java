package pe.edu.lamolina.model.enums.oficina;

import java.util.HashMap;
import java.util.Map;

public enum TipoRegistroOficinaEnum {

    OFICIAL("Registrado desde Amauta"),
    OBUAE("Registrado desde OBU");

    private final String value;
    private static final Map<String, TipoRegistroOficinaEnum> lookup = new HashMap<>();

    static {
        for (TipoRegistroOficinaEnum d : TipoRegistroOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoRegistroOficinaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoRegistroOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoRegistroOficinaEnum d : TipoRegistroOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
