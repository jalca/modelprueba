package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContenidoCartaEnum {

    TERMS("Términos y Condiciones", 1L, 1L),
    CARTA("Carta de Compromiso", 2L, 1L),
    //HEAD_BOLETA_EMAIL_TODOS
    //HEAD_BOLETA_EMAIL_CEPRE
    HEADMAILBOLPAGPOS("Cabecera del email de boleta de pago de postulante genérico", 3L, 1L),
    HEADMAILBOLPAGINGCEPRE("Cabecera del email de boleta de pago de ingresante CEPRE", 4L, 1L),
    HEADWEBBOLPAGPOS("Cabecera web de boleta de pago de postulante genérico", 5L, 1L),
    FOOTWEBBOLPAGPOS("Pie web de boleta de pago de postulante genérico", 6L, 1L),
    HEADPDFBOLPAGPOS("Cabecera del PDF de boleta de pago de postulante genérico", 7L, 1L),
    HEADPDFBOLPAGINGCEPRE("Cabecera del PDF de boleta de pago de ingresante CEPRE", 8L, 1L),
    MAILCERTMIN("Email por validación MINEDU de certificados de estudios", 9L, 1L),
    MAILNOCERTMIN("Email por NO validación MINEDU de certificados de estudios", 10L, 1L),
    MAILNOTIROL("Mail de Notificación de Roles", 11L, 1L),
    FOOTWEBBOLPAGPOSCEPRE("Pie web de boleta de pago de postulante CEPRE", 12L, 1L),
    MAILNOTIREGPOST("Email de Notificación de Registro a Postulantes de Apoyo", 16L, 1L),
    MAILPOSTUAPOELE("Mail Postulante de Apoyo Elegido", 20L, 1L),
    HEADWEBBOLPAGCEPRE("Cabecera web de boleta de pago de postulante cepre", 35L, 1L),
    CARTASINEXAMEN("Carta de Compromiso para postulantes que no rinden examen", 36L, 1L),
    TERMINOSSINEXAMEN("Términos y Condiciones para postulantes que no rinden examen", 37L, 1L),
    HEAD_BOLETA_GUIA("Cabecera Boleta Web Solo Guía Postulante", 38L, 1L),
    HEAD_BOLETA_PIR("Cabecera Boleta Web Modalidad PIR", 39L, 1L),
    HEAD_BOLETA_CEPRE_REG("Cabecera Boleta Web CEPRE Regulares", 40L, 1L),
    HEAD_BOLETA_CEPRE_INT("Cabecera Boleta Web CEPRE Intensivos", 41L, 1L),
    HEAD_BOLETA_OTROS_MODS("Cabecera Boleta Web Otras Modalidades", 42L, 1L),
    FOOT_BOLETA_GUIA("Pie de Boleta Web Solo Guía Postulante", 43L, 1L),
    FOOT_BOLETA_PIR("Pie de Boleta Web Modalidad PIR", 44L, 1L),
    FOOT_BOLETA_CEPRE_REG("Pie de Boleta Web CEPRE Regulares", 45L, 1L),
    FOOT_BOLETA_CEPRE_INT("Pie de Boleta Web CEPRE Intensivos", 46L, 1L),
    FOOT_BOLETA_OTROS_MODS("Pie de Boleta Web Otras Modalidades", 47L, 1L),
    HEAD_BOLETAPDF_GUIA("Cabecera Boleta PDF Solo Guía Postulante", 48L, 1L),
    HEAD_BOLETAPDF_PIR("Cabecera Boleta PDF Modalidad PIR", 49L, 1L),
    HEAD_BOLETAPDF_CEPRE_REG("Cabecera Boleta PDF CEPRE Regulares", 50L, 1L),
    HEAD_BOLETAPDF_CEPRE_INT("Cabecera Boleta PDF CEPRE Intensivos", 51L, 1L),
    HEAD_BOLETAPDF_OTROS_MODS("Cabecera BoletaV Otras Modalidades", 52L, 1L),
    FOOT_BOLETAPDF_GUIA("Pie de Boleta PDF Solo Guía Postulante", 53L, 1L),
    FOOT_BOLETAPDF_PIR("Pie de Boleta PDF Modalidad PIR", 54L, 1L),
    FOOT_BOLETAPDF_CEPRE_REG("Pie de Boleta PDF CEPRE Regulares", 55L, 1L),
    FOOT_BOLETAPDF_CEPRE_INT("Pie de Boleta PDF CEPRE Intensivos", 56L, 1L),
    FOOT_BOLETAPDF_OTROS_MODS("Pie de Boleta PDF Otras Modalidades", 57L, 1L),
    HEAD_BOLETA_NOEXAMEN("Cabecera Boleta Web Modalidades sin examen", 58L, 1L),
    HEAD_BOLETAPDF_NOEXAMEN("Cabecera Boleta PDF Modalidades sin examen", 59L, 1L),
    FOOT_BOLETA_NOEXAMEN("Pie de Boleta Web Modalidades sin examen", 60L, 1L),
    FOOT_BOLETAPDF_NOEXAMEN("Pie de Boleta PDF Modalidades sin examen", 61L, 1L),
    HEAD_BOLETAPDF_CAMBIOS("Cabecera Boleta PDF cambio de datos", 62L, 1L),
    FOOT_BOLETAPDF_CAMBIOS("Pie de Boleta PDF cambio de datos", 63L, 1L),
    /**/
    HEAD_BOLETAEMAIL_CEPRE_REG("Cabecera del email de boleta de pago de ingresante CEPRE ciclo regular", 66L, 1L),
    HEAD_BOLETAEMAIL_CEPRE_INT("Cabecera del email de boleta de pago de ingresante CEPRE ciclo intensivo", 67L, 1L),
    HEAD_BOLETAEMAIL_PIR("Cabecera del email de boleta de pago de postulantes PIR", 68L, 1L),
    HEAD_BOLETAEMAIL_NOEXAMEN("Cabecera del email de boleta de pago de postulantes que no rinden examen de admisión", 69L, 1L),
    HEAD_BOLETAEMAIL_OTROS_MODS("Cabecera del email de boleta de pago de otras modalidades", 70L, 1L),
    HEAD_BOLETAEMAIL_GUIA("Cabecera del email de boleta de pago de solo guía del postulante", 71L, 1L),
    HEAD_BOLETAEMAIL_CAMBIOS("Cabecera del email de boleta de pago de cambio de datos", 72L, 1L),
    /**/
    BOLETA002("Boleta tramite solicitud constancia académica pie", 17L, 3L),
    NOTIFYSOLICITUD("Notificacion de creacion de solicitud constancia académica", 18L, 3L),
    BOLETA001("Boleta tramite solicitud constancia académica contenido", 19L, 3L),
    CREATEUSERALUMNOVISITANTE("Notificación de correo institucional para alumnos visitantes", 21L, 3L),
    HEAD_BOLETAPDF_VERANO("Cabecera Boleta de Pago PDF para cursos de verano", 73L, 3L),
    FOOT_BOLETAPDF_VERANO("Pie de la Boleta de Pago PDF para cursos de verano", 74L, 3L),
    /**/
    HEAD_BOLETA_PAGO_WEB_ALUMNO("Cabecera web de boleta de pago de ingresante", 13L, 4L),
    FOOT_BOLETA_PAGO_WEB_ALUMNO("Pie web de boleta de pago de ingresante", 14L, 4L),
    HEADPDFBOLPAGING("Cabecera del PDF de boleta de pago de ingresante", 15L, 4L),
    /**/
    BOLSAINVDECANO("Notificación sobre Bolsa de Investigacion al Decano de Facultad", 22L, 5L),
    BOLSAINVFACULTAD("Notificación sobre Bolsa de Investigacion a la Facultad", 23L, 5L),
    /**/
    HELPDESK_NUEVO("Creación de Ticket", 1L, 1L),
    HELPDESK_RESPUESTA("Respuesta al Ticket", 1L, 1L),
    HELPDESK_FINALIZADO("Cierre del Ticket", 1L, 1L),
    HELPDESK_INCONFORMIDAD("No conformidad en Ticket", 1L, 1L),
    HELPDESK_RECORDATORIO("Recordatorio de Cierre de Ticket", 1L, 1L),
    HELPDESK_AUTOCONFORMIDAD("Recordatorio de Cierre de Ticket", 1L, 1L),
    HELPDESK_AUTOCIERRE("Recordatorio de Cierre de Ticket", 1L, 1L),
    HELPDESK_REPORTE_COORDINADOR("Recordatorio de Cierre de Ticket", 1L, 1L),
    HELPDESK_CREADO("Creación de Ticket", 1L, 1L),
    HEAD_BOLETA_PAGO_PDF_ALUMNO("Cabecera web de boleta de pago de ingresante", 15L, 5L),
    FOOT_BOLETA_PAGO_PDF_ALUMNO("Pie web de boleta de pago de ingresante", 16L, 5L),
    HEAD_BOLETA_EXMAEN_MEDICO_PDF("Cabecera PDF de boleta examen médico", 15L, 5L),
    FOOT_BOLETA_EXMAEN_MEDICO_PDF("Pie PDF de boleta examen médico", 16L, 5L),
    /**/
    RECORRIDO_BIENVENIDO_INGRESANTE("Correo de bienvenida generica a los ingresantes", 64L, 5L),
    RECORRIDO_PERSONALIZADO_INGRESANTE("Correo de bienvenida personalizada al ingresantes", 65L, 5L),
    /**/
    RESERVA_AULA_ACEPTAR("Solicitud de Reserva Ambiente Aceptado", 1L, 1L),
    RESERVA_AULA_RECHAZAR("Solicitud de Reserva Ambiente Rechazado", 1L, 1L),
    /**/
    EPG_VALIDAR_EMAIL("Notificación para validar cuenta de usuario", 1L, 1L),
    EPG_CAMBIO_PASSWORD("Solicitud de cambio de contraseña", 1L, 1L),
    EPG_NITIFICACION_DOCUMENTO_OBSERVADO("Notificación documento observado", 1L, 1L),
    EPG_DECLARACION_JURADA("Declaración Jurada Posgrado", 1L, 1L), //
    EPG_DECLARACION_JURADA_MAESTRIA("Declaración Jurada Posgrado", 1L, 1L),
    EPG_DECLARACION_JURADA_DOCTORADO("Declaración Jurada Posgrado", 1L, 1L),
    EPG_BOLETA_PAGO_HEADER("Boleta de Pago Posgrado Header", 1L, 1L),
    EPG_BOLETA_PAGO_FOOTER("Boleta de Pago Posgrado Footer", 1L, 1L),
    EPG_RESOLUCION("Resolucion Creación Alumno", 1L, 1L),
    EPG_NOTIFICACION_RECORD_ACADEMICO_OBSERVADO("Notificación record acádemico observado", 1L, 1L),
    EPG_NOTIFICACION_CAMBIO_CLAVE("Notificación cambio contraseña", 1L, 1L),
    EPG_CONCURSO_ADMISION_DOCTORADO("ACTA DEL CONCURSO DE ADMISIÓN DEL PROGRAMA DE DOCTORADO", 1L, 1L),
    EPG_CONCURSO_ADMISION_MAESTRIA("ACTA DEL CONCURSO DE ADMISIÓN DEL PROGRAMA DE MAESTRÍA", 1L, 1L),
    AMAUTA_FOOTER_INVENTARIO_DOCENTE("Inventario Docente", 93L, 3L),
    LLAMAME_ADMISION("Modal Llámame - Admisión", 94L, 1L),
    BODY_MAIL_CLAVE_PROFE_TALLER("Email contraseña profesor taller", 95L, 5L),
    /**/
    DECLARA_VIRTUAL("Declaración Jurada Virtualización", 96L, 1L),
    MEDIDA_BIOSEG("Medidas de bioseguridad", 100L, 1L),
    PROHIB_EXAMEN("Prohibido en examen", 101L, 1L),
     PERDIDA_VAC("Perdida de vacante", 102L, 1L);
    
    private final String value;
    private final Long idContenido;
    private final Long idSistema;
    private static final Map<String, ContenidoCartaEnum> lookup = new HashMap<>();

    static {
        for (ContenidoCartaEnum d : ContenidoCartaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ContenidoCartaEnum(String value, Long idContenido, Long idSistema) {
        this.value = value;
        this.idContenido = idContenido;
        this.idSistema = idSistema;
    }

    public String getValue() {
        return value;
    }

    public Long getIdSistema() {
        return idSistema;
    }

    public Long getIdContenido() {
        return idContenido;
    }

    public static ContenidoCartaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ContenidoCartaEnum d : ContenidoCartaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
