package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPedidoGastoEnum {

    CRE("Creado"), SOL("Solicitado"), EJE("Ejecutado"), ANU("Anulado");

    private final String value;
    private static final Map<String, EstadoPedidoGastoEnum> lookup = new HashMap<>();

    static {
        for (EstadoPedidoGastoEnum d : EstadoPedidoGastoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoPedidoGastoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPedidoGastoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPedidoGastoEnum d : EstadoPedidoGastoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
