package pe.edu.lamolina.model.optativo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.EvaluacionPlan;
import pe.edu.lamolina.model.academico.TipoEvaluacion;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "opt_evaluacion_optativo")
public class EvaluacionOptativo implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_evaluacion_superior")
//    private EvaluacionOptativo evaluacionOptativoSuperior;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_tipo_evaluacion")
//    private TipoEvaluacion tipoEvaluacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion_calificacion_optativo")
    private EvaluacionCalificacionOptativo evaluacionCalificacionOptativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

//    @Column(name = "estado")
//    private String estado;
//    @Column(name = "peso")
//    private BigDecimal peso;
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nivel")
    private Integer nivel;
//
//    @Column(name = "nota_minima_anulable")
//    private Boolean notaMinimaAnulable;
//
//    @Column(name = "notas_ingresadas")
//    private Boolean notasIngresadas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_programada")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgramada;

    @Column(name = "fecha_realizada")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizada;

    public EvaluacionOptativo() {
    }

    public EvaluacionOptativo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EvaluacionCalificacionOptativo getEvaluacionCalificacionOptativo() {
        return evaluacionCalificacionOptativo;
    }

    public void setEvaluacionCalificacionOptativo(EvaluacionCalificacionOptativo evaluacionCalificacionOptativo) {
        this.evaluacionCalificacionOptativo = evaluacionCalificacionOptativo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EvaluacionOptativo)) {
            return false;
        }
        EvaluacionOptativo other = (EvaluacionOptativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.optativo.EvaluacionCalificacionOptativo[ id=" + id + " ]";
    }

}
