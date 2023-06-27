package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "med_odonto_hallazgo")
public class OdontoHallazgo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "veces")
    private Long veces;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "superior")
    private OdontoHallazgo superior;

    @Column(name = "boton_imagen")
    private String botonImagen;

    @Column(name = "color_trazo")
    private String colorTrazo;

    @Column(name = "requiere_trazo")
    private Boolean requiereTrazo;

    @Column(name = "requiere_ambos")
    private Boolean requiereAmbos;

    @Transient
    private List<OdontoHallazgo> subLista;

    @Transient
    private Boolean seleccion = Boolean.FALSE;

    @Transient
    private Boolean tieneSubLista = Boolean.FALSE;

    @Transient
    private Integer columna = 1;

    public OdontoHallazgo() {
    }

    public OdontoHallazgo(Object id) {
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

    public OdontoHallazgo getSuperior() {
        return superior;
    }

    public void setSuperior(OdontoHallazgo superior) {
        this.superior = superior;
    }

    public String getBotonImagen() {
        return botonImagen;
    }

    public void setBotonImagen(String botonImagen) {
        this.botonImagen = botonImagen;
    }

    public Boolean getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Boolean seleccion) {
        this.seleccion = seleccion;
    }

    public List<OdontoHallazgo> getSubLista() {
        return subLista;
    }

    public void setSubLista(List<OdontoHallazgo> subLista) {
        this.subLista = subLista;
    }

    public Boolean getTieneSubLista() {
        return tieneSubLista;
    }

    public void setTieneSubLista(Boolean tieneSubLista) {
        this.tieneSubLista = tieneSubLista;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public Boolean getRequiereTrazo() {
        return requiereTrazo;
    }

    public void setRequiereTrazo(Boolean requiereTrazo) {
        this.requiereTrazo = requiereTrazo;
    }

    public String getColorTrazo() {
        return colorTrazo;
    }

    public void setColorTrazo(String colorTrazo) {
        this.colorTrazo = colorTrazo;
    }

    public Boolean getRequiereAmbos() {
        return requiereAmbos;
    }

    public void setRequiereAmbos(Boolean requiereAmbos) {
        this.requiereAmbos = requiereAmbos;
    }

    public Long getVeces() {
        return veces;
    }

    public void setVeces(Long veces) {
        this.veces = veces;
    }
}
