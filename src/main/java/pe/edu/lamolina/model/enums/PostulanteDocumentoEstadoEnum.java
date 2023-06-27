package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PostulanteDocumentoEstadoEnum {

    COMPROMISO("Pendiente"), ENTREGADO("Entregado"), SIN_ENTREGAR("No entregado");

    private final String value;
    private static final Map<String, PostulanteDocumentoEstadoEnum> lookup = new HashMap<>();

    static {
        for (PostulanteDocumentoEstadoEnum d : PostulanteDocumentoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PostulanteDocumentoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PostulanteDocumentoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PostulanteDocumentoEstadoEnum d : PostulanteDocumentoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
