package pe.edu.lamolina.model.constantines;

public interface BienestarConstantine {

    //Formatos de Fecha
    String DIR_LEFT = "LEFT";
    String DIR_RIGTH = "RIGHT";

    String PARENTESCO_ESPOSO = "esposo";
    String PARENTESCO_ESPOSA = "esposa";

    Long PADRE = 1L;
    Long MADRE = 2L;
    Long CONYUGE = 3L;
    Long TUTOR = 4L;
    Long CONTACTO_EMERGENCIA = 5l;

    String TRAMITE = "TRAM";

    String BECA_ALMUERZO = "Beca almuerzo";
    String BOLSA_TRABAJO = "Bolsa de Trabajo";
    String AREA_VERDE = "Áreas Verdes";
    String BECA_INVESTIGACION = "Beca de Investigación";
    String SUBVENCION_VIVIENDA = "Subvención de vivienda";
    String SERVICIO_ALMUERZO = "Almuerzo";

    Integer TIME_FREE_RELEASE = 15;
    String COMEDOR_VENTA = "VENTA";
    String COMEDOR_ATENCION = "ATENCION";

    String APORTE_SEMESTRAL = "Aporte Semestral";
    String COLOR_PLOMO_FULL_CALENDAR = "#e5e5e5";

    Long LOTE_SERIE = 1L;
    Long HALLAZGO_SERIE = 1L;

    Long PERFIL_COMPANIA_ASISTENTA_ID = 18l;

    Long OFICINA_DBU_ID = 53l;

    // REVISAR: Se identifica que esto es Asuntos Estudiantiles 
    Long OFICINA_BIENESTAR_ID = 61l;

    String CANAL_GENERAL = "sala-espera";
    String QUEUE = "colilla";
    String QUEUE_COMEDOR = "colilla-comedor";
    String SATISFACCION_CARRERA = "Satisfacción con la carrera";

    String DEP_PARCIAL = "Depende parcialmente";
    String DEPEN = "Si es independiente";

    Integer CREDITOS_MINIMO_BENEFICIO_COMEDOR = 12;

    Integer MINUTOS_PREVIOS_RESERVA_CITA = 0;

    boolean VALIDAR_ULTIMO_CICLO_BENEFICIO_COMEDOR = true;

    // Storage
    String S3_DIR_CERTIFICADO_MEDICO = "certificado-medico/";
    String S3_DIR_EXONERACION_SEGURO = "exoneracion-seguro/";
    String S3_HIJO_TRABAJADOR_VERANO = "parentesco-verano/";
    String S3_DIR_DOCUMENTO_ENTREVISTA = "documento-entrevista-socioeco/";
    String S3_DIR_INFORME_SUBVENCION = "informe-subvencion/";
    String S3_DIR_JUSTIFICACION_SUBVENCION = "justificacion-subvencion/";
    String S3_DIR_FOLLETO_EVENTO = "folleto-evento/";
    String S3_DIR_FACHADA = "fotos/fachadas/";
    String S3_DIR_FOTO_CARNET_TALLER = "fotos/carnet-taller/";
    String S3_DIR_FOTO_DISCAPACIDAD = "fotos/documento-discapacidad/";

}
