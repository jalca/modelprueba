package pe.edu.lamolina.model.cms;

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
@Table(catalog = "lamolina", name = "cms_bloque")
public class Bloque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "editable")
    private Boolean editable;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sitio")
    private Sitio sitio;

    public Bloque() {
    }

    public Bloque(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Bloque(Sitio sitio, RecursoPlantilla recurso) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
