package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.AprobacionComiteConsejeroEstadoEnum;
import pe.edu.lamolina.model.graduacion.MiembroComiteConsejero;

@Entity
@Table(name = "epg_aprobacion_comite_consejero")
public class AprobacionComiteConsejero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_alumno_plan_estudio")
    private AlumnoPlanEstudios alumnoPlanEstudios;

    @JoinColumn(name = "id_miembro_comite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MiembroComiteConsejero miembroComiteConsejero;

    public AprobacionComiteConsejero() {
    }

    public AprobacionComiteConsejero(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoPlanEstudios getAlumnoPlanEstudios() {
        return alumnoPlanEstudios;
    }

    public void setAlumnoPlanEstudios(AlumnoPlanEstudios alumnoPlanEstudios) {
        this.alumnoPlanEstudios = alumnoPlanEstudios;
    }

    public MiembroComiteConsejero getMiembroComiteConsejero() {
        return miembroComiteConsejero;
    }

    public void setMiembroComiteConsejero(MiembroComiteConsejero miembroComiteConsejero) {
        this.miembroComiteConsejero = miembroComiteConsejero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(AprobacionComiteConsejeroEstadoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public AprobacionComiteConsejeroEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(this.estado)) {
            return null;
        }
        return AprobacionComiteConsejeroEstadoEnum.valueOf(this.estado);
    }

}
