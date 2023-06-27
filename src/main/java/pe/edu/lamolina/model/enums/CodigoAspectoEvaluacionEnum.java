package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoAspectoEvaluacionEnum {

    EXAM("Examen Admisión"),
    ENTR("Entrevista Personal"), 
    DOCU("Documentación Entregada");

    private final String value;
    private static final Map<String, CodigoAspectoEvaluacionEnum> lookup = new HashMap<>();

    static {
        for (CodigoAspectoEvaluacionEnum d : CodigoAspectoEvaluacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoAspectoEvaluacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoAspectoEvaluacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoAspectoEvaluacionEnum d : CodigoAspectoEvaluacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
