package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoExoneracionAporteSemestralEnum {

    EXON("Exoneración Total"),
    DESC("Descuento");

    private final String value;
    private static final Map<String, TipoExoneracionAporteSemestralEnum> lookup = new HashMap<>();

    static {
        for (TipoExoneracionAporteSemestralEnum d : TipoExoneracionAporteSemestralEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoExoneracionAporteSemestralEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoExoneracionAporteSemestralEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoExoneracionAporteSemestralEnum d : TipoExoneracionAporteSemestralEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
