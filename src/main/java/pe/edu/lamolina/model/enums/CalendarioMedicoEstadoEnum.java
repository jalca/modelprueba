package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CalendarioMedicoEstadoEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, CalendarioMedicoEstadoEnum> lookup = new HashMap<>();

    static {
        for (CalendarioMedicoEstadoEnum d : CalendarioMedicoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CalendarioMedicoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CalendarioMedicoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CalendarioMedicoEstadoEnum d : CalendarioMedicoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (CalendarioMedicoEstadoEnum e : CalendarioMedicoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
