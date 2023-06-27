package pe.edu.lamolina.model.cms;

import com.fasterxml.jackson.databind.node.ObjectNode;
import pe.albatross.zelpers.miscelanea.TypesUtil;
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
import pe.albatross.zelpers.json.JaneHelper;

@Entity
@Table(name = "cms_menu")
public class MenuWeb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "editable")
    private Boolean editable;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private Sitio sitio;

    public MenuWeb() {
    }

    public MenuWeb(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public MenuWeb(Sitio sitio, RecursoPlantilla recurso) {
        this.sitio = sitio;
        this.titulo = recurso.getCodigo().toUpperCase();
        this.codigo = recurso.getCodigo();
        this.editable = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public ObjectNode toJson() {

        return JaneHelper.from(this).json();
    }

}
