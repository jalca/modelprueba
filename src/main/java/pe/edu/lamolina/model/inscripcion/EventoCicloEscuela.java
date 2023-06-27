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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.posgrado.admision.CarreraEscuela;
import pe.edu.lamolina.model.posgrado.admision.CicloEscuela;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "epg_evento_ciclo_escuela")
public class EventoCicloEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden")
    private Long orden;

    @Column(name = "lugar_evento")
    private String lugarEvento;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "visible_movil")
    private Boolean visibleMovil;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_escuela")
    private CicloEscuela cicloEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_escuela")
    private CarreraEscuela carreraEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_escuela")
    private EventoEscuela eventoEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private String horaInicio;

    @Transient
    private String horaFin;

    public EventoCicloEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean getMovil() {
        return visibleMovil;
    }

    public void setMovil(Boolean movil) {
        this.visibleMovil = movil;
    }

}
