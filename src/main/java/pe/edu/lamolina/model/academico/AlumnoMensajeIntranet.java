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
import static pe.edu.lamolina.model.constantines.GlobalConstantine.SCHEMA_AUDITOR;

@Entity
@Table(name = "aca_alumno_mensaje_intranet", catalog = SCHEMA_AUDITOR)
public class AlumnoMensajeIntranet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "principal")
    private Integer principal;

    @Column(name = "fecha_mensaje")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaMensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mensaje_intranet")
    private MensajeIntranet mensajeIntranet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    public AlumnoMensajeIntranet() {
    }

    public AlumnoMensajeIntranet(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public MensajeIntranet getMensajeIntranet() {
        return mensajeIntranet;
    }

    public void setMensajeIntranet(MensajeIntranet mensajeIntranet) {
        this.mensajeIntranet = mensajeIntranet;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

}
