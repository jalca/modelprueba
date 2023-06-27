package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CategoriaProductoEnum {

    // Para la farmacia
    AMPO("Ampollas", 3L),
    CRYS("Cremas/Soluciones", 4L),
    MEDG("Medicamentos en General", 5L),
    INSMED("Insumo Médico", 214L),
    // Para inventario de articulos deportivo y culturales
    IMPLEM("Implementos Taller de Verano", 228L),
    SERVTV("Servicios de Taller de Verano", 229L);

    private final String value;
    private final Long id;
    private static final Map<String, CategoriaProductoEnum> lookup = new HashMap<>();

    static {
        for (CategoriaProductoEnum d : CategoriaProductoEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private CategoriaProductoEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static CategoriaProductoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
