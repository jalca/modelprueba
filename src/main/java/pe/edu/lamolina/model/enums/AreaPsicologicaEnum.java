package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AreaPsicologicaEnum {

    DINAMICA("Dinámica Familiar", 1L),
    SALUD("Antecedentes de salud mental", 2L),
    SOCIOEMOCIONAL("Área socioemocional y salud mental", 3L),
    PSICOSOCIAL("Área Psicosocial", 4L),
    PSICOPEDAGOGICA("Área Psicopedagógica", 5L),
    IMPRESION("Impresión Diagnóstica", 6L);

    private final String value;
    private final Long parametro;
    private static final Map<String, AreaPsicologicaEnum> lookup = new HashMap<>();

    static {
        for (AreaPsicologicaEnum d : AreaPsicologicaEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private AreaPsicologicaEnum(String value, Long parametro) {
        this.value = value;
        this.parametro = parametro;
    }

    public String getValue() {
        return value;
    }

    public Long getParametro() {
        return parametro;
    }
    
    public static AreaPsicologicaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
