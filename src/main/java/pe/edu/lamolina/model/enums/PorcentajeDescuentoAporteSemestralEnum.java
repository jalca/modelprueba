package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PorcentajeDescuentoAporteSemestralEnum {

    CINCO("5%", 5),
    VEINTE("20%", 20),
    CUARENTA("40%", 40),
    SESENTA("60%", 60),
    OCHENTA("80%", 80),
    CIEN("100%", 100);

    private final String value;
    private final Integer numero;
    private static final Map<String, PorcentajeDescuentoAporteSemestralEnum> lookup = new HashMap<>();
    private static final Map<Integer, PorcentajeDescuentoAporteSemestralEnum> lookupNum = new HashMap<>();

    static {
        for (PorcentajeDescuentoAporteSemestralEnum d : PorcentajeDescuentoAporteSemestralEnum.values()) {
            lookup.put(d.getValue(), d);
            lookupNum.put(d.getNumero(), d);
        }
    }

    private PorcentajeDescuentoAporteSemestralEnum(String value, Integer numero) {
        this.value = value;
        this.numero = numero;
    }

    public String getValue() {
        return value;
    }

    public Integer getNumero() {
        return numero;
    }

    public static PorcentajeDescuentoAporteSemestralEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PorcentajeDescuentoAporteSemestralEnum d : PorcentajeDescuentoAporteSemestralEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
