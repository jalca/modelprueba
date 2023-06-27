package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAbonoEnum {

    SWIFT("Swift"),
    TRANSF("Transferencia"),
    DEP("Depósito"),
    SALDO_AFAVOR("Saldo a favor");

    private final String value;
    private static final Map<String, TipoAbonoEnum> lookup = new HashMap<>();

    static {
        for (TipoAbonoEnum d : TipoAbonoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAbonoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAbonoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAbonoEnum d : TipoAbonoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
