package pe.edu.lamolina.model.enums.activadorficha;

import java.util.HashMap;
import java.util.Map;

public enum TipoVigenciaEnum {

    VIGENTE("Vigente"),
    PASADO("Pasado"),
    FUTURO("Futuro");

    private final String value;
    private static final Map<String, TipoVigenciaEnum> lookup = new HashMap<>();

    static {
        for (TipoVigenciaEnum d : TipoVigenciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoVigenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoVigenciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoVigenciaEnum d : TipoVigenciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
