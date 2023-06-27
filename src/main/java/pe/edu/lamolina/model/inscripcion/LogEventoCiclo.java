package pe.edu.lamolina.model.inscripcion;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "sip_log_evento_ciclo")
public class LogEventoCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_inicio_antes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicioAntes;

    @Column(name = "fecha_fin_antes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFinAntes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_ciclo")
    private EventoCiclo eventoCiclo;

    public LogEventoCiclo() {
    }

    public LogEventoCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicioAntes() {
        return fechaInicioAntes;
    }

    public void setFechaInicioAntes(Date fechaInicioAntes) {
        this.fechaInicioAntes = fechaInicioAntes;
    }

    public Date getFechaFinAntes() {
        return fechaFinAntes;
    }

    public void setFechaFinAntes(Date fechaFinAntes) {
        this.fechaFinAntes = fechaFinAntes;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public EventoCiclo getEventoCiclo() {
        return eventoCiclo;
    }

    public void setEventoCiclo(EventoCiclo eventoCiclo) {
        this.eventoCiclo = eventoCiclo;
    }

}
