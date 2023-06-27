package pe.edu.lamolina.model.constantines;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import pe.albatross.zelpers.miscelanea.OSValidator;
import static pe.edu.lamolina.model.constantines.GlobalConstantine.S3_URL_BASE;

public interface AdmisionConstantine {

    String SESSION_USUARIO = "SESSION_USUARIO";

    String CODIGO_PERU = "PE";

    Long MINUTE_TO_MILISECOND = 60000L;
    Long TIME_REFRESH = 1000L;

    // STORE
    String S3_BUCKET_ADMISION = "lamolina-admision";
    String S3_URL_ADMISION = S3_URL_BASE + S3_BUCKET_ADMISION + File.separator;
    String S3_PROSPECTO_DIR = "prospectos/";
    String S3_FOTO_POSTULANTE = "fotos-postulante/";
    String S3_PDF_GUIA = "publico/guias/";
    String S3_CARTAS_DIR = "cartas/";
    String S3_PUBLIC_DIR_EVA = "evaluacion/";
    String S3_PARROT = "parrot/";
    String S3_CARNET_VACUNA = "carne-vacuna/";
    //LOCALDIR
    String ADMISION_DIR = OSValidator.isWindows() ? "C:/tmp/" : "/sip/admision/";
    String SIP_DIR = OSValidator.isWindows() ? "c:\\sip\\" : "/sip/";

    Long ID_POSTULANTE_DUMMY = 50l;
    String CODE_POSTULANTE_DUMMY = "00000000";
    Long SYSTEM_PERSON_ID = 100L;

    String CEPRE = " CEPRE ";
    String ENTREVISTA_OBUAE_CEPRE = "CEPRE";
    String ENTREVISTA_OBUAE_OTROS = "OTROS";

    String CODE_PROSPECTO = "000";
    String CODE_DIFERENCIA_PRECIO = "008";
    String CODE_EXTEMPORANEO = "739";
    String CODE_SIN_DESCRIPCION = "999";
    String CODE_EXAMEN_VIRTUAL = "003";
    String CODE_GASTOS_ADMIN = "004";
    String CODE_PRUEBAS = "756";

    String CODE_GUIAPOSTULANTE_CON_EXAMEN = "001";
    String CODE_GUIAPOSTULANTE_SIN_EXAMEN = "002";

    String CODE_MODALIDAD_ORDINARIO = "01";
    String CODE_MODALIDAD_PRIMEROS_PUESTOS = "02";
    String CODE_MODALIDAD_CEPRE = "03";
    String CODE_MODALIDAD_TRASLADO = "04";
    String CODE_MODALIDAD_GRADUADOS_TITULADOS = "05";
    List<String> CODE_MODALIDAD_ANDRES_BELLO = Arrays.asList("08", "27");
    String CODE_MODALIDAD_PRIMEROS_PUESTOS_COL = "19";
    String CODE_MODALIDAD_PRIMEROS_PUESTOS_PRES_REP = "20";
    String CODE_MODALIDAD_QUINTO_SECUNDARA = "24";
    String CODE_MODALIDAD_PARTICIPANTE_LIBRE = "25";
    String CODE_MODALIDAD_CONCURSO_ORDINARIO = "01";
    String CODE_MODALIDAD_COAR = "23";
    String CODE_MODALIDAD_PIR = "13";
    String CODE_MODALIDAD_BECARIO_EXTRANJERO = "07";

    String CONCEPTO_PAGO_GUIAPOSTULANTE = "PROSPECTO";
    List<String> CONCEPTOS_DSCTO_GENERICOS = Arrays.asList("01.05", "01.06", "01.07", "01.08");
    List<String> CONCEPTOS_DSCTO_BASES = Arrays.asList("01.01", "01.02", "01.03", "02.01", "02.02", "02.03", "04.01", "04.02", "05.00", "06.00", "06.02", "07.00", "08.00", "09.00", "10.01", "10.02", "10.03", "11.01", "11.02", "11.03", "12.01", "12.02", "12.03", "15.00", "23.00", "24.01", "24.02", "25.00", "88.03");

    String LISTA_FOTOS = "LISTA_FOTOS";
    String CICLO_REPORTES = "CICLO_REPORTES";
    String CICLO_POSTULANTE = "CICLO_POSTULANTE";

    String AUTOMATIC_CREATION = "Creado Automáticamente";
    String CERTIFICADO_ESTUDIO = "Certificado de estudios de 1° a 5° año de secundaria visado por la UGEL";
    Long CERTIFICADO_ESTUDIO_ID = 2L;
    Long EVALUACION_VIRTUAL = 3L;
    String ENCUESTA_ACTIVA = "ENCUESTA_ACTIVA";

    Long NEW_CICLO = 9L;

    String CELULAR_HELPDESK = "(+51) 937-413-951";

    String SOLO_INTERESADO = "SOLO-INTERESADO";

    String NO_INTERESADO = "No desea ser contactado";

    // MIMES
    String MIME_APPLICATION_PDF = "application/pdf";
    String MIME_IMAGE_GIF = "image/gif";
    String MIME_IMAGE_JPEG = "image/jpeg";
    String MIME_IMAGE_PNG = "image/png";

    String URL_BANNER_EMAIL = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-admision/website/2023-I/headerMail20231.png";

    String URL_HEADER_MAIL_01 = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-admision/publico/banner-obuae-01.png";
    String URL_HEADER_MAIL_02 = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-admision/publico/banner-obuae-02.png";
    String URL_HEADER_MAIL_03 = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-admision/publico/banner-obuae-03.png";

    // WEBSITE
    Long ID_OFICINA_CAP = 81L;
    Long SITIO_ADMISION = 1L;
    Long BLOQUE_GENERAL = 1L;
}
