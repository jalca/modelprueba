package pe.edu.lamolina.model.academico;

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
import javax.persistence.UniqueConstraint;
import org.springframework.util.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.AlumnoEvaluacionEstadoEnum;
import pe.edu.lamolina.model.enums.MotivoAnulacionEnum;

@Entity
@Table(name = "aca_alumno_evaluacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_evaluacion"})
})
public class AlumnoEvaluacion implements Serializable {

    public final static String NSP = "NSP";

    public final static String NCV = "NCV";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nota")
    private String nota;

    @Column(name = "valor_numerico")
    private BigDecimal valorNumerico;

    @Column(name = "valor_letra")
    private String valorLetra;

    @Column(name = "es_ingreso_regular")
    private Integer esIngresoRegular;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_ingreso_nota")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaIngresoNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_ingreso_nota")
    private Usuario usuarioIngresoNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion")
    private Evaluacion evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reclamo_nota")
    private ReclamoNota reclamoNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    public AlumnoEvaluacion() {
    }

    public AlumnoEvaluacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getEstado() {
        return estado;
    }

    public AlumnoEvaluacionEstadoEnum getEstadoEnum() {
        return AlumnoEvaluacionEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(AlumnoEvaluacionEstadoEnum estado) {
        this.estado = estado.name();
    }

    public boolean isEstadoCalc() {
        if (this.getEstadoEnum().equals(AlumnoEvaluacionEstadoEnum.CALC)) {
            return true;
        }
        return false;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public BigDecimal getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(BigDecimal valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public Integer getEsIngresoRegular() {
        return esIngresoRegular;
    }

    public void setEsIngresoRegular(Integer esIngresoRegular) {
        this.esIngresoRegular = esIngresoRegular;
    }

    public Usuario getUsuarioIngresoNota() {
        return usuarioIngresoNota;
    }

    public void setUsuarioIngresoNota(Usuario usuarioIngresoNota) {
        this.usuarioIngresoNota = usuarioIngresoNota;
    }

    public Date getFechaIngresoNota() {
        return fechaIngresoNota;
    }

    public void setFechaIngresoNota(Date fechaIngresoNota) {
        this.fechaIngresoNota = fechaIngresoNota;
    }

    public ReclamoNota getReclamoNota() {
        return reclamoNota;
    }

    public void setReclamoNota(ReclamoNota reclamoNota) {
        this.reclamoNota = reclamoNota;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public boolean isNotaAnulada() {
        if (this.getMotivoAnulacion() != null && !this.getMotivoAnulacion().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public MotivoAnulacionEnum getMotivoAnulacionEnum() {
        return (motivoAnulacion == null) ? null : MotivoAnulacionEnum.valueOf(motivoAnulacion);
    }

    public String getMotivoAnulacionText() {
        if (motivoAnulacion == null) {
            return null;
        }
        if (StringUtils.isEmpty(motivoAnulacion)) {
            return null;

        }
        return MotivoAnulacionEnum.valueOf(motivoAnulacion).getValue();
    }

    public Curso getCurso() {
        if (evaluacion == null) {
            return null;
        }
        if (evaluacion.getEvaluacionSeccion() == null) {
            return null;
        }
        if (evaluacion.getEvaluacionSeccion().getGrupoSeccion() == null) {
            return null;
        }
        if (evaluacion.getEvaluacionSeccion().getGrupoSeccion().getCurso() == null) {
            return null;
        }
        return evaluacion.getEvaluacionSeccion().getGrupoSeccion().getCurso();
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public String getValorLetra() {
        return valorLetra;
    }

    public void setValorLetra(String valorLetra) {
        this.valorLetra = valorLetra;
    }

    public boolean isNCV() {
        if (NCV.equals(this.getNota())) {
            return true;
        }
        return false;
    }

    public String getNotaLetra() {
        String result = "";

        if (this.getValorLetra().equals("A")) {
            result = "Aprobado";
        } else {
            result = "Desaprobado";
        }
        return result;
    }

}
