package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResultadoReunionComiteEvaluadorEnum {

    APROB("Aprobado"), 
    DESA("Desaprobado");

    private final String value;
    private static final Map<String, ResultadoReunionComiteEvaluadorEnum> lookup = new HashMap<>();

    static {
        for (ResultadoReunionComiteEvaluadorEnum d : ResultadoReunionComiteEvaluadorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ResultadoReunionComiteEvaluadorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ResultadoReunionComiteEvaluadorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ResultadoReunionComiteEvaluadorEnum d : ResultadoReunionComiteEvaluadorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
