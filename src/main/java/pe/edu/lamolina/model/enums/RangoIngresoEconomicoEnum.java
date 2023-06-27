package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RangoIngresoEconomicoEnum {

    HASTA930("Hasta S/. 930.00"),
    DE931A1000("S/. 931.00 - S/. 1000.00"),
    DE1001A1500("S/. 1001.00 - S/. 1500.00"),
    DE1501A2000("S/. 1501.00 - S/. 2000.00"),
    DE2001A3000("S/. 2001.00 - S/. 3000.00"),
    DE3001A4000("S/. 3001.00 - S/. 4000.00"),
    DE4001A5000("S/. 4001.00 - S/. 5000.00"),
    DE5001A6000("S/. 5001.00 - S/. 6000.00"),
    DE6001A7000("S/. 6001.00 - S/. 7000.00"),
    DE7001AMAS("S/. 7001.00 - A Más");

    private final String value;
    private static final Map<String, RangoIngresoEconomicoEnum> lookup = new HashMap<>();

    static {
        for (RangoIngresoEconomicoEnum d : RangoIngresoEconomicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RangoIngresoEconomicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RangoIngresoEconomicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RangoIngresoEconomicoEnum d : RangoIngresoEconomicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
