package pe.edu.lamolina.model.cms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.cms.enums.TipoItemMenuEnum;

@Entity
@Table(name = "cms_menu_item")
public class MenuWebItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "instancia")
    private Long instancia;

    @Column(name = "url")
    private String url;

    @Column(name = "nombre_link")
    private String nombreLink;

    @Column(name = "clase")
    private String clase;

    @Column(name = "orden")
    private Integer orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu")
    private MenuWeb menu;

    public MenuWebItem() {
    }

    public MenuWebItem(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public String getTipo() {
        return tipo;
    }

    @JsonIgnore
    public TipoItemMenuEnum getTipoEnum() {
        return TipoItemMenuEnum.valueOf(tipo);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getInstancia() {
        return instancia;
    }

    public void setInstancia(Long instancia) {
        this.instancia = instancia;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreLink() {
        return nombreLink;
    }

    public void setNombreLink(String nombreLink) {
        this.nombreLink = nombreLink;
    }

    public MenuWeb getMenu() {
        return menu;
    }

    public void setMenu(MenuWeb menu) {
        this.menu = menu;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public ObjectNode toJson() {

        MenuWeb menu = this.getMenu() != null ? this.getMenu() : new MenuWeb();
        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory, true);

        json.set("menu", JsonHelper.createJson(menu, factory));

        return json;
    }
}
