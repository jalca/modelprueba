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
import javax.persistence.Id;

@Entity
@Table(catalog = "lamolina", name = "base_post_base")
public class PostBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "estado")
    private String estado;

    @Column(name = "url")
    private String url;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "numero_vistas")
    private Long numeroVistas;

    @Column(name = "visible_autenticado")
    private Boolean visibleAutenticado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaBase categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private SitioBase sitio;

    public PostBase() {
    }

    public PostBase(Object id) {
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getNumeroVistas() {
        return numeroVistas;
    }

    public void setNumeroVistas(Long numeroVistas) {
        this.numeroVistas = numeroVistas;
    }

    public Boolean getVisibleAutenticado() {
        return visibleAutenticado;
    }

    public void setVisibleAutenticado(Boolean visibleAutenticado) {
        this.visibleAutenticado = visibleAutenticado;
    }

    public CategoriaBase getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBase categoria) {
        this.categoria = categoria;
    }

    public SitioBase getSitio() {
        return sitio;
    }

    public void setSitio(SitioBase sitio) {
        this.sitio = sitio;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
