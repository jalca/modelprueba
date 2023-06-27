package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoCurriculaEnum;
import pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum;
import static pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum.EEP;
import static pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum.ELC;
import static pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum.ELE;
import static pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum.GEN;
import static pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum.OBL;

@Entity
@Table(name = "aca_tipo_curso_curricula")
public class TipoCursoCurricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "orden_proceso")
    private Integer ordenProceso;

    @Column(name = "config_creditos_manual")
    private Integer configCreditosManual;

    @OneToMany(mappedBy = "tipoCursoCurricula", fetch = FetchType.LAZY)
    private List<CursoCurricula> cursoCurricula;

    @OneToMany(mappedBy = "tipoCursoCurricula", fetch = FetchType.LAZY)
    private List<CursoOpcionalCurricula> cursoOpcionalCurricula;

    @OneToMany(mappedBy = "tipoCursoCurricula", fetch = FetchType.LAZY)
    private List<ResumenPlanCurricular> resumenPlanCurricular;

    public TipoCursoCurricula() {
    }

    public TipoCursoCurricula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoCursoCurriculaEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoCursoCurriculaEnum.valueOf(codigo);
    }

    public void setCodigo(TipoCursoCurriculaEnum codigo) {
        this.codigo = codigo.name();
    }

    public List<CursoCurricula> getCursoCurricula() {
        return cursoCurricula;
    }

    public void setCursoCurricula(List<CursoCurricula> cursoCurricula) {
        this.cursoCurricula = cursoCurricula;
    }

    public List<CursoOpcionalCurricula> getCursoOpcionalCurricula() {
        return cursoOpcionalCurricula;
    }

    public void setCursoOpcionalCurricula(List<CursoOpcionalCurricula> cursoOpcionalCurricula) {
        this.cursoOpcionalCurricula = cursoOpcionalCurricula;
    }

    public List<ResumenPlanCurricular> getResumenPlanCurricular() {
        return resumenPlanCurricular;
    }

    public void setResumenPlanCurricular(List<ResumenPlanCurricular> resumenPlanCurricular) {
        this.resumenPlanCurricular = resumenPlanCurricular;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getOrdenProceso() {
        return ordenProceso;
    }

    public void setOrdenProceso(Integer ordenProceso) {
        this.ordenProceso = ordenProceso;
    }

    public Integer getConfigCreditosManual() {
        return configCreditosManual;
    }

    public void setConfigCreditosManual(Integer configCreditosManual) {
        this.configCreditosManual = configCreditosManual;
    }

    public boolean isTieneRequisitos() {
        if (TipoCursoCurriculaEnum.OBL.name().equals(this.getCodigo())
                || TipoCursoCurriculaEnum.GEN.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isTieneCreditoManual() {
        if (this.configCreditosManual == null) {
            return false;
        }

        return (this.configCreditosManual == 1);
    }

    public boolean getIsObligatorio() {
        if (TipoCursoCurriculaEnum.OBL.equals(this.getCodigoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsGeneral() {
        if (TipoCursoCurriculaEnum.GEN.equals(this.getCodigoEnum())) {
            return true;
        }
        return false;
    }

    public List<TipoCurriculaEnum> getTiposCursoCurricula() {
        List<TipoCurriculaEnum> tiposCurricula = null;
        if (Arrays.asList(GEN, OBL).contains(this.getCodigoEnum())) {
            tiposCurricula = new ArrayList();
            tiposCurricula.add(TipoCurriculaEnum.ADIC);
            tiposCurricula.add(TipoCurriculaEnum.REG);
        }

        if (Arrays.asList(ELC, ELE, EEP).contains(this.getCodigoEnum())) {
            tiposCurricula = new ArrayList();
            tiposCurricula.add(TipoCurriculaEnum.COMD);
        }
        return tiposCurricula;
    }

}
