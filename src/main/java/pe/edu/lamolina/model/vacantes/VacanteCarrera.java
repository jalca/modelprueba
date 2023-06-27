package pe.edu.lamolina.model.vacantes;

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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.inscripcion.CarreraPostula;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;

@Entity
@Table(name = "vac_vacante_carrera")
public class VacanteCarrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cupos")
    private Integer cupos;

    @Column(name = "asignadas")
    private Integer vacantesAsignadas;

    @Column(name = "anulados")
    private Integer anulados;

    @Column(name = "renunciantes")
    private Integer renunciantes;

    @Column(name = "sobrantes")
    private Integer sobrantes;

    @Column(name = "empates")
    private Integer empates;

    @Column(name = "adicionales")
    private Integer adicionales;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_postula")
    private CarreraPostula carreraPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @Transient
    private Long enviados;

    @Transient
    private Long inscritos;

    public VacanteCarrera() {
    }

    public VacanteCarrera(Long idCarreraPostula, Long enviados, Long inscritos) {
        this.carreraPostula = new CarreraPostula(idCarreraPostula);
        this.enviados = enviados;
        this.inscritos = inscritos;
    }

    public VacanteCarrera(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public CarreraPostula getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(CarreraPostula carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public String getCuposText() {
        if (this.cupos == null) {
            return " ";
        }
        return this.cupos + "";
    }

    public String getTipoCPRE() {
        if (!this.getTipoCiclo().equals("NINGUNO")) {

            return this.getModalidadIngreso().getId() + this.getTipoCiclo();
        }
        return this.getModalidadIngreso().getId().toString();
    }

    public Integer getVacantesAsignadas() {
        return vacantesAsignadas;
    }

    public void setVacantesAsignadas(Integer vacantesAsignadas) {
        this.vacantesAsignadas = vacantesAsignadas;
    }

    public Integer getAnulados() {
        return anulados;
    }

    public void setAnulados(Integer anulados) {
        this.anulados = anulados;
    }

    public Integer getRenunciantes() {
        return renunciantes;
    }

    public void setRenunciantes(Integer renunciantes) {
        this.renunciantes = renunciantes;
    }

    public Long getEnviados() {
        return enviados;
    }

    public void setEnviados(Long enviados) {
        this.enviados = enviados;
    }

    public Long getInscritos() {
        return inscritos;
    }

    public void setInscritos(Long inscritos) {
        this.inscritos = inscritos;
    }

    public Integer getSobrantes() {
        return sobrantes;
    }

    public void setSobrantes(Integer sobrantes) {
        this.sobrantes = sobrantes;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(Integer adicionales) {
        this.adicionales = adicionales;
    }

}
