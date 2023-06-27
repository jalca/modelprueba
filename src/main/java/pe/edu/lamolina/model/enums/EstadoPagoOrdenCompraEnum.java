package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPagoOrdenCompraEnum {

    INA("Inactivo"),
    PEND("Pendiente"),
    AUT("Autorizado"),
    PROC("Procesado"),
    CHEQ("Cheque"),
    PAG("Pagado");

    private final String value;
    private static final Map<String, EstadoPagoOrdenCompraEnum> lookup = new HashMap<>();

    private EstadoPagoOrdenCompraEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPagoOrdenCompraEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPagoOrdenCompraEnum d : EstadoPagoOrdenCompraEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
