package pe.edu.lamolina.model.enums.dashboard;

import java.util.HashMap;
import java.util.Map;

public enum TipoMatriculableEnum {

    MATRICULABLE("Matriculable"),
    NO_MATRICULADO("No Matriculado"),
    MATRICULADO("Matriculado");

    private final String value;
    private static final Map<String, TipoMatriculableEnum> lookup = new HashMap<>();

    static {
        for (TipoMatriculableEnum d : TipoMatriculableEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMatriculableEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
