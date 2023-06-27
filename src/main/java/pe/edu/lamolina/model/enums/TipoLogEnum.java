package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoLogEnum {

    LOGIN("Login"),
    LOGOUT("Longout"),
    MATALU("Matricula Alumno"),
    PMATALU("Pre Matricula Alumno"),
    RETALU("Retiro de alumno"),
    MATALU_ADM("Matricula alumno por administrativo"),
    PMATALU_ADM("Pre matricula alumno por administrativo"),
    RETALU_ADM("Retiro matricula alumno por administrativo"),
    MATALU_DOC("Matricula alumno docente"),
    PMATALU_DOC("Pre matricula alumno docente"),
    RETALU_DOC("Retiro matricula alumno docente"),
    MATALU_BARR("Matricula alumno por barrido"),
    PMATALU_BARR("Pre matricula alumno por barrido");

    private final String value;
    private static final Map<String, TipoLogEnum> lookup = new HashMap<>();

    static {
        for (TipoLogEnum d : TipoLogEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoLogEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoLogEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
