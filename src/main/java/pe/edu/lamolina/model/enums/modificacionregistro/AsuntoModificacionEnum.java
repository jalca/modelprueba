package pe.edu.lamolina.model.enums.modificacionregistro;

import java.util.HashMap;
import java.util.Map;

public enum AsuntoModificacionEnum {

    CAMBIO_FECHA_CRONOGRAMA("Cambio de la fecha del cronograma"),
    CAMBIO_DELEGADO_VIAJE_CURSO("Cambio del delegado del Viaje de Curso");

    private final String value;
    private static final Map<String, AsuntoModificacionEnum> lookup = new HashMap<>();

    static {
        for (AsuntoModificacionEnum d : AsuntoModificacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AsuntoModificacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AsuntoModificacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AsuntoModificacionEnum d : AsuntoModificacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
