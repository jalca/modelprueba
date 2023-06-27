package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoObservacionProyectoTesisEnum;
import pe.edu.lamolina.model.enums.TipoMiembroComiteEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tram_observacion_proyecto_tesis")
public class ObservacionProyectoTesis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "tipo_observador")
    private String tipoObservador;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_observador")
    private Persona personaObservador;

    @Column(name = "fecha_inactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInactivacion;

    @Column(name = "fecha_observacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaObservacion;

    @Column(name = "fecha_respuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto_tesis")
    private ProyectoTesis proyectoTesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_observacion_proyecto_tesis")
    private TipoObservacionProyectoTesis tipoObservacionProyectoTesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_original")
    private Archivo documentoOriginal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_observado")
    private Archivo documentoObservado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_observacion_padre")
    private ObservacionProyectoTesis observacionPadre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inactivacion")
    private Usuario userInactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_observacion")
    private Usuario userObservacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_respuesta")
    private Usuario userRespuesta;

    @Transient
    private List<ObservacionProyectoTesis> observacionesAnteriores;

    public ObservacionProyectoTesis(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoMiembroComiteEnum getTipoObservadorEnum() {
        if (tipoObservador == null) {
            return null;
        }
        return TipoMiembroComiteEnum.valueOf(tipoObservador);
    }

    @JsonIgnore
    public void setTipoObservadorEnum(TipoMiembroComiteEnum tipoObservador) {
        if (tipoObservador == null) {
            return;
        }
        this.tipoObservador = tipoObservador.name();
    }

    public EstadoObservacionProyectoTesisEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoObservacionProyectoTesisEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoObservacionProyectoTesisEnum estado) {
        this.estado = estado.name();
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
        final ObservacionProyectoTesis other = (ObservacionProyectoTesis) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
