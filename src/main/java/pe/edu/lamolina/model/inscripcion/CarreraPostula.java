package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.vacantes.CarreraModalidadIngreso;
import pe.edu.lamolina.model.vacantes.VacanteCarrera;

@Entity
@Table(name = "sip_carrera_postula")
public class CarreraPostula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vacantes_base")
    private Integer vacantesBase;

    @Column(name = "vacantes_total")
    private Integer vacantesTotal;

    @Column(name = "referencia_vacantes")
    private String referenciaVacantes;

    @Column(name = "cifra_referencia")
    private Integer cifraReferencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @OneToMany(mappedBy = "carreraPostula", fetch = FetchType.LAZY)
    private List<OpcionCarrera> opcionCarrera;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<Prelamolina> prelamolina;

    @OneToMany(mappedBy = "carreraPostula", fetch = FetchType.LAZY)
    private List<CarreraModalidadIngreso> carreraModalidadIngreso;

    @OneToMany(mappedBy = "carreraPostula", fetch = FetchType.LAZY)
    private List<VacanteCarrera> vacanteCarrera;

    public CarreraPostula() {
    }

    public CarreraPostula(Object id) {
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getVacantesBase() {
        return vacantesBase;
    }

    public void setVacantesBase(Integer vacantesBase) {
        this.vacantesBase = vacantesBase;
    }

    public Integer getVacantesTotal() {
        return vacantesTotal;
    }

    public void setVacantesTotal(Integer vacantesTotal) {
        this.vacantesTotal = vacantesTotal;
    }

    public String getReferenciaVacantes() {
        return referenciaVacantes;
    }

    public void setReferenciaVacantes(String referenciaVacantes) {
        this.referenciaVacantes = referenciaVacantes;
    }

    public Integer getCifraReferencia() {
        return cifraReferencia;
    }

    public void setCifraReferencia(Integer cifraReferencia) {
        this.cifraReferencia = cifraReferencia;
    }

    public List<OpcionCarrera> getOpcionCarrera() {
        return opcionCarrera;
    }

    public void setOpcionCarrera(List<OpcionCarrera> opcionCarrera) {
        this.opcionCarrera = opcionCarrera;
    }

    public List<Prelamolina> getPrelamolina() {
        return prelamolina;
    }

    public void setPrelamolina(List<Prelamolina> prelamolina) {
        this.prelamolina = prelamolina;
    }

    public List<CarreraModalidadIngreso> getCarreraModalidadIngreso() {
        return carreraModalidadIngreso;
    }

    public void setCarreraModalidadIngreso(List<CarreraModalidadIngreso> carreraModalidadIngreso) {
        this.carreraModalidadIngreso = carreraModalidadIngreso;
    }

    public List<VacanteCarrera> getVacanteCarrera() {
        return vacanteCarrera;
    }

    public void setVacanteCarrera(List<VacanteCarrera> vacanteCarrera) {
        this.vacanteCarrera = vacanteCarrera;
    }

    public static class CompareCodigo implements Comparator<CarreraPostula> {

        @Override
        public int compare(CarreraPostula cp1, CarreraPostula cp2) {
            Carrera car1 = cp1.getCarrera();
            Carrera car2 = cp2.getCarrera();
            return car1.getCodigo().compareTo(car2.getCodigo());
        }
    }

}
