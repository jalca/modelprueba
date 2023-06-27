package pe.edu.lamolina.model.tramite;

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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoMiembroComiteEvaluadorEnum;
import pe.edu.lamolina.model.enums.TipoAsesorEnum;
import pe.edu.lamolina.model.enums.TipoMiembroComiteEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "epg_miembro_comite_evaluador")
public class MiembroComiteEvaluador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_miembro_comite")
    private String tipoMiembroComite;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_inasistencia")
    private String motivoInasistencia;

    @Column(name = "tipo_colaborador")
    private String tipoColaborador;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reunion_comite_evaluador")
    private ReunionComiteEvaluador reunionComiteEvaluador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public MiembroComiteEvaluador() {
    }

    public MiembroComiteEvaluador(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMiembroComite() {
        return tipoMiembroComite;
    }

    public void setTipoMiembroComite(String tipoMiembroComite) {
        this.tipoMiembroComite = tipoMiembroComite;
    }

    public TipoMiembroComiteEnum getTipoMiembroComiteEnum() {
        if (StringUtils.isBlank(this.tipoMiembroComite)) {
            return null;
        }
        return TipoMiembroComiteEnum.valueOf(this.tipoMiembroComite);
    }

    @JsonIgnore
    public void setTipoMiembroComiteEnum(TipoMiembroComiteEnum tipoMiembroComiteEnum) {
        this.tipoMiembroComite = tipoMiembroComiteEnum.name();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoInasistencia() {
        return motivoInasistencia;
    }

    public void setMotivoInasistencia(String motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ReunionComiteEvaluador getReunionComiteEvaluador() {
        return reunionComiteEvaluador;
    }

    public void setReunionComiteEvaluador(ReunionComiteEvaluador reunionComiteEvaluador) {
        this.reunionComiteEvaluador = reunionComiteEvaluador;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public EstadoMiembroComiteEvaluadorEnum getEstadoEnum() {
        if (StringUtils.isBlank(this.estado)) {
            return null;
        }
        return EstadoMiembroComiteEvaluadorEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMiembroComiteEvaluadorEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public TipoAsesorEnum getTipoColaboradorEnum() {
        if (StringUtils.isBlank(this.tipoColaborador)) {
            return null;
        }
        return TipoAsesorEnum.valueOf(this.tipoColaborador);
    }

    @JsonIgnore
    public void setTipoColaboradorEnum(TipoAsesorEnum tipoColaboradorEnum) {
        this.tipoColaborador = tipoColaboradorEnum.name();
    }

}
