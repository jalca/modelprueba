package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MiembroConsejeroEstadoEnum {

    ACT("Activo"),
    INA("Inactivo"),
    PEND("Pendiente"),
    ACEP("Aceptado"), // En retiro ciclo es  Aceptado en su totalidad
    RCHZ("Rechazado"),
    CRE("Creado"),
    GRAD("Graduado")
    ;

    private final String value;
    private static final Map<String, MiembroConsejeroEstadoEnum> lookup = new HashMap<>();

    static {
        for (MiembroConsejeroEstadoEnum d : MiembroConsejeroEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MiembroConsejeroEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MiembroConsejeroEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
