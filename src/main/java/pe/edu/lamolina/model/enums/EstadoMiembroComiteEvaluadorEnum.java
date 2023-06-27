package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoMiembroComiteEvaluadorEnum {

    PROG("Programado"), 
    INAS("Inasistio"),
    ASIS("Asistio");

    private final String value;
    private static final Map<String, EstadoMiembroComiteEvaluadorEnum> lookup = new HashMap<>();

    static {
        for (EstadoMiembroComiteEvaluadorEnum d : EstadoMiembroComiteEvaluadorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoMiembroComiteEvaluadorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoMiembroComiteEvaluadorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoMiembroComiteEvaluadorEnum d : EstadoMiembroComiteEvaluadorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
