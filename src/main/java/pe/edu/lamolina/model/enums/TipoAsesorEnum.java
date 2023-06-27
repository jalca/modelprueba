package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAsesorEnum {

    DOCENTE("Docente"), EXTERNO("Externo");

    private final String value;
    private static final Map<String, TipoAsesorEnum> lookup = new HashMap<>();

    static {
        for (TipoAsesorEnum d : TipoAsesorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAsesorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAsesorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAsesorEnum d : TipoAsesorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
