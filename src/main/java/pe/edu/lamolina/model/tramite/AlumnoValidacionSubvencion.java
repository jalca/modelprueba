package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import pe.edu.lamolina.model.bienestar.AlumnoSubvencionado;
import pe.edu.lamolina.model.enums.CumplimientoValidacionEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_alumno_validacion_subvencion")
public class AlumnoValidacionSubvencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "auditable")
    private Boolean auditable;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion_nocumple")
    private String descripcionNocumple;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_subvencionado")
    private AlumnoSubvencionado alumnoSubvencionado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caso_social")
    private CasoSocial casoSocial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_validacion_subvencion")
    private ValidacionSubvencion validacionSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_nocumple")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaNocumple;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Transient
    private Boolean bloqueado;

    public AlumnoValidacionSubvencion() {
    }

    public AlumnoValidacionSubvencion(Long id) {
        this.id = id;
    }

    public CumplimientoValidacionEstadoEnum getEstadoEnum() {
        return CumplimientoValidacionEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(CumplimientoValidacionEstadoEnum cumplimiento) {
        this.estado = cumplimiento.name();
    }

}
