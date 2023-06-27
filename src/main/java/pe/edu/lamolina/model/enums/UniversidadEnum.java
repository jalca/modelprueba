package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UniversidadEnum {

    UNALM("Activo", 47L);

    private final String value;
    private final Long id;
    private static final Map<String, UniversidadEnum> lookup = new HashMap<>();

    static {
        for (UniversidadEnum d : UniversidadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private UniversidadEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static UniversidadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (UniversidadEnum d : UniversidadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
