package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum VariableGenericaEnum {

    NOMBRE_PERSONA("@(NOMBRE-PERSONA)", 1L),
    MATRICULA("@(MATRICULA)", 2L),
    PRIMER_CICLO_MATRICULADO_ROM("@(PRIMER-CICLO-MATRICULADO-ROM)", 3L),
    YEAR_INICIO("@(YEAR-INICIO)", 4L),
    ULTIMO_CICLO_MATRICULADO_ROM("@(ULTIMO-CICLO-MATRICULADO-ROM)", 5L),
    YEAR_FIN("@(YEAR-FIN)", 6L),
    CICLO_MATRICULA("@(CICLO-MATRICULADO)", 7L),
    FECHA_CONSTANCIA("@(FECHA-CONSTANCIA)", 10L),
    ESPECIALIDAD("@(ESPECIALIDAD)", 11L),
    ORDEN_MERITO_EGRESADO("@(ORDEN-MERITO_EGRESADO)", 12L),
    CICLO_ACADEMICO("@(CICLO-ACADEMICO)", 13L),
    NIVEL_ACADEMICO("@(NIVEL-ACADEMICO)", 14L),
    ORDEN_MERITO_NUMERICO("@(ORDEN-MERITO-NUMERICO)", 15L),
    CANTIDAD_ALUMNOS("@(CANTIDAD-ALUMNOS)", 16L),
    CICLO_PROMOCION("@(CICLO-PROMOCION)", 17L),
    CANTIDAD_CREDITOS_APROBADOS("@(CANTIDAD-CREDITOS-APROBADOS)", 18L),
    CANTIDAD_CREDITOS_CURSADOS("@(CANTIDAD-CREDITOS-CURSADOS)", 666L),
    CANTIDAD_CREDITOS_CONVALIDADOS("@(CANTIDAD-CREDITOS-CONVALIDADOS)", 666L),
    CANTIDAD_CURSOS_CONVALIDADOS("@(CANTIDAD-CURSOS-CONVALIDADOS)", 666L),
    CANTIDAD_TOTAL_CREDITOS("@(CANTIDAD-TOTAL-CREDITOS)", 666L),
    CANTIDAD_SEMANAS_CICLOS("@(CANTIDAD-SEMANAS-CICLO)", 19L),
    PROMEDIO_PONDERADO_GRADUACION("@(PROMEDIO-PONDERADO-GRADUACION)", 20L),
    MEJOR_PROMEDIO_PONDERADO_GRADUACION("@(MEJOR-PROMEDIO-PONDERADO-GRADUACION)", 21L),
    TITULO_PROFESIONAL("@(TITULO-PROFESIONAL)", 22L),
    PUESTO_ALUMNO_FACULTAD("@(PUESTO-ALUMNO-FACULTAD)", 23L),
    PRIMER_CICLO_MATRICULADO("@(PRIMER-CICLO-MATRICULADO)", 24L),
    FECHA_EGRESO("@(FECHA-EGRESO)", 25L),
    PROMEDIO_PONDERADO_ACADEMICO("@(PROMEDIO-PONDERADO-ACADEMICO)", 26L),
    NOMBRE_CURSO("@(NOMBRE-CURSO)", 27L),
    NOTA("@(NOTA)", 28L),
    CREDITO("@(CREDITO)", 29L),
    CODIGO_CURSO("@(CODIGO-CURSO)", 30L),
    SITUACION_ALUMNO("@(SITUACION-ALUMNO)", 31L),
    CARRERA("@(CARRERA)", 32L),
    SEX_MATRI("@(SEXO-MATRICULADO)", 33L),
    SEX_ALUM("@(SEXO-ALUMNO)", 34L),
    SEX_IDENT("@(SEXO-IDENTIFICADO)", 35L),
    ESTIMADO("@(ESTIMADO)", 36L),
    DECANO("@(DECANO)", 666L),
    TIPO_DOCUMENTO("@(TIPO-DOCUMENTO)", 666L),
    NUMERO_DOCUMENTO("@(NUMERO-DOCUMENTO)", 666L),
    RESOL_EGRESO("@(RESOL-EGRESO)", 666L),
    RESOL_FECHA("@(RESOL-FECHA)", 666L),
    ULTIMO_CICLO_MATRICULADO("@(ULTIMO-CICLO-MATRICULADO)", 666L),
    FECHA_ULTIMA_MATRICULA("@(FECHA-ULTIMA-MATRICULA)", 666L),
    ALUMNO_REGULAR("@(ALUMNO-REGULAR)", 666L),
    INCRUSTACION("@(INCRUSTACION)", 666L),
    RESOL_TITULO("@(RESOL-TITULO)", 666L),
    RESOL_TITULO_FECHA("@(RESOL-TITULO-FECHA)", 666L),
    CANTIDAD_CURSOS_APROBADOS("@(CANTIDAD-CURSOS-APROBADOS)", 666L),
    FIRMA_JEFE_FACULTAD("@(FIRMA-JEFE-FACULTAD)", 666L),
    JEFE_POS_GRADO("@(JEFE-POS-GRADO)", 666L),
    EPG_PROMEDIO_PONDERADO("@(EPG-PROMEDIO-PONDERADO)", 666L),
    //    Nuevos
    SEX_INTERESADO("@(SEX_INTERESADO)", 666L),
    FECHA_PRIMERA_MATRICULA("@(FECHA-PRIMERA-MATRICULA)", 25L),
    NIVEL_CURSADO("@(NIVEL-CURSADO)", 666L),
    CICLO_EGRESO("@(CICLO-EGRESO)", 666L),
    YEAR_CURSADO("@(YEAR-CURSADO)", 666L),
    APELLIDO_PERSONA("@(APELLIDO-PERSONA)", 666L),
    SENOR_A("@(SENOR-A)", 666L),
    EPG_PPA("@(EPG_PPA)", 666L),
    CICLO_ALIANZA_ESTRATEGICA("@(CICLO-ALIANZA-ESTRATEGICA)", 666L),
    CICLOS_CURSADOS("@(CICLOS-CURSADOS)", 666L),
    TABLA_CODIGO_CURSO("@(TABLA-CODIGO-CURSO)", 666L),
    TABLA_CURSO("@(TABLA-CURSO)", 666L),
    TABLA_CURSO_NOTA("@(TABLA-CURSO-NOTA)", 666L),
    TABLA_CURSO_CREDITO("@(TABLA-CURSO-CREDITO)", 666L),
    TABLA_CICLO_CURSADO("@(TABLA-CICLO_CURSADO)", 666L),
    TABLA_CICLO_ROM_CURSADO("@(TABLA-CICLO_ROM_CURSADO)", 666L),
    PROGRAMA("@(PROGRAMA)", 666L),
    CORRELATIVO_DOC("@(CORRELATIVO-DOCUMENTO)", 666L),
    FACULTAD("@(FACULTAD)", 666L),
    JEFE_OFICINA_OERA("@(JEFE-OFICINA-OERA)", 666L),
    JEFE_URA("@(JEFE-URA)", 666L),
    FECHA_TITULO("@(FECHA-TITULO)", 666L),
    APELLIDOS("@(APELLIDOS)", 666L),
    SEGNOR_MIN("@(EGNOR_MIN)", 666L),
    SEGNOR_MAY("@(SEGNOR_MAY)", 666L),
    PATERNO("@(PATERNO)", 666L),
    RESOLUCION_TESIS("@(RESOLUCION_TESIS)", 666L),
    FECHA_SESION_TESIS("@(FECHA_SESION_TESIS)", 666L),
    PATROCINADOR_TESIS("@(PATROCINADOR_TESIS)", 666L),
    TITULO_TESIS("@(TITULO_TESIS)", 666L),
    DIRECTOR("@(DIRECTOR)", 666L),
    SECRETARIO("@(SECRETARIO)", 666L),
    TABLA_CICLO("@(TABLA_CICLO)", 666L),
    TABLA_CICLO_ANIO("@(TABLA_CICLO)", 666L),
    TABLA_SUMA_CREDITOS("@(TABLA_SUMA_CREDITOS)", 666L),
    CICLO_INGRESO("@(CICLO_INGRESO)", 666L),
    ORIENTACION("@(ORIENTACION)", 666L),
    TIPO_SESION_TESIS("@(TIPO_SESION_TESIS)", 666L),
    CICLO_ANTERIOR("@(CICLO_ANTERIOR)", 666L),
    CREDITOS_APR_ANTERIOR("@(CREDITOS_APR_ANTERIOR)", 666L),
    VARIABLE_PARA_REMPLAZAR("@(VARIABLE_PARA_REMPLAZAR)", 666L),
    TABLA_HORAS_LECTIVAS("@(TABLA_HORAS_LECTIVAS)", 666L),
    TOTAL_HORAS_LECTIVAS("@(TOTAL_HORAS_LECTIVAS)", 666L),;

    private final String value;
    private final Long idVariable;
    private static final Map<String, VariableGenericaEnum> lookname = new HashMap<>();
    private static final Map<Long, VariableGenericaEnum> lookup = new HashMap<>();

    static {
        for (VariableGenericaEnum d : VariableGenericaEnum.values()) {
            lookname.put(d.getValue(), d);
            lookup.put(d.getIdVariable(), d);
        }
    }

    private VariableGenericaEnum(String value, Long id) {
        this.value = value;
        this.idVariable = id;
    }

    public String getValue() {
        return value;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public static VariableGenericaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (VariableGenericaEnum d : VariableGenericaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

}
