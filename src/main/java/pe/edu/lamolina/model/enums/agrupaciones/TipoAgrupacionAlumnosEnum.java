package pe.edu.lamolina.model.enums.agrupaciones;

import java.util.HashMap;
import java.util.Map;

public enum TipoAgrupacionAlumnosEnum {

    FEUA("Federación de Alumnos", "FEDERADO"),
    CCFA("Centro Federado de Facultad", "FEDERADO"),
    TERCIO("Tercio Estudiantil", "FEDERADO"),
    EVENTO("Agrupación por Evento", "GENERICO");

    private final String value;
    private final String nivel;
    private static final Map<String, TipoAgrupacionAlumnosEnum> lookup = new HashMap<>();

    static {
        for (TipoAgrupacionAlumnosEnum d : TipoAgrupacionAlumnosEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoAgrupacionAlumnosEnum(String value, String nivel) {
        this.value = value;
        this.nivel = nivel;
    }

    public String getValue() {
        return value;
    }

    public String getNivel() {
        return nivel;
    }

    public static TipoAgrupacionAlumnosEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoAgrupacionAlumnosEnum d : TipoAgrupacionAlumnosEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
