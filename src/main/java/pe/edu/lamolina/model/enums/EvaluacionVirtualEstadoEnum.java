package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EvaluacionVirtualEstadoEnum {

    CRE("Creado"), 
    ACT("Activo"), 
    INA("Inactivo");

    private final String value;
    private static final Map<String, EvaluacionVirtualEstadoEnum> lookup = new HashMap<>();

    static {
        for (EvaluacionVirtualEstadoEnum d : EvaluacionVirtualEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EvaluacionVirtualEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EvaluacionVirtualEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EvaluacionVirtualEstadoEnum d : EvaluacionVirtualEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EvaluacionVirtualEstadoEnum e : EvaluacionVirtualEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
