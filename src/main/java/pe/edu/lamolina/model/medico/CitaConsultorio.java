package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CitaConsultorioEstadoEnum;
import pe.edu.lamolina.model.enums.medico.TipoPacienteEnum;
import pe.edu.lamolina.model.enums.medico.TipoRegistroEnum;
import pe.edu.lamolina.model.enums.medico.TipoSesionCitaEnum;
import pe.edu.lamolina.model.general.TipoDocumentoCompania;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "med_cita_consultorio")
public class CitaConsultorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hora")
    private String hora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_sesion")
    private String tipoSesion;

    @Column(name = "tipo_paciente")
    private String tipoPaciente;

    @Column(name = "numero_reserva")
    private String numeroReserva;

    @Column(name = "tipo_registro")
    private String tipoRegistro;

    @Column(name = "motivo_inhabilitado")
    private String motivoInhabilitado;

    @Column(name = "fecha_reserva")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @Column(name = "fecha_cancelacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCancelacion;

    @Column(name = "fecha_inhabilitacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInhabilitacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario_consultorio")
    private CalendarioConsultorio calendarioConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoCompania tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_reserva")
    private Usuario userReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cancelacion")
    private Usuario userCancelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inhabilitacion")
    private Usuario userInhabilitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private Integer elemento;
    @Transient
    private Integer orden;
    @Transient
    private List<AtencionConsultorio> atenciones;

    public CitaConsultorio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CitaConsultorioEstadoEnum getEstadoEnum() {
        if (estado == null) {
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

    public TipoSesionCitaEnum getTipoSesionEnum() {
        if (tipoSesion == null) {
            return null;
        }
        return TipoSesionCitaEnum.valueOf(tipoSesion);
    }

    @JsonIgnore
    public void setTipoSesionEnum(TipoSesionCitaEnum tipoSesion) {
        if (tipoSesion == null) {
            return;
        }
        this.tipoSesion = tipoSesion.name();
    }

    public TipoPacienteEnum getTipoPacienteEnum() {
        if (tipoPaciente == null) {
            return null;
        }
        return TipoPacienteEnum.valueOf(tipoPaciente);
    }

    @JsonIgnore
    public void setTipoPacienteEnum(TipoPacienteEnum tipoPaciente) {
        if (tipoPaciente == null) {
            return;
        }
        this.tipoPaciente = tipoPaciente.name();
    }

    public TipoRegistroEnum getTipoRegistroEnum() {
        if (tipoRegistro == null) {
            return null;
        }
        return TipoRegistroEnum.valueOf(tipoRegistro);
    }

    @JsonIgnore
    public void setTipoRegistroEnum(TipoRegistroEnum tipoRegistro) {
        if (tipoRegistro == null) {
            return;
        }
        this.tipoRegistro = tipoRegistro.name();
    }

    public Integer getHoraNumber() {
        return new Integer(this.hora.replace(":", ""));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CitaConsultorio other = (CitaConsultorio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "hora", hora);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "tipoSesion", tipoSesion, false);
        ModelUtils.getDataByAttr(join, "tipoPaciente", tipoPaciente, false);
        ModelUtils.getDataByAttr(join, "tipoRegistro", tipoRegistro, false);
        ModelUtils.getDataByAttr(join, "numeroReserva", numeroReserva, false);
        ModelUtils.getDataByAttr(join, "fechaReserva", fechaReserva, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttr(join, "fechaCancelacion", fechaCancelacion, false);
        ModelUtils.getDataByAttr(join, "fechaInhabilitacion", fechaInhabilitacion, false);
        ModelUtils.getDataByAttrObject(join, "calendarioConsultorio", calendarioConsultorio, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "paciente", paciente, "id");
        ModelUtils.getDataByAttrObject(join, "tipoDocumento", tipoDocumento, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "userReserva", userReserva, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userCancelacion", userCancelacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userInhabilitacion", userInhabilitacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
