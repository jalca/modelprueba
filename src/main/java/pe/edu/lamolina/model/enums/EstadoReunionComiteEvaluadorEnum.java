package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoReunionComiteEvaluadorEnum {

    PROG("Programado"), 
    POSTG("Postergado"),
    EJEC("Ejecutado");

    private final String value;
    private static final Map<String, EstadoReunionComiteEvaluadorEnum> lookup = new HashMap<>();

    static {
        for (EstadoReunionComiteEvaluadorEnum d : EstadoReunionComiteEvaluadorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoReunionComiteEvaluadorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoReunionComiteEvaluadorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoReunionComiteEvaluadorEnum d : EstadoReunionComiteEvaluadorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
