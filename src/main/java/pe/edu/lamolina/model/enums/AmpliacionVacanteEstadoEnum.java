package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmpliacionVacanteEstadoEnum {

    PENDIENTE("Pendiente"), ACEPTADO("Aceptado"), RECHAZADO("Rechazado"), ANULADA("Anulada");

    private final String value;
    private static final Map<String, AmpliacionVacanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (AmpliacionVacanteEstadoEnum d : AmpliacionVacanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmpliacionVacanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmpliacionVacanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AmpliacionVacanteEstadoEnum d : AmpliacionVacanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
