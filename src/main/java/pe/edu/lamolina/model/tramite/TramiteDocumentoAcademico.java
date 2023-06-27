package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoConstanciaEnum;
import pe.edu.lamolina.model.enums.oficina.OficinaEnum;
import pe.edu.lamolina.model.finanzas.Acreencia;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Idioma;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoDocumentoCompania;
import pe.edu.lamolina.model.posgrado.concepto.TransferenciaSwift;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_tramite_documento_academico")
public class TramiteDocumentoAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "persona_contacto")
    private String personaContacto;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "cantidad_ciclos")
    private Integer cantidadCiclos;

    @Column(name = "opcion_foto")
    private String opcionFoto;

    @Column(name = "numero_boleta")
    private String numeroBoleta;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "correlativo_documento")
    private String correlativoDocumento;

    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    @Column(name = "numero_formato")
    private String numeroFormato;
    
    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_documento")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDocumento;

    @Column(name = "fecha_entrega")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_compania")
    private TipoDocumentoCompania tipoDocumentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transferencia_swift")
    private TransferenciaSwift transferenciaSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla")
    private Archivo plantilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_entrega")
    private Usuario userEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @Transient
    private String valorParametro;
    @Transient
    private Integer tamanoFont;
    @Transient
    private Boolean bloquear;

    @Transient
    private Acreencia acreencia;
    @Transient
    private BigDecimal montoUsarSaldo;

    public TramiteDocumentoAcademico() {
    }

    public TramiteDocumentoAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getDescripcion() {
        String num = NumberFormat.codigo(tramite.getNumero(), 4);
        Long seriex = tramite.getSerie();
        Oficina oficina = tramite.getOficina();

        String simbolo = "T.Docum.";
        if (oficina.getCodigoEnum() == OficinaEnum.EPG) {
            simbolo = "T.Const.";
        } else if (oficina.getCodigoEnum() == OficinaEnum.OERA && tipoDocumentoAcademico.getTipoConstanciaEnum() == TipoConstanciaEnum.CONS) {
            simbolo = "T.Const.";
        } else if (oficina.getCodigoEnum() == OficinaEnum.OERA && tipoDocumentoAcademico.getTipoConstanciaEnum() == TipoConstanciaEnum.CERT) {
            simbolo = "T.Cert.";
        }

        return String.format("%s %s-%s/%s",
                simbolo,
                num, seriex,
                oficina.getCodigoDocumento());
    }

}
