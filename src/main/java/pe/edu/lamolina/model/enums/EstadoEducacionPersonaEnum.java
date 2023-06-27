package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoEducacionPersonaEnum {

    PEND("Pendiente"), 
    ENVI("Enviado"),
    OBSB("Observado"),
    ACEP("Aceptado");

    private final String value;
    private static final Map<String, EstadoEducacionPersonaEnum> lookup = new HashMap<>();

    static {
        for (EstadoEducacionPersonaEnum d : EstadoEducacionPersonaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoEducacionPersonaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoEducacionPersonaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoEducacionPersonaEnum d : EstadoEducacionPersonaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
