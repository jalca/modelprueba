package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.CategoriaBienestar;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.FichaSocioeconomica;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "tram_tramite_recategorizacion")
public class TramiteRecategorizacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ficha_socioeconomica")
    private FichaSocioeconomica fichaSocioeconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_inicio")
    private CategoriaBienestar categoriaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_final")
    private CategoriaBienestar categoriaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public TramiteRecategorizacion() {
    }

    public TramiteRecategorizacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public FichaSocioeconomica getFichaSocioeconomica() {
        return fichaSocioeconomica;
    }

    public void setFichaSocioeconomica(FichaSocioeconomica fichaSocioeconomica) {
        this.fichaSocioeconomica = fichaSocioeconomica;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public CategoriaBienestar getCategoriaInicio() {
        return categoriaInicio;
    }

    public void setCategoriaInicio(CategoriaBienestar categoriaInicio) {
        this.categoriaInicio = categoriaInicio;
    }

    public CategoriaBienestar getCategoriaFinal() {
        return categoriaFinal;
    }

    public void setCategoriaFinal(CategoriaBienestar categoriaFinal) {
        this.categoriaFinal = categoriaFinal;
    }
}
