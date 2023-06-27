package pe.edu.lamolina.model.base;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Table(catalog = "lamolina", name = "base_categoria_base")
public class CategoriaBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "visible_autenticado")
    private Boolean visibleAutenticado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private SitioBase sitio;

    @Transient
    List<PostBase> posts;

    public CategoriaBase() {
    }

    public CategoriaBase(Object id) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getVisibleAutenticado() {
        return visibleAutenticado;
    }

    public void setVisibleAutenticado(Boolean visibleAutenticado) {
        this.visibleAutenticado = visibleAutenticado;
    }

    public SitioBase getSitio() {
        return sitio;
    }

    public void setSitio(SitioBase sitio) {
        this.sitio = sitio;
    }

    public List<PostBase> getPosts() {
        if (posts == null) {
            posts = new ArrayList();
        }
        return posts;
    }

    public void setPosts(List<PostBase> posts) {
        this.posts = posts;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
