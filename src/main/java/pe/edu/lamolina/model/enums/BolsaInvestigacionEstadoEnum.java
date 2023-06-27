package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum BolsaInvestigacionEstadoEnum {

    PEND("Pendiente"), ENV("Enviado");

    private final String value;
    private static final Map<String, BolsaInvestigacionEstadoEnum> lookup = new HashMap<>();

    static {
        for (BolsaInvestigacionEstadoEnum d : BolsaInvestigacionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private BolsaInvestigacionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BolsaInvestigacionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (BolsaInvestigacionEstadoEnum d : BolsaInvestigacionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
