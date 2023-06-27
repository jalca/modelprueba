package pe.edu.lamolina.model.medico;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.TipoDocumentoCompania;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "med_cita_cancelada")
public class CitaCancelada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_reserva")
    private String numeroReserva;

    @Column(name = "fecha_cancelacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCancelacion;

    @Column(name = "fecha_reserva")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita_consultorio")
    private CitaConsultorio citaConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoCompania tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cancelacion")
    private Usuario userCancelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_reserva")
    private Usuario userReserva;

    public CitaCancelada(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
