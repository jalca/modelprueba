package pe.edu.lamolina.model.enums.encuesta;

import java.util.HashMap;
import java.util.Map;

public enum ExamenVirtualEstadoEnum {

    CRE("Creada"),
    ACT("Activa"),
    INA("Inactiva");

    private final String value;
    private static final Map<String, ExamenVirtualEstadoEnum> lookup = new HashMap<>();

    static {
        for (ExamenVirtualEstadoEnum d : ExamenVirtualEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ExamenVirtualEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExamenVirtualEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ExamenVirtualEstadoEnum d : ExamenVirtualEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ExamenVirtualEstadoEnum e : ExamenVirtualEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
