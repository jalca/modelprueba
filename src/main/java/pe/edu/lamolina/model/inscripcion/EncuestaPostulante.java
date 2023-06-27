package pe.edu.lamolina.model.inscripcion;

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
import pe.edu.lamolina.model.examen.OpcionPregunta;
import pe.edu.lamolina.model.examen.PreguntaExamen;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_encuesta_postulante")
public class EncuestaPostulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "respuesta_otro")
    private String respuestaOtro;

    @Column(name = "numero_pregunta")
    private Integer numeroPregunta;

    @Column(name = "letra_opcion")
    private String letraOpcion;

    @Column(name = "orden_multiple")
    private Integer ordenMultiple;

    @Column(name = "fecha_respuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRespuesta;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    private PreguntaExamen pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion")
    private OpcionPregunta opcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @Transient
    private String valido;

    public EncuestaPostulante() {
    }

    public EncuestaPostulante(Object id) {
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

    public PreguntaExamen getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaExamen pregunta) {
        this.pregunta = pregunta;
    }

    public OpcionPregunta getOpcion() {
        return opcion;
    }

    public void setOpcion(OpcionPregunta opcion) {
        this.opcion = opcion;
    }

    public String getRespuestaOtro() {
        return respuestaOtro;
    }

    public void setRespuestaOtro(String respuestaOtro) {
        this.respuestaOtro = respuestaOtro;
    }

    public Integer getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(Integer numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getLetraOpcion() {
        return letraOpcion;
    }

    public void setLetraOpcion(String letraOpcion) {
        this.letraOpcion = letraOpcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getOrdenMultiple() {
        return ordenMultiple;
    }

    public void setOrdenMultiple(Integer ordenMultiple) {
        this.ordenMultiple = ordenMultiple;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Usuario getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(Usuario userCreacion) {
        this.userCreacion = userCreacion;
    }

    public String getValido() {
        return valido;
    }

    public void setValido(String valido) {
        this.valido = valido;
    }

}
