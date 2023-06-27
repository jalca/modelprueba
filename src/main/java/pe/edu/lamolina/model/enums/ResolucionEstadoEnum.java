package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResolucionEstadoEnum {

    ACT("Activo"), CRE("Creado"), INA("Inactivo"), ANU("Anulado"), DOC_CONF("Documento Confirmado"), VB_RES("V.B. Resolucion");

    private final String value;
    private static final Map<String, ResolucionEstadoEnum> lookup = new HashMap<>();

    static {
        for (ResolucionEstadoEnum d : ResolucionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ResolucionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ResolucionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ResolucionEstadoEnum d : ResolucionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
