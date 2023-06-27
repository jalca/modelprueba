package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContenidoEmailEnum {

    CREATEUSERALUMNOVISITANTE("Creación de usuario de alumno visitante. "),
    REUNIONCONSEJERO("Reunión Consejero"),
    UPDATEREUNIONCONSEJERO("Actualización de reunión consejero"),
    DELETEREUNIONCONSEJERO("Cancelación de reunión consejero")
    ;

    private final String value;
    private static final Map<String, ContenidoEmailEnum> lookup = new HashMap<>();

    static {
        for (ContenidoEmailEnum d : ContenidoEmailEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContenidoEmailEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContenidoEmailEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContenidoEmailEnum d : ContenidoEmailEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
