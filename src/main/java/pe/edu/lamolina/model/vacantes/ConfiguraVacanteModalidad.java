package pe.edu.lamolina.model.vacantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import pe.edu.lamolina.model.enums.CicloAcademicoEstadoEnum;
import pe.edu.lamolina.model.inscripcion.CarreraPostula;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;
import static pe.edu.lamolina.model.vacantes.VacanteConstantine.BASE;
import static pe.edu.lamolina.model.vacantes.VacanteConstantine.ORDINARIO;

@Entity
@Table(name = "vac_configura_vacante_modalidad")
public class ConfiguraVacanteModalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vacantes_fija")
    private Integer vacantesFija;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "referencia_porcentaje")
    private String referenciaPorcentaje;

    @Column(name = "supernumerario")
    private Integer supernumerario;

    @Column(name = "por_carrera")
    private Integer porCarrera;

    @Column(name = "vacantes_total")
    private Integer vacantesTotal;

    @Column(name = "con_vacantes")
    private Integer conVacantes;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @Transient
    private List<CarreraModalidadIngreso> carreraModalidadIngreso;
    @Transient
    private Long[] carrera;

    public ConfiguraVacanteModalidad() {
    }

    public ConfiguraVacanteModalidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getSupernumerario() {
        return supernumerario;
    }

    public void setSupernumerario(Integer supernumerario) {
        this.supernumerario = supernumerario;
    }

    public Integer getPorCarrera() {
        return porCarrera;
    }

    public void setPorCarrera(Integer porCarrera) {
        this.porCarrera = porCarrera;
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

    public Integer getVacantesTotal() {
        return vacantesTotal;
    }

    public void setVacantesTotal(Integer vacantesTotal) {
        this.vacantesTotal = vacantesTotal;
    }

    public Integer getConVacantes() {
        return conVacantes;
    }

    public void setConVacantes(Integer conVacantes) {
        this.conVacantes = conVacantes;
    }

    public Integer getVacantesFija() {
        return vacantesFija;
    }

    public void setVacantesFija(Integer vacantesFija) {
        this.vacantesFija = vacantesFija;
    }

    public String getReferenciaPorcentaje() {
        return referenciaPorcentaje;
    }

    public void setReferenciaPorcentaje(String referenciaPorcentaje) {
        this.referenciaPorcentaje = referenciaPorcentaje;
    }

    public List<CarreraModalidadIngreso> getCarreraModalidadIngreso() {
        return carreraModalidadIngreso;
    }

    public void setCarreraModalidadIngreso(List<CarreraModalidadIngreso> carreraModalidadIngreso) {
        this.carreraModalidadIngreso = carreraModalidadIngreso;
    }

    public Long[] getCarrera() {
        return carrera;
    }

    public void setCarrera(Long[] carrera) {
        this.carrera = carrera;
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public CicloAcademicoEstadoEnum getEstadoEnum() {
        return CicloAcademicoEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(CicloAcademicoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getEstado() {
        return estado;
    }

    public String getCarreras() {
        String idCarreras = "";
        List<CarreraModalidadIngreso> carrerasModalidad = this.carreraModalidadIngreso;
        for (CarreraModalidadIngreso carr : carrerasModalidad) {
            idCarreras += idCarreras.equals("") ? "" : ",";
            idCarreras += carr.getCarreraPostula().getId();
        }
        return idCarreras;
    }

    public void setCarreras() {
        this.carreraModalidadIngreso = new ArrayList();
        if (this.carrera == null) {
            return;
        }

        for (Long idCarrera : this.carrera) {
            if (idCarrera == null) {
                continue;
            }
            CarreraModalidadIngreso carr = new CarreraModalidadIngreso();
            carr.setCarreraPostula(new CarreraPostula(idCarrera));
            this.carreraModalidadIngreso.add(carr);
        }

    }

    public String getTextSupernumerario() {
        if (this.supernumerario == 1) {
            return "s";
        }
        return "";
    }

    public String getTextReferenciaPorcentaje() {
        if (this.referenciaPorcentaje == null) {
            return "";
        }
        if (this.referenciaPorcentaje.equals(BASE)) {
            return "B";
        }
        if (this.referenciaPorcentaje.equals(ORDINARIO)) {
            return "CO";
        }
        return "";
    }

}
