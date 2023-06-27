package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.examen.OpcionPregunta;
import pe.edu.lamolina.model.examen.PreguntaExamen;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "sip_respuesta_interesado")
public class RespuestaInteresado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero_pregunta")
    private Integer numeroPregunta;

    @Column(name = "letra_opcion")
    private String letraOpcion;

    @Column(name = "fecha_creacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_interesado")
    private ExamenInteresado examenInteresado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    private PreguntaExamen pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion")
    private OpcionPregunta opcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    public RespuestaInteresado() {
    }

    public RespuestaInteresado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamenInteresado getExamenInteresado() {
        return examenInteresado;
    }

    public void setExamenInteresado(ExamenInteresado examenInteresado) {
        this.examenInteresado = examenInteresado;
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

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Usuario getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(Usuario userCreacion) {
        this.userCreacion = userCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public static class ComparePreguntas implements Comparator<RespuestaInteresado> {

        @Override
        public int compare(RespuestaInteresado s1, RespuestaInteresado s2) {
            Integer int1 = 0;
            Integer int2 = 0;
            if (s1.getPregunta().getTema() != null) {
                int1 = s1.getPregunta().getTema().getOrden();
            } else {
                if (s1.getPregunta().getSubtitulo() != null) {
                    int1 = s1.getPregunta().getSubtitulo().getTemaExamen().getOrden();
                } else {
                    int1 = s1.getPregunta().getBloquePreguntas().getSubTituloExamen().getTemaExamen().getOrden();
                }
            }

            if (s2.getPregunta().getTema() != null) {
                int2 = s2.getPregunta().getTema().getOrden();
            } else {
                if (s2.getPregunta().getSubtitulo() != null) {
                    int2 = s2.getPregunta().getSubtitulo().getTemaExamen().getOrden();
                } else {
                    int2 = s2.getPregunta().getBloquePreguntas().getSubTituloExamen().getTemaExamen().getOrden();
                }
            }

            Integer resul1 = int1.compareTo(int2);

            if (resul1 == 0) {

                Integer int11 = 0;
                Integer int22 = 0;

                if (s1.getPregunta().getSubtitulo() != null) {
                    int11 = s1.getPregunta().getSubtitulo().getOrden();
                } else if (s1.getPregunta().getBloquePreguntas() != null) {
                    int11 = s1.getPregunta().getBloquePreguntas().getSubTituloExamen().getOrden();
                }

                if (s2.getPregunta().getSubtitulo() != null) {
                    int22 = s2.getPregunta().getSubtitulo().getOrden();
                } else if (s2.getPregunta().getBloquePreguntas() != null) {
                    int22 = s2.getPregunta().getBloquePreguntas().getSubTituloExamen().getOrden();
                }

                resul1 = int11.compareTo(int22);

            }

            return resul1;
        }
    }

}
