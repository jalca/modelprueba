package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPsiquiatricoEnum {

    PSIC("Psicologico"), PSIQ("Psiquiatrico");

    private final String value;
    private static final Map<String, TipoPsiquiatricoEnum> lookup = new HashMap<>();

    static {
        for (TipoPsiquiatricoEnum d : TipoPsiquiatricoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPsiquiatricoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPsiquiatricoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPsiquiatricoEnum d : TipoPsiquiatricoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
