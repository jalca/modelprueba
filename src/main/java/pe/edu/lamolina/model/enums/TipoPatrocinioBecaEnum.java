package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPatrocinioBecaEnum {

    BECA("Beca"), TRAB("Trabajador"), DOC_UNALM("Beca Docente UNALM"), TRAB_UNALM("Beca Trabajador UNALM");

    private final String value;
    private static final Map<String, TipoPatrocinioBecaEnum> lookup = new HashMap<>();

    static {
        for (TipoPatrocinioBecaEnum d : TipoPatrocinioBecaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPatrocinioBecaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPatrocinioBecaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPatrocinioBecaEnum d : TipoPatrocinioBecaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
