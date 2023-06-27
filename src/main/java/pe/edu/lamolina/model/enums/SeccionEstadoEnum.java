package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SeccionEstadoEnum {

    ACT("Activo"),
    INA("Inactivo"),
    CRE("Creado"),
    ANU("Anulado"),
    BLO("Bloqueado"),
    FUS("Fusionado"),
    CAN("Cancelada");

    private final String value;
    private static final Map<String, SeccionEstadoEnum> lookup = new HashMap<>();

    static {
        for (SeccionEstadoEnum d : SeccionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SeccionEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SeccionEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SeccionEstadoEnum d : SeccionEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
