package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDocumentoCompaniaEnum {

    TRAM("Trámite"),
    CARTA("Carta"),
    MANUAL("Manual"),
    TICKET("Ticket"),
    ABOCOM("Movimiento Alumno Comedor"),
    ORDEN_SUBV("Orden Pago Subvención"),
    PUB_ENCUESTA("Publicación Encuesta"),
    // Trámites de Constancias y Certificados
    TRAM_CONS("Trámite Constancia"),
    TRAM_CERT("Trámite Certificado"),
    TRAM_CONS_EPG("Trámite Constancia Posgrado"),
    // Constancias y Certificados
    DOC_CERT("Documento Certificado"),
    DOC_CONS("Documento Constancia"),
    DOC_CONS_EPG("Documento Constancia Posgrado"),
    //
    RECCOM("Recibo Comedor"),
    PEDFAR("Pedido Farmacia"),
    MOVALM("Movimiento Almacén"),
    LOTE("Lote"),
    NRO_HZGO("Número Hallazgo Dental"),
    INF_CBC("Informe Comisión de Becas"),
    ACTA_TRAM_EPG("Acta Trámite Posgrado"),
    CERT_IDIOMA("Certificado del Centro de Idiomas"),
    CERT_IDIOMA_EXTERNO("Certificado de un Centro de Idiomas Externo"),
    ORDEN_COMPRA("Orden Compra"),
    ORDEN_SERVICIO("Orden Servicio"),
    REGBEC("Registro Becados"),
    REGAUS("Registro Auspiciados"),
    FACTURA("Factura"),
    BOLETA_VENTA("Boleta Venta"),
    GUIA_REM("Guía Remisión"),
    RHE("Recibo de Honorarios"),
    PAS("Pasaporte"),
    SR4C("Suspensión de Retenciones 4ta"),
    SR5C("Suspensión de Retenciones 5ta"),
    RESOLUCION("Resolución"),
    CARTA_GENERAL("Carta"),
    SOLICITUD("Solicitud"),
    MEMORANDUM("Memorandum"),
    OFICIO("Oficio"),
    CIRCULAR("Circular"),
    OTROS("Otros"),
    TRAMITE_FUT("Trámite FUT"),
    TRAM_RETIRO_CICLO("Trámite Retiro Ciclo"),
    DIPLOMA_GRADO("Diploma Grado Académico"),
    TRAM_ANU_CICLO("Trámite Anulación Ciclo"),
    TRAM_REIN("Trámite Reincorporación"),
    TRAM_TRAS_INT("Trámite Traslado Interno"),
    TRAM_BACHI("Trámite Bachiller"),
    TRAM_TITULO("Trámite Titulo"),
    TRAM_PRAC_PROF("Trámite Practicas Pre-profesionales"),
    TRAMITE_CAMBIO_PLAN_CURRICULAR("Trámite Cambio Plan Curricular"),
    TRAMITE_READMISION("Trámite Readmisión"),
    RESERVA_CITA_MED("Reserva Cita Centro Médico");

    private final String value;
    private static final Map<String, TipoDocumentoCompaniaEnum> lookup = new HashMap<>();

    static {
        for (TipoDocumentoCompaniaEnum d : TipoDocumentoCompaniaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoDocumentoCompaniaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDocumentoCompaniaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDocumentoCompaniaEnum d : TipoDocumentoCompaniaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
