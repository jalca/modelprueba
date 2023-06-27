package pe.edu.lamolina.model.enums.comedor;

import java.util.HashMap;
import java.util.Map;

public enum TipoServicioEnum {

    DESA("Desayuno", 1),
    ALMU("Almuerzo", 2),
    CENA("Cena", 3);

    private final String value;
    private final Integer orden;
    private static final Map<String, TipoServicioEnum> lookup = new HashMap<>();

    static {
        for (TipoServicioEnum d : TipoServicioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoServicioEnum(String value, Integer orden) {
        this.value = value;
        this.orden = orden;
    }

    public String getValue() {
        return value;
    }

    public Integer getOrden() {
        return orden;
    }

    public static TipoServicioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoServicioEnum d : TipoServicioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
