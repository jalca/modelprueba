package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCalendarioConsultorioEnum {
	
	    DIS("Disponible"), RES("Reservado"), ATE("Atendido"), CAN("Cancelado");

    private final String value;
    private static final Map<String, EstadoCalendarioConsultorioEnum> lookup = new HashMap<>();

    static {
        for (EstadoCalendarioConsultorioEnum d : EstadoCalendarioConsultorioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCalendarioConsultorioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCalendarioConsultorioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCalendarioConsultorioEnum d : EstadoCalendarioConsultorioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
