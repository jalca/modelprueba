package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_curso_opcional_curricula")
public class CursoOpcionalCurricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_requisito")
    private Integer creditosRequisito;

    @Column(name = "creditos_curricula_requisito")
    private Integer creditosCurriculaRequisito;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "requisitos_or")
    private Boolean requisitosOr;

    @Column(name = "creditos_requisito_or")
    private Boolean creditosRequisitosOr;

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

    @OneToMany(mappedBy = "cursoOpcional", fetch = FetchType.LAZY)
    private List<RequisitoCursoOpcional> cursosOpcionales;

    @OneToMany(mappedBy = "cursoRequisitoOpcional", fetch = FetchType.LAZY)
    private List<RequisitoCursoOpcional> requisitosCursoOpcionales;

    @OneToMany(mappedBy = "cursoOpcionalCurricula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CursoEquivalenteElectivo> cursoEquivalenteElectivo;

    public CursoOpcionalCurricula() {
    }

    public CursoOpcionalCurricula(Object id) {
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCreditosRequisito() {
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

    public List<RequisitoCursoOpcional> getCursosOpcionales() {
        return cursosOpcionales;
    }

    public void setCursosOpcionales(List<RequisitoCursoOpcional> cursosOpcionales) {
        this.cursosOpcionales = cursosOpcionales;
    }

    public List<RequisitoCursoOpcional> getRequisitosCursoOpcionales() {
        return requisitosCursoOpcionales;
    }

    public void setRequisitosCursoOpcionales(List<RequisitoCursoOpcional> requisitosCursoOpcionales) {
        this.requisitosCursoOpcionales = requisitosCursoOpcionales;
    }

    public List<CursoEquivalenteElectivo> getCursoEquivalenteElectivo() {
        return cursoEquivalenteElectivo;
    }

    public void setCursoEquivalenteElectivo(List<CursoEquivalenteElectivo> cursoEquivalenteElectivo) {
        this.cursoEquivalenteElectivo = cursoEquivalenteElectivo;
    }

    public Boolean getRequisitosOr() {
        if (requisitosOr == null) {
            return false;
        }
        return requisitosOr;
    }

    public void setRequisitosOr(Boolean requisitosOr) {
        this.requisitosOr = requisitosOr;
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

}
