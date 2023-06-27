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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;

@Entity
@Table(name = "tram_estado_tramite_bienestar")
public class EstadoTramiteBienestar implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "orden")
    private Integer orden;
    
    @Column(name = "icono")
    private String icono;

    public EstadoTramiteBienestar() {
    }

    public EstadoTramiteBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public TipoSubvencion getTipoSubvencion() {
        return tipoSubvencion;
    }

    public void setTipoSubvencion(TipoSubvencion tipoSubvencion) {
        this.tipoSubvencion = tipoSubvencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

}
