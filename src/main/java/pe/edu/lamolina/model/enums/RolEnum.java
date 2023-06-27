package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RolEnum {

    // Maestros
    ALU("Alumno"),
    DOC("Docente"),
    ADM_UNALM("Administrativo UNALM"),
    ADM_CPA("Administrativo CPA"),
    // Oficina de estudios
    OREA("Estudios Académicos"),
    RACD("Registro Académico"),
    OPER_PROGH_OERA("Operador de Programación de Horarios de Estudios"), // antes PHOR
    OPER_PROGH_EPG("Operador de Programación de Horarios de Posgrado"),
    REVISOR_PROGH_EPG("Operador de Programación de Horarios de Posgrado"),
    OPER_PROGH_ESP_EPG("Operador de Programación de Horarios de maestría de Posgrado"),
    OPER_PROGH_DPTO("Operador de Programación de Horarios de departamentos académicos"),
    OPER_PROGH_ESP_PRE("Operador de Programación de Horarios de carrera de Pregrado"),
    OPER_MATRICULA_OERA("Operador Matrícula OERA"),
    EDITOR_ALUMNO_OERA("Editor de Alumnos OERA"),
    EDITOR_ENCU("Editor de Encuestas"),
    EDITOR_CURRICULA("Editor Plan Curricular"),
    EDITOR_CURSOS("Editor de Cursos"),
    CALCULO_PROM_AVANCE("Ejecutor de promedios y avance"),
    TRAM_DOCUM_OERA("Tramitador Documentario OERA"),
    //
    DPTO("Departamento Académico"),
    FAC("Facultad"),
    IOREA("Informático de Oficina de Estudios"),
    OPER_ADM("Operador Admisión"),
    CONF_ADM("Configurador Admisión"),
    PAGO_ADM("Pagos Admisión"),
    EXAM_ADM("Configurador Examen Admisión"),
    REV_CICLO("Revisor de Ciclos"),
    SEG_ADM("Seguridad Admisión"),
    JUR_ADM("Jurado Admisión"),
    RECTOR("Rector"),
    VICE_ACAD("Vicerrector académico"),
    VICE_INVES("Vicerrector de investigación"),
    SECRE_GEN("Secretario General"),
    DECANO_FAC("Decano Facultad"),
    DECA_FAC_AGRO("Decano Facultad de Agronomía"),
    DECA_FAC_CIEN("Decano Facultad de Ciencias"),
    DECA_FAC_ECO("Decano Facultad de Economía y Planificación"),
    DECA_FAC_FOR("Decano Facultad de Forestales"),
    DECA_FAC_AGRI("Decano Facultad de Ingeniería Agrícola"),
    DECA_FAC_IND("Decano Facultad de Industrias Alimentarias"),
    DECA_FAC_PES("Decano Facultad de Pesquería"),
    DECA_FAC_ZOO("Decano Facultad de Zootecnia"),
    DIR_EPG("Director de la Escuela de Posgrado"),
    JEFE_OERA("Jefe de la Oficina de Estudios y Registros académicos"),
    JEFE_OBUAE("Jefe de la Oficina de Bienestar Universitario"),
    JEFE_DPTO_ACA("Jefe de Departamento Académico"),
    DIR_OCA("Director de la Oficina de Calidad y Acreditación Universitaria (OCA)"),
    ASIS_OCA("Asistente Administrativo OCA"),
    RRPP("Relaciones Públicas"),
    ADM_EXAM_VIR("Administrador Examen Virtual"),
    CPA("CPA"),
    ADMIN_CMS("Administrador CMS"),
    DIR_CEPRE("Director CEPRE-UNALM"),
    DIR_BAN("Director Biblioteca Agrícola Nacional"),
    JEFE_CAR_GEST("Jefe Carrera Gestión Empresarial"),
    JEFE_CAR_BIO("Jefe Carrera Biología"),
    JEFE_CAR_ECO("Jefe Carrera Economía"),
    JEFE_CAR_ESTA("Jefe Carrera Estadística e Informática"),
    JEFE_CAR_METEO("Jefe Carrera Meteorología"),
    JEFE_CAR_PESQ("Jefe Carrera Pesquería"),
    JEFE_CAR_AGRI("Jefe Carrera Ingeniería Agrícola"),
    JEFE_CAR_ZOO("Jefe Carrera Zootecnia"),
    JEFE_CAR_ALIM("Jefe Carrera Industrias Alimentarias"),
    JEFE_CAR_AGRO("Jefe Carrera Agronomía"),
    JEFE_CAR_FORE("Jefe Carrera Ingeniería Forestal"),
    JEFE_CAR_AMBI("Jefe Carrera Ingeniería Ambiental"),
    COORD_TUTO("Coordinador de Tutoría"),
    TODO("Todo"),
    MOD("Modalidad"),
    ESP("Especialidad"),
    REVISOR_FAC_ECONOMIA("Revisor de la Facultad de Economía y Planificación"),
    //NETWORKING
    ADMIN_NETWORKING("Administrador Networking"),
    ADMIN_FAC("Administrador Facultad"),
    EGRE("Egresado"),
    EMPRE("Empresa"),
    ADM_OCA("Apoyo administrativo OCA"),
    MED("Médico"),
    // 
    ALM_DEPO("Almacenero Deporte"),
    ALM_CULT("Almacenero Cultural"),
    RESDEP("Reservista Ambiente Deporte"),
    RESCULT("Reservista Ambiente Cultural"),
    ASIG_CUR_DEP("Asignador de Cursos Libres de Deporte"),
    ASIG_CUR_CULT("Asignador de Cursos Libres de Culturales"),
    TESO_DEP("Tesorero de Departamento de Deporte"),
    TESO_CULT("Tesorero de Departamento de Cultura"),
    TUTO("Tutoría"),
    TUTOC("Tutoría C."),
    // Bienestar
    SUPER_SUBV("Supervisor de Subvenciones"),
    ASOCIAL("Asistenta Social"),
    SECRE_ASOCIAL("Secretaria de Asuntos Estudiantiles"),
    SECRE_OBUAE("Secretaria Jefatura OBU"),
    EDITOR_ALUMNO_OBUAE("Editor de Alumnos OBU"),
    OPER_DESC_ESPECIAL_VERANO("Operador descuento especial Verano"),
    OPER_MAT_VERANO("Operador matricula Verano"),
    OPER_PRESUPUESTO_OBUAE("Operador Presupuesto OBUAE"),
    OPER_PROG_VERANO("Operador Programacion verano"),
    OPER_SUBV("Operador de Subvenciones"),
    RESP_ASIS_VERANO("Responsable de asistencia de verano"),
    CFG_CENMED("Configurador Centro Médico"),
    TEC_ENF("Técnico enfermería"),
    TEC_FARMA("Técnico farmacia"),
    ECONO("Economista"),
    INF_OBUAE("Informático Bienestar"),
    REVISOR_APORTE("Revisor de Aportes"),
    SECRE_EXO_SEG("Secretario(a) de exoneración de seguro contra accidentes"),
    TECBIO("Técnico en bioanalista"),
    EXO_APO_EXTRA("Exonerador Aportes Extraordinario"),
    // comedor
    INSPECTOR_COMEDOR("Inspector Comedor"),
    CONFIG_COMEDOR("Configurador Comedor"),
    VENDE_COMEDOR("Vendedor Comedor"),
    PORTERO_COMEDOR("Portero Comedor"),
    // Calidad
    UCA_ZOO("Calidad Académica Zootecnia"),
    UCA_PESQ("Calidad Académica Pesquería"),
    OPER_OCI("Operador OCI"),
    // EPG
    INF_EPG("Informático Escuela Posgrado"),
    DUPG("Director de la Unidad de Posgrado"),
    COORD_ESP_EPG("Coordinador de Especialidad de Posgrado"),
    SECRE_ACAD_EPG("Secretario Academico de Posgrado"),
    SECRE_ESP_EPG("Secretaria de Especialidad de Posgrado"),
    OPER_ADM_EPG("Operador Admisión EPG"),
    REV_POSTUL_EPG("Revisor Postulante EPG"),
    EVA_POSTUL_EPG("Evaluador Postulante EPG"),
    EDITOR_CURRICULA_EPG("Editor Plan Curricular de Posgrado"),
    EDITOR_CURRICULA_ESP_EPG("Editor Plan Curricular de Especialidad de Posgrado"),
    OPER_TARIFA_EPG("Operador Tarifas EPG"),
    OPER_TARIFA_ESP_EPG("Operador Tarifas de Maestría"),
    REVISOR_TARIFA_EPG("Revisor Tarifas EPG"),
    REVISOR_TARIFA_ESP_EPG("Revisor Tarifas de Maestría"),
    OPER_MATRICULA_EPG("Operador Matrícula EPG"),
    OPER_MATRICULA_ESP_EPG("Operador Matrícula Especialidad Posgrado"),
    EDITOR_ALUMNO_EPG("Editor de Alumnos EPG"),
    COMITE_CONSJ("Comité consejero EPG"),
    COMITE_EVAL("Comité Evaluador"),
    JEFE_CAPE_EPG("Jefe CAPE EPG"),
    OPER_PLAN_EST("Operador plan de estudios"),
    OPER_TRAM_ACAD_EPG("Operador de Trámite Académico Posgrado"),
    OPER_PROY_TESIS("Operador Proyecto Tesis"),
    OPER_COMITE_CONSJERO("Operador Comité Consejero"),
    REVISOR_CURSOS_EPG("Revisor Cursos de Posgrado"),
    REVISOR_CURSOS_MAESTRIA("Revisor Cursos de Especialidad de Posgrado"),
    OPER_CARNET_EPG("Operador Carnet EPG"),
    OPER_CAPE("Operador CAPE"),
    REVISOR_CAPE("Revisor CAPE"),
    GESTOR_MATRICULA_EPG("Administrador Matrícula Posgrado"),
    //    COORDINADOR_TRAMITE("Coordinador de tramites"),
    // Generales
    GESTOR_OFICINA("Administrador Módulo Oficina"),
    GESTOR_OFICINA_EPG("Administrador Oficinas Posgrado"),
    OPER_DEU_MATER("Operador Deuda Material"),
    REVISOR_ENCU("Revisor de Encuestas"),
    REVISOR_CURRICULA_PRE("Revisor Plan Curricular Pregrado"),
    REVISOR_CURRICULA_EPG("Revisor Plan Curricular Posgrado"),
    REVISOR_CURSOS_DPTO("Revisor Cursos por Departamento Académico"),
    REVCARR("Revisor de Malla Curricular"),
    //
    OPER_BIBLIO("Operador Bibliotecario"),
    // OPERADORES PRESUPUESTO ANUAL EPG
    OPER_GASTOS_ESP_EPG("Operador Gastos Especialidad Posgrado"),
    OPER_GASTOS_EPG("Operador Gastos Posgrado"),
    OPER_COMPRAS_EPG("Operador Compras Posgrado"),
    OPER_COMPRAS_ESP_EPG("Operador Compras Especialidad Posgrado"),
    OPER_ACTANOTAS_OERA("Operador Acta de Notas"),
    REVISOR_ACTANOTAS_OERA("Revisor Acta de Notas OERA"),
    REVISOR_ACTANOTAS_EPG("Revisor Acta de Notas EPG"),
    REVISOR_GASTOS_ESP_EPG("Revisor Gastos Especialidad Posgrado"),
    // COMUNICA
    ADMIN_COMUNICA("Administrador Software Comunica"),
    EDITOR_WEB("Editor de Websites"),
    EDITOR_BASE("Editor de Base de Conocimiento"),
    OPERADOR_HELPDESK("Operadores de Atención en Helpdesk"),
    //
    CAPE("CAPE"),
    DIRECTOR_DEPARTAMENTO("Director departamento"),
    REVISOR_INFORMACION_ACADEMICA("Revisor de información académica"),
    // casilla Electronica
    CAS_ELEC_POST("Postulante con casilla electronica"),
    CAS_ELEC_ADM("Administrador de casilla electronica"),
    //OCA
    OPERADOR_OCA("Operador de Oficina de Calidad y Acreditación"),
    //ADMISION
    ACREDITACION_CIENCIAS("Acreditación ciencias"),;

    private final String value;
    private static final Map<String, RolEnum> lookup = new HashMap<>();

    static {
        for (RolEnum d : RolEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RolEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RolEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RolEnum d : RolEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
