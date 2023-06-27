package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CalendarioConsultorioEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "med_calendario_consultorio")
public class CalendarioConsultorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_disponible")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDisponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "calendarioConsultorio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CitaConsultorio> citaConsultorios;

    @OneToMany(mappedBy = "calendarioConsultorio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MedicoConsultorio> medicoConsultorios;

    @OneToMany(mappedBy = "calendarioConsultorio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AtencionConsultorio> atencionConsultorios;

    @Transient
    private Integer columna;

    public CalendarioConsultorio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CalendarioConsultorioEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return CalendarioConsultorioEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(CalendarioConsultorioEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Date getFechaDisponibleDia() {
        if (this.fechaDisponible == null) {
            return null;
        }
        return new LocalDate(this.fechaDisponible).toDate();
    }

    public String getFechaDisponibleHora() {
        if (this.fechaDisponible == null) {
            return null;
        }
        return new DateTime(this.fechaDisponible).toString("HH:mm");
    }

}
