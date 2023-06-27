package pe.edu.lamolina.model.posgrado.admision;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "epg_documento_requisito_escuela")
public class DocumentoRequisitoEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "con_formato")
    private Boolean conFormato;

    @Column(name = "obligatorio_alumno_especial")
    private Boolean obligatorioAlumnoEspecial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_formato")
    private Archivo archivoFormato;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "documentoRequisitoEscuela", fetch = FetchType.LAZY)
    private List<DocumentoEspecialidad> documentoEspecialidad;

    @Transient
    private Integer cantidadEspecialidad;

    public DocumentoRequisitoEscuela() {
    }

    public DocumentoRequisitoEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getCantidadEspecialidad() {
        if (this.cantidadEspecialidad == null) {
            return 0;
        }
        return cantidadEspecialidad;
    }

}
