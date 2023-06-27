package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMiembroComisionEnum {

    PRE("Presidente"),
    DOC("Docente"),
    ALU("Alumno");

    private final String value;
    private static final Map<String, TipoMiembroComisionEnum> lookup = new HashMap<>();

    static {
        for (TipoMiembroComisionEnum d : TipoMiembroComisionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMiembroComisionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMiembroComisionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMiembroComisionEnum d : TipoMiembroComisionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
