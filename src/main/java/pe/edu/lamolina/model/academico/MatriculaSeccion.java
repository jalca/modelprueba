package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.enums.TipoAmpliacionEnum;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "aca_matricula_seccion")
public class MatriculaSeccion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "visible")
    private Integer visible;

    @Column(name = "en_solicitud")
    private Boolean enSolicitud;

    @Column(name = "es_ampliacion_vacante")
    private Boolean esAmpliacionVacante;

    @Column(name = "tipo_ampliacion")
    private String tipoAmpliacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_prematricula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaPrematricula;

    @Column(name = "fecha_matricula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaMatricula;

    @Column(name = "fecha_anula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAnula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_resumen")
    private MatriculaResumen matriculaResumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_prematricula")
    private Usuario userPrematricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_matricula")
    private Usuario userMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anula")
    private Usuario userAnula;

    @Transient
    private String codigoAlumno;
    @Transient
    private String codigoSeccion;
    @Transient
    private Integer procesado;
    @Transient
    private Integer cargado;
    @Transient
    private Integer creditos;
    @Transient
    private Date fechaInicioProceso;
    @Transient
    private Date fechaFinProceso;
    @Transient
    private boolean ocupado;

    public MatriculaSeccion() {
        this.procesado = 0;
        this.cargado = 0;
        this.ocupado = false;
        this.enSolicitud = Boolean.FALSE;
    }

    public MatriculaSeccion(String codigoAlumno, String codigoSeccion, Integer creditos) {
        this.codigoAlumno = codigoAlumno;
        this.codigoSeccion = codigoSeccion;
        this.creditos = creditos;
        this.procesado = 0;
        this.cargado = 0;
        this.ocupado = false;
    }

    public MatriculaSeccion(Object id) {
        this.id = TypesUtil.getLong(id);
        procesado = 0;
        cargado = 0;
        this.enSolicitud = Boolean.FALSE;
    }

    public MatriculaSeccion(Curso curso,
            MatriculaResumen matriculaResumen,
            Seccion seccion,
            EstadoMatriculaEnum estadoMatriculaEnum,
            Usuario usuario, Date fechaRegistro) {
        this();
        this.creditos = curso.getCreditos();
        //    matriculaSeccion.setEstadoEnum(EstadoMatriculaEnum.MAT);
        this.matriculaResumen = matriculaResumen;
        this.seccion = seccion;
        this.userRegistro = usuario;
        this.fechaRegistro = new Date();
        this.setEstadoEnum(estadoMatriculaEnum);
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public TipoAmpliacionEnum getTipoAmpliacionEnum() {
        if (tipoAmpliacion == null) {
            return null;
        }
        return TipoAmpliacionEnum.valueOf(tipoAmpliacion);
    }

    @JsonIgnore
    public void setTipoAmpliacionEnum(TipoAmpliacionEnum tipoAmpliacionEnum) {
        if (tipoAmpliacionEnum == null) {
            return;
        }
        this.tipoAmpliacion = tipoAmpliacionEnum.name();
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isEstadoRCU() {
        if (EstadoMatriculaEnum.RCU.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoMAT() {
        if (EstadoMatriculaEnum.MAT.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoSOL() {
        if (EstadoMatriculaEnum.SOL.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoPMAT() {
        if (EstadoMatriculaEnum.PMAT.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRCA() {
        if (EstadoMatriculaEnum.RCA.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRHZ() {
        if (EstadoMatriculaEnum.RHZ.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public synchronized boolean getPerdirPermiso() {
        if (this.ocupado) {
            return false;
        }
        this.ocupado = true;
        return true;
    }

    public void setLiberarPermiso() {
        this.ocupado = false;
    }

    public Boolean getEsAmpliacionVacante() {
        if (this.esAmpliacionVacante == null) {
            return Boolean.FALSE;
        }
        return esAmpliacionVacante;
    }

    public String getKey() {
        Curso curso = this.seccion.getGrupoSeccion().getCurso();
        Alumno alumno = this.matriculaResumen.getAlumno();

        return alumno.getId() + "-" + curso.getId();
    }

    public String getKeyLoad() {
        return this.codigoAlumno + "-" + this.codigoSeccion;
    }

    public static class CompareReverseId implements Comparator<MatriculaSeccion> {

        @Override
        public int compare(MatriculaSeccion s1, MatriculaSeccion s2) {
            return s2.getId().compareTo(s1.getId());
        }
    }

    @Override
    public MatriculaSeccion clone() {
        MatriculaSeccion clone = null;
        try {
            clone = (MatriculaSeccion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "MatriculaSeccion{"
                + "id=" + id
                + ", estado=" + estado
                + ", seccion=" + seccion
                + ", enSolicitud=" + enSolicitud + '}';
    }

}
