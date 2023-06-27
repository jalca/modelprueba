package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAtencionExternaEnum {
    
    DER("Derivado"), ENT("Entregado"), VEN("Vencido");

    private final String value;
    private static final Map<String, EstadoAtencionExternaEnum> lookup = new HashMap<>();

    static {
        for (EstadoAtencionExternaEnum d : EstadoAtencionExternaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAtencionExternaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAtencionExternaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAtencionExternaEnum d : EstadoAtencionExternaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
