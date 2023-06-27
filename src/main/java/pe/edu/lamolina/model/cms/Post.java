package pe.edu.lamolina.model.cms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import javax.persistence.TemporalType;
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
import javax.persistence.Temporal;
import pe.edu.lamolina.model.cms.enums.PostEnum;
import pe.edu.lamolina.model.cms.enums.TipoPostEnum;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "cms_post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url")
    private String url;

    @Column(name = "template")
    private String template;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCreacion;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaPublicacion;

    @Column(name = "fecha_evento")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEvento;

    @Column(name = "estado")
    private String estado;

    @Column(name = "meta")
    private String meta;

    @Column(name = "css")
    private String css;

    @Column(name = "javascript")
    private String javascript;

    @Column(name = "tags")
    private String tags;

    @Column(name = "miniatura")
    private String miniatura;

    @Column(name = "banner")
    private String banner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Taxonomy categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private Sitio sitio;

    public Post() {
    }

    public Post(Object id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public PostEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PostEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PostEnum estado) {
        this.estado = estado.name();
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getJavascript() {
        return javascript;
    }

    public void setJavascript(String javascript) {
        this.javascript = javascript;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public Taxonomy getCategoria() {
        return categoria;
    }

    public void setCategoria(Taxonomy categoria) {
        this.categoria = categoria;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonIgnore
    public TipoPostEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoPostEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoPostEnum tipo) {
        this.tipo = tipo.name();
    }

    public String getFechaPublicacionStr() {
        if (fechaPublicacion == null) {
            return "";
        }
        return TypesUtil.getStringDateLongFormat(fechaPublicacion);
    }

    public String getFechaEventoStr() {
        if (fechaEvento== null) {
            return "";
        }
        return TypesUtil.getStringDateLongFormat(fechaEvento);
    }

    public String getFechaEventoDay() {
        if (fechaEvento== null) {
            return "";
        }
        return TypesUtil.getStringDate(fechaEvento,"dd");
    }

    public String getFechaEventoMonth() {
        if (fechaEvento== null) {
            return "";
        }
        return TypesUtil.getStringDate(fechaEvento,"MMM");
    }

}
