package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoVerificacionEnum {

    ESTUDIA("Estudió en el ciclo", 1),
    MATRI("Matriculado en el ciclo", 2),
    PAGO("Pagó Autoseguro en el ciclo", 3),
    EXMED("Pagó Examen Médico en el ciclo", 4);

    private final String value;
    private final Integer prioridad;
    private static final Map<String, TipoVerificacionEnum> lookup = new HashMap<>();

    static {
        for (TipoVerificacionEnum d : TipoVerificacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoVerificacionEnum(String value, Integer prioridad) {
        this.value = value;
        this.prioridad = prioridad;
    }

    public String getValue() {
        return value;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public static TipoVerificacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoVerificacionEnum d : TipoVerificacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
