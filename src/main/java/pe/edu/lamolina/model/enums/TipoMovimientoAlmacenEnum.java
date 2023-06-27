package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMovimientoAlmacenEnum {

    SALDAN("Salida de productos dañados"),
    SALCAD("Salida de productos caducados"),
    INGPRO("Ingreso de Productos"),
    SAL("Salida de Productos");
    
    private final String value;
    private static final Map<String, TipoMovimientoAlmacenEnum> lookup = new HashMap<>();

    static {
        for (TipoMovimientoAlmacenEnum d : TipoMovimientoAlmacenEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMovimientoAlmacenEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMovimientoAlmacenEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMovimientoAlmacenEnum d : TipoMovimientoAlmacenEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
