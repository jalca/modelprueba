package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoNoticiaEnum {

    NEWS("Noticia"), EVENT("Evento");

    private final String value;
    private static final Map<String, TipoNoticiaEnum> lookup = new HashMap<>();

    static {
        for (TipoNoticiaEnum d : TipoNoticiaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoNoticiaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoNoticiaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoNoticiaEnum d : TipoNoticiaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
