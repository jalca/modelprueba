package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
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
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.general.Aula;

@Entity
@Table(name = "sip_aula_examen")
public class AulaExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "capacidad_examen")
    private Integer capacidadExamen;

    @Column(name = "postulantes")
    private Integer postulantes;

    @Column(name = "planificados")
    private Integer planificados;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pabellon_examen")
    private PabellonExamen pabellonExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @OneToMany(mappedBy = "aulaExamen", fetch = FetchType.LAZY)
    private List<AgrupacionAulaExamen> agrupacionAulaExamen;

    public AulaExamen() {
    }

    public AulaExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidadExamen() {
        return capacidadExamen;
    }

    public void setCapacidadExamen(Integer capacidadExamen) {
        this.capacidadExamen = capacidadExamen;
    }

    public PabellonExamen getPabellonExamen() {
        return pabellonExamen;
    }

    public void setPabellonExamen(PabellonExamen pabellonExamen) {
        this.pabellonExamen = pabellonExamen;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public String getEstado() {
        return estado;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public Integer getPlanificados() {
        return planificados;
    }

    public void setPlanificados(Integer planificados) {
        this.planificados = planificados;
    }

    public List<AgrupacionAulaExamen> getAgrupacionAulaExamen() {
        return agrupacionAulaExamen;
    }

    public void setAgrupacionAulaExamen(List<AgrupacionAulaExamen> agrupacionAulaExamen) {
        this.agrupacionAulaExamen = agrupacionAulaExamen;
    }

}
