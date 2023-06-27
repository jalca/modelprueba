package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.enums.EstadoCursoMasivoEnum;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rex_curso_masivo_examen")
public class CursoMasivoExamen implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "secciones")
    private Integer secciones;

    @Column(name = "alumnos")
    private Integer alumnos;

    @Column(name = "capacidad_aulas")
    private Integer capacidadAulas;

    @Column(name = "aulas")
    private Integer aulas;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_exclusion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExclusion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_exclusion")
    private Usuario usuarioExclusion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_examen")
    private GrupoHorasExamen grupoHorasExamen;

    @OneToMany(mappedBy = "cursoMasivoExamen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AulaCursoMasivo> aulasCursosMasivos;

    @OneToMany(mappedBy = "cursoMasivoExamen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DocenteCursoMasivo> docentesCursosMasivos;

    @OneToMany(mappedBy = "cursoMasivoExamen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AlumnoCursoMasivo> alumnosCursosMasivos;

    @OneToMany(mappedBy = "cursoMasivoExamen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeccionCursoMasivo> seccionesCursosMasivos;

    @Transient
    @JsonIgnore
    private Integer alumnosCursosMasivosCount;

    @Transient
    @JsonIgnore
    private Integer seccionesCursosMasivosCount;

    @Transient
    @JsonIgnore
    private Integer docentesCount;

    @Transient
    @JsonIgnore
    private Integer alumnosCount;

    @Transient
    @JsonIgnore
    private Integer seccionesCount;

    public CursoMasivoExamen() {
    }

    public CursoMasivoExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSecciones() {
        return secciones;
    }

    public void setSecciones(Integer secciones) {
        this.secciones = secciones;
    }

    public Integer getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Integer alumnos) {
        this.alumnos = alumnos;
    }

    public Integer getAulas() {
        return aulas;
    }

    public void setAulas(Integer aulas) {
        this.aulas = aulas;
    }

    public Integer getCapacidadAulas() {
        return capacidadAulas;
    }

    public void setCapacidadAulas(Integer capacidadAulas) {
        this.capacidadAulas = capacidadAulas;
    }

    public RolExamenes getRolExamenes() {
        return rolExamenes;
    }

    public void setRolExamenes(RolExamenes rolExamenes) {
        this.rolExamenes = rolExamenes;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<AlumnoCursoMasivo> getAlumnosCursosMasivos() {
        return alumnosCursosMasivos;
    }

    public void setAlumnosCursosMasivos(List<AlumnoCursoMasivo> alumnosCursosMasivos) {
        this.alumnosCursosMasivos = alumnosCursosMasivos;
    }

    public Integer getAlumnosCursosMasivosCount() {
        return alumnosCursosMasivosCount;
    }

    public void setAlumnosCursosMasivosCount(Integer alumnosCursosMasivosCount) {
        this.alumnosCursosMasivosCount = alumnosCursosMasivosCount;
    }

    public List<SeccionCursoMasivo> getSeccionesCursosMasivos() {
        return seccionesCursosMasivos;
    }

    public void setSeccionesCursosMasivos(List<SeccionCursoMasivo> seccionesCursosMasivos) {
        this.seccionesCursosMasivos = seccionesCursosMasivos;
    }

    public Integer getSeccionesCursosMasivosCount() {
        return seccionesCursosMasivosCount;
    }

    public void setSeccionesCursosMasivosCount(Integer seccionesCursosMasivosCount) {
        this.seccionesCursosMasivosCount = seccionesCursosMasivosCount;
    }

    public List<AulaCursoMasivo> getAulasCursosMasivos() {
        return aulasCursosMasivos;
    }

    public void setAulasCursosMasivos(List<AulaCursoMasivo> aulasCursosMasivos) {
        this.aulasCursosMasivos = aulasCursosMasivos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioExclusion() {
        return usuarioExclusion;
    }

    public void setUsuarioExclusion(Usuario usuarioExclusion) {
        this.usuarioExclusion = usuarioExclusion;
    }

    public Date getFechaExclusion() {
        return fechaExclusion;
    }

    public void setFechaExclusion(Date fechaExclusion) {
        this.fechaExclusion = fechaExclusion;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoCursoMasivoEnum estadoCursoMasivoEnum) {
        this.estado = estadoCursoMasivoEnum.name();
    }

    public EstadoCursoMasivoEnum getEstadoEnum() {
        if (this.estado != null) {
            return EstadoCursoMasivoEnum.valueOf(this.estado);
        }
        return null;
    }

    public GrupoHorasExamen getGrupoHorasExamen() {
        return grupoHorasExamen;
    }

    public void setGrupoHorasExamen(GrupoHorasExamen grupoHorasExamen) {
        this.grupoHorasExamen = grupoHorasExamen;
    }

    public List<DocenteCursoMasivo> getDocentesCursosMasivos() {
        return docentesCursosMasivos;
    }

    public void setDocentesCursosMasivos(List<DocenteCursoMasivo> docentesCursosMasivos) {
        this.docentesCursosMasivos = docentesCursosMasivos;
    }

    public Integer getDocentesCount() {
        return docentesCount;
    }

    public void setDocentesCount(Integer docentesCount) {
        this.docentesCount = docentesCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CursoMasivoExamen other = (CursoMasivoExamen) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public Integer getAlumnosCount() {
        return alumnosCount;
    }

    public void setAlumnosCount(Integer alumnosCount) {
        this.alumnosCount = alumnosCount;
    }

    public Integer getSeccionesCount() {
        return seccionesCount;
    }

    public void setSeccionesCount(Integer seccionesCount) {
        this.seccionesCount = seccionesCount;
    }

    @Override
    public CursoMasivoExamen clone() {
        CursoMasivoExamen clone = null;
        try {
            clone = (CursoMasivoExamen) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public boolean isEstadoActivo() {
        if (this.estado == null) {
            return false;
        }
        return EstadoCursoMasivoEnum.ACT.equals(this.getEstadoEnum());
    }

    public boolean isEstadoExcluido() {
        if (this.estado == null) {
            return false;
        }
        return EstadoCursoMasivoEnum.EXC.equals(this.getEstadoEnum());
    }

}
