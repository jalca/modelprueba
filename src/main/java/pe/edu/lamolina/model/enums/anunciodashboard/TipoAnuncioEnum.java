package pe.edu.lamolina.model.enums.anunciodashboard;

import java.util.HashMap;
import java.util.Map;

public enum TipoAnuncioEnum {

    ALERTA("Anuncio Importante"),
    ANUNCIO("Anuncio Simple"),
    ACCESO_DIR("Acceso Directo"),
    CARRUSEL("Imágenes Carrusel");

    private final String value;
    private static final Map<String, TipoAnuncioEnum> lookup = new HashMap<>();

    static {
        for (TipoAnuncioEnum d : TipoAnuncioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAnuncioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAnuncioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAnuncioEnum d : TipoAnuncioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
