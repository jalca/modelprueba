package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoGestionEnum {
    PUB("Público"),
    AMB("Ambos"),
    INDEF("Indefinido"),
    PRIV("Privado");

    private final String value;
    private static final Map<String, TipoGestionEnum> lookup = new HashMap<>();

    static {
        for (TipoGestionEnum d : TipoGestionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoGestionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoGestionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoGestionEnum d : TipoGestionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoGestionEnum e : TipoGestionEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }

}
