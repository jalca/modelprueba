package pe.edu.lamolina.model.encuestaestudiantil;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.enums.EncuestaEstudiantilEstadoEnum;

@Entity
@Table(name = "exam_encuesta_docente_modalidad")
public class EncuestaDocenteModalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "serie")
    private Integer serie;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "puntaje_base5")
    private BigDecimal puntajeBase5;

    @Column(name = "puntaje_base10")
    private BigDecimal puntajeBase10;

    @Column(name = "alumnos_encuestados")
    private Integer alumnosEncuestados;

    @Column(name = "fecha_inicio_encuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicioEncuesta;

    @Column(name = "fecha_fin_encuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFinEncuesta;

    @Column(name = "fecha_cierre")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierre;

    @Column(name = "fecha_informe")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInforme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @Transient
    private List<PuntajeEncuestaDocente> puntajeEncuestaDocente;

    @Transient
    private List<PuntajeEncuestaDocenteModalidad> puntajeEncuestaDocenteModalidad;

    public EncuestaDocenteModalidad() {
    }

    public EncuestaDocenteModalidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

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

    public EncuestaEstudiantilEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EncuestaEstudiantilEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EncuestaEstudiantilEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        if (serie == null || numero == null) {
            return null;
        }

        return String.format("%d-%d", serie, numero);
    }

    public BigDecimal getPuntajeBase5() {
        return puntajeBase5;
    }

    public void setPuntajeBase5(BigDecimal puntajeBase5) {
        this.puntajeBase5 = puntajeBase5;
    }

    public BigDecimal getPuntajeBase10() {
        return puntajeBase10;
    }

    public void setPuntajeBase10(BigDecimal puntajeBase10) {
        this.puntajeBase10 = puntajeBase10;
    }

    public Integer getAlumnosEncuestados() {
        return alumnosEncuestados;
    }

    public void setAlumnosEncuestados(Integer alumnosEncuestados) {
        this.alumnosEncuestados = alumnosEncuestados;
    }

    public Date getFechaInicioEncuesta() {
        return fechaInicioEncuesta;
    }

    public void setFechaInicioEncuesta(Date fechaInicioEncuesta) {
        this.fechaInicioEncuesta = fechaInicioEncuesta;
    }

    public Date getFechaFinEncuesta() {
        return fechaFinEncuesta;
    }

    public void setFechaFinEncuesta(Date fechaFinEncuesta) {
        this.fechaFinEncuesta = fechaFinEncuesta;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public ModalidadEstudio getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(ModalidadEstudio modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public String getKey() {
        return this.docente.getId() + "-" + this.modalidadEstudio.getId();
    }

    public List<PuntajeEncuestaDocente> getPuntajeEncuestaDocente() {
        return puntajeEncuestaDocente;
    }

    public void setPuntajeEncuestaDocente(List<PuntajeEncuestaDocente> puntajeEncuestaDocente) {
        this.puntajeEncuestaDocente = puntajeEncuestaDocente;
    }

    public List<PuntajeEncuestaDocenteModalidad> getPuntajeEncuestaDocenteModalidad() {
        return puntajeEncuestaDocenteModalidad;
    }

    public void setPuntajeEncuestaDocenteModalidad(List<PuntajeEncuestaDocenteModalidad> puntajeEncuestaDocenteModalidad) {
        this.puntajeEncuestaDocenteModalidad = puntajeEncuestaDocenteModalidad;
    }
}
