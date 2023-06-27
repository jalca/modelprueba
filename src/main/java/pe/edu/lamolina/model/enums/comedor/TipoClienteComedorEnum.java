package pe.edu.lamolina.model.enums.comedor;

import java.util.HashMap;
import java.util.Map;

public enum TipoClienteComedorEnum {

    ALUMNO("Alumno"),
    BECADO("Becado"),
    VENTA_LIBRE("Venta Libre"),
    INGRESO_LIBRE("Ingreso Libre");

    private final String value;
    private static final Map<String, TipoClienteComedorEnum> lookup = new HashMap<>();

    static {
        for (TipoClienteComedorEnum d : TipoClienteComedorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoClienteComedorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoClienteComedorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoClienteComedorEnum d : TipoClienteComedorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
