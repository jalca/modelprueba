package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDeudaEnum {

    EPG("Deuda Admisión Posgrado"),
    CUOTA_EPG("Cuota Posgrado"),
    APO("Deuda Aportes OBU"),
    VERANO("Curso Verano"),
    EXM("Examen Medico");

    private final String value;
    private static final Map<String, TipoDeudaEnum> lookup = new HashMap<>();

    static {
        for (TipoDeudaEnum d : TipoDeudaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoDeudaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDeudaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDeudaEnum d : TipoDeudaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
