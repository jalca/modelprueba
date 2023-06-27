package pe.edu.lamolina.model.enums.contabilidad;

import java.util.HashMap;
import java.util.Map;

public enum TipoMovimientoPresupuestoEnum {

    ENTRADA("Entrada Dinero"),
    SALIDA("Salida Dinero");

    private final String value;
    private static final Map<String, TipoMovimientoPresupuestoEnum> lookup = new HashMap<>();

    static {
        for (TipoMovimientoPresupuestoEnum d : TipoMovimientoPresupuestoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMovimientoPresupuestoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMovimientoPresupuestoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMovimientoPresupuestoEnum d : TipoMovimientoPresupuestoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
