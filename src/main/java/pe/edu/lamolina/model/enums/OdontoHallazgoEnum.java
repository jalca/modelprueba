package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OdontoHallazgoEnum {

    CAR(1L, "Caries"),
    RES(32L, "Restauracion");

    private Long id;
    private final String value;
    private static final Map<String, OdontoHallazgoEnum> lookup = new HashMap<>();

    static {
        for (OdontoHallazgoEnum d : OdontoHallazgoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OdontoHallazgoEnum(Long id, String value) {
        this.value = value;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static OdontoHallazgoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OdontoHallazgoEnum d : OdontoHallazgoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
