package pe.edu.lamolina.model.escalafon;

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
import pe.edu.lamolina.model.general.Idioma;

@Entity
@Table(catalog = "lamolina", name = "esc_idioma_escalafon")
public class IdiomaEscalafon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "idioma_otro")
    private String idiomaOtro;
    
    @Column(name = "lectura")
    private String lectura;
    
    @Column(name = "conversacion")
    private String conversacion;
    
    @Column(name = "escritura")
    private String escritura;
    
    @Column(name = "lengua_materna")
    private Boolean lenguaMaterna;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_escalafon")
    private Escalafon escalafon;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    public IdiomaEscalafon() {}

    public IdiomaEscalafon(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getIdiomaOtro() {
        return idiomaOtro;
    }

    public void setIdiomaOtro(String idiomaOtro) {
        this.idiomaOtro = idiomaOtro;
    }
    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }
    public String getConversacion() {
        return conversacion;
    }

    public void setConversacion(String conversacion) {
        this.conversacion = conversacion;
    }
    public String getEscritura() {
        return escritura;
    }

    public void setEscritura(String escritura) {
        this.escritura = escritura;
    }
    public Boolean getLenguaMaterna() {
        return lenguaMaterna;
    }

    public void setLenguaMaterna(Boolean lenguaMaterna) {
        this.lenguaMaterna = lenguaMaterna;
    }
    public Escalafon getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Escalafon escalafon) {
        this.escalafon = escalafon;
    }
    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}