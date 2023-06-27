package pe.edu.lamolina.model.tramite;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoOficina;

@Entity
@Table(name = "tram_accion_tramite_academico")
public class AccionTramiteAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_inicio")
    EstadoTramite estadoTramiteInicio;

    @Column(name = "respuesta")
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_final")
    EstadoTramite estadoTramiteFinal;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "pregunta_usuario")
    private String preguntaUsuario;

    @Column(name = "orden_opcion")
    private Integer ordenOpcion;

    @Column(name = "orden_accion")
    private Integer ordenAccion;

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

    @Column(name = "es_final")
    private Integer esFinal;

    @Column(name = "es_regular")
    private Integer esRegular;

    @Column(name = "solicitar_motivo")
    private Integer solicitarMotivo;

    public AccionTramiteAcademico() {
    }

    public AccionTramiteAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public EstadoTramite getEstadoTramiteInicio() {
        return estadoTramiteInicio;
    }

    public void setEstadoTramiteInicio(EstadoTramite estadoTramiteInicio) {
        this.estadoTramiteInicio = estadoTramiteInicio;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public EstadoTramite getEstadoTramiteFinal() {
        return estadoTramiteFinal;
    }

    public void setEstadoTramiteFinal(EstadoTramite estadoTramiteFinal) {
        this.estadoTramiteFinal = estadoTramiteFinal;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Integer getOrdenOpcion() {
        return ordenOpcion;
    }

    public void setOrdenOpcion(Integer ordenOpcion) {
        this.ordenOpcion = ordenOpcion;
    }

    public Oficina getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(Oficina oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public TipoOficina getTipoOficinaOrigen() {
        return tipoOficinaOrigen;
    }

    public void setTipoOficinaOrigen(TipoOficina tipoOficinaOrigen) {
        this.tipoOficinaOrigen = tipoOficinaOrigen;
    }

    public Oficina getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(Oficina oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public TipoOficina getTipoOficinaDestino() {
        return tipoOficinaDestino;
    }

    public void setTipoOficinaDestino(TipoOficina tipoOficinaDestino) {
        this.tipoOficinaDestino = tipoOficinaDestino;
    }

    public Integer getEsFinal() {
        return esFinal;
    }

    public void setEsFinal(Integer esFinal) {
        this.esFinal = esFinal;
    }

    public Integer getEsRegular() {
        return esRegular;
    }

    public void setEsRegular(Integer esRegular) {
        this.esRegular = esRegular;
    }

    public Integer getSolicitarMotivo() {
        return solicitarMotivo;
    }

    public void setSolicitarMotivo(Integer solicitarMotivo) {
        this.solicitarMotivo = solicitarMotivo;
    }

    public Integer getOrdenAccion() {
        return ordenAccion;
    }

    public void setOrdenAccion(Integer ordenAccion) {
        this.ordenAccion = ordenAccion;
    }

    public String getPreguntaUsuario() {
        return preguntaUsuario;
    }

    public void setPreguntaUsuario(String preguntaUsuario) {
        this.preguntaUsuario = preguntaUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AccionTramiteAcademico)) {
            return false;
        }
        AccionTramiteAcademico other = (AccionTramiteAcademico) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    public boolean getEsFinalBool() {
        if (this.getEsFinal().compareTo(BigDecimal.ONE.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsSolicitarMotivo() {
        if (this.getSolicitarMotivo() == BigDecimal.ONE.intValue()) {
            return true;
        }
        return false;
    }

    public boolean getEsSatisfactorio() {
        if (this.getRespuesta().equals("OK")) {
            return true;
        }
        return false;
    }

    public boolean getEsNegado() {
        if (this.getRespuesta().equals("ERROR")) {
            return true;
        }
        return false;
    }

}
