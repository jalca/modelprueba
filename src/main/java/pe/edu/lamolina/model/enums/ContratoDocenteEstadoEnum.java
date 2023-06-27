package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContratoDocenteEstadoEnum {

    PEND("Pendiente"),
    RESL("Con Resolución"),
    ACT("Activo"),
    VENC("Vencido"),
    CFIN("Finalizado");

    private final String value;
    private static final Map<String, ContratoDocenteEstadoEnum> lookup = new HashMap<>();

    static {
        for (ContratoDocenteEstadoEnum d : ContratoDocenteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContratoDocenteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContratoDocenteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContratoDocenteEstadoEnum d : ContratoDocenteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
