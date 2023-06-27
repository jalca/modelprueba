package pe.edu.lamolina.model.posgrado.admision;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_documento_especialidad")
public class DocumentoEspecialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private CarreraEscuela carreraEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_requisito_escuela")
    private DocumentoRequisitoEscuela documentoRequisitoEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;
   
    public DocumentoEspecialidad() {
    }

    public DocumentoEspecialidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CarreraEscuela getCarreraEscuela() {
        return carreraEscuela;
    }

    public void setCarreraEscuela(CarreraEscuela carreraEscuela) {
        this.carreraEscuela = carreraEscuela;
    }

    public DocumentoRequisitoEscuela getDocumentoRequisitoEscuela() {
        return documentoRequisitoEscuela;
    }

    public void setDocumentoRequisitoEscuela(DocumentoRequisitoEscuela documentoRequisitoEscuela) {
        this.documentoRequisitoEscuela = documentoRequisitoEscuela;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

}
