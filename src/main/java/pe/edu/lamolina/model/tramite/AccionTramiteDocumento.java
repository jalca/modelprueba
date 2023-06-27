package pe.edu.lamolina.model.tramite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Idioma;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoOficina;

@Getter
@Setter
@Entity
@Table(name = "tram_accion_tramite_documento")
public class AccionTramiteDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "url")
    private String url;

    @Column(name = "es_final")
    private Integer esFinal;

    @Column(name = "solicita_motivo")
    private Integer solicitaMotivo;

    @Column(name = "puede_verse")
    private Integer puedeVerse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite_final")
    private EstadoTramite estadoTramiteFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_origen")
    private Oficina oficinaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina_origen")
    private TipoOficina tipoOficinaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina_destino")
    private TipoOficina tipoOficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_academico")
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    public AccionTramiteDocumento() {
    }

    public AccionTramiteDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getSolicitaMotivo() {
        if (solicitaMotivo == null) {
            return 0;
        }
        return solicitaMotivo;
    }

    public boolean getEsSatisfactorio() {
        if (this.getRespuesta().equals("OK")) {
            return true;
        }
        return false;
    }
}
