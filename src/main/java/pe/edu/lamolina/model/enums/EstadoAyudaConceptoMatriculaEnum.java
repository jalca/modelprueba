package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAyudaConceptoMatriculaEnum {

    ACT("Activo"), ANU("Anulado");

    private final String value;
    private static final Map<String, EstadoAyudaConceptoMatriculaEnum> lookup = new HashMap<>();

    static {
        for (EstadoAyudaConceptoMatriculaEnum d : EstadoAyudaConceptoMatriculaEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private EstadoAyudaConceptoMatriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAyudaConceptoMatriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
