package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoVacanteAlumnoEnum {

    DISP("Disponible"),
    INA("Anulado"),
    RCI("Retirado Ciclo"),
    RCU("Retirado Curso"),
    RET("Retirado"),
    RSV("Reservado"),
    RSVR("Reservado de Retiro"),
    OCUP("Ocupado");

    private final String value;
    private static final Map<String, EstadoVacanteAlumnoEnum> lookup = new HashMap<String, EstadoVacanteAlumnoEnum>();

    static {
        for (EstadoVacanteAlumnoEnum d : EstadoVacanteAlumnoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoVacanteAlumnoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoVacanteAlumnoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
