package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoAlumnoEnum {

    REG("Alumno Regular"), AREND("Alumno Alto Rendimiento"), BREND("Alumno Bajo Rendimiento"), ULTCIC("Alumno Último Ciclo");

    private final String value;
    private static final Map<String, TipoAlumnoEnum> lookup = new HashMap<>();

    static {
        for (TipoAlumnoEnum d : TipoAlumnoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAlumnoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoAlumnoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAlumnoEnum d : TipoAlumnoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
