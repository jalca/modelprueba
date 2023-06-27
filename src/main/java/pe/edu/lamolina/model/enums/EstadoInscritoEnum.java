package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoInscritoEnum {

    INS("Inscrito"), ASIS("Asistió"), INSASIS("Inscrito Asistió"), ACT("Activo");

    private final String value;
    private static final Map<String, EstadoInscritoEnum> lookup = new HashMap<>();

    static {
        for (EstadoInscritoEnum d : EstadoInscritoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoInscritoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoInscritoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoInscritoEnum d : EstadoInscritoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
