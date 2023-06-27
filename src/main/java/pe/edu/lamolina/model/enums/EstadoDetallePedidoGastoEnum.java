package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoDetallePedidoGastoEnum {

    PEN("Pendiente"), GEN("Generado"), ENV("Enviado"), OBSV("Observado"), ACEP("Aceptado");

    private final String value;
    private static final Map<String, EstadoDetallePedidoGastoEnum> lookup = new HashMap<>();

    static {
        for (EstadoDetallePedidoGastoEnum d : EstadoDetallePedidoGastoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoDetallePedidoGastoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoDetallePedidoGastoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (EstadoDetallePedidoGastoEnum d : EstadoDetallePedidoGastoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
