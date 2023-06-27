package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MotivoDescuemtoEnum {

    HIJOTRA("Hijo Trabajador o Docente", null),
    MODAL("Modalidad", null),
    CEPRE25("Cepre 25", 25),
    CEPRE30("Cepre 30", 30),
    CEPRE50("Cepre 50", 50),
    ESP25("Especial 25", 25),
    ESP50("Especial 50", 50),
    ESP100("Especial 100", 100),
    CAMP("Campaña", null);

    private final String value;
    private final Integer porcentaje;

    private static final Map<String, MotivoDescuemtoEnum> lookup = new HashMap<>();

    static {
        for (MotivoDescuemtoEnum d : MotivoDescuemtoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MotivoDescuemtoEnum(String value, Integer porcentaje) {
        this.value = value;
        this.porcentaje = porcentaje;
    }

    public String getValue() {
        return value;
    }

    public Integer getValueInt() {
        return porcentaje;
    }

    public static MotivoDescuemtoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MotivoDescuemtoEnum d : MotivoDescuemtoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
