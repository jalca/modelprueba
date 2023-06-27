package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExoneracionSeguroEstadoEnum {

    SOL("Solicitado"),
    ACEP("Aceptado"),
    RCHZ("Rechazado");

    private final String value;
    private static final Map<String, ExoneracionSeguroEstadoEnum> lookup = new HashMap<>();

    static {
        for (ExoneracionSeguroEstadoEnum d : ExoneracionSeguroEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ExoneracionSeguroEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExoneracionSeguroEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ExoneracionSeguroEstadoEnum d : ExoneracionSeguroEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
