package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TutorSolicitudEnum {

    PEN("Pendiente"), ACEP("Aceptado"), NACEP("No Procede");

    private final String value;
    private static final Map<String, TutorSolicitudEnum> lookup = new HashMap<>();

    static {
        for (TutorSolicitudEnum d : TutorSolicitudEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TutorSolicitudEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TutorSolicitudEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TutorSolicitudEnum d : TutorSolicitudEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
