package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoGradoEnum {

    TITULO("Título", 2),
    DOCTOR("Doctor", 4),
    MAESTRO("Maestro", 3),
    BACHILLER("Bachiller", 1);

    private final String value;
    private final Integer peso;
    private static final Map<String, TipoGradoEnum> lookup = new HashMap<>();

    static {
        for (TipoGradoEnum d : TipoGradoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoGradoEnum(String value, Integer peso) {
        this.value = value;
        this.peso = peso;
    }

    public String getValue() {
        return value;
    }

    public Integer getPeso() {
        return peso;
    }

    public static TipoGradoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoGradoEnum d : TipoGradoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoGradoEnum e : TipoGradoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
