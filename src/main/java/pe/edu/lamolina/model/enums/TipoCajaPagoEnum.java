package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCajaPagoEnum {

    EXAMEDICO("Examen Medico"), APOACADEMI("Aporte Academico");

    private final String value;
    private static final Map<String, TipoCajaPagoEnum> lookup = new HashMap<>();

    static {
        for (TipoCajaPagoEnum d : TipoCajaPagoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCajaPagoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCajaPagoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCajaPagoEnum d : TipoCajaPagoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
