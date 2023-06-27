package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProcesoMethodEnum {

    ANU_OMI("Anular Omiso Eleciones"),
    CLN_DEU("Limpiar Deudas");

    private final String value;

    private static final Map<String, ProcesoMethodEnum> lookup = new HashMap();

    static {
        for (ProcesoMethodEnum d : ProcesoMethodEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ProcesoMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProcesoMethodEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ProcesoMethodEnum d : ProcesoMethodEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
