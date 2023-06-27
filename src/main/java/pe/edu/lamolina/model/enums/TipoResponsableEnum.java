package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoResponsableEnum {

    RES("Responsable"), SUP("Supervisor"), SOP("Sop. Tecnico");

    private final String value;
    private static final Map<String, TipoResponsableEnum> lookup = new HashMap<>();

    static {
        for (TipoResponsableEnum d : TipoResponsableEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoResponsableEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoResponsableEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoResponsableEnum d : TipoResponsableEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
