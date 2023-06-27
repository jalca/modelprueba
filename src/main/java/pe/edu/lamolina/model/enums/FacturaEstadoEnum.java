package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum FacturaEstadoEnum {

    ACT("Activo"),
    ANU("Anulado"),
    DEL("Eliminado");

    private final String value;
    private static final Map<String, FacturaEstadoEnum> lookup = new HashMap<>();

    static {
        for (FacturaEstadoEnum d : FacturaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private FacturaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FacturaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (FacturaEstadoEnum d : FacturaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (FacturaEstadoEnum e : FacturaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
