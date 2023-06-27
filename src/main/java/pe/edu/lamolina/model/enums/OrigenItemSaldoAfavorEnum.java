package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrigenItemSaldoAfavorEnum {

    TRANSF("Transferencia Bancaria"),
    MANUAL("Manual"),
    CONSU("Consumo"),
    AUTOMA("Automático");

    private final String value;
    private static final Map<String, OrigenItemSaldoAfavorEnum> lookup = new HashMap<>();

    static {
        for (OrigenItemSaldoAfavorEnum d : OrigenItemSaldoAfavorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OrigenItemSaldoAfavorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrigenItemSaldoAfavorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OrigenItemSaldoAfavorEnum d : OrigenItemSaldoAfavorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
