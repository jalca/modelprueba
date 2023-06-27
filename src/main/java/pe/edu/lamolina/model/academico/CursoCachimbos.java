package pe.edu.lamolina.model.academico;

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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "aca_curso_cachimbos")
public class CursoCachimbos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "horarios")
    private Integer horarios;

    @Column(name = "claves")
    private Integer claves;

    @Column(name = "id_user_creacion")
    private Long idUserCreacion;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Transient
    private Integer demanda;
    @Transient
    private Integer oferta;
    @Transient
    private Integer demandaTotal;
    @Transient
    private Integer ofertaTotal;

    public CursoCachimbos() {
    }

    public CursoCachimbos(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getHorarios() {
        return horarios;
    }

    public void setHorarios(Integer horarios) {
        this.horarios = horarios;
    }

    public Integer getClaves() {
        return claves;
    }

    public void setClaves(Integer claves) {
        this.claves = claves;
    }

    public Long getIdUserCreacion() {
        return idUserCreacion;
    }

    public void setIdUserCreacion(Long idUserCreacion) {
        this.idUserCreacion = idUserCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getDemanda() {
        return demanda;
    }

    public void setDemanda(Integer demanda) {
        this.demanda = demanda;
    }

    public Integer getOferta() {
        return oferta;
    }

    public void setOferta(Integer oferta) {
        this.oferta = oferta;
    }

    public Integer getDemandaTotal() {
        return demandaTotal;
    }

    public void setDemandaTotal(Integer demandaTotal) {
        this.demandaTotal = demandaTotal;
    }

    public Integer getOfertaTotal() {
        return ofertaTotal;
    }

    public void setOfertaTotal(Integer ofertaTotal) {
        this.ofertaTotal = ofertaTotal;
    }

    public String getCursoCarrera() {
        String cad = this.curso.getId() + "-";
        cad += this.carrera.getId();
        return cad;
    }
}
