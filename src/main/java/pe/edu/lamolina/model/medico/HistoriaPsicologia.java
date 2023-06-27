package pe.edu.lamolina.model.medico;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.albatross.zelpers.spring.deserializer.DateTimeDeserializer;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "med_historia_psicologia")
public class HistoriaPsicologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_sesion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaSesion;

    @Column(name = "proxima_sesion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date proximaSesion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita_consultorio")
    private CitaConsultorio citaConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public HistoriaPsicologia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
