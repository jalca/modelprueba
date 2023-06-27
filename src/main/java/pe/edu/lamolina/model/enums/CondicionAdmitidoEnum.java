package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CondicionAdmitidoEnum {

    REG("Regular"), ESP("Especial"), COND("Condicional"), NADM("No Admitido");

    private final String value;
    private static final Map<String, CondicionAdmitidoEnum> lookup = new HashMap<>();

    static {
        for (CondicionAdmitidoEnum d : CondicionAdmitidoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CondicionAdmitidoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CondicionAdmitidoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CondicionAdmitidoEnum d : CondicionAdmitidoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
