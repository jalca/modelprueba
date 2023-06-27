package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoExoneracionSeguroEnum {

    EXON("Exoneración Total"),
    ADQU("Adquisición Seguro Particular");

    private final String value;
    private static final Map<String, TipoExoneracionSeguroEnum> lookup = new HashMap<>();

    static {
        for (TipoExoneracionSeguroEnum d : TipoExoneracionSeguroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoExoneracionSeguroEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoExoneracionSeguroEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoExoneracionSeguroEnum d : TipoExoneracionSeguroEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
