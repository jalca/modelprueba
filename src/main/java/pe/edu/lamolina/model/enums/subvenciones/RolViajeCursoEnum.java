package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum RolViajeCursoEnum {

    DOCENTE("Docente"),
    JEFE_DPTO("Jefe del Departamento Académico del Curso"),
    DELEGADO("Alumno Delegado"),
    ALUMNO("Alumno"),
    ADMINISTRACION("Personal del área de Administración"),
    JEFATURA("Personal de la Jefatura OBU");

    private final String value;
    private static final Map<String, RolViajeCursoEnum> lookup = new HashMap<>();

    static {
        for (RolViajeCursoEnum d : RolViajeCursoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RolViajeCursoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RolViajeCursoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RolViajeCursoEnum d : RolViajeCursoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
