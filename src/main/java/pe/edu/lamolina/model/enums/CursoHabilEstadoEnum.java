package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CursoHabilEstadoEnum {

    HAB("Habilitado"),
    BLQ("Bloqueado");

    private final String value;
    private static final Map<String, CursoHabilEstadoEnum> lookup = new HashMap<>();

    static {
        for (CursoHabilEstadoEnum d : CursoHabilEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CursoHabilEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CursoHabilEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CursoHabilEstadoEnum d : CursoHabilEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
