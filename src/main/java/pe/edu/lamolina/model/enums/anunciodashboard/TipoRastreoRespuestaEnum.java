package pe.edu.lamolina.model.enums.anunciodashboard;

import java.util.HashMap;
import java.util.Map;

public enum TipoRastreoRespuestaEnum {

    DETALLE("Por cada clic"),
    RESUMIDO("Solo contar clics");

    private final String value;
    private static final Map<String, TipoRastreoRespuestaEnum> lookup = new HashMap<>();

    static {
        for (TipoRastreoRespuestaEnum d : TipoRastreoRespuestaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoRastreoRespuestaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoRastreoRespuestaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoRastreoRespuestaEnum d : TipoRastreoRespuestaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
