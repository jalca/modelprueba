package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.util.Comparator;
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
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_requisito_curso_opcional")
public class RequisitoCursoOpcional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "simultaneo")
    private Integer simultaneo;

    @Column(name = "requisito_obligatorio")
    private Boolean requisitosObligatorio;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)//requisito 
    @JoinColumn(name = "id_curso_requisito_curricula")
    private CursoCurricula cursoRequisitoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_requisito_opcional") //requisito 
    private CursoOpcionalCurricula cursoRequisitoOpcional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_opcional") //principal
    private CursoOpcionalCurricula cursoOpcional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public RequisitoCursoOpcional() {
    }

    public RequisitoCursoOpcional(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Curso getCursoRequisito() {
        if (cursoRequisitoCurricula != null) {
            return cursoRequisitoCurricula.getCurso();
        }
        if (cursoRequisitoOpcional != null) {
            return cursoRequisitoOpcional.getCurso();
        }
        return null;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        if (cursoRequisitoCurricula != null) {
            return cursoRequisitoCurricula.getTipoCursoCurricula();
        }
        if (cursoRequisitoOpcional != null) {
            return cursoRequisitoOpcional.getTipoCursoCurricula();
        }
        return null;
    }

    public Integer getNumeroCiclo() {
        if (cursoRequisitoCurricula != null) {
            return cursoRequisitoCurricula.getNumeroCiclo();
        }
        return null;
    }

    public String getNumeroRomano() {
        if (cursoRequisitoCurricula != null) {
            return NumberFormat.roman(cursoRequisitoCurricula.getNumeroCiclo());
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSimultaneo() {
        return simultaneo;
    }

    public void setSimultaneo(Integer simultaneo) {
        this.simultaneo = simultaneo;
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

    public CursoCurricula getCursoRequisitoCurricula() {
        return cursoRequisitoCurricula;
    }

    public void setCursoRequisitoCurricula(CursoCurricula cursoRequisitoCurricula) {
        this.cursoRequisitoCurricula = cursoRequisitoCurricula;
    }

    public CursoOpcionalCurricula getCursoRequisitoOpcional() {
        return cursoRequisitoOpcional;
    }

    public void setCursoRequisitoOpcional(CursoOpcionalCurricula cursoRequisitoOpcional) {
        this.cursoRequisitoOpcional = cursoRequisitoOpcional;
    }

    public CursoOpcionalCurricula getCursoOpcional() {
        return cursoOpcional;
    }

    public void setCursoOpcional(CursoOpcionalCurricula cursoOpcional) {
        this.cursoOpcional = cursoOpcional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Boolean getRequisitosObligatorio() {
        if (requisitosObligatorio == null) {
            return false;
        }
        return requisitosObligatorio;
    }

    public void setRequisitosObligatorio(Boolean requisitosObligatorio) {
        this.requisitosObligatorio = requisitosObligatorio;
    }

    public static class CompareNombre implements Comparator<RequisitoCursoOpcional> {

        @Override
        public int compare(RequisitoCursoOpcional c1, RequisitoCursoOpcional c2) {
            return c1.getCursoRequisito().getNombre().compareTo(c2.getCursoRequisito().getNombre());
        }
    }

}
