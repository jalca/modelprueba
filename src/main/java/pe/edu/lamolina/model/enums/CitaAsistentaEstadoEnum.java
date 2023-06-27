package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CitaAsistentaEstadoEnum {

    ATEN("Atendido"), PROG("Programado"), ANU("Anulado"), RPROG("Reprogramado");

    private final String value;
    private static final Map<String, CitaAsistentaEstadoEnum> lookup = new HashMap<>();

    static {
        for (CitaAsistentaEstadoEnum d : CitaAsistentaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CitaAsistentaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CitaAsistentaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CitaAsistentaEstadoEnum d : CitaAsistentaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
