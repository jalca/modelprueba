package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DiaEnum {
    
    LUNES("Lunes",1L),
    MIERCOLES("Miércoles",3L),
    VIERNES("Viernes",5L),
    SABADO("Sábado",6L);

    private final String value;
    private final Long id;
    private static final Map<String, DiaEnum> lookup = new HashMap<>();

    static {
        for (DiaEnum d : DiaEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private DiaEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static DiaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
