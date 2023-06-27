package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoPostulanteDocumentoEscuelaEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "epg_postulante_documento_escuela")
public class PostulanteDocumentoEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_documento")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaDocumento;

    @Column(name = "fecha_valida")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaValida;

    @Column(name = "fecha_observacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaObservacion;

    @Column(name = "fecha_anula")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAnula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_especialidad")
    private DocumentoEspecialidad documentoEspecialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_documento")
    private Archivo archivoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_documento")
    private Usuario userDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_valida")
    private Usuario userValida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_observacion")
    private Usuario userObservacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anula")
    private Usuario userAnula;

    @Transient
    private Integer observado;

    public PostulanteDocumentoEscuela() {
    }

    public PostulanteDocumentoEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoPostulanteDocumentoEscuelaEnum getEstadoEnum() {
        if (Strings.isNullOrEmpty(this.estado)) {
            return null;
        }
        return EstadoPostulanteDocumentoEscuelaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoPostulanteDocumentoEscuelaEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

}
