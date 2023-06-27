package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TallerCicloEstadoEnum {

    ACT("Activo"), INA("Inactivo"), CRE("Creado");

    private final String value;
    private static final Map<String, TallerCicloEstadoEnum> lookup = new HashMap<>();

    static {
        for (TallerCicloEstadoEnum d : TallerCicloEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TallerCicloEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TallerCicloEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TallerCicloEstadoEnum d : TallerCicloEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
