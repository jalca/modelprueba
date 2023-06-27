package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConsultorioEnum {

    MED("Medicina", 1L),
    PSICO("Psicología", 2L),
    PSICOPE("Psicopedagogía", 3L),
    ENFERM("Enfermería", 5L),
    TECENF("Técnica en Enfermería", 6L),
    DEN("Técnica en Enfermería", 7L),
    ODONTO("Odontología", 4L);

    private final String value;
    private final Long id;
    private static final Map<String, ConsultorioEnum> lookup = new HashMap<>();

    static {
        for (ConsultorioEnum d : ConsultorioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ConsultorioEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static ConsultorioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ConsultorioEnum d : ConsultorioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
