package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SilaboCursoEstadoEnum {

    ACT("Activo"),
    PEND("Pendiente"),
    CRE("Creado"),
    RCHZ("Rechazado"),
    REV("Revisión"),
    ERROREV("Error en Revisión"),
    VEN("Vencido");

    private final String value;
    private static final Map<String, SilaboCursoEstadoEnum> lookup = new HashMap<>();

    static {
        for (SilaboCursoEstadoEnum d : SilaboCursoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SilaboCursoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SilaboCursoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SilaboCursoEstadoEnum d : SilaboCursoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
