package pe.edu.lamolina.model.calificacion;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;

@Entity
@Table(name = "sce_info_vacante_modalidad")
public class InfoVacanteModalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "devuelve_vacantes")
    private Integer devuelveVacantes;

    @Column(name = "porcentaje_aumento_nota")
    private Integer porcentajeAumentoNota;

    @Column(name = "control_nota_minima_ordinario")
    private Integer controlNotaMinimaOrdinario;

    @Column(name = "nota_minima")
    private BigDecimal notaMinima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @Transient
    private Integer rindeExamenAdmision;

    @Transient
    private Integer orden;

    @Transient
    private Integer cantidadOpciones;

    public InfoVacanteModalidad() {
    }

    public InfoVacanteModalidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDevuelveVacantes() {
        return devuelveVacantes;
    }

    public void setDevuelveVacantes(Integer devuelveVacantes) {
        this.devuelveVacantes = devuelveVacantes;
    }

    public Integer getPorcentajeAumentoNota() {
        return porcentajeAumentoNota;
    }

    public void setPorcentajeAumentoNota(Integer porcentajeAumentoNota) {
        this.porcentajeAumentoNota = porcentajeAumentoNota;
    }

    public Integer getControlNotaMinimaOrdinario() {
        return controlNotaMinimaOrdinario;
    }

    public void setControlNotaMinimaOrdinario(Integer controlNotaMinimaOrdinario) {
        this.controlNotaMinimaOrdinario = controlNotaMinimaOrdinario;
    }

    public BigDecimal getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(BigDecimal notaMinima) {
        this.notaMinima = notaMinima;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public Integer getRindeExamenAdmision() {
        return rindeExamenAdmision;
    }

    public void setRindeExamenAdmision(Integer rindeExamenAdmision) {
        this.rindeExamenAdmision = rindeExamenAdmision;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getCantidadOpciones() {
        return cantidadOpciones;
    }

    public void setCantidadOpciones(Integer cantidadOpciones) {
        this.cantidadOpciones = cantidadOpciones;
    }

}
