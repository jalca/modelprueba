package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CurriculaEstadoEnum;
import pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_curso_curricula")
public class CursoCurricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_ciclo")
    private Integer numeroCiclo;

    @Column(name = "numero_curso")
    private Integer numeroCurso;

    @NotNull
    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_requisito")
    private Integer creditosRequisito;

    @Column(name = "creditos_curricula_requisito")
    private Integer creditosCurriculaRequisito;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "requisitos_or")
    private Boolean requisitosOr;

    @Column(name = "creditos_requisito_or")
    private Boolean creditosRequisitosOr;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_curricular")
    private PlanCurricular planCurricular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_caduca")
    private Usuario userCaduca;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_caduca")
    private Date fechaCaduca;

    @OneToMany(mappedBy = "cursoCurricula", fetch = FetchType.LAZY)
    private List<RequisitoCursoCurricula> cursosCurricula;

    @OneToMany(mappedBy = "cursoRequisitoCurricula", fetch = FetchType.LAZY)
    private List<RequisitoCursoOpcional> requisitosCursoOpcional;

    @OneToMany(mappedBy = "cursoRequisito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RequisitoCursoCurricula> requisitosCursoCurricula;

    @OneToMany(mappedBy = "cursoCurricula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CursoEquivalente> cursosEquivalentes;

    public CursoCurricula() {
    }

    public CursoCurricula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanCurricular getPlanCurricular() {
        return planCurricular;
    }

    public void setPlanCurricular(PlanCurricular planCurricular) {
        this.planCurricular = planCurricular;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(TipoCursoCurricula tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

    public TipoCursoCurriculaEnum getTipoCursoCurriculaEnum() {

        return this.tipoCursoCurricula.getCodigoEnum();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(Integer numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public Integer getNumeroCurso() {
        return numeroCurso;
    }

    public void setNumeroCurso(Integer numeroCurso) {
        this.numeroCurso = numeroCurso;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCreditosRequisito() {
        if (creditosRequisito == null) {
            return 0;
        }
        return creditosRequisito;
    }

    public void setCreditosRequisito(Integer creditosRequisito) {
        this.creditosRequisito = creditosRequisito;
    }

    public Integer getCreditosCurriculaRequisito() {
        return creditosCurriculaRequisito;
    }

    public void setCreditosCurriculaRequisito(Integer creditosCurriculaRequisito) {
        this.creditosCurriculaRequisito = creditosCurriculaRequisito;
    }

    public List<RequisitoCursoCurricula> getCursosCurricula() {
        return cursosCurricula;
    }

    public void setCursosCurricula(List<RequisitoCursoCurricula> cursosCurricula) {
        this.cursosCurricula = cursosCurricula;
    }

    public List<RequisitoCursoCurricula> getRequisitosCursoCurricula() {
        return requisitosCursoCurricula;
    }

    public void setRequisitosCursoCurricula(List<RequisitoCursoCurricula> requisitosCursoCurricula) {
        this.requisitosCursoCurricula = requisitosCursoCurricula;
    }

    public List<RequisitoCursoOpcional> getRequisitosCursoOpcional() {
        return requisitosCursoOpcional;
    }

    public void setRequisitosCursoOpcional(List<RequisitoCursoOpcional> requisitosCursoOpcional) {
        this.requisitosCursoOpcional = requisitosCursoOpcional;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public List<CursoEquivalente> getCursosEquivalentes() {
        return cursosEquivalentes;
    }

    public Boolean getRequisitosOr() {
        if (requisitosOr == null) {
            return false;
        }
        return requisitosOr;
    }

    public String getEstado() {
        return estado;
    }

    public CurriculaEstadoEnum getEstadoEnum() {
        return CurriculaEstadoEnum.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRequisitosOr(Boolean requisitosOr) {
        this.requisitosOr = requisitosOr;
    }

    public void setCursosEquivalentes(List<CursoEquivalente> cursosEquivalentes) {
        this.cursosEquivalentes = cursosEquivalentes;
    }

    public Usuario getUserCaduca() {
        return userCaduca;
    }

    public void setUserCaduca(Usuario userCaduca) {
        this.userCaduca = userCaduca;
    }

    public Date getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(Date fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public Boolean getCreditosRequisitosOr() {
        if (creditosRequisitosOr == null) {
            return false;
        }
        return creditosRequisitosOr;
    }

    public void setCreditosRequisitosOr(Boolean creditosRequisitosOr) {
        this.creditosRequisitosOr = creditosRequisitosOr;
    }

    public static class CompareNombre implements Comparator<CursoCurricula> {

        @Override
        public int compare(CursoCurricula c1, CursoCurricula c2) {
            return c1.getCurso().getNombre().compareTo(c2.getCurso().getNombre());
        }
    }

    @Override
    public String toString() {
        if (curso == null) {
            return "";
        }
        return "CursoCurricula{" + "id=" + id + ", numeroCiclo=" + numeroCiclo + ", curso=" + ObjectUtil.getParent(curso, "id") + '}';
    }

}
