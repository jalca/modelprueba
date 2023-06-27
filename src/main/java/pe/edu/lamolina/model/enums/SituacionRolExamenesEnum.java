package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SituacionRolExamenesEnum {

    CFG_ROL("Configuración Rol Examenes", "Configurar Rol Examenes", 1),
    CFG_HOR("Configuración Horario", "Configurar Horarios", 2),
    CONF_HOR("Confirmar Horario", "Confirmar Horarios", 3),
    CFG_MAS("Configuración Cursos Masivos", "Configurar Cursos Masivos", 4),
    CFG_REG("Configuración Cursos Regulares", "Configurar Cursos Regulares", 5),
    CFG_HOR_MAS("Configuración Horario Cursos Masivos", "Configurar Horario Cursos Masivos", 6),
    CFG_ESP("Configuración Cursos Especiales", "Configurar Cursos Especiales", 7);

    private final String value;
    private final String value2;
    private final Integer level;
    private static final Map<String, SituacionRolExamenesEnum> lookup = new HashMap<>();

    static {
        for (SituacionRolExamenesEnum d : SituacionRolExamenesEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SituacionRolExamenesEnum(String value, String value2, Integer level) {
        this.value = value;
        this.value2 = value2;
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public String getValue2() {
        return value2;
    }

    public Integer getLevel() {
        return level;
    }

    public static SituacionRolExamenesEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SituacionRolExamenesEnum d : SituacionRolExamenesEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
