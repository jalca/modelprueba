package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ColaboradorEstadoEnum {

    ACT("Activo"), VAC("Vacaciones"), RET("Retirado"), DSC("Descanso"), PER("Permiso"), DESP("Despedido");

    private final String value;
    private static final Map<String, ColaboradorEstadoEnum> lookup = new HashMap<>();

    static {
        for (ColaboradorEstadoEnum d : ColaboradorEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ColaboradorEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ColaboradorEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ColaboradorEstadoEnum d : ColaboradorEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static String getName(String value) {

        for (ColaboradorEstadoEnum d : ColaboradorEstadoEnum.values()) {
            if (d.getValue().equalsIgnoreCase(value)) {
                return d.name();
            }
        }

        return value;
    }
}
