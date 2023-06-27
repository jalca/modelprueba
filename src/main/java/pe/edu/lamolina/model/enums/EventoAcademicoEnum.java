package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EventoAcademicoEnum {

    MAT_REG("Matrícula regular de pregrado"),
    MAT_EPG("Matrícula regular de posgrado"),
    MAT_VER("Matrícula nivelación"),
    MAT_REI("Reinscripción"),
    MAT_AMP_DOC("Ampliación Vacante Docente"),
    MAT_ING("Matricula ingresantes de pregrado"),
    MAT_EXTMP("Matrícula Extemporánea"),
    CREAR_CUOTAS("Generación de Cuotas"),
    //
    REGULA_PRE("Regularización de Matrícula de Pregrado"),
    REGULA_EPG("Regularización de Matrícula de Posgrado"),
    //
    RET_CURSO_PRE("Retiro Curso Pregrado"),
    RET_CURSO_EPG("Retiro Curso Posgrado"),
    RET_CICLO_PRE("Retiro Ciclo Pregrado"),
    RET_CICLO_EXE("Retiro Ciclo Excepcional"),
    RET_CICLO_EPG("Retiro Ciclo Postgrado"),
    RET_CICLO_EPG_PAGO("Retiro Ciclo Posgrado con Pago"),
    RET_CICLO_PRE_PAGO("Retiro Ciclo Pregrado con Pago"),
    RET_CURSO_PRE_PAGO("Retiro Curso Pregrado con Pago"),
    RET_CURSO_EPG_PAGO("Retiro Curso Posgrado con Pago"),
    RET_CURSO_LIBRE("Retiro Ciclo Sin Conteo"),
    //
    ISEC("Llenado de Información Socioecónomica"),
    //
    CLASES_EPG("Dictado de clases de posgrado"),
    CLASES_PRE("Dictado de clases de pregrado"),
    CLASES_VER("Dictado de clases de nivelación"),
    //
    EXAMEN_PARC("Exámenes Parciales"),
    EXAMEN_FIN("Exámenes Finales"),
    EVENT_SOPORTE("Evento para soporte"),
    FECHAS_BACH("Fecha primera matricula y egreso"),
    ENCU_GEN("Encuestas Generales"),
    //
    EXAM_MEDICO("Examen Centro Médico"),
    EPG_MAT_EXTMP("Matricula Extemporáneo EPG"),
    INCRIPCION_CURSO_DIRIGIDO("Inscripción curso dirigido");

    private final String value;
    private static final Map<String, EventoAcademicoEnum> lookup = new HashMap<>();

    static {
        for (EventoAcademicoEnum d : EventoAcademicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EventoAcademicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventoAcademicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EventoAcademicoEnum d : EventoAcademicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
