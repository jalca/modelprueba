package pe.edu.lamolina.model.tramite;

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
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.enums.TipoResolucionEnum;

@Entity
@Table(name = "tram_tipo_resolucion")
public class TipoResolucion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "codigo")
    private String codigo;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "para_tramite")
    private Boolean paraTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    public TipoResolucion() {
    }

    public TipoResolucion(Long id) {
        this.id = id;
    }

    public TipoResolucion(Long id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoResolucionEnum getTipoEnum() {
        if (this.codigo == null) {
            return null;
        }
        return TipoResolucionEnum.valueOf(codigo);
    }

    public boolean isReincorporacion() {
        if (this.getCodigo().equals(TipoResolucionEnum.REIC.name())) {
            return true;
        }
        return false;
    }

    public boolean isCursoDirigido() {
        if (this.getCodigo().equals(TipoResolucionEnum.CURDIR.name())) {
            return true;
        }
        return false;
    }

    public boolean isRetiroCiclo() {
        if (this.getCodigo().equals(TipoResolucionEnum.RCI.name())) {
            return true;
        }
        return false;
    }

    public boolean isAnulacionCiclo() {
        if (this.getCodigo().equals(TipoResolucionEnum.ANCI.name())) {
            return true;
        }
        return false;
    }

    public boolean isCambioNota() {
        if (this.getCodigo().equals(TipoResolucionEnum.CAM_NOTA.name())) {
            return true;
        }
        return false;
    }

    public boolean isNotaBaja() {
        if (this.getCodigo().equals(TipoResolucionEnum.NOTA_BAJA.name())) {
            return true;
        }
        return false;
    }

    public boolean isTrasladoInterno() {
        if (this.getCodigo().equals(TipoResolucionEnum.TRAS_INT.name())) {
            return true;
        }
        return false;
    }

    public boolean isReadmision() {
        if (this.getCodigo().equals(TipoResolucionEnum.READMISION.name())) {
            return true;
        }
        return false;
    }

    public boolean isCambioPlanCurricular() {
        if (this.getCodigo().equals(TipoResolucionEnum.CAMBIO_PLAN_CURRICULAR.name())) {
            return true;
        }
        return false;
    }

    public boolean isTrasladoExterno() {
        if (this.getCodigo().equals(TipoResolucionEnum.TRAS.name())) {
            return true;
        }
        return false;
    }

    public boolean isIntercambioEstudiantil() {
        if (this.getCodigo().equals(TipoResolucionEnum.INTES.name())) {
            return true;
        }
        return false;
    }

    public boolean isIngresoFisicoHistorial() {
        if (this.getCodigo().equals(TipoResolucionEnum.ING_HIS.name())) {
            return true;
        }
        return false;
    }

    public boolean isTramiteBachiller() {
        if (this.getCodigo().equals(TipoResolucionEnum.BACHI.name())) {
            return true;
        }
        return false;
    }

    public boolean isTramiteTitulo() {
        if (this.getCodigo().equals(TipoResolucionEnum.TITUL.name())) {
            return true;
        }
        return false;
    }

    public boolean isTramitePracticas() {
        if (this.getCodigo().equals(TipoResolucionEnum.PRACTICAS.name())) {
            return true;
        }
        return false;
    }

    public Boolean getParaTramite() {
        if (paraTramite == null) {
            return false;
        }
        return paraTramite;
    }

    public void setParaTramite(Boolean paraTramite) {
        this.paraTramite = paraTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof TipoResolucion)) {
            return false;
        }
        TipoResolucion other = (TipoResolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isTramiteBachillerFacultad() {
        if (this.getCodigo().equals(TipoResolucionEnum.BACHIFAC.name())) {
            return true;
        }
        return false;
    }

}
