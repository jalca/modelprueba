package pe.edu.lamolina.model.constantines;

import java.util.Arrays;
import java.util.List;
import pe.albatross.zelpers.miscelanea.OSValidator;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;

public interface GlobalConstantine {

    String SESSION_USUARIO = "SESSION_USUARIO";

    String ACCESS_TOKEN_OAUTH = "ACCESS_TOKEN_OAUTH";

    final Usuario USUARIO_ADMIN = new Usuario(100000);
    final Persona PERSONA_ADMIN = new Persona(100000);

    String TMP_DIR = OSValidator.isWindows() ? "c:\\tmp\\" : "/tmp/";

    Integer DEFAULT_BUFFER_SIZE_DOWNLOAD = 1024 * 8;
    Integer MAX_IMG_SIZE = 300;

    String SCHEMA_OCTOPUS = "octopus";
    String SCHEMA_AUDITOR = "auditor";
    String SCHEMA_CROACIA = "croacia";
    String SCHEMA_CASILLA = "casillaElectronica";
    String SCHEMA_CIFRAS = "cifras";

    String[] FLAT_COLOR = {"#1abc9c", "#3498db", "#e74c3c", "#9b59b6", "#2ecc71", "#f39c12", "#A59275", "#434b51"};
    String[] MORE_FLAT_COLOR = {"#3498db", "#2ecc71", "#9b59b6", "#34495e", "#d35400", "#16a085", "#2980b9", "#8e44ad", "#2c3e50", "#f1c40f", "#e67e22", "#e74c3c", "#ecf0f1", "#27ae60", "#95a5a6", "#f39c12", "#c0392b", "#bdc3c7", "#7f8c8d", "#1abc9c"};

    List<String> BG_COLORS = Arrays.asList("bg-black", "bg-blue-purple", "bg-blue-shine", "bg-brown", "bg-clouds", "bg-cyan", "bg-danger", "bg-dark", "bg-deep-orange", "bg-deep-purple", "bg-gold", "bg-green", "bg-info", "bg-light", "bg-light-purple", "bg-limo", "bg-midnight", "bg-old-blue", "bg-orange", "bg-pink", "bg-primary", "bg-purple", "bg-red", "bg-silver", "bg-success", "bg-warning");

    // STORAGE
    String S3_URL_BASE = "https://cdn.lamolina.edu.pe/v1/AUTH_90afa410262f41f1af475ed599eeb798/";
    String S3_PUBLIC_DIR = "publico/";
    String S3_TRASH = "trash/";
    String S3_TMP = "tmp/";
    String S3_DOC_PLANTILLA = "documental/%s/plantillas/";
    String S3_DOC_DOCUMENTO = "documental/%s/documentos/";

    // Pdf Generator
    String PDF_IMG_1 = "/public/app/pdf/img/";
    String PDF_IMG = "/public/pdf/img/";
    String PDF_CSS = "/public/pdf/css/pdf.css";
    String PDF_FUENTES = "/public/pdf/fuentes/";
    String PDF_LOGO_UNALM_ALFA = "/public/pdf/img/escudoUnalm.png";
    String PDF_LOGO_UNALM = "/public/pdf/img/escudoUnalmSm.jpg";
    String FIRMA_JEFE_DERA = "/public/pdf/img/firmaSelloAlipio.png";
    String PDF_LOGO_EPG = "/public/pdf/img/logoepg.jpg";
    String PDF_LOGO_EPG_ALFA = "/public/pdf/img/logo-posgrado.png";

    // Avatars
    String AVATAR_MALE = "/phobos/images/unalm/male.png";
    String AVATAR_FEMALE = "/phobos/images/unalm/female.png";
    String AVATAR_UNKNOWN = "/phobos/images/unalm/unknown-person.gif";

    String EMAIL_SOPORTE = "soporte@albatross.pe";

    //formato imagen
    int IMAGE_DPIHEIGHT = 72;
    String IMAGE_DPIHEIGHT_MSG = "la imagen debe de tener un dpi mayor o igual a 72";
    int IMAGE_DPIWIDTH = 72;
    String IMAGE_DPIWIDTH_MSG = "la imagen debe de tener un dpi mayor o igual a 72";
    int IMAGE_HEIGHT = 504;
    String IMAGE_HEIGHT_MSG = "la imagen debe de tener una altura aproximada a 504";
    int IMAGE_WIDTH = 341;
    String IMAGE_WIDTH_MSG = "la imagen debe de tener un ancho aproximada a 341";
    int IMAGE_DELTA_SIZE = 5;
    String[] IMAGE_FORMAT = {"JPEG", "PNG"};
    String IMAGE_FORMAT_MSG = "la imagen debe de ser formato jpeg";
    String IMAGE_COLORTYPE = "RGB";
    String IMAGE_COLORTYPE_MSG = "la imagen debe de tener el sistema de color  RGB";
    int IMAGE_BITSPERPIXEL = 24;
    String IMAGE_BITSPERPIXEL_MSG = "la imagen debe de tener la cantidad de bits por pixel mayor a  24";
    boolean IMAGE_TRANSPARENT = Boolean.FALSE;
    String IMAGE_TRANSPARENT_MSG = "la imagen no debe de ser transparente";

    // Estados
    String COLOR_WARNING = "warning";
    String COLOR_SUCCESS = "success";
    String COLOR_DANGER = "danger";

    // Templates
    String HTML_PRE = "<!DOCTYPE html><html><head>"
            + "<meta charset='UTF-8'/><title></title>"
            + "</head><body>";

    String HTML_SUB = "</body></html>";

    String VARIABLE_TABLE = "albLoop";
    String VARIABLE_INCRUSTACION = "albIncrustacion";

    // Fechas
    String FECHA_STANDARD = "dd/MM/yyyy";
    String FECHA_HORA = "dd/MM/yyyy HH:mm";
    String FECHA_HORA_COMPLETA = "dd/MM/yyyy HH:mm:ss";
    String FECHA_HORA_24 = "dd/MM/yyyy HH:mm:ss a";
    String FECHA_YEAR = "yyyy";
    String FECHA_MONTH = "MM";
    String FECHA_MONTH_NAME = "MMMMM";
    String FECHA_DAY = "dd";
    String FECHA_YEAR_MONTH = "yyyy/MM";
    String FECHA_MONTH_YEAR = "MM/yyyy";
    String HORA = "HH:mm";

    // Codigos & Ids por Defecto
    Long ID_PERU = 178l;
    Long DPTO_LIMA = 153L;

    String PROV_LIMA = "150100";
    String PROV_CALLAO = "070100";
    String CODE_PERU = "PE";
    String RUC_UNALM = "20147897406";
    String RUC_BCP = "20100047218";

    Long ID_TIPO_DOCUMENTO_RUC = 4L;

    Long ID_CONSEJERO_NN = 1l;
    Long BOLS_TRABAJO_ID = 1l;

    // Menus
    String AMBIENTES = "PROD,TEST,DESA";
    String MODALIDADES = "PRE,EPG,ESP,VIS";
    Long ID_SISTEMA_MAIPI = 4L;
    
    // Respuesta Http
    int OK = 200;
    int CREATED = 201;
    int BAD_REQUEST = 400;
    int NOT_FOUND = 404;
    int INTERNAL_SERVER_ERROR = 500;

}
