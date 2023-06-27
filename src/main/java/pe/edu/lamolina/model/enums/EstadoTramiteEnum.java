package pe.edu.lamolina.model.enums;

public enum EstadoTramiteEnum {
    
    NADA(200000L);

    /****************
    SOL_REI(1L),
    REV_HIS(2L),
    CON_FAC(3L), //Constancia facultad
    RES_FAC(4L), //Resolucion Facultad
    SUB_DOC(5L), //Subir documento 
    RES_CON(6L), //Resolucion confirmada
    REC_SIT(7L), //Recalcular situacion
    AGE_CON_FAC(9L),//Agendado Consejo Facultad
    PROC_SOL(8L),//Procesar Solicitud
    RHZ_SOL(10L),//Rechazar Solicitud 
    REV_FAC(11L),
    SOL_ACEP(12L), //Solicitud Aceptada
    SOL_DEN(13L), //Solicitud Denegada
    VAL_URA(14L), // Validación registro academico
    PAG(17L),//Rechazar Solicitud
    CTRL_CALIDAD(23L), //Control Calidad
    VB_UR(24L), //Visto.Bueno. Ura
    PREPA(25L), //Preparado
    SOL_CAM_NOTA(65L), //Preparado
    SOL_CUR_DIR(35L), //Preparado
    VB_DOC(36L), // Visto Bueno Docente
    RCH_DOC(37L),
    VB_DEP_DOC(39L),
    REV_DEP(40L),
    RHZ_DEP(41L),
    SOL_ANU(42L),
    SOL_CORR_HISTO(43L),
    DOC_APR_CON(44L),
    DOC_RCHZ_CON(45L),
    COMP(45L),
    ENT(45L),
    //EPG_PLAN_CURRICULA
    EPG_PLAN_PEND(52L),//Pendiente revision
    EPG_PLAN_VB_COMI(44L),//Visto Bueno Comité
    EPG_PLAN_VB_CAPE(45L),//Visto Bueno Presidente CADE
    EPG_PLAN_VB_ACAD(46L),//Visto Bueno Secretario Academico
    EPG_PLAN_VB_ESPE(47L),//Visto Bueno Coordinador Especialidad
    EPG_PLAN_OBS_COMI(48L),//Observado Comité
    EPG_PLAN_OBS_CAPE(49L),//Observado Presidente CADE
    EPG_PLAN_OBS_ACAD(50L),//Observado Secretario Academico
    EPG_PLAN_OBS_ESPE(51L),//Observado Coordinador Especialidad
    EPG_PLAN_VB_DIR_EPG(47L),//Visto Bueno Coordinador Especialidad
    EPG_PLAN_OBS_DIR_EPG(47L),//Visto Bueno Coordinador Especialidad
    EPG_PLAN_VB_DIR_UNI(47L),//Visto Bueno Coordinador Especialidad
    EPG_PLAN_OBS_DIR_UNI(47L),//Visto Bueno Coordinador Especialidad
    // PROYECTO TESIS
    CRE(0L),
    SUG_ASESOR(0L),
    CONF_COMITE(0L),
    APR_CONSEJEROS(0L),
    REV_CONSEJEROS(0L),
    TRAM_COMITE(0L),
    OBSC_COMITE(0L),
    SOL_PROY_TESIS(0L), // solicitado
    REV_PROY_TESIS(0L), // en revision
    OBS_PROY_TESIS(0L), // observado
    ACEP_PROY_TESIS(0L), // aceptado por todos los miembros
    APR_PROY_TESIS(0L), // aprobado
    APC_COMITE(0L), // Comité Consejero Aprobado por el Coordinador
    OBSD_COMITE(0L), // Comité Consejero Observado por el Director de Unidad
    APD_COMITE(0L), // Comité Consejero Aprobado por el Director de Unidad
    OBSA_COMITE(0L), // Comité Consejero Observado por el Secretario Académico
    APR_COMITE(0L), // Comité Consejero Aprobado por el Secretario Académico
    ANU_TRAMITE(0L), // Trámite Comité Consejero Anulado
    RECHZ_PROY_TESIS(0L), // rechazado por el directorio
    // AGENDA
    AGEN_REU_CONS(0L),
    //EPG TRAMITE GRADO
    EPG_TRAM_GRADO_PEND(0L),//Pendiente 
    EPG_TRAM_GRADO_SOL(0L),//Pagado
    EPG_TRAM_GRADO_AGEN(0L),//Agendado
    EPG_TRAM_GRADO_APRO(0L),//Aprobado
    EPG_TRAM_GRADO_DESA(0L),//Desaprobado,
    ANU(0L);
    **********/ 

    private final Long id;

    private EstadoTramiteEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
