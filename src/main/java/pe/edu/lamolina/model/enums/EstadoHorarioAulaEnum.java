package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoHorarioAulaEnum {

    ACT("Activo"),
    PEND("Pendiente"),
    SOL("Solicitado");

    private final String value;
    private static final Map<String, EstadoHorarioAulaEnum> lookup = new HashMap<>();

    static {
        for (EstadoHorarioAulaEnum d : EstadoHorarioAulaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoHorarioAulaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoHorarioAulaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
