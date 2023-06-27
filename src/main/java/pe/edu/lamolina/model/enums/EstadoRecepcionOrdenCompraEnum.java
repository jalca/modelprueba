package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoRecepcionOrdenCompraEnum {

    PEND("Pendiente"),
    PAR("Parcial"),
    COM("Completo");

    private final String value;
    private static final Map<String, EstadoRecepcionOrdenCompraEnum> lookup = new HashMap<>();

    private EstadoRecepcionOrdenCompraEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoRecepcionOrdenCompraEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoRecepcionOrdenCompraEnum d : EstadoRecepcionOrdenCompraEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
