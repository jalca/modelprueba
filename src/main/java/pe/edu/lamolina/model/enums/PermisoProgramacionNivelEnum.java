package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PermisoProgramacionNivelEnum {

    CURSO("Curso"), GPOSECC("Grupo Seccion"), SECCION("Seccion"), DOCENTE("Docente");

    private final String value;
    private static final Map<String, PermisoProgramacionNivelEnum> lookup = new HashMap<>();

    static {
        for (PermisoProgramacionNivelEnum d : PermisoProgramacionNivelEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PermisoProgramacionNivelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PermisoProgramacionNivelEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PermisoProgramacionNivelEnum d : PermisoProgramacionNivelEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
