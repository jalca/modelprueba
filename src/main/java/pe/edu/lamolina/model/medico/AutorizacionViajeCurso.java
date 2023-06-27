package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.AlumnoViajeCurso;
import pe.edu.lamolina.model.enums.subvenciones.SaludEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "med_autorizacion_viaje_curso")
public class AutorizacionViajeCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "motivo")
    private String motivo;

    @Column(name = "dias_vigencia")
    private Integer diasVigencia;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_dictamen")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDictamen;

    @Column(name = "fecha_cita")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_viaje_curso")
    private AlumnoViajeCurso alumnoViajeCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico_dictamen")
    private Medico medicoDictamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AutorizacionViajeCurso() {
    }

    public AutorizacionViajeCurso(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public SaludEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return SaludEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(SaludEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Boolean isPendiente() {
        if (this.estado == null) {
            return false;
        }
        return SaludEstadoEnum.valueOf(estado) == SaludEstadoEnum.PENDIENTE;
    }

    public Boolean isSaludable() {
        if (this.estado == null) {
            return false;
        }
        return SaludEstadoEnum.valueOf(estado) == SaludEstadoEnum.SALUD_OK;
    }

    public Boolean isIndispuesto() {
        if (this.estado == null) {
            return false;
        }
        return SaludEstadoEnum.valueOf(estado) == SaludEstadoEnum.SALUD_NO_OK;
    }
}
