package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSubvencionEnum {

    BOLSATRA("Bolsa de Trabajo"),
    BECALMEN("Beca almuerzo"),
    SUBVIVIE("Subvención de vivienda"),
    AREAVERDE("Áreas Verdes"),
    BOLSAINV("Bolsa de Investigación"),
    VIAJECURSO("Subvención por viaje de curso"),
    EVENTOFEDERADO("Evento de Federación Alumnos"),
    EVENTOGENERICO("Evento Genérico"),
    NOEXISTE("Evento no identificado");

    private final String value;
    private static final Map<String, TipoSubvencionEnum> lookup = new HashMap<>();

    static {
        for (TipoSubvencionEnum d : TipoSubvencionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoSubvencionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoSubvencionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSubvencionEnum d : TipoSubvencionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
