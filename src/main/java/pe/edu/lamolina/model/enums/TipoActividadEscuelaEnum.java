package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoActividadEscuelaEnum {

    BOPA("Boleta de Pago"),
    REGR("Requisitos Grados"),
    REAC("Record Académica"),
    DAPE("Datos Pesonales"),
    INLA("Información Laboral"),
    DEJU("Declaración Jurada"),
    CONST("Constancia");

    private final String value;
    private static final Map<String, TipoActividadEscuelaEnum> lookup = new HashMap<>();

    static {
        for (TipoActividadEscuelaEnum d : TipoActividadEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoActividadEscuelaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoActividadEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoActividadEscuelaEnum d : TipoActividadEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
