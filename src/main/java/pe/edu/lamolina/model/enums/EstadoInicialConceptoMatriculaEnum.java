package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoInicialConceptoMatriculaEnum {

    PAG("Pagado"),
    PAR("Pagado"),
    DEU("Deuda"),
    FRA("Fraccionado");

    private final String value;
    private static final Map<String, EstadoInicialConceptoMatriculaEnum> lookup = new HashMap<>();

    static {
        for (EstadoInicialConceptoMatriculaEnum d : EstadoInicialConceptoMatriculaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoInicialConceptoMatriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoInicialConceptoMatriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoInicialConceptoMatriculaEnum d : EstadoInicialConceptoMatriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
