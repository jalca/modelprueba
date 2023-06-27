package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.RecorridoIngresante;
import pe.edu.lamolina.model.academico.TipoActividadIngresante;
import pe.edu.lamolina.model.enums.PostulanteDocumentoEstadoEnum;
import pe.edu.lamolina.model.enums.ValidadorDocumentoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "sip_postulante_documento")
public class PostulanteDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entregado")
    private Integer entregado;

    @Column(name = "fecha_recepcion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRecepcion;

    @Column(name = "fecha_compromiso_entrega")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaCompromisoEntrega;

    @Column(name = "validador")
    private String validador;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_modalidad")
    private DocumentoModalidad documentoModalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_recepcion")
    private Usuario userRecepcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_compromiso")
    private Usuario userCompromiso;

    @Transient
    private TipoActividadIngresante tipo;
    @Transient
    private RecorridoIngresante recorrido;

    public PostulanteDocumento() {
    }

    public PostulanteDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public DocumentoModalidad getDocumentoModalidad() {
        return documentoModalidad;
    }

    public void setDocumentoModalidad(DocumentoModalidad documentoModalidad) {
        this.documentoModalidad = documentoModalidad;
    }

    public Integer getEntregado() {
        return entregado;
    }

    public void setEntregado(Integer entregado) {
        this.entregado = entregado;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Usuario getUserRecepcion() {
        return userRecepcion;
    }

    public void setUserRecepcion(Usuario userRecepcion) {
        this.userRecepcion = userRecepcion;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public ValidadorDocumentoEnum getValidadorEnum() {
        if (validador == null) {
            return null;
        }
        return ValidadorDocumentoEnum.valueOf(validador);
    }

    @JsonIgnore
    public void setValidadorEnum(ValidadorDocumentoEnum validador) {
        if (validador == null) {
            return;
        }
        this.validador = validador.name();
    }

    public Date getFechaCompromisoEntrega() {
        return fechaCompromisoEntrega;
    }

    public void setFechaCompromisoEntrega(Date fechaCompromisoEntrega) {
        this.fechaCompromisoEntrega = fechaCompromisoEntrega;
    }

    public Usuario getUserCompromiso() {
        return userCompromiso;
    }

    public void setUserCompromiso(Usuario userCompromiso) {
        this.userCompromiso = userCompromiso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PostulanteDocumentoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PostulanteDocumentoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PostulanteDocumentoEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoActividadIngresante getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividadIngresante tipo) {
        this.tipo = tipo;
    }

    public RecorridoIngresante getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(RecorridoIngresante recorrido) {
        this.recorrido = recorrido;
    }

}
