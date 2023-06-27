package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCareoEnum {

    PEND("Pendiente"), SUPL("Suplantación"), CORRE("Correcto");

    private final String value;
    private static final Map<String, EstadoCareoEnum> lookup = new HashMap<>();

    static {
        for (EstadoCareoEnum d : EstadoCareoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCareoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCareoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCareoEnum d : EstadoCareoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
