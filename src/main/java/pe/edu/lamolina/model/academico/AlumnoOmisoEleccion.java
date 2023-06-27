package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.AporteAlumnoCiclo;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.enums.MotivoOmisoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "aca_alumno_omiso_eleccion")
public class AlumnoOmisoEleccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "multa")
    private BigDecimal multa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aporte_alumno_ciclo")
    private AporteAlumnoCiclo aporteAlumnoCiclo;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Transient
    private Boolean seleccionado;

    public AlumnoOmisoEleccion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public MotivoOmisoEnum getMotivoEnum() {
        if (this.motivo == null) {
            return null;
        }
        return MotivoOmisoEnum.valueOf(motivo);
    }

    @JsonIgnore
    public void setMotivoEnum(MotivoOmisoEnum motivoEnum) {
        this.motivo = motivoEnum.name();
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum deudaEstadoEnum) {
        this.estado = deudaEstadoEnum.name();
    }

    public Boolean getSeleccionado() {
        if (seleccionado == null) {
            return false;
        }
        return seleccionado;
    }

    public String getKey() {
        return this.alumno.getId() + "-" + this.cicloAcademico.getId() + "-" + this.motivo;
    }
}
