package pe.edu.lamolina.model.constantines;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import pe.albatross.zelpers.miscelanea.OSValidator;
import static pe.edu.lamolina.model.constantines.GlobalConstantine.S3_URL_BASE;

public interface AcademicoConstantine {

    //Storage
    String S3_BUCKET_ACADEMICO = "lamolina-academico";
    String S3_URL_ACADEMICO = S3_URL_BASE + S3_BUCKET_ACADEMICO + File.separator;

    String S3_DIR_ARCHIVO_ATENCION = "archivo/atencion/";
    String S3_DIR_FOTO_TMP = "fotos/temporal/";
    String S3_DIR_FOTO_DOCUMENTO = "fotos/documentos/";
    String S3_DIR_FOTO_CARNET = "fotos/carnet/";
    String S3_DIR_BECADOS = "becados/documento/";
    String S3_RESOLUCIONES_DIR = "resoluciones/";
    String S3_DIR_INVENTARIO = "inventario/";
    String S3_DIR_CONVENIO = "convenio/";
    String S3_DIR_DOC_CV = "curriculum-vitaes/";
    String S3_PROY_TESIS = "tramites/proyecto-tesis/";
    String S3_DIR_SILABUS = "silabus/";
    String S3_FOTO_DOCENTE = "public-unalm/profile/";
    String S3_ESCALAFON_CURRICULUM = "escalafon/";
    String S3_TRAMITE_DOCUMENTO = "documental/TRAMITE_DOCUMENTOS/boletas/";
    String S3_PLANTILLA_WORD = "documental/TRAMITE_DOCUMENTOS/plantillaWord/";

    String INTRANET_DIR = OSValidator.isWindows() ? "C:/intranet/" : "/intranet/";

    ///---- MATRICULA
    String[] CODIGO_INGRESANTE = {"8", "9"};

    Integer VECES_TRIKA = 3;

    Integer ULTIMO_CICLO = 10;

    Integer CANT_MINIMA_MATRICULA_CACHIMBOS = 6;

    //---- ACADEMICOS
    Long ID_OFICINA_OERA = 50L;

    Long CAPA_ULTIMO_CICLO = 172l;

    Integer YEAR_ALL_APPROVE = 1986;

    String DOCENTE_INDETERMINADO = "N.N.";

    Integer DAYS_EDIT_TEMA_CICLO = 3;

    String CODE_ALUMNO_DUMMY = "00000000";

    String CODE_POSTULANTE_DUMMY = "00000000";

    String COD_CARRERA_ALUMNO_VISITANTE = "001";
    String COD_CARRERA_ALUMNO_ESPECIAL = "000";

    Long ANEXO_SUP_DEP_ACAD = 2l;

    String CODIGO_ALIANZA_ESTRATEGICA = "003";

    Long ID_CICLO_NOVENTA_TRES = 374l;

    //--- TRAMITES
    String TRAMITE = "TRAM";
    String CODE_IDIOMA_ESPANOL = "es";
    String CODE_IDIOMA_INGLES = "en";
    String FECHA_STANDARD = "dd/MM/yyyy";
    String CREDITOS_INSUFICIENTES = "Créditos matrículados insuficientes";

    String RETIRO_CICLO = "Retiro de ciclo académico";

    Integer CANTIDAD_MAXIMA_VECES_RETIRO_CICLO = 2;

    Integer CANTIDAD_MAXIMA_VECES_ANULACION_CICLO = 1;

    Integer CANTIDAD_MAXIMA_VECES_RETIRO_CURSO = 6;

    //--- ENCUESTA DOCENTE
    String REQ_MAX_DOCENTE = "No cumple requisito de máximo docentes";
    String REQ_MIN_ALUMNO = "No cumple requisito de mínimo alumnos";
    String REQ_CUR_TEORIA = "Encuestado en el curso de  teoría";
    String REQ_EVENTO = "Evento académico no configurado";

    Long ID_TIPO_SUBVENCION_INVESTIGACION = 5L;
    Long ID_TIPO_TRAMITE_SUBVENCION = 1L;

    String CICLO_ORDEN_MERITO = "CICLO_ORDEN_MERITO";
    String CICLO_ANEXO_BOLETIN = "CICLO_ANEXO_BOLETIN";

    final static Integer CANTIDAD_HORAS_POR_EXAMEN = 2;

    //---PLANES
    Integer CREDITOS_ADIC_ELC = 4;
    String CODIGO_CURSO_DEP = "EG1006";
    String GRUPO_ZTEO = "Z";
    String GRUPO_ZPRA = "Z*";
    List<Long> GRUPOS_HORAS_UNUSED = Arrays.asList(23L, 24L);

    //---PLATAFORMAS EXTERNAS
    String URL_DINA = "https://ctivitae.concytec.gob.pe/appDirectorioCTI/VerDatosInvestigador.do?id_investigador=%s";

    String URL_SCOPUS = "https://www.scopus.com/authid/detail.uri?authorId=%s";

    String URL_ORCID = "https://orcid.org/%s";

}
