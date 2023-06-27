package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum ViajeCursoEstadoEnum {

    CREADO("Creado", "Debe enviar al Jefe del Departamento Académico", RolViajeCursoEnum.DOCENTE.name()),
    PENDIENTE("Pendiente Aprobación", "Requiere VºBº del Jefe del Departamento Académico", RolViajeCursoEnum.JEFE_DPTO.name()),
    DESAPROBADO("Desaprobado", "", ""),
    APROBADO("Aprobado", "El delegado debe llenar los datos del Viaje de Curso", RolViajeCursoEnum.DELEGADO.name()),
    DESCRITO("Descrito", "Los alumnos deben registrarse en el Viaje de Curso", RolViajeCursoEnum.ALUMNO.name()),
    INSCRITOS("Con inscritos", "Requiere el VºBº del área de Administración", RolViajeCursoEnum.ADMINISTRACION.name()),
    OBSERVADO("Observado", "Requiere que el Delegado levante las observaciones", RolViajeCursoEnum.DELEGADO.name()),
    VB_ADMIN("VºBº Administración", "Requiere el VºBº de Jefatura OBU", RolViajeCursoEnum.JEFATURA.name()),
    VB_JEFE_OBU("VºBº Jefatura OBU", "El Delegado debe registrar la asistencia de los que viajaron", RolViajeCursoEnum.DELEGADO.name()),
    ASISTENCIA("Con Asistencia Alumnos", "El Delegado debe llenar la justificación del viaje", RolViajeCursoEnum.DELEGADO.name()),
    JUSTIFICADO("Con Justificación", "La justificación requiere el VºBº del docente", RolViajeCursoEnum.DOCENTE.name()),
    VB_JUSTIFICACION("VºBº Justificación Docente", "La justificación requiere el VºBº del área de Administración", RolViajeCursoEnum.ADMINISTRACION.name()),
    OBSERVA_DOCENTE("Observado por el Docente", "Requiere que el Delegado levante las observaciones del docente", RolViajeCursoEnum.DELEGADO.name()),
    VB_ADMIN_JUSTIFICA("VºBº Justificación Administración", "Falta que se ejecute el proceso de cierre", ""),
    JUSTIFICACION_ABIERTA("Justificación Abierta", "El Delegado debe agregar más justificaciones", RolViajeCursoEnum.DELEGADO.name()),
    MAS_JUSTIFICACIONES("Justificación contiene añadidos", "La justificación requiere el VºBº del área de Administración", RolViajeCursoEnum.ADMINISTRACION.name()),
    CERRADO("Viaje Cerrado", "", "");

    private final String value;
    private final String siguientePaso;
    private final String rolInteresado;
    private static final Map<String, ViajeCursoEstadoEnum> lookup = new HashMap<>();

    static {
        for (ViajeCursoEstadoEnum d : ViajeCursoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ViajeCursoEstadoEnum(String value, String siguientePaso, String rolInteresado) {
        this.value = value;
        this.siguientePaso = siguientePaso;
        this.rolInteresado = rolInteresado;
    }

    public String getValue() {
        return value;
    }

    public String getSiguientePaso() {
        return siguientePaso;
    }

    public String getRolInteresado() {
        return rolInteresado;
    }

    public static ViajeCursoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ViajeCursoEstadoEnum d : ViajeCursoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
