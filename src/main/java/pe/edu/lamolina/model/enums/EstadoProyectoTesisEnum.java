package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoProyectoTesisEnum {

    CRE("Creado"), ANU("Anulado"), INA("Inactivo"), PEND("Pendiente"), ACEP("Aceptado");

    private final String value;
    private static final Map<String, EstadoProyectoTesisEnum> lookup = new HashMap<>();

    static {
        for (EstadoProyectoTesisEnum d : EstadoProyectoTesisEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoProyectoTesisEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoProyectoTesisEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (EstadoProyectoTesisEnum d : EstadoProyectoTesisEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
