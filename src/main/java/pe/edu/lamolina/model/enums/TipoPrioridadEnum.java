package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPrioridadEnum {

    POND("Ponderado"), ECON("Económico"), OTRO("Otros"), BECA("Becado");

    private final String value;
    private static final Map<String, TipoPrioridadEnum> lookup = new HashMap<>();

    static {
        for (TipoPrioridadEnum d : TipoPrioridadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPrioridadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPrioridadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPrioridadEnum d : TipoPrioridadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
