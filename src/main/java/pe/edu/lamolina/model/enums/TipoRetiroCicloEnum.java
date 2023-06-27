package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoRetiroCicloEnum {

    EXTEMP("Extemporánea"),
    EXTORD("Extraordinaria"),
    EXCEP("Excepcional"),
    RESEPG("Resolución Posgrado"),
    REG("Regular"),
    ANUC("Anulación Ciclo"),
    ;

    private final String value;
    private static final Map<String, TipoRetiroCicloEnum> lookup = new HashMap<>();

    static {
        for (TipoRetiroCicloEnum d : TipoRetiroCicloEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoRetiroCicloEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoRetiroCicloEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoRetiroCicloEnum d : TipoRetiroCicloEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
