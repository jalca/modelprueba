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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "gen_persona_historial")
public class PersonaHistorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "numero_documento_from")
    private String numeroDocumentoFrom;

    @Column(name = "numero_documento_to")
    private String numeroDocumentoTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_from")
    private TipoDocIdentidad tipoDocumentoFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_to")
    private TipoDocIdentidad tipoDocumentoTo;

    public PersonaHistorial() {

    }

    public PersonaHistorial(Long id) {
        this.id = id;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDocumentoFrom() {
        return numeroDocumentoFrom;
    }

    public void setNumeroDocumentoFrom(String numeroDocumentoFrom) {
        this.numeroDocumentoFrom = numeroDocumentoFrom;
    }

    public String getNumeroDocumentoTo() {
        return numeroDocumentoTo;
    }

    public void setNumeroDocumentoTo(String numeroDocumentoTo) {
        this.numeroDocumentoTo = numeroDocumentoTo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDocIdentidad getTipoDocumentoFrom() {
        return tipoDocumentoFrom;
    }

    public void setTipoDocumentoFrom(TipoDocIdentidad tipoDocumentoFrom) {
        this.tipoDocumentoFrom = tipoDocumentoFrom;
    }

    public TipoDocIdentidad getTipoDocumentoTo() {
        return tipoDocumentoTo;
    }

    public void setTipoDocumentoTo(TipoDocIdentidad tipoDocumentoTo) {
        this.tipoDocumentoTo = tipoDocumentoTo;
    }

}
