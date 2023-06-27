package pe.edu.lamolina.model.comedor;

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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_salida_comedor")
public class SalidaComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_salida")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio_comedor")
    private TipoServicioComedor tipoServicioComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_abono")
    private AlumnoAbono alumnoAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_comedor")
    private TicketComedor ticketComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public SalidaComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
