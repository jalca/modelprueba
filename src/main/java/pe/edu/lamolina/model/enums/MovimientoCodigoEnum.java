package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MovimientoCodigoEnum {

    RCU("Retiro Curso"),
    MAT("Matricula"),
    DEV("Devolución")
    
    ;

    private final String value;
    private static final Map<String, MovimientoCodigoEnum> lookup = new HashMap<>();

    static {
        for (MovimientoCodigoEnum d : MovimientoCodigoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MovimientoCodigoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MovimientoCodigoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MovimientoCodigoEnum d : MovimientoCodigoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
