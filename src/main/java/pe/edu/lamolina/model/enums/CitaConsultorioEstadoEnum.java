package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CitaConsultorioEstadoEnum {

    ATEN("Atendido"),
    LIB("Libre"),
    RES("Reservado"),
    ESPR("En espera"),
    CONS("En consulta"),
    ANU("Anulado"),
    CAN("Cancelado"),
    NDIS("No disponible"),
    POST("Postergado");

    private final String value;
    private static final Map<String, CitaConsultorioEstadoEnum> lookup = new HashMap<>();

    static {
        for (CitaConsultorioEstadoEnum d : CitaConsultorioEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CitaConsultorioEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CitaConsultorioEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CitaConsultorioEstadoEnum d : CitaConsultorioEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
