package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.enums.TramiteEstadoEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tram_accion_tramite_bienestar")
public class AccionTramiteBienestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado_inicio")
    private String estadoInicio;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "estado_final")
    private String estadoFinal;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "orden_opcion")
    private Long ordenOpcion;

    @Column(name = "es_final")
    private Long esFinal;

    @Column(name = "es_regular")
    private Long esRegular;

    @Column(name = "solicita_motivo")
    private Long solicitaMotivo;

    @Column(name = "que_hacer")
    private String queHacer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    public AccionTramiteBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getKey() {
        if (this.tipoTramite == null) {
            return null;
        }
        if (this.tipoTramite.getId() == null) {
            return null;
        }
        if (StringUtils.isBlank(this.estadoInicio)) {
            return null;
        }

        String key = this.tipoTramite.getId() + "";

        if (this.tipoSubvencion != null) {
            key += "-" + this.tipoSubvencion.getId();
        }

        key += "-" + this.estadoInicio;
        return key;
    }

    public TramiteEstadoEnum getEstadoInicioEnum() {
        if (estadoInicio == null) {
            return null;
        }
        return TramiteEstadoEnum.valueOf(estadoInicio);
    }

    @JsonIgnore
    public void setEstadoInicioEnum(TramiteEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estadoInicio = estadoEnum.name();
    }

    public TramiteEstadoEnum getEstadoFinalEnum() {
        if (estadoFinal == null) {
            return null;
        }
        return TramiteEstadoEnum.valueOf(estadoFinal);
    }

    @JsonIgnore
    public void setEstadoFinalEnum(TramiteEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estadoFinal = estadoEnum.name();
    }
}
