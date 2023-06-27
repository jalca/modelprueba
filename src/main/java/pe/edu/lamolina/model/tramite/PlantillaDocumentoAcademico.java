package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.enums.TipoPlantillaDocumentoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Idioma;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Getter
@Setter
@Table(name = "tram_plantilla_documento_academico")
public class PlantillaDocumentoAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_academico")
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @OneToMany(mappedBy = "plantillaDocumentoAcademico", fetch = FetchType.LAZY)
    private List<VariablePlantilla> variablePlantilla;

    public PlantillaDocumentoAcademico() {
    }

    public PlantillaDocumentoAcademico(Long id) {
        this.id = id;
    }

    public PlantillaDocumentoAcademico(Long id, String contenido, Usuario userRegistro, Date fechaRegistro, TipoDocumentoAcademico tipoDocumentoAcademico, Idioma idioma) {
        this.id = id;
        this.contenido = contenido;
        this.userRegistro = userRegistro;
        this.fechaRegistro = fechaRegistro;
        this.tipoDocumentoAcademico = tipoDocumentoAcademico;
        this.idioma = idioma;
    }

    public TipoPlantillaDocumentoEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoPlantillaDocumentoEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoPlantillaDocumentoEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }


}
