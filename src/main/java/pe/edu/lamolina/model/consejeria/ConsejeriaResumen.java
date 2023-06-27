package pe.edu.lamolina.model.consejeria;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_consejeria_resumen")
public class ConsejeriaResumen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "consejeros_activos")
    private Integer consejerosActivos;

    @Column(name = "consejeros_inactivos")
    private Integer consejerosInactivos;

    @Column(name = "aconsejados_activos")
    private Integer aconsejadosActivos;

    @Column(name = "aconsejados_inactivos")
    private Integer aconsejadosInactivos;

    @Column(name = "sinconsejero_activos")
    private Integer sinconsejeroActivos;

    @Column(name = "sinconsejero_inactivos")
    private Integer sinconsejeroInactivos;

    @Column(name = "inhabilitados")
    private Integer inhabilitados;

    @Column(name = "fecha_actualizacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    public ConsejeriaResumen() {
        this.consejerosActivos = 0;
        this.consejerosInactivos = 0;
        this.aconsejadosActivos = 0;
        this.aconsejadosInactivos = 0;
        this.sinconsejeroInactivos = 0;
        this.sinconsejeroActivos = 0;
        this.inhabilitados = 0;
    }

    public ConsejeriaResumen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConsejerosActivos() {
        return consejerosActivos;
    }

    public void setConsejerosActivos(Integer consejerosActivos) {
        this.consejerosActivos = consejerosActivos;
    }

    public Integer getConsejerosInactivos() {
        return consejerosInactivos;
    }

    public void setConsejerosInactivos(Integer consejerosInactivos) {
        this.consejerosInactivos = consejerosInactivos;
    }

    public Integer getAconsejadosActivos() {
        return aconsejadosActivos;
    }

    public void setAconsejadosActivos(Integer aconsejadosActivos) {
        this.aconsejadosActivos = aconsejadosActivos;
    }

    public Integer getAconsejadosInactivos() {
        return aconsejadosInactivos;
    }

    public void setAconsejadosInactivos(Integer aconsejadosInactivos) {
        this.aconsejadosInactivos = aconsejadosInactivos;
    }

    public Integer getSinconsejeroActivos() {
        return sinconsejeroActivos;
    }

    public void setSinconsejeroActivos(Integer sinconsejeroActivos) {
        this.sinconsejeroActivos = sinconsejeroActivos;
    }

    public Integer getSinconsejeroInactivos() {
        return sinconsejeroInactivos;
    }

    public void setSinconsejeroInactivos(Integer sinconsejeroInactivos) {
        this.sinconsejeroInactivos = sinconsejeroInactivos;
    }

    public Integer getInhabilitados() {
        return inhabilitados;
    }

    public void setInhabilitados(Integer inhabilitados) {
        this.inhabilitados = inhabilitados;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

}
