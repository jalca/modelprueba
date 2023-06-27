package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;
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
import org.joda.time.DateTime;
import org.joda.time.Years;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.SeguroSalud;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "med_historia_clinica")
public class HistoriaClinica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tiene_seguro")
    private Boolean tieneSeguro;

    @Column(name = "otro_seguro")
    private String otroSeguro;

    @Column(name = "telefono_emergencia")
    private String telefonoEmergencia;

    @Column(name = "celular_emergencia")
    private String celularEmergencia;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_medico_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaMedicoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguro")
    private SeguroSalud seguroSalud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico_registro")
    private Medico medicoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Alumno alumno;
    
    @Transient
    private HistoriaAntecedente historiaAntecedente;

    public HistoriaClinica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getEdadHistoria() {
        if (this.fechaRegistro == null) {
            return null;
        }
        DateTime nac = new DateTime(this.paciente.getPersona().getFechaNacer());
        DateTime registro = new DateTime(this.fechaRegistro);
        return Years.yearsBetween(nac, registro).getYears();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tieneSeguro", tieneSeguro, false);
        ModelUtils.getDataByAttr(join, "otroSeguro", otroSeguro, false);
        ModelUtils.getDataByAttr(join, "telefonoEmergencia", telefonoEmergencia, false);
        ModelUtils.getDataByAttr(join, "celularEmergencia", celularEmergencia, false);
        ModelUtils.getDataByAttr(join, "observacion", observacion, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaMedicoRegistro", fechaMedicoRegistro, false);
        ModelUtils.getDataByAttrObject(join, "paciente", paciente, "id", "tipoPaciente");
        ModelUtils.getDataByAttrObject(join, "seguroSalud", seguroSalud, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "medicoRegistro", medicoRegistro, "id");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
