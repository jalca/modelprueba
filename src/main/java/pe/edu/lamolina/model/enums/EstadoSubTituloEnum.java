package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoSubTituloEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoSubTituloEnum> lookup = new HashMap<>();

    static {
        for (EstadoSubTituloEnum d : EstadoSubTituloEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoSubTituloEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoSubTituloEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoSubTituloEnum d : EstadoSubTituloEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoSubTituloEnum e : EstadoSubTituloEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
