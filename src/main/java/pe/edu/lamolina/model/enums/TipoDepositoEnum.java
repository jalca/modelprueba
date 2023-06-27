package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDepositoEnum {

    DEP("Deposito"),TRANS("Transferencia");

    private final String value;
    private static final Map<String, TipoDepositoEnum> lookup = new HashMap<>();

    static {
        for (TipoDepositoEnum d : TipoDepositoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoDepositoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDepositoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDepositoEnum d : TipoDepositoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
