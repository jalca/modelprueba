package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoDescuentoEnum {

    DESC_CANT("Descuento por cantidad de alumnos"),
    DESC_ESP("Descuento especial"),
    DESC_AFAV("Descuento saldo a favor"),
    DESC_HIJO("Descuento por hijo de trabajador");

    private final String value;
    private static final Map<String, CodigoDescuentoEnum> lookup = new HashMap<>();

    static {
        for (CodigoDescuentoEnum d : CodigoDescuentoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoDescuentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoDescuentoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoDescuentoEnum d : CodigoDescuentoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
