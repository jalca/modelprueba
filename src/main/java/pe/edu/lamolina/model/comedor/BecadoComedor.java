package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoBecaComedorEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.TramiteSubvencion;

@Getter
@Setter
@Entity
@Table(name = "com_becado_comedor")
public class BecadoComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_anulado")
    private String motivoAnulado;

    @Column(name = "inasistencias_preavisadas")
    private Integer inasistenciasPreavisadas;

    @Column(name = "inasistencias_justificadas")
    private Integer inasistenciasJustificadas;

    @Column(name = "inasistencias_injustificadas")
    private Integer inasistenciasInjustificadas;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio_comedor")
    private TipoServicioComedor tipoServicioComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_subvencion")
    private TramiteSubvencion tramiteSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    public BecadoComedor() {
    }

    public BecadoComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoBecaComedorEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoBecaComedorEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoBecaComedorEnum.valueOf(estado);
    }

    public String getKeyAlumnoServicio() {
        if (this.alumno == null) {
            return null;
        }
        if (this.tipoServicioComedor == null) {
            return null;
        }

        return alumno.getId() + "-" + this.tipoServicioComedor.getId();
    }
}
