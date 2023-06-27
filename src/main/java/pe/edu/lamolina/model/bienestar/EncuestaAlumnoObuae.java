package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.examen.OpcionPregunta;
import pe.edu.lamolina.model.examen.PreguntaExamen;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "obu_encuesta_alumno_obuae")
public class EncuestaAlumnoObuae implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "respuesta_otro")
    private String respuestaOtro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    private PreguntaExamen pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion")
    private OpcionPregunta opcion;

    public EncuestaAlumnoObuae() {
    }

    public EncuestaAlumnoObuae(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuestaOtro() {
        return respuestaOtro;
    }

    public void setRespuestaOtro(String respuestaOtro) {
        this.respuestaOtro = respuestaOtro;
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Alumno a = this.alumno == null ? new Alumno() : this.alumno;
        PreguntaExamen pe = this.pregunta == null ? new PreguntaExamen() : this.pregunta;
        OpcionPregunta op = this.opcion == null ? new OpcionPregunta() : this.opcion;

        json.set("alumno", JsonHelper.createJson(a, JsonNodeFactory.instance));
        json.set("pregunta", JsonHelper.createJson(pe, JsonNodeFactory.instance));
        json.set("opcion", JsonHelper.createJson(op, JsonNodeFactory.instance));
        return json;
    }
}
