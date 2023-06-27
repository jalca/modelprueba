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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoOficina;

@Entity
@Table(name = "tram_configuracion_firma_documento")
public class ConfiguracionFirmaDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden")
    private Integer orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina")
    private TipoOficina tipoOficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_academico")
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    public ConfiguracionFirmaDocumento() {
    }

    public ConfiguracionFirmaDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public TipoOficina getTipoOficina() {
        return tipoOficina;
    }

    public void setTipoOficina(TipoOficina tipoOficina) {
        this.tipoOficina = tipoOficina;
    }

    public TipoDocumentoAcademico getTipoDocumentoAcademico() {
        return tipoDocumentoAcademico;
    }

    public void setTipoDocumentoAcademico(TipoDocumentoAcademico tipoDocumentoAcademico) {
        this.tipoDocumentoAcademico = tipoDocumentoAcademico;
    }

}
