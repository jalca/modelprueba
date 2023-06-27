package pe.edu.lamolina.model.academico;

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
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_reclamo_nota")
public class ReclamoNota implements Serializable {

    public static Integer MAXIMO_DIAS_RECLAMO = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "origen_reclamo")
    private String origenReclamo;

    @Column(name = "numero_reclamo")
    private Integer numeroReclamo;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "nota_inicial")
    private String notaInicial;

    @Column(name = "nota_final")
    private String notaFinal;

    @Column(name = "letra_inicial")
    private String letraInicial;

    @Column(name = "letra_final")
    private String letraFinal;

    @Column(name = "id_user_respuesta")
    private Long idUserRespuesta;

    @Column(name = "fecha_reclamo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaReclamo;

    @Column(name = "fecha_respuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion")
    private Evaluacion evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_reclamo")
    private Usuario userReclamo;

    public ReclamoNota() {
    }

    public ReclamoNota(Object id) {
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

    public String getOrigenReclamo() {
        return origenReclamo;
    }

    public void setOrigenReclamo(String origenReclamo) {
        this.origenReclamo = origenReclamo;
    }

    public Integer getNumeroReclamo() {
        return numeroReclamo;
    }

    public void setNumeroReclamo(Integer numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Usuario getUserReclamo() {
        return userReclamo;
    }

    public void setUserReclamo(Usuario userReclamo) {
        this.userReclamo = userReclamo;
    }

    public Date getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(Date fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public String getNotaInicial() {
        return notaInicial;
    }

    public void setNotaInicial(String notaInicial) {
        this.notaInicial = notaInicial;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Long getIdUserRespuesta() {
        return idUserRespuesta;
    }

    public void setIdUserRespuesta(Long idUserRespuesta) {
        this.idUserRespuesta = idUserRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getLetraInicial() {
        return letraInicial;
    }

    public void setLetraInicial(String letraInicial) {
        this.letraInicial = letraInicial;
    }

    public String getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(String letraFinal) {
        this.letraFinal = letraFinal;
    }

}
