package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoAnexoBoletinEnum {

    G01("Cursos Ingresantes", 1L),
    G02("Dptos. Académicos", 2L),
    G03("Actv. Culturales", 3L),
    G04("Cursos Postgrado", 4L),
    G05("Otras Actividades", 5L);

    private final String value;
    private final Long id;
    private static final Map<String, CodigoAnexoBoletinEnum> lookup = new HashMap<>();

    static {
        for (CodigoAnexoBoletinEnum d : CodigoAnexoBoletinEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoAnexoBoletinEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static CodigoAnexoBoletinEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoAnexoBoletinEnum d : CodigoAnexoBoletinEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
