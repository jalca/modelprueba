package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrigenAcreenciaEnum {
    INT("Interconexion"),
    HIS("Historico");

    private final String value;
    private static final Map<String, OrigenAcreenciaEnum> lookup = new HashMap<>();

    static {
        for (OrigenAcreenciaEnum d : OrigenAcreenciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OrigenAcreenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrigenAcreenciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
