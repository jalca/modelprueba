package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.SituacionAcademicaEnum;

@Entity
@Table(name = "aca_situacion_academica")
public class SituacionAcademica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "situacionAcademica", fetch = FetchType.LAZY)
    private List<Alumno> alumno;

    @OneToMany(mappedBy = "situacionInicio", fetch = FetchType.LAZY)
    private List<AlumnoCiclo> alumnoCiclo;

    @OneToMany(mappedBy = "situacionFinal", fetch = FetchType.LAZY)
    private List<AlumnoCiclo> alumnoCiclo1;

    @OneToMany(mappedBy = "situacionInicio", fetch = FetchType.LAZY)
    private List<MatriculaResumen> matriculaResumen;

    @OneToMany(mappedBy = "situacionFinal", fetch = FetchType.LAZY)
    private List<MatriculaResumen> matriculaResumen1;

    public SituacionAcademica() {
    }

    public SituacionAcademica(SituacionAcademicaEnum sitEnum) {
        this.id = sitEnum.getId();
        this.codigo = sitEnum.getValue();
        this.nombre = sitEnum.getNombre();
    }

    public SituacionAcademica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public SituacionAcademicaEnum getCodigoEnum() {
        return SituacionAcademicaEnum.valueOf("S_".concat(codigo));
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }

    public List<AlumnoCiclo> getAlumnoCiclo() {
        return alumnoCiclo;
    }

    public void setAlumnoCiclo(List<AlumnoCiclo> alumnoCiclo) {
        this.alumnoCiclo = alumnoCiclo;
    }

    public List<AlumnoCiclo> getAlumnoCiclo1() {
        return alumnoCiclo1;
    }

    public void setAlumnoCiclo1(List<AlumnoCiclo> alumnoCiclo1) {
        this.alumnoCiclo1 = alumnoCiclo1;
    }

    public List<MatriculaResumen> getMatriculaResumen() {
        return matriculaResumen;
    }

    public void setMatriculaResumen(List<MatriculaResumen> matriculaResumen) {
        this.matriculaResumen = matriculaResumen;
    }

    public List<MatriculaResumen> getMatriculaResumen1() {
        return matriculaResumen1;
    }

    public void setMatriculaResumen1(List<MatriculaResumen> matriculaResumen1) {
        this.matriculaResumen1 = matriculaResumen1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTrikeado() {
        if (SituacionAcademicaEnum.S_T.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isSuspendido() {
        if (SituacionAcademicaEnum.S_6.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isObservado2Veces() {
        if (SituacionAcademicaEnum.S_2.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isEnPrueba() {
        if (SituacionAcademicaEnum.S_3.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isEnPruebaUltimoCiclo() {
        if (SituacionAcademicaEnum.S_3U.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isSeparado() {
        if (SituacionAcademicaEnum.S_4.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isSeparadoUltimoCiclo() {
        if (SituacionAcademicaEnum.S_4U.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isSeparadoTrika() {
        if (SituacionAcademicaEnum.S_4T.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isNormalConAntecedente() {
        if (SituacionAcademicaEnum.S_5.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIngresantePregrado() {
        if (SituacionAcademicaEnum.S_8.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIngresanteSeparado() {
        if (SituacionAcademicaEnum.S_7.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIngresanteNoMatriculado() {
        if (SituacionAcademicaEnum.S_9.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isEgresadoMatriculable() {
        if (SituacionAcademicaEnum.S_EM.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isEgresado() {
        if (SituacionAcademicaEnum.S_E.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }
    
    public boolean isGraduado() {
        if (SituacionAcademicaEnum.S_G.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isSeparadoDefinitivo() {
        if (SituacionAcademicaEnum.S_X.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isDesertor() {
        if (SituacionAcademicaEnum.S_D.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIngresanteRenunciante() {
        if (SituacionAcademicaEnum.S_R.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIngresoAnulado() {
        if (SituacionAcademicaEnum.S_Y.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isQuintoSecundaria() {
        if (SituacionAcademicaEnum.S_Q.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isNormal() {
        if (SituacionAcademicaEnum.S_N.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isObservado() {
        if (SituacionAcademicaEnum.S_1.getValue().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory);

        return json;
    }

    @Override
    public String toString() {
        return "SituacionAcademica{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
