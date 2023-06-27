package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoBolsaInvestigacionEstadoEnum {

    CRE("Creado"),
    INVI("Invitado"),
    ENV("Enviado"),
    APR("Aprobado"),
    RCHZ("Rechazado"),
    ANU("Anulado");

    private final String value;
    private static final Map<String, AlumnoBolsaInvestigacionEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoBolsaInvestigacionEstadoEnum d : AlumnoBolsaInvestigacionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoBolsaInvestigacionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoBolsaInvestigacionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoBolsaInvestigacionEstadoEnum d : AlumnoBolsaInvestigacionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
