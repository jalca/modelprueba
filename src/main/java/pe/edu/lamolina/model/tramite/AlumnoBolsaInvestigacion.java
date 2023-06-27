package pe.edu.lamolina.model.tramite;

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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.AlumnoBolsaInvestigacionEstadoEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tram_alumno_bolsa_investigacion")
public class AlumnoBolsaInvestigacion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_investigacion")
    private String nombreInvestigacion;

    @Column(name = "estado")
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_subvencion")
    private TramiteSubvencion tramiteSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bolsa_investigacion")
    private BolsaInvestigacion bolsaInvestigacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private Colaborador supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    public AlumnoBolsaInvestigacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AlumnoBolsaInvestigacionEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return AlumnoBolsaInvestigacionEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(AlumnoBolsaInvestigacionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public boolean isTramiteAnulado() {
        if (estado == null) {
            return false;
        }
        return AlumnoBolsaInvestigacionEstadoEnum.ANU.name().equals(estado);
    }

    @Override
    public AlumnoBolsaInvestigacion clone() {
        AlumnoBolsaInvestigacion clone = null;
        try {
            clone = (AlumnoBolsaInvestigacion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
