package pe.edu.lamolina.model.consejeria;

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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "aca_alumno_consejero")
public class AlumnoConsejero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "beneficio_utlimo_ciclo")
    private Integer beneficioUtlimoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consejero")
    private Consejero consejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_asigna")
    private Usuario userAsigna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desasigna")
    private Usuario userDesigna;

    @Column(name = "fecha_asigna")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAsigna;

    @Column(name = "fecha_desasigna")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesasigna;

    @Transient
    String estadoMatriculable;
    @Transient
    Boolean estadoMatriculaAutorizacion;
    @Transient
    Integer cursosMatriculados;
    @Transient
    Integer creditosMatriculados;
    @Transient
    Boolean seleccionado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public Date getFechaAsigna() {
        return fechaAsigna;
    }

    public void setFechaAsigna(Date fechaAsigna) {
        this.fechaAsigna = fechaAsigna;
    }

    public Date getFechaDesasigna() {
        return fechaDesasigna;
    }

    public void setFechaDesasigna(Date fechaDesasigna) {
        this.fechaDesasigna = fechaDesasigna;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Consejero getConsejero() {
        return consejero;
    }

    public void setConsejero(Consejero consejero) {
        this.consejero = consejero;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Usuario getUserAsigna() {
        return userAsigna;
    }

    public void setUserAsigna(Usuario userAsigna) {
        this.userAsigna = userAsigna;
    }

    public Usuario getUserDesigna() {
        return userDesigna;
    }

    public void setUserDesigna(Usuario userDesigna) {
        this.userDesigna = userDesigna;
    }

    public EstadoMatriculaEnum getEstadoMatriculableEnum() {
        if (estadoMatriculable == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estadoMatriculable);
    }

    @JsonIgnore
    public void setEstadoMatriculableEnum(EstadoMatriculaEnum estadoMatriculable) {
        if (estadoMatriculable == null) {
            return;
        }
        this.estadoMatriculable = estadoMatriculable.name();
    }

    public Boolean getEstadoMatriculaAutorizacion() {
        return estadoMatriculaAutorizacion;
    }

    @JsonIgnore
    public void setEstadoMatriculaAutorizacion(Boolean estadoMatriculaAutorizacion) {
        this.estadoMatriculaAutorizacion = estadoMatriculaAutorizacion;
    }

    public Integer getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(Integer cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    public Integer getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setCreditosMatriculados(Integer creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    public Integer getBeneficioUtlimoCiclo() {
        return beneficioUtlimoCiclo;
    }

    public void setBeneficioUtlimoCiclo(Integer beneficioUtlimoCiclo) {
        this.beneficioUtlimoCiclo = beneficioUtlimoCiclo;
    }

    public Boolean getSeleccionado() {
        if (seleccionado == null) {
            return false;
        }
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

}
