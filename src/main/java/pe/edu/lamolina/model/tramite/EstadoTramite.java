package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TramiteEstadoEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tram_estado_tramite")
public class EstadoTramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "icono")
    private String icono;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "visibilidad_bandeja")
    private Integer visibilidadBandeja;

    public EstadoTramite(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean getEsSolicitudReincorporacion() {
        if (this.getId().compareTo(TramiteEstadoEnum.SOL_REI.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsSolicitudHistorialRevisado() {
        if (this.getId().compareTo(TramiteEstadoEnum.REV_HIS.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsConsejoFacultad() {
        if (this.getId().compareTo(TramiteEstadoEnum.CON_FAC.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsResolucionFacultad() {
        if (this.getId().compareTo(TramiteEstadoEnum.RES_FAC.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsAgendadoConsejoFacultad() {
        if (this.getId().compareTo(TramiteEstadoEnum.AGE_CON_FAC.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsProcesarSolicitud() {
        if (this.getId().compareTo(TramiteEstadoEnum.PROC_SOL.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsControlCalidad() {
        if (this.getId().compareTo(TramiteEstadoEnum.CTRL_CALIDAD.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsRechazarSolicitud() {
        if (this.getId().compareTo(TramiteEstadoEnum.RHZ_SOL.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsDocumentoCargado() {
        if (this.getId().compareTo(TramiteEstadoEnum.SUB_DOC.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsVistoBuenoUR() {
        if (this.getId().compareTo(TramiteEstadoEnum.VB_UR.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsPreparado() {
        if (this.getId().compareTo(TramiteEstadoEnum.PREPA.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsRevicionDepartamento() {
        if (this.getId().compareTo(TramiteEstadoEnum.REV_DEP.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsVBDepartamentoDocente() {
        if (this.getId().compareTo(TramiteEstadoEnum.VB_DEP_DOC.getId()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getEsSolicitudCursoDirigido() {
        if (this.getId().compareTo(TramiteEstadoEnum.SOL_CUR_DIR.getId()) == 0) {
            return true;
        }
        return false;
    }

    public TramiteEstadoEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TramiteEstadoEnum.valueOf(codigo);
    }

    public boolean getIsVisibleBandeja() {
        if (BigDecimal.ONE.intValue() == this.getVisibilidadBandeja()) {
            return true;
        }
        return false;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        json.put("esSolReincorporacion", this.getEsSolicitudReincorporacion());
        json.put("esConsejoFacultad", this.getEsConsejoFacultad());
        return json;
    }

}
