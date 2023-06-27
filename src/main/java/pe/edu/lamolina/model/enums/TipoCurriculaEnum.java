package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCurriculaEnum {

    COMD("Comodin"),
    ADIC("No Acreditado"),
    ADIE("No Acreditado Externo"),
    REG("Acreditado");

    private final String value;
    private static final Map<String, TipoCurriculaEnum> lookup = new HashMap();

    static {
        for (TipoCurriculaEnum d : TipoCurriculaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCurriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCurriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (TipoCurriculaEnum d : TipoCurriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
