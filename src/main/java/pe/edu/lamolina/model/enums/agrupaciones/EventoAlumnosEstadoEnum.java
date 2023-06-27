package pe.edu.lamolina.model.enums.agrupaciones;

import java.util.HashMap;
import java.util.Map;

public enum EventoAlumnosEstadoEnum {

    CREADO("Creado", "Requiere que el Delegado configure el Evento"),
    REG_EVENTO("Configurando Evento", "El Delegado debe enviar la solicitud a Jefatura OBU"),
    REQUIERE_VB("Requiere VºBº Jefatura OBU", "Requiere VºBº Jefatura OBU"),
    PENDIENTE("Requiere VºBº Alumnos", "Requiere VºBº Alumnos"),
    VB_BENEFICIARIO("Requiere VºBº Beneficiarios", "Requiere VºBº Beneficiarios"),
    OBSERVADO_OBU("Observado por Jefatura OBU", "El Delegado debe levantar las observaciones"),
    OBSERVADO_ALUMNO("Observado por Alumnos", "El Delegado debe levantar las observaciones de los alumnos"),
    RECHAZADO("Rechazado", ""),
    VB_JEFE_OBU("VºBº Jefatura OBU", "Requiere que el Delegado ingrese las justificaciones"),
    JUSTIFICADO("Con Justificación", "La justificación requiere VºBº del área de Administración"),
    VB_ADMIN_JUSTIFICA("VºBº Justificación Administración", "Falta que se ejecute el proceso de cierre"),
    JUSTIFICACION_ABIERTA("Justificación Abierta", "El Delegado debe ingresar más justificaciones"),
    MAS_JUSTIFICACIONES("Justificación contiene añadidos", "La justificación requiere VºBº del área de Administración"),
    CERRADO("Evento Cerrado", "");

    private final String value;
    private final String siguientePaso;
    private static final Map<String, EventoAlumnosEstadoEnum> lookup = new HashMap<>();

    static {
        for (EventoAlumnosEstadoEnum d : EventoAlumnosEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EventoAlumnosEstadoEnum(String value, String siguientePaso) {
        this.value = value;
        this.siguientePaso = siguientePaso;
    }

    public String getValue() {
        return value;
    }

    public String getSiguientePaso() {
        return siguientePaso;
    }

    public static EventoAlumnosEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EventoAlumnosEstadoEnum d : EventoAlumnosEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
