package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TramiteEstadoEnum {

    ACEP("Trámite Aceptado", 85L),
    ACT("Activo", 92L),
    AGEN_CAPE("Agendado para CAPE", 80L),
    AGEN_REU_CONS("Agendado por Reunión Consejo", 65L),
    AGE_CON_FAC("Agendado Consejo Facultad", 9L),
    ANU_TRAMITE("Trámite Comité Consejero Anulado", 34L),
    APC_COMITE("Comité Consejero Aprobado por el Coordinador", 31L),
    APD_COMITE("Comité Consejero Aprobado por el Director de Unidad", 64L),
    APR("Aprobado", 87L),
    APR_COMITE("Comité Consejero Aprobado por el Secretario Académico", 33L),
    APR_CONSEJEROS("Aprobación de Miembros Comité Consejero", 47L),
    CONF_COMITE("Configurando Comité Consejero", 28L),
    CON_FAC("Consejo Facultad", 3L),
    CTRL_CALIDAD("Control Calidad", 23L),
    DESAPR("Desaprobado", 102L),
    DEU_CANC("Deuda Cancelada", 90L),
    DEV("Devuelto", 93L),
    ENVJ("Enviado a Jefatura", 86L),
    //
    // estados tramites documentarios EPG
    //// CRE("Tramite Creado", 15L),
    DOC_APR_CON("Documento Aprobado por Consejero", 44L),
    PAG("Trámite Pagado", 17L),
    PIMP("Pre Impresión", 22L),
    COMP("Trámite Completo", 19L),
    ENT("Trámite Entregado", 20L),
    DOC_RCHZ_CON("Documento Rechazado por Consejero", 45L),
    //// ANU("Trámite Anulado", 76L),
    //
    // estados tramites subvencion obu
    //// SOL("Solicitado", 89L),
    CRE("Trámite Creado", 15L),
    FSEC("Ficha SEC Completada", 116L),
    CITA("Cita Reservada con Trabajadora Social", 117L),
    CTA_BANCO("Registró su Cuenta Bancaria", 118L),
    REV_FSEC("Ficha Socioeconómica observada", 119L),
    REV_ASUNT_ESTD("Revisión en Asuntos Estudiantiles", 111L),
    APR_ASUNT_ESTD("Aprobado por Asuntos Estudiantiles", 112L),
    RCHZ_ASUNT_ESTD("Rechazado por Asuntos Estudiantiles", 113L),
    SUPERV_ASIGN("Supervisor Asignado", 120L),
    SUPERV_APR("Supervisor Acepta Asignación", 121L),
    SUPERV_RCHZ("Supervisor Rechaza Asignación", 122L),
    APR_JEFE_ASUNT_ESTD("Aprobado por Jefe Asuntos Estudiantiles", 114L),
    APR_JEFE_OBUAE("Aprobado por Jefe Bienestar", 115L),
    ANU("Trámite Anulado", 76L),
    //
    // estados de procesos antiguos
    VER_COL("Validando Solicitud", 83L),
    ACTA_PEND("Actas Pendientes", 82L),
    APR_COOR("Aprobado por Coordinador", 81L),
    RCHZ_COOR("Rechazado por Coordinador", 79L),
    SOL("Solicitado", 89L),
    PEND_CAPE("Pendiente Aprobación de la CAPE", 110L),
    APR_CAPE("Aprobado por CAPE", 78L),
    RCHZ_CAPE("Rechazado por CAPE", 77L),
    //
    // estados del proceso del proyecto de tesis
    SOL_PROY_TESIS("Solicitado", 58L),
    REV_PROY_TESIS("Revisión del Proyecto de Tesis", 59L),
    OBS_PROY_TESIS("Observaciones del Proyecto de Tesis", 60L),
    ACEP_PROY_TESIS("Proyecto de Tesis Aceptado", 61L),
    APR_PROY_TESIS("Aprobado por el Directorio", 62L),
    RECHZ_PROY_TESIS("Rechazado por el Directorio", 66L),
    //
    // estados del proceso de plan de estudios
    EPG_PLAN_OBS_ACAD("Observado Secretario Academico", 55L),
    EPG_PLAN_OBS_CAPE("Observado Presidente CAPE", 54L),
    EPG_PLAN_OBS_COMI("Observado Comité", 53L),
    EPG_PLAN_OBS_DIR_EPG("Observado Director Posgrado", 68L),
    EPG_PLAN_OBS_DIR_UNI("Observado Director Unidad Posgrado", 70L),
    EPG_PLAN_OBS_ESPE("Observado Coordinador Especialidad", 56L),
    EPG_PLAN_PEND("Pendiente revisión del Comité Consejero", 57L),
    EPG_PLAN_VB_ACAD("Visto Bueno Secretario Academico", 50L),
    EPG_PLAN_VB_CAPE("Visto Bueno Presidente CAPE", 49L),
    EPG_PLAN_VB_COMI("Visto Bueno Comité", 48L),
    EPG_PLAN_VB_DIR_EPG("Visto Bueno Director Posgrado", 67L),
    EPG_PLAN_VB_DIR_UNI("Visto Bueno Director Unidad Posgrado", 69L),
    EPG_PLAN_VB_ESPE("Visto Bueno Coordinador Especialidad", 51L),
    //
    // estados de varios tramites de graduacion
    EPG_TRAM_GRADO_AGEN("Trámite Agendado", 73L),
    EPG_TRAM_GRADO_APC("Trámite Aprobado por el Cordinador", 107L),
    EPG_TRAM_GRADO_APRO("Trámite Aprobado", 74L),
    EPG_TRAM_GRADO_DESA("Trámite Desaprobado", 75L),
    EPG_TRAM_GRADO_PAC("Pendiente de Aprobación del Coordinador", 105L),
    EPG_TRAM_GRADO_PCA("Pendiente de Aprobación de la CAPE", 108L),
    EPG_TRAM_GRADO_PCERT("Pendiente de Certificado", 109L),
    EPG_TRAM_GRADO_PEND("Pendiente de pago", 71L),
    EPG_TRAM_GRADO_PVB("Pendiente de Visto Bueno del Secretario Académico", 106L),
    EPG_TRAM_GRADO_RCHZ("Trámite Rechazado", 104L),
    EPG_TRAM_GRADO_SOL("Trámite Solicitado", 72L),
    //
    //
    FVAL("Foto Validada", 16L),
    IMPW("Impreso Word", 18L),
    INC("Incompleto", 95L),
    NPAG("Trámite No Pagado", 21L),
    OBSA_COMITE("Comité Consejero Observado por el Secretario Académico", 32L),
    OBSC_COMITE("Comité Consejero Observado por el Coordinador", 30L),
    OBSD_COMITE("Comité Consejero Observado por el Director de Unidad", 63L),
    PEND("Pendiente", 91L),
    PREPA("Preparado", 25L),
    PROC("Procesando", 98L),
    PROC_SOL("Pendiente Revisión Consejo", 8L),
    PROG("Programado", 97L),
    RCHJ("Rechazado por jefe", 88L),
    RCHR("Rechazado por resolución", 94L),
    RCHS("Rechazado por Secretaria", 96L),
    RCHZ("Rechazado", 99L),
    RCH_DOC("Rechazado por Docente", 37L),
    REC_SIT("Recalcular Situación", 7L),
    RESOLUC_CRC("Con resolución con cargo a rendir cuenta", 84L),
    RES_CON("Solicitud Finalizada", 6L),
    RES_FAC("Resolución Facultad", 4L),
    REV_CONSEJEROS("Revisión de Consejeros", 52L),
    REV_DEP("Revisión Departamento", 40L),
    REV_FAC("Revisión Facultad", 11L),
    REV_HIS("Revisión Historial", 2L),
    RHZ_DEP("Rechazo Departamento", 41L),
    RHZ_SOL("Rechazo Solicitud", 10L),
    SOL_ACEP("Solicitud Aceptada", 12L),
    SOL_ANU("Solicitud Anulada", 42L),
    SOL_CAM_NOTA("Solicitud Cambio de Nota", 38L),
    SOL_CANC("Solicitud Cancelada", 46L),
    SOL_CORR_HISTO("Solicitud Correccion Historial", 43L),
    SOL_CUR_DIR("Solicitud Curso Dirigido", 35L),
    SOL_DEN("Solicitud Denegada", 13L),
    SOL_REI("Solicitud Reincorporación", 1L),
    SUB_DOC("Subir Documento", 5L),
    SUG_ASESOR("Sugiriendo Asesores para el Comité Consejero", 27L),
    TRAM_COMITE("Revisión Comité Consejero", 29L),
    VAL_URA("Validación Registro Académico", 14L),
    VBS("Visto Bueno de Secretaria", 100L),
    VB_DEP_DOC("Visto Bueno Departamento", 39L),
    VB_DOC("Visto Bueno Docente", 36L),
    VB_UR("V.B. URA", 24L),
    VERPAGO("Verificación de Pago Documento", 83L),
    //
    // estados de tramite subvencion
    CCS("Corroborado por Supervisor", 23L),
    RCHD("Rechazado por datos", 23L),
    RCHCS("Rechazado por Supervisor", 23L);

    private final String value;
    private final Long id;
    private static final Map<String, TramiteEstadoEnum> lookup = new HashMap<>();

    static {
        for (TramiteEstadoEnum d : TramiteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TramiteEstadoEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static TramiteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
