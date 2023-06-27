package pe.edu.lamolina.model.finanzas;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.inscripcion.CarreraPostula;

@Entity
@Table(name = "sip_solicitud_cambio_carrera")
public class SolicitudCambioCarrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "es_anterior")
    private Integer esAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud_cambio_info")
    private SolicitudCambioInfo solicitudCambioInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_postula")
    private CarreraPostula carreraPostula;

    public SolicitudCambioCarrera() {
    }

    public SolicitudCambioCarrera(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public SolicitudCambioInfo getSolicitudCambioInfo() {
        return solicitudCambioInfo;
    }

    public void setSolicitudCambioInfo(SolicitudCambioInfo solicitudCambioInfo) {
        this.solicitudCambioInfo = solicitudCambioInfo;
    }

    public CarreraPostula getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(CarreraPostula carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    public Integer getEsAnterior() {
        return esAnterior;
    }

    public void setEsAnterior(Integer esAnterior) {
        this.esAnterior = esAnterior;
    }

}
