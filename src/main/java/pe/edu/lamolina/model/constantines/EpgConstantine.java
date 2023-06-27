package pe.edu.lamolina.model.constantines;

import java.util.Arrays;
import java.util.List;

public interface EpgConstantine {

    String INTERESADO_TIPO_TMP = "INTERESADO_TIPO_TMP";
    String INTERESADO_TMP = "INTERESADO_TMP";
    String INTERESADO_TOKEN_TMP = "INTERESADO_TOKEN_TMP";

    // Tarifas Creditos Míminos
//    Integer TARIFA_CREDITOS_MINIMO = new Integer(10);
//    Integer TARIFA_CREDITOS_MAXIMO = new Integer(18);
    String TARIFA_NOMBRE_ESPECIAL = "Genérico";

    // Códigos Generales
    Long ID_OFICINA_EPG = 57L;
    String CODIGO_OFICINA_EPG = "EPG";

    String CODIGO_CARREA_SIN_CARRERA = "SC";
    String PATH_ORIGEN = "PATH_ORIGEN";

    // REPORTES
    String REPORTE_COD_FICHA_EVALUACION = "SIS-F-008 Rev. 0";
    String REPORTE_FICHA_DATOS_PERSONALES = "SIS-F-007 Rev. 0";
    String REPORTE_COD_CONTROL_EXPEDIENTE = "SIS-F-006 Rev. 2";
    String REPORTE_ACTA_CONCURSO_ADMISION = "SIS-F-009 Rev. 04";

    String ORDEN_COMPRA_CODE = "Formato SIS-F-040 \n Rev. N° 01 Fecha: 2021-01-04";
    String ORDEN_SERVICIO_CODE = "Formato SIS-F-041 \n Rev. N° 01 Fecha: 2021-01-04";

    List<String> PTJES_MTO_INICIAL_EPG = Arrays.asList("25", "40", "50", "60");

    String FOOTER_EPG_ESTADO_CUENTA = "SI REQUIERE FACTURA COMUNICAR DENTRO DE LAS 24 HORAS DEL PAGO A LA OFICINA DE CONTABILIDAD EPG O A LOS SIGUIENTES CORREOS: escuela@lamolina.edu.pe , tmedina@lamolina.edu.pe, EN EL CASO CONTRARIO LA EPG EMITIRÁ BOLETAS DE VENTA";

    // Mail
    String EPG_RECURSO_IMG_UNALM_MAIL = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-academico/publico/1562080481334.png";
    String EPG_RECURSO_IMG_EPG_MAIL = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-academico/publico/1562080468808.jpg";

    String EPG_RECURSO_TUTORIAL = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/lamolina-academico/publico/1562080492687.pdf";

    //para fines de boleta de pago
    String EPG_RECURSO_IMG_UNALM_PDF = "escudoUnalmSm.jpg";
    String EPG_RECURSO_IMG_EPG_PDF = "logoepg.jpg";
    //boleta pago logo html
    String PDF_LOGO_UNALM = "/pdf/img/escudoUnalmSm.jpg";
    String PDF_LOGO_EPG = "/pdf/img/logoepg.jpg";
    String PDF_ESCUDO_UNALM = "/public/pdf/img/escudo-vertical.png";

    // STORAGE   
    String S3_DIR_FORMATO = "posgrado/formato/";
    String S3_DIR_VSWIFT = "posgrado/vswift/";
    String S3_DIR_FOTO_POSTULANTE = "posgrado/fotos-postulante/";
    String S3_DIR_ACTAS_EPG = "posgrado/actas-posgrado/";
    String S3_CONSTANCIAS_EPG = "posgrado/constancias-posgrado/";
    String S3_DIR_BOUCHER_EPG = "posgrado/boucher-posgrado/";
    String S3_DIR_ADMISION_DOC = "posgrado/admision/documento/";
    String S3_DIR_FACTURAS = "posgrado/facturas/";

    String RUTA_FICHA_SOCIOECONOMICA = "/bienestar/fichaalumno/datosalumno/socioecono";

    // HELP
    String CELULAR_HELP = "936780789";

}
