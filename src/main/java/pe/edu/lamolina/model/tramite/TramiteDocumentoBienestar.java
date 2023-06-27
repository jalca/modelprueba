package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.DocumentoBienestar;

@Entity
@Table(name = "tram_tramite_documento_bienestar")
public class TramiteDocumentoBienestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entregado")
    private Boolean entregado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_bienestar")
    private DocumentoBienestar documentoBienestar;

    public TramiteDocumentoBienestar() {
    }

    public TramiteDocumentoBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public DocumentoBienestar getDocumentoBienestar() {
        return documentoBienestar;
    }

    public void setDocumentoBienestar(DocumentoBienestar documentoBienestar) {
        this.documentoBienestar = documentoBienestar;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Tramite t = this.tramite == null ? new Tramite() : this.tramite;
        DocumentoBienestar db = this.documentoBienestar == null ? new DocumentoBienestar() : this.documentoBienestar;        

        json.set("tramite", JsonHelper.createJson(t, JsonNodeFactory.instance));
        json.set("documentoBienestar", JsonHelper.createJson(db, JsonNodeFactory.instance));
        return json;
    }

}
