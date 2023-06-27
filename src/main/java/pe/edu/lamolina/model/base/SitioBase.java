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
import pe.edu.lamolina.model.general.Oficina;

@Entity
@Table(catalog = "lamolina", name = "base_sitio_base")
public class SitioBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen_cabecera")
    private String imagenCabecera;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cabecera")
    private String cabecera;

    @Column(name = "icono")
    private String icono;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "visible_autenticado")
    private Boolean visibleAutenticado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    public SitioBase() {
    }

    public SitioBase(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagenCabecera() {
        return imagenCabecera;
    }

    public void setImagenCabecera(String imagenCabecera) {
        this.imagenCabecera = imagenCabecera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public Boolean getVisibleAutenticado() {
        return visibleAutenticado;
    }

    public void setVisibleAutenticado(Boolean visibleAutenticado) {
        this.visibleAutenticado = visibleAutenticado;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
