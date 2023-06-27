package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ParametrosSaludEnum {

    PRESION("Presión Arterial", 1L),
    FRECUENCIA("Frecuencia Cardíaca", 2L),
    TEMPERATURA("Temperatura Corporal", 3L),
    SATURACION("Saturación Oxígeno", 4L),
    GRUPO("Grupo Sanguíneo", 5L),
    HEMOGLOBINA("Hemoglobina", 6L),
    FACTOR("Factor Rh", 7L);

    private final String value;
    private final Long parametro;

    private static final Map<String, ParametrosSaludEnum> lookup = new HashMap<>();

    static {
        for (ParametrosSaludEnum d : ParametrosSaludEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private ParametrosSaludEnum(String value, Long parametro) {
        this.value = value;
        this.parametro = parametro;
    }

    public String getValue() {
        return value;
    }

    public Long getParametro() {
        return parametro;
    }

    public static ParametrosSaludEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
