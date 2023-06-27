package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum TipoFacturaJustificacionEnum {

    FACTURA("Factura"),
    BOLETA("Boleta Venta"),
    TICKET("Ticket"),
    VOUCHER("Voucher"),
    FOLLETO("Folleto"),
    OTRO("Otro documento");

    private final String value;
    private static final Map<String, TipoFacturaJustificacionEnum> lookup = new HashMap<>();

    static {
        for (TipoFacturaJustificacionEnum d : TipoFacturaJustificacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoFacturaJustificacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoFacturaJustificacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoFacturaJustificacionEnum d : TipoFacturaJustificacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
