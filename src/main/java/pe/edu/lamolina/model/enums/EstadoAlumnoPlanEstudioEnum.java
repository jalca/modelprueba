package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAlumnoPlanEstudioEnum {

    MAN("Manualmente"),
    PEND("Pendiente"),
    REV("Revision"),
    OBS("Observado"),
    APRO("Aprobado"),
    INA("Inactivo");
    //tramite  PEND ( plan en REV, OBS) -> ACEP o ANU 

    private final String value;
    private static final Map<String, EstadoAlumnoPlanEstudioEnum> lookup = new HashMap<>();

    static {
        for (EstadoAlumnoPlanEstudioEnum d : EstadoAlumnoPlanEstudioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAlumnoPlanEstudioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAlumnoPlanEstudioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAlumnoPlanEstudioEnum d : EstadoAlumnoPlanEstudioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
