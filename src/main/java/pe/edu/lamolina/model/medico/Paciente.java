package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import pe.edu.lamolina.model.enums.medico.TipoPacienteEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.general.Colaborador;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "med_paciente")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "instancia")
    private Long instancia;

    @Column(name = "tipo_paciente")
    private String tipoPaciente;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Transient
    private Docente docenteTemporal;
    @Transient
    private Alumno alumnoTemporal;
    @Transient
    private Colaborador colaboradorTemporal;
    @Transient
    private Boolean revisado;

    @Transient
    private List<Alumno> alumnos;
    @Transient
    private List<Docente> docentes;
    @Transient
    private List<Colaborador> colaboradores;

    @JsonIgnore
    public void setTipoPacienteEnum(TipoPacienteEnum tipoPaciente) {
        this.tipoPaciente = tipoPaciente.name();
    }

    public TipoPacienteEnum getTipoPacienteEnum() {
        if (StringUtils.isBlank(tipoPaciente)) {
            return null;
        }
        return TipoPacienteEnum.valueOf(tipoPaciente);
    }

}
