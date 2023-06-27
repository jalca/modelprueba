package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoInformacionHistorialPdfEnum {

    CICLO("Ciclo"),
    PROM("Promedio"),
    LIST("Lista");

    private final String value;
    private static final Map<String, TipoInformacionHistorialPdfEnum> lookup = new HashMap<>();

    static {
        for (TipoInformacionHistorialPdfEnum d : TipoInformacionHistorialPdfEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoInformacionHistorialPdfEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoInformacionHistorialPdfEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoInformacionHistorialPdfEnum d : TipoInformacionHistorialPdfEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
