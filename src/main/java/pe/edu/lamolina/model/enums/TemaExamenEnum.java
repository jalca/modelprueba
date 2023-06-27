package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TemaExamenEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, TemaExamenEnum> lookup = new HashMap<>();

    static {
        for (TemaExamenEnum d : TemaExamenEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TemaExamenEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TemaExamenEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TemaExamenEnum d : TemaExamenEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TemaExamenEnum e : TemaExamenEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
