package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DeudaAlumnoEstadoEnum {

    REST("Restringido"),
    LEV("Levantado"),
    ANU("Anulado");

    private final String value;
    private static final Map<String, DeudaAlumnoEstadoEnum> lookup = new HashMap<>();

    static {
        for (DeudaAlumnoEstadoEnum d : DeudaAlumnoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DeudaAlumnoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DeudaAlumnoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DeudaAlumnoEstadoEnum d : DeudaAlumnoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (DeudaAlumnoEstadoEnum e : DeudaAlumnoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }

}
