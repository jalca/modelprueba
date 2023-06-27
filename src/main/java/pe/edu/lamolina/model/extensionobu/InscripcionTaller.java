package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "extn_inscripcion_taller")
public class InscripcionTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "con_boleta_pago")
    private Boolean conBoletaPago;

    @Column(name = "estado")
    private String estado;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "cuota_inicial")
    private BigDecimal cuotaInicial;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_preinscripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPreinscripcion;

    @Column(name = "fecha_inscripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    @Column(name = "fecha_modifica")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller_ciclo")
    private TallerCiclo tallerCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_preinscripcion")
    private Usuario usuarioPreinscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inscripcion")
    private Usuario usuarioInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario usuarioModifica;
    
    public InscripcionTaller(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        estado = estadoEnum.name();
    }
}
