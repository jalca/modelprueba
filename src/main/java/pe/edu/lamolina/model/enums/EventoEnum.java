package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EventoEnum {

    ANT("Antes de la Inscripción"),
    CEPRE("Inscripción CEPRE"),
    INSC("Inscripción"),
    EXTM("Inscripción Extemporánea"),
    VER("Solo Visualización"),
    AULA("Visualización de Aula"),
    OTR("Inscripcin otras modalidades"),
    FIN("Fin del Proceso"),
    ENTREV("Entrevista OBUAE"),
    EXAM("Examen de Admisión"),
    ENTDOC("Entrega de Documentos"),
    CEPRE_EXTM("Extemporaneo Cepre");

    private final String value;
    private static final Map<String, EventoEnum> lookup = new HashMap<>();

    static {
        for (EventoEnum d : EventoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EventoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EventoEnum d : EventoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EventoEnum e : EventoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
