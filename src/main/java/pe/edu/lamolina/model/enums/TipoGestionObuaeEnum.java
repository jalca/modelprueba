package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoGestionObuaeEnum {
    NAC("Colegio Nacional"),
    PART("Colegio Particular"),
    PARROQ("Colegio Parroquial");

    private final String value;
    private static final Map<String, TipoGestionObuaeEnum> lookup = new HashMap<>();

    static {
        for (TipoGestionObuaeEnum d : TipoGestionObuaeEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoGestionObuaeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoGestionObuaeEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoGestionObuaeEnum d : TipoGestionObuaeEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoGestionObuaeEnum e : TipoGestionObuaeEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }

}
