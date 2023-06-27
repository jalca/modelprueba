package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAulaEnum {

    MOD("Módulo de Aulas", 14L),
    AUL("Aula", 1L);

    private final String value;
    private final Long identifier;
    private static final Map<String, TipoAulaEnum> lookup = new HashMap<>();

    static {
        for (TipoAulaEnum d : TipoAulaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAulaEnum(String value, Long identifier) {
        this.value = value;
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public static TipoAulaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAulaEnum d : TipoAulaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
