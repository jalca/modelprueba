package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EntidadOficinaEnum {

    FAC("Facultad"),
    ESP("Especialidad"),
    MOD("Modalidad Estudio"),
    DPTO("Departamento Académico");

    private final String value;
    private static final Map<String, EntidadOficinaEnum> lookup = new HashMap<>();

    static {
        for (EntidadOficinaEnum d : EntidadOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EntidadOficinaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EntidadOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EntidadOficinaEnum d : EntidadOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EntidadOficinaEnum e : EntidadOficinaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
