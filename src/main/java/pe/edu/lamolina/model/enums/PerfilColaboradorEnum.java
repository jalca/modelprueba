package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PerfilColaboradorEnum {

    ASISSOC("Asistenta Social"),
    ADMTVO("Administrativo"),
    EDITPROG("Editor de la Programación de Horarios"),
    DOC("Docente"),
    JMEDICO("Médico Jefe"),
    MEDICO("Médico"),
    TECENF("Técnico en enfermería"),
    SECUNDA_TUTOR("Coordinador Secundario de Tutoría"),
    COORDTUTOR("Coordinador de Tutoría"),
    F10038("Editor Examen Médico");

    private final String value;
    private static final Map<String, PerfilColaboradorEnum> lookup = new HashMap<>();

    static {
        for (PerfilColaboradorEnum d : PerfilColaboradorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PerfilColaboradorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PerfilColaboradorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PerfilColaboradorEnum d : PerfilColaboradorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
