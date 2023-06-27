package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum BecadoPosgradoCodigoEnum {

    BECA_DOC("Beca Docente/Trabajador UNALM"),
    BECA_ESTUDIA("Beca Estudiante"),
    BECA_TRABAJA("Auspicio Trabajador");

    private final String value;
    private static final Map<String, BecadoPosgradoCodigoEnum> lookup = new HashMap<>();

    static {
        for (BecadoPosgradoCodigoEnum d : BecadoPosgradoCodigoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private BecadoPosgradoCodigoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BecadoPosgradoCodigoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (BecadoPosgradoCodigoEnum d : BecadoPosgradoCodigoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
