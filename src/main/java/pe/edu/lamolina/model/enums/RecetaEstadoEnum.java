package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RecetaEstadoEnum {

    CRE("Creado"), ENT("Entregado"), PAR("Parcialmente"), ANU("Anulado");

    private final String value;
    private static final Map<String, RecetaEstadoEnum> lookup = new HashMap<>();

    static {
        for (RecetaEstadoEnum d : RecetaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RecetaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RecetaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RecetaEstadoEnum d : RecetaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
