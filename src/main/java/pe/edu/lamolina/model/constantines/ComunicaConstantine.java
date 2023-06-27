package pe.edu.lamolina.model.constantines;

import java.io.File;
import static pe.edu.lamolina.model.constantines.GlobalConstantine.S3_URL_BASE;

public interface ComunicaConstantine {
    
    String CODIGO_SISTEMA = "COMUNICA";
    
    // URLS
    String URL_TEST = "https://otros-test.lamolina.edu.pe/sites/";
    String URL_DEVEL = "http://localhost:9966/sites/";

    // CACHE - WEBSITES
    String CACHE_SITIO = "SITIO";
    String CACHE_POST = "POST";
    String CACHE_POST_CAT = "POST_CAT";
    String CACHE_POST_SNIPP = "POST_SNIPP";
    String CACHE_CAT = "CAT";
    String CACHE_BLOCK = "BLOCK";
    String CACHE_RECURSO = "RECURSO";

    // CACHE - BASE
    String CACHE_SITIO_BASE = "SITIO_BASE";
    String CACHE_SITIOS_BASE = "SITIOS_BASE";
    String CACHE_POST_BASE = "POST_BASE";
    String CACHE_CAT_BASE = "POST_CAT_BASE";

    // S3 CONSTANTS
    String S3_BUCKET_COMUNICA = "lamolina-comunica";

    String S3_URL_COMUNICA = S3_URL_BASE + S3_BUCKET_COMUNICA + File.separator;

    // WEBSITES FOLDER
    String S3_SITIO_ROOT = "websites/%s/";

    // sitio.folder/galerias/
    String S3_SITIO_MEDIA_GALERIAS = "websites/%s/galerias/";

    // sitio.folder/documentos/
    String S3_SITIO_MEDIA_DOCUMENTOS = "websites/%s/documentos/";

    // sitio.folder/miscelanea/
    String S3_SITIO_MEDIO_MISCELANEA = "websites/%s/miscelanea/";

    // HELPDESK FOLDER
    String S3_BASE_ROOT = "base/%s";

    // HELPDESK FOLDER
    String S3_HELPDESK_ROOT = "helpdesk/%s/";

}
