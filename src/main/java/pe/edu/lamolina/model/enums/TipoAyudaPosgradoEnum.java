package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAyudaPosgradoEnum {

    GEN("Genérico"), BEC("Beca trabajador");

    private final String value;
    private static final Map<String, TipoAyudaPosgradoEnum> lookup = new HashMap<>();

    static {
        for (TipoAyudaPosgradoEnum d : TipoAyudaPosgradoEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private TipoAyudaPosgradoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAyudaPosgradoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
