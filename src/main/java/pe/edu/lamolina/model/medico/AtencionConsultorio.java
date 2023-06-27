package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CitaConsultorioEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Getter
@Setter
@Table(name = "med_atencion_consultorio")
public class AtencionConsultorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_fin_atencion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFinAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario_consultorio")
    private CalendarioConsultorio calendarioConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita_consultorio")
    private CitaConsultorio citaConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AtencionConsultorio() {
    }

    public AtencionConsultorio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CitaConsultorioEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return CitaConsultorioEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(CitaConsultorioEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

}
