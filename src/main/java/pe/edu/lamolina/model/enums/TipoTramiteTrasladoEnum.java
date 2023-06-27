package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoTramiteTrasladoEnum {

    TRAS("Trámite Traslado Externo"),
    TRAS_INT("Trámite Traslado Interno"),
    ING_HIS("Ingreso Historial"),
    INTES("Intercambio Estudiantil");

    private final String value;
    private static final Map<String, TipoResolucionEnum> lookup = new HashMap<>();

    static {
        for (TipoResolucionEnum d : TipoResolucionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTramiteTrasladoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoResolucionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoResolucionEnum d : TipoResolucionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
