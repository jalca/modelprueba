package pe.edu.lamolina.model.encuestaestudiantil;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.GrupoSeccion;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.enums.EncuestaEstudiantilEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "exam_encuesta_curso")
public class EncuestaCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "modo_encuesta")
    private String modoEncuesta;

    @Column(name = "alumnos_inicio")
    private Long alumnosInicio;

    @Column(name = "alumnos_fin")
    private Long alumnosFin;

    @Column(name = "alumnos_encuestados")
    private Long alumnosEncuestados;

    @Column(name = "puntaje_base5")
    private BigDecimal puntajeBase5;

    @Column(name = "puntaje_base10")
    private BigDecimal puntajeBase10;

    @Column(name = "porcentaje_encuesta")
    private BigDecimal porcentajeEncuesta;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_encuesta_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEncuestaInicio;

    @Column(name = "fecha_encuesta_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEncuestaFin;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_estudiantil")
    private EncuestaEstudiantil encuestaEstudiantil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_seccion")
    private GrupoSeccion grupoSeccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_docente")
    private EncuestaDocente encuestaDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public EncuestaCurso() {
    }

    public EncuestaCurso(Object id) {
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

    public Long getAlumnosInicio() {
        return alumnosInicio;
    }

    public void setAlumnosInicio(Long alumnosInicio) {
        this.alumnosInicio = alumnosInicio;
    }

    public void setAlumnosInicioInteger(Integer alumnosInicio) {
        if (alumnosInicio == null) {
            this.alumnosInicio = null;
        } else {
            this.alumnosInicio = Long.valueOf(alumnosInicio);
        }
    }

    public Long getAlumnosFin() {
        return alumnosFin;
    }

    public void setAlumnosFin(Long alumnosFin) {
        this.alumnosFin = alumnosFin;
    }

    public void setAlumnosFinInteger(Integer alumnosFin) {
        if (alumnosFin == null) {
            this.alumnosFin = null;
        } else {
            this.alumnosFin = Long.valueOf(alumnosFin);
        }
    }

    public Long getAlumnosEncuestados() {
        return alumnosEncuestados;
    }

    public void setAlumnosEncuestados(Long alumnosEncuestados) {
        this.alumnosEncuestados = alumnosEncuestados;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EncuestaEstudiantil getEncuestaEstudiantil() {
        return encuestaEstudiantil;
    }

    public void setEncuestaEstudiantil(EncuestaEstudiantil encuestaEstudiantil) {
        this.encuestaEstudiantil = encuestaEstudiantil;
    }

    public GrupoSeccion getGrupoSeccion() {
        return grupoSeccion;
    }

    public void setGrupoSeccion(GrupoSeccion grupoSeccion) {
        this.grupoSeccion = grupoSeccion;
    }

    public EncuestaEstudiantilEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EncuestaEstudiantilEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(EncuestaEstudiantilEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEncuestaInicio() {
        return fechaEncuestaInicio;
    }

    public void setFechaEncuestaInicio(Date fechaEncuestaInicio) {
        this.fechaEncuestaInicio = fechaEncuestaInicio;
    }

    public Date getFechaEncuestaFin() {
        return fechaEncuestaFin;
    }

    public void setFechaEncuestaFin(Date fechaEncuestaFin) {
        this.fechaEncuestaFin = fechaEncuestaFin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getModoEncuesta() {
        return modoEncuesta;
    }

    public void setModoEncuesta(String modoEncuesta) {
        this.modoEncuesta = modoEncuesta;
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

    public BigDecimal getPorcentajeEncuesta() {
        return porcentajeEncuesta;
    }

    public void setPorcentajeEncuesta(BigDecimal porcentajeEncuesta) {
        this.porcentajeEncuesta = porcentajeEncuesta;
    }

    public EncuestaDocente getEncuestaDocente() {
        return encuestaDocente;
    }

    public void setEncuestaDocente(EncuestaDocente encuestaDocente) {
        this.encuestaDocente = encuestaDocente;
    }

    public ModalidadEstudio getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(ModalidadEstudio modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

}
