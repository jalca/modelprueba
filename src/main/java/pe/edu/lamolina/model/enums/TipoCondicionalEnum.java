package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCondicionalEnum {

    RETIRO_CICLO("Por retiro de ciclo"),//    ,
    CAMBIO_NOTA("Por cambio de nota"),
    OTRO("Por otro motivo"),
    REI("Reincorporación"),
    TRAS("Trámite Traslado Externo"),
    TRAS_INT("Trámite Traslado Interno"),
    INTES("Intercambio Estudiantil");

//    ULTIMO_CICLO("Por último ciclo")
    ;

    private final String value;
    private static final Map<String, TipoCondicionalEnum> lookup = new HashMap<>();

    static {
        for (TipoCondicionalEnum d : TipoCondicionalEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCondicionalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCondicionalEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCondicionalEnum d : TipoCondicionalEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
