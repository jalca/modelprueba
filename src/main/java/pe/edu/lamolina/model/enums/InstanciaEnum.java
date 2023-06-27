package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum InstanciaEnum {

    ALUMNO_VIAJE_CURSO_FORM_APODERADO("obu_alumno_viaje_curso.id_formulario_apoderado"),
    ITEM_JUSTIFICACION_GASTO("cont_item_justificacion_gasto"),
    DOC_DOCUMENTAL("doc_documento"),
    DOCUMENTO_COMPANIA("gen_documento_compania"),
    DOCUMENTO_EXTERNO("gen_documento_externo"),
    DOCUMENTO_EMITE_PERSONA("gen_documento_emite_persona"),
    DOCUMENTO_RESOLUCION("tram_resolucion"),
    FORMATO_REQUISITO_ESCUELA("epg_documento_requisito_escuela"),
    GUIAPOSTULANTEAPOYO("Guia Postulante Apoyo"),
    HIJO_TRABAJADOR_VERANO("extn_hijo_trabajador_verano"),
    INVENTARIO("Inventario"),
    INFORME_SUBVENCION("obu_informe_subvencionado"),
    ITEM_CARGA_ABONO("fin_item_carga_abono"),
    ITEM_SALDO_AFAVOR("fin_item_saldo_afavor"),
    MIEMBRO_COMITE_CONSEJERO("epg_miembro_comite_consejero"),
    PLANTILLA_DOCUMENTAL("doc_plantilla"),
    OBSERVACION_PROY_TESIS("tram_observacion_proyecto_tesis"),
    PERSONA_FOTO("gen_persona_foto"),
    // POSTULANTE_DOCUMENTO_GRADO("soc_educacion_persona"), Anulado por no ser descriptivo
    EDUCACION_PERSONA_MERITO("soc_educacion_persona.id_archivo_merito"),
    EDUCACION_PERSONA_CERTIFCADO("soc_educacion_persona.id_archivo_certificado"),
    EDUCACION_PERSONA_DIPLOMA("soc_educacion_persona.id_archivo_diploma"),
    POSTULANTE_ESCUELA("epg_postulante_escuela"),
    POSTULANTE_REQUISITO_ESCUELA("epg_postulante_documento_escuela"),
    FACTURA("fin_factura"),
    PROY_TESIS("tram_proyecto_tesis"),
    PROFORMA_EVENTO_SUBVENCIONADO("obu_proforma_evento_subvencionado"),
    RECORRIDO_INGRESANTE("aca_recorrido_ingresante"),
    PERSONA_DOMICILIO("aca_persona_docimicilio"),
    SUSTENTO_RETIRO_CICLO("tram_sustento_retiro_ciclo"),
    TALLER("sip_taller"),
    TALLERBANNER("taller/banner"),
    TALLERSLIDER("taller/galeria"),
    TICKET_AYUDA("Ticket Ayuda"),
    TICKET_AYUDA_MENSAJE("Mensaje Ticket Ayuda"),
    TRAM_TRAMITE("tram_tramite"),
    TRANSFER_SWIFT("fin_transferencia_swift"),
    PRECIO_DOCUMENTO("tram_precio_documento"),
    TRAM_DOCUMENTO("tram_tramite_documento"),
    TRAM_PLANTILLA_DOCUMENTO_ACADEMICO("tram_plantilla_documento_academico"),
    HISTORIA_ANTECEDENTE("med_historia_antecedente");

    private final String value;
    private static final Map<String, InstanciaEnum> lookup = new HashMap<>();

    static {
        for (InstanciaEnum d : InstanciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private InstanciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InstanciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (InstanciaEnum d : InstanciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
