package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum ContextoObjecionEnum {

    JUSTIFICACION("Justificación"),
    CRONOGRAMA("Cronograma"),
    PROFORMA("Proforma"),
    VIAJE("Viaje de Curso"),
    EVENTO("Evento de Alumnos");

    private final String value;
    private static final Map<String, ContextoObjecionEnum> lookup = new HashMap<>();

    static {
        for (ContextoObjecionEnum d : ContextoObjecionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContextoObjecionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContextoObjecionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContextoObjecionEnum d : ContextoObjecionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
