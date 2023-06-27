package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum FichaSocioeconomicaEstadoEnum {

    PEND("Llenado pendiente"),
    ENV("Enviado a revisión"),
    //REV("Revisado"),
    DEV("Devuelto al alumno"),
    ACP("Aceptada"),
    LIB("Liberada"),
    DJUR("Con Decl.Jurada"), // TRAM("En tramite")
    ;

    private final String value;
    private static final Map<String, FichaSocioeconomicaEstadoEnum> lookup = new HashMap<>();

    static {
        for (FichaSocioeconomicaEstadoEnum d : FichaSocioeconomicaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private FichaSocioeconomicaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FichaSocioeconomicaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (FichaSocioeconomicaEstadoEnum d : FichaSocioeconomicaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
