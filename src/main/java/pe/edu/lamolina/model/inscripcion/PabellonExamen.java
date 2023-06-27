package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Puerta;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_pabellon_examen")
public class PabellonExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "capacidad_aulas")
    private Integer capacidadAulas;

    @Column(name = "capacidad_examen")
    private Integer capacidadExamen;

    @Column(name = "aulas")
    private Integer aulas;

    @Column(name = "aulas_planificadas")
    private Integer aulasPlanificadas;

    @Column(name = "postulantes")
    private Integer postulantes;

    @Column(name = "planificados")
    private Integer planificados;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_agrupaciones_modalidades")
    private String agrupaciones;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pabellon")
    private Aula pabellon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_puerta")
    private Puerta puerta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuario;

    @OneToMany(mappedBy = "pabellonExamen", fetch = FetchType.LAZY)
    private List<AulaExamen> aulasExamen;

    public PabellonExamen() {
    }

    public PabellonExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Aula getPabellon() {
        return pabellon;
    }

    public void setPabellon(Aula pabellon) {
        this.pabellon = pabellon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCapacidadAulas() {
        return capacidadAulas;
    }

    public void setCapacidadAulas(Integer capacidadAulas) {
        this.capacidadAulas = capacidadAulas;
    }

    public Integer getCapacidadExamen() {
        return capacidadExamen;
    }

    public void setCapacidadExamen(Integer capacidadExamen) {
        this.capacidadExamen = capacidadExamen;
    }

    public Integer getAulas() {
        return aulas;
    }

    public void setAulas(Integer aulas) {
        this.aulas = aulas;
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

    public String getAgrupaciones() {
        return agrupaciones;
    }

    public void setAgrupaciones(String agrupaciones) {
        this.agrupaciones = agrupaciones;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public Integer getPlanificados() {
        return planificados;
    }

    public void setPlanificados(Integer planificados) {
        this.planificados = planificados;
    }

    public Integer getAulasPlanificadas() {
        return aulasPlanificadas;
    }

    public void setAulasPlanificadas(Integer aulasPlanificadas) {
        this.aulasPlanificadas = aulasPlanificadas;
    }

    public List<AulaExamen> getAulasExamen() {
        return aulasExamen;
    }

    public void setAulasExamen(List<AulaExamen> aulasExamen) {
        this.aulasExamen = aulasExamen;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

}
