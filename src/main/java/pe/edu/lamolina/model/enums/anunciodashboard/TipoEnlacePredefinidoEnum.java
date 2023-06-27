package pe.edu.lamolina.model.enums.anunciodashboard;

import java.util.HashMap;
import java.util.Map;

public enum TipoEnlacePredefinidoEnum {

    ENCUESTA("Encuesta Publicada"),
    FICHA_SEC("Ficha Socioeconómica"),
    NINGUNO("Ninguno");

    private final String value;
    private static final Map<String, TipoEnlacePredefinidoEnum> lookup = new HashMap<>();

    static {
        for (TipoEnlacePredefinidoEnum d : TipoEnlacePredefinidoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEnlacePredefinidoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEnlacePredefinidoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEnlacePredefinidoEnum d : TipoEnlacePredefinidoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
