package pe.edu.lamolina.model.base;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.util.Date;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import pe.edu.lamolina.model.general.Persona;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
@Table(catalog = "lamolina", name = "base_autorizacion_base")
public class AutorizacionBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private SitioBase sitio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaBase categoria;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_post")
    private PostBase post;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public AutorizacionBase() {}

    public AutorizacionBase(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public SitioBase getSitio() {
        return sitio;
    }

    public void setSitio(SitioBase sitio) {
        this.sitio = sitio;
    }
    public CategoriaBase getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBase categoria) {
        this.categoria = categoria;
    }
    public PostBase getPost() {
        return post;
    }

    public void setPost(PostBase post) {
        this.post = post;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}