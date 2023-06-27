package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RecorridoIngresanteEstadoEnum {

    PEND("Pendiente"),
    INC("Incompleto"),
    POST("Postergado"),
    PROC("En proceso"),
    ACT("Completo"),
    SUPL("Suplantado"),
    MAT("Matriculado");

    private final String value;
    private static final Map<String, RecorridoIngresanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (RecorridoIngresanteEstadoEnum d : RecorridoIngresanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RecorridoIngresanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RecorridoIngresanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RecorridoIngresanteEstadoEnum d : RecorridoIngresanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
