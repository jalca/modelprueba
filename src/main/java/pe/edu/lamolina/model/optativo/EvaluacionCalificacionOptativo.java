package pe.edu.lamolina.model.optativo;

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
import javax.persistence.TemporalType;
import pe.edu.lamolina.model.academico.EvaluacionPlan;
import pe.edu.lamolina.model.academico.TipoEvaluacion;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "opt_evaluacion_calificacion_optativo")
public class EvaluacionCalificacionOptativo implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calificacion_optativo")
    private CalificacionOptativo calificacionOptativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion_calificacion_superior")
    EvaluacionCalificacionOptativo evaluacionCalificacionSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evaluacion")
    private TipoEvaluacion tipoEvaluacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "esta_desagregado")
    private Boolean estaDesagregado;

    @Column(name = "nota_minima_anulable")
    private Boolean notaMinimaAnulable;

    @Column(name = "notas_ingresadas")
    private Boolean notasIngresadas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desagregar")
    private Usuario usuarioDesagregar;

    @Column(name = "fecha_desagregar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesagregar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public EvaluacionCalificacionOptativo() {
    }

    public EvaluacionCalificacionOptativo(EvaluacionPlan evaluacionPlan, Date fechaRegistro, Usuario userRegistro) {
        this.estado = EstadoEnum.ACT.name();
        this.fechaRegistro = fechaRegistro;
        this.nivel = evaluacionPlan.getNivel();
        this.notaMinimaAnulable = Boolean.FALSE;
        this.notasIngresadas = Boolean.FALSE;
        this.numero = evaluacionPlan.getNumero();
        this.peso = evaluacionPlan.getPesoEvaluacion();
        this.tipoEvaluacion = evaluacionPlan.getTipoEvaluacion();
        this.usuarioRegistro = userRegistro;
        // this.estaDesagregado = evaluacionPlan.ge
    }

    public EvaluacionCalificacionOptativo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalificacionOptativo getCalificacionOptativo() {
        return calificacionOptativo;
    }

    public void setCalificacionOptativo(CalificacionOptativo calificacionOptativo) {
        this.calificacionOptativo = calificacionOptativo;
    }

    public EvaluacionCalificacionOptativo getEvaluacionCalificacionSuperior() {
        return evaluacionCalificacionSuperior;
    }

    public void setEvaluacionCalificacionSuperior(EvaluacionCalificacionOptativo evaluacionCalificacionSuperior) {
        this.evaluacionCalificacionSuperior = evaluacionCalificacionSuperior;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Boolean getEstaDesagregado() {
        return estaDesagregado;
    }

    public void setEstaDesagregado(Boolean estaDesagregado) {
        this.estaDesagregado = estaDesagregado;
    }

    public Boolean getNotaMinimaAnulable() {
        return notaMinimaAnulable;
    }

    public void setNotaMinimaAnulable(Boolean notaMinimaAnulable) {
        this.notaMinimaAnulable = notaMinimaAnulable;
    }

    public Boolean getNotasIngresadas() {
        return notasIngresadas;
    }

    public void setNotasIngresadas(Boolean notasIngresadas) {
        this.notasIngresadas = notasIngresadas;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuarioDesagregar() {
        return usuarioDesagregar;
    }

    public void setUsuarioDesagregar(Usuario usuarioDesagregar) {
        this.usuarioDesagregar = usuarioDesagregar;
    }

    public Date getFechaDesagregar() {
        return fechaDesagregar;
    }

    public void setFechaDesagregar(Date fechaDesagregar) {
        this.fechaDesagregar = fechaDesagregar;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}
