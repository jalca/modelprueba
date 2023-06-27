package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Table(name = "nivel_idiomas", catalog = GlobalConstantine.SCHEMA_CROACIA)
public class NivelIdiomasMy implements Serializable, Cloneable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_IDIOMA")
    private String idIdioma;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "FECHA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "IDIOMA")
    private String idioma;

    @Column(name = "MODALIDAD")
    private String modalidad;

    @Column(name = "APROBADO")
    private String aprobado;

    @Column(name = "GENERA_USER")
    private String generaUser;

    @Column(name = "GENERA_FECHA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date generaFecha;

    @Column(name = "NOTAS")
    private String notas;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "CARTA")
    private String carta;

    public NivelIdiomasMy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getGeneraUser() {
        return generaUser;
    }

    public void setGeneraUser(String generaUser) {
        this.generaUser = generaUser;
    }

    public Date getGeneraFecha() {
        return generaFecha;
    }

    public void setGeneraFecha(Date generaFecha) {
        this.generaFecha = generaFecha;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

}
