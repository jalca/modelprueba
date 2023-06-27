package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.TemporalType;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.enums.NivelIdiomaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "gen_persona_idioma")
public class PersonaIdioma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "es_materno")
    private Boolean esMaterno;

    @Column(name = "nivel_lectura")
    private String nivelLectura;

    @Column(name = "nivel_escritura")
    private String nivelEscritura;

    @Column(name = "nivel_conversacion")
    private String nivelConversacion;

    @Column(name = "otro_idioma")
    private String otroIdioma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEsMaterno() {
        return esMaterno;
    }

    public void setEsMaterno(Boolean esMaterno) {
        this.esMaterno = esMaterno;
    }

    public String getNivelLectura() {
        return nivelLectura;
    }

    public NivelIdiomaEnum getNivelLecturaEnum() {
        if (StringUtils.isBlank(nivelLectura)) {
            return null;
        }
        return NivelIdiomaEnum.valueOf(nivelLectura);
    }

    public void setNivelLectura(String nivelLectura) {
        this.nivelLectura = nivelLectura;
    }

    public String getNivelEscritura() {
        return nivelEscritura;
    }

    public NivelIdiomaEnum getNivelEscrituraEnum() {
        if (StringUtils.isBlank(nivelEscritura)) {
            return null;
        }
        return NivelIdiomaEnum.valueOf(nivelEscritura);
    }

    public void setNivelEscritura(String nivelEscritura) {
        this.nivelEscritura = nivelEscritura;
    }

    public String getNivelConversacion() {
        return nivelConversacion;
    }

    public NivelIdiomaEnum getNivelConversacionEnum() {
        if (StringUtils.isBlank(nivelConversacion)) {
            return null;
        }
        return NivelIdiomaEnum.valueOf(nivelConversacion);
    }

    public void setNivelConversacion(String nivelConversacion) {
        this.nivelConversacion = nivelConversacion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getOtroIdioma() {
        return otroIdioma;
    }

    public void setOtroIdioma(String otroIdioma) {
        this.otroIdioma = otroIdioma;
    }

}
