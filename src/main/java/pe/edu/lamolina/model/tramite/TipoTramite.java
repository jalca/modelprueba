package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.DocumentoBienestar;
import pe.edu.lamolina.model.enums.TipoTramiteEnum;
import pe.edu.lamolina.model.general.Oficina;

@Getter
@Setter
@Entity
@Table(name = "tram_tipo_tramite")
public class TipoTramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "requiere_ficha_sec")
    private Boolean requiereFichaSocioeconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite_inicio")
    private EstadoTramite estadoTramiteInicio;

    @OneToMany(mappedBy = "tipoTramite", fetch = FetchType.LAZY)
    private List<Tramite> tramite;

    @OneToMany(mappedBy = "tipoTramite", fetch = FetchType.LAZY)
    private List<DocumentoBienestar> documentoBienestar;

    @Transient
    TramiteSubvencion tramiteSubvencion;

    public TipoTramite() {
    }

    public TipoTramite(TipoTramiteEnum tipoEnum) {
        this.id = tipoEnum.getId();
        this.codigo = tipoEnum.name();
        this.nombre = tipoEnum.getValue();
    }

    public TipoTramite(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean getEsReincorporacionPregrado() {
        if (TipoTramiteEnum.REI.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsReincorporacionPosgrado() {
        if (TipoTramiteEnum.REI_EPG.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsRetiroCiclo() {
        if (TipoTramiteEnum.RCI.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsTramiteConstancia() {
        if (TipoTramiteEnum.CONS.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsCorreccionHistorial() {
        if (TipoTramiteEnum.CORR_HISTO.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsNotaMasBaja() {
        if (TipoTramiteEnum.NOTA_BAJA.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getEsCursoDirigido() {
        if (TipoTramiteEnum.CURDIR.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isExamenIdioma() {
        if (TipoTramiteEnum.EXM_IDIOMA.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public TipoTramiteEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoTramiteEnum.valueOf(codigo);
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Oficina o = this.oficina == null ? new Oficina() : this.oficina;

        json.set("oficina", JsonHelper.createJson(o, JsonNodeFactory.instance));
        json.put("esTipoTramiteRei", this.getEsReincorporacionPregrado());
        return json;
    }

}
