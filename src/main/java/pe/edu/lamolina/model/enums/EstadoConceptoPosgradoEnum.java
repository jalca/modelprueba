package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoConceptoPosgradoEnum {

    ACT("Activo"), ANU("Anulado");

    private final String value;
    private static final Map<String, EstadoConceptoPosgradoEnum> lookup = new HashMap<>();

    static {
        for (EstadoConceptoPosgradoEnum d : EstadoConceptoPosgradoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoConceptoPosgradoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoConceptoPosgradoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoConceptoPosgradoEnum d : EstadoConceptoPosgradoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
