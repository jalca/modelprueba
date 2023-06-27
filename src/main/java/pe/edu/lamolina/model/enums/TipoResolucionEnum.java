package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoResolucionEnum {

    ALU_ESP("Alumno Especial"),
    AING("Anulación de Ingreso"),
    RCI("Retiro Ciclo"),
    ANCI("Anulación Ciclo"),
    CAM_NOTA("Cambio de Nota"),
    NOTA_BAJA("Cambio de Nota más Baja"),
    REIC("Reincorporación"),
    CURDIR("Curso Dirigido"),
    EPG_ING("Posgrado Resolución Ingresante"),
    TRAS("Trámite Traslado Externo"),
    TRAS_INT("Trámite Traslado Interno"),
    ING_HIS("Ingresos Físicos al Historial"),
    INTES("Intercambio Estudiantil"),
    SUST_TESIS("Sustentación de Tesis"),
    REI_EPG("Reincorporación EPG"),
    OBTE_GRADO("Obtención de Grado"),
    BACHI("Obtención Bachiller"),
    TITUL("Obtención Título"),
    JURADO("Nombrar Jurado para Examen Grado/Sustentación Tesis"),
    BECA_EPG("Beca Docente/Trabajador UNALM"),
    PRACTICAS("Practicas pre-profesionales"),
    READMISION("Readmisión"),
    CAMBIO_PLAN_CURRICULAR("Cambio Plan Curricular"),
    BACHIFAC("Obtención Bachiller Facultad");

    private final String value;
    private static final Map<String, TipoResolucionEnum> lookup = new HashMap<>();

    static {
        for (TipoResolucionEnum d : TipoResolucionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoResolucionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoResolucionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoResolucionEnum d : TipoResolucionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
