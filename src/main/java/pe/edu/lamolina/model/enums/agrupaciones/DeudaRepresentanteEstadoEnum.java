package pe.edu.lamolina.model.enums.agrupaciones;

import java.util.HashMap;
import java.util.Map;

public enum DeudaRepresentanteEstadoEnum {

    SIN_DEUDA("Sin deuda"),
    CON_DEUDA("Con deuda"),
    JUSTIFICADO("Deuda justificada"),
    DEVUELTO("Deuda devuelta");

    private final String value;
    private static final Map<String, DeudaRepresentanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (DeudaRepresentanteEstadoEnum d : DeudaRepresentanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DeudaRepresentanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DeudaRepresentanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DeudaRepresentanteEstadoEnum d : DeudaRepresentanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
