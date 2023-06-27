package pe.edu.lamolina.model.enums.activadorficha;

import java.util.HashMap;
import java.util.Map;

public enum TipoActivacionFichaEnum {

    OBLIGATORIO("Obligatorio"),
    OPCIONAL("Opcional");

    private final String value;
    private static final Map<String, TipoActivacionFichaEnum> lookup = new HashMap<>();

    static {
        for (TipoActivacionFichaEnum d : TipoActivacionFichaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoActivacionFichaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoActivacionFichaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoActivacionFichaEnum d : TipoActivacionFichaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
