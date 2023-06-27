package pe.edu.lamolina.model.academico;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CambioAulaGrupoEstadoEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.horario.GrupoHoras;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_cambio_aula_grupo")
public class CambioAulaGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentario_respuesta")
    private String comentarioRespuesta;

    @Column(name = "fecha_solicitud")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaSolicitud;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @Column(name = "fecha_respuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula_inicio")
    private Aula aulaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula_fin")
    private Aula aulaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_inicio")
    private GrupoHoras grupoHorasInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_fin")
    private GrupoHoras grupoHorasFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_respuesta")
    private Colaborador colaboradorRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public CambioAulaGrupo() {
    }

    public CambioAulaGrupo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Aula getAulaInicio() {
        return aulaInicio;
    }

    public void setAulaInicio(Aula aulaInicio) {
        this.aulaInicio = aulaInicio;
    }

    public Aula getAulaFin() {
        return aulaFin;
    }

    public void setAulaFin(Aula aulaFin) {
        this.aulaFin = aulaFin;
    }

    public GrupoHoras getGrupoHorasInicio() {
        return grupoHorasInicio;
    }

    public void setGrupoHorasInicio(GrupoHoras grupoHorasInicio) {
        this.grupoHorasInicio = grupoHorasInicio;
    }

    public GrupoHoras getGrupoHorasFin() {
        return grupoHorasFin;
    }

    public void setGrupoHorasFin(GrupoHoras grupoHorasFin) {
        this.grupoHorasFin = grupoHorasFin;
    }

    public Colaborador getColaboradorRespuesta() {
        return colaboradorRespuesta;
    }

    public void setColaboradorRespuesta(Colaborador colaboradorRespuesta) {
        this.colaboradorRespuesta = colaboradorRespuesta;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    @JsonIgnore
    public void setEstadoEnum(CambioAulaGrupoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public CambioAulaGrupoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return CambioAulaGrupoEstadoEnum.valueOf(this.getEstado());
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

}
