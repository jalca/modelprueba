package pe.edu.lamolina.model.graduacion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_asesor_sugerido")
public class AsesorSugerido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comite_consejero")
    private ComiteConsejero comiteConsejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @Column(name = "id_user_registro")
    private Long usuarioRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Transient
    List<Docente> asesores;

    public AsesorSugerido() {
    }

    public AsesorSugerido(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComiteConsejero getComiteConsejero() {
        return comiteConsejero;
    }

    public void setComiteConsejero(ComiteConsejero comiteConsejero) {
        this.comiteConsejero = comiteConsejero;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Long usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Docente> getAsesores() {
        return asesores;
    }

    public void setAsesores(List<Docente> asesores) {
        this.asesores = asesores;
    }

}
