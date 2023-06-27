package pe.edu.lamolina.model.matricula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.CursoCurricula;
import pe.edu.lamolina.model.academico.CursoOpcionalCurricula;
import pe.edu.lamolina.model.academico.RequisitoCursoCurricula;
import pe.edu.lamolina.model.academico.RequisitoCursoOpcional;
import pe.edu.lamolina.model.academico.TipoCursoCurricula;
import pe.edu.lamolina.model.enums.CursoCurriculaEstadoEnum;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.posgrado.AlumnoPlanEstudios;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "aca_alumno_curso_curricula")
public class AlumnoCursoCurricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nota")
    private String nota;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_cumplidos")
    private Integer creditosCumplidos;

    @Column(name = "veces_cursado")
    private Integer vecesCursado;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_matricula")
    private String estadoMatricula;

    @Column(name = "estado_registro")
    private String estadoRegistro;

    @Column(name = "numero_ciclo")
    private Integer numeroCiclo;

    @Column(name = "es_simultaneo")
    private Boolean esSimultaneo;

    @Column(name = "fecha_habilita_curso")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHabilitaCurso;

    @Column(name = "fecha_deshabilitacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDeshabilitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_curricula")
    private CursoCurricula cursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula_origen")
    private TipoCursoCurricula tipoCursoCurriculaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_opcional")
    private CursoOpcionalCurricula cursoOpcional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_aprobado")
    private CicloAcademico cicloAprobado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_estudia_futuro")
    private CicloAcademico cicloEstudiaFuturo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_habil")
    private CicloAcademico cicloHabil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_plan_estudios")
    private AlumnoPlanEstudios alumnoPlanEstudios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_habilita_curso")
    private Usuario userHabilitaCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_deshabilitacion")
    private Usuario userDeshabilitacion;

    @Transient
    private boolean validado = false;

    @Transient
    private boolean caduco = false;

    @Transient
    private List<RequisitoCursoCurricula> requisitoCursoCurriculas;
    @Transient
    private List<RequisitoCursoOpcional> requisitoCursoOpcional;

    public AlumnoCursoCurricula() {
    }

    public AlumnoCursoCurricula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CursoCurriculaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return CursoCurriculaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(CursoCurriculaEstadoEnum cursoCurriculaEstadoEnum) {
        this.estado = cursoCurriculaEstadoEnum.name();
    }

    public EstadoMatriculaEnum getEstadoMatriculaEnum() {
        if (estadoMatricula == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estadoMatricula);
    }

    @JsonIgnore
    public void setEstadoMatriculaEnum(EstadoMatriculaEnum cursoCurriculaEstadoEnum) {
        if (cursoCurriculaEstadoEnum == null) {
            this.estadoMatricula = null;
            return;
        }
        this.estadoMatricula = cursoCurriculaEstadoEnum.name();
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public Boolean getEsSimultaneo() {
        if (esSimultaneo == null) {
            return false;
        }
        return esSimultaneo;
    }

    public void setEsSimultaneo(Boolean esSimultaneo) {
        if (esSimultaneo == null) {
            this.esSimultaneo = false;
        }
        this.esSimultaneo = esSimultaneo;
    }

    public EstadoEnum getEstadoRegistroEnum() {
        if (StringUtils.isBlank(estadoRegistro)) {
            return null;
        }
        return EstadoEnum.valueOf(estadoRegistro);
    }

    @JsonIgnore
    public void setEstadoRegistroEnum(EstadoEnum estadoRegistro) {
        if (estadoRegistro == null) {
            return;
        }
        this.estadoRegistro = estadoRegistro.name();
    }

    public boolean isCaduco() {
        return caduco;
    }

    public void setCaduco(boolean caduco) {
        this.caduco = caduco;
    }

    public String getKeyCicloCurso() {
        if (this.curso == null) {
            return null;
        }
        if (this.cicloEstudiaFuturo == null) {
            return null;
        }
        return this.cicloEstudiaFuturo.getId() + "-" + this.curso.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AlumnoCursoCurricula)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        AlumnoCursoCurricula other = (AlumnoCursoCurricula) obj;
        if (other.getId() == null || this.id == null) {
            return false;
        }

        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    public static class CompareOrdenTipoCurr implements Comparator<AlumnoCursoCurricula> {

        @Override
        public int compare(AlumnoCursoCurricula ca1, AlumnoCursoCurricula ca2) {
            TipoCursoCurricula t1 = ca1.getTipoCursoCurricula();
            TipoCursoCurricula t2 = ca2.getTipoCursoCurricula();

            if (t1 == null || t2 == null) {
                return -1;
            }
            if (t1.getOrdenProceso() == null && t2.getOrdenProceso() != null) {
                return -1;
            }
            if (t1.getOrdenProceso() != null && t2.getOrdenProceso() == null) {
                return 1;
            }

            return t1.getOrdenProceso().compareTo(t2.getOrdenProceso());
        }
    }

    public static class CompareCreditos implements Comparator<AlumnoCursoCurricula> {

        @Override
        public int compare(AlumnoCursoCurricula ca1, AlumnoCursoCurricula ca2) {
            return ca1.getCreditos().compareTo(ca2.getCreditos());
        }
    }

    public static class CompareCicloFuturo implements Comparator<AlumnoCursoCurricula> {

        @Override
        public int compare(AlumnoCursoCurricula acc1, AlumnoCursoCurricula acc2) {
            CicloAcademico ca1 = acc1.getCicloEstudiaFuturo();
            CicloAcademico ca2 = acc2.getCicloEstudiaFuturo();
            return ca1.getCodigo().compareTo(ca2.getCodigo());
        }
    }

}
