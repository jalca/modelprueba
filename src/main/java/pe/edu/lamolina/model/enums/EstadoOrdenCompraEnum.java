package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoOrdenCompraEnum {
    
    CRE("Creado"),
    PAG("Pagado"),
    ENV("Enviado"),
    ENT("Entregado"),
    PSE("Pagado sin entrega")
    ;

    private final String value;
    private static final Map<String, EstadoOrdenCompraEnum> lookup = new HashMap<>();

    private EstadoOrdenCompraEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoOrdenCompraEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoOrdenCompraEnum d : EstadoOrdenCompraEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
