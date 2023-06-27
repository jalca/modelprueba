package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPeriodoEnum {

    UNA("Una vez"),
    MES("Un mes"),
    MMES("Más de un mes"),
    SEM("Seis meses"),
    MSEM("Más de seis meses"),
    YEAR("Un Año"),
    MYEAR("Más de un año");

    private final String value;
    private static final Map<String, TipoPeriodoEnum> lookup = new HashMap<>();

    static {
        for (TipoPeriodoEnum d : TipoPeriodoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPeriodoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPeriodoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPeriodoEnum d : TipoPeriodoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
