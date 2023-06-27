package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EncuestaEstadoEnum {

    CRE("Creada"),
    NCRE("No creada"),
    CFG("Configurando"),
    ACT("Activa"),
    CER("Cerrada");

    private final String value;
    private static final Map<String, EncuestaEstadoEnum> lookup = new HashMap<>();

    static {
        for (EncuestaEstadoEnum d : EncuestaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EncuestaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EncuestaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EncuestaEstadoEnum d : EncuestaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EncuestaEstadoEnum e : EncuestaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
