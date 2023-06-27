package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;
import pe.edu.lamolina.model.constantines.AcademicoConstantine;
import pe.edu.lamolina.model.enums.TipoMigracionEnum;

@Getter
@Setter
@Entity
@Table(name = "aca_alumno_ciclo")
public class AlumnoCiclo implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "creditos_cursados_ciclo")
    private Integer creditosCursadosCiclo;

    @Column(name = "creditos_acumulados")
    private Integer creditosAcumulados;

    @Column(name = "creditos_aprobados_ciclo")
    private Integer creditosAprobadosCiclo;

    @Column(name = "creditos_aprobados_acumulados")
    private Integer creditosAprobadosAcumulados;

    @Column(name = "creditos_aprobados_acumulados_curricula")
    private Integer creditosAprobadosAcumuladosCurricula;

    @Column(name = "creditos_convalidados")
    private Integer creditosConvalidados;

    @Column(name = "creditos_convalidados_acumulados")
    private Integer creditosConvalidadosAcumulados;

    @Column(name = "puntaje_ciclo")
    private Integer puntajeCiclo;

    @Column(name = "puntaje_acumulado")
    private Integer puntajeAcumulado;

    @Column(name = "promedio_ciclo")
    private BigDecimal promedioCiclo;

    @Column(name = "promedio_acumulado")
    private BigDecimal promedioAcumulado;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "cursos_inscritos")
    private Integer cursosInscritos;

    @Column(name = "cursos_aprobados")
    private Integer cursosAprobados;

    @Column(name = "esta_aprobado")
    private Integer estaAprobado;

    @Column(name = "tercio_superior_carrera")
    private Integer tercioSuperiorCarrera;

    @Column(name = "tercio_superior_facultad")
    private Integer tercioSuperiorFacultad;

    @Column(name = "tercio_superior_ciclo")
    private Integer tercioSuperiorCiclo;

    @Column(name = "quinto_superior_carrera")
    private Integer quintoSuperiorCarrera;

    @Column(name = "quinto_superior_facultad")
    private Integer quintoSuperiorFacultad;

    @Column(name = "quinto_superior_ciclo")
    private Integer quintoSuperiorCiclo;

    @Column(name = "cuadro_honor_carrera")
    private Integer cuadroHonorCarrera;

    @Column(name = "cuadro_honor_facultad")
    private Integer cuadroHonorFacultad;

    @Column(name = "cuadro_honor_ciclo")
    private Integer cuadroHonorCiclo;

    @Column(name = "orden_merito_carrera")
    private Integer ordenMeritoCarrera;

    @Column(name = "orden_merito_facultad")
    private Integer ordenMeritoFacultad;

    @Column(name = "orden_merito_ciclo")
    private Integer ordenMeritoCiclo;

    @Column(name = "orden_merito_ciclo_nivel")
    private Integer ordenMeritoCicloNivel;

    @Column(name = "orden_merito_facultad_nivel")
    private Integer ordenMeritoFacultadNivel;

    @Column(name = "orden_merito_carrera_nivel")
    private Integer ordenMeritoCarreraNivel;

    @Column(name = "cuadro_honor_ciclo_nivel")
    private Integer cuadroHonorCicloNivel;

    @Column(name = "cuadro_honor_facultad_nivel")
    private Integer cuadroHonorFacultadNivel;

    @Column(name = "cuadro_honor_carrera_nivel")
    private Integer cuadroHonorCarreraNivel;

    @Column(name = "quinto_superior_ciclo_nivel")
    private Integer quintoSuperiorCicloNivel;

    @Column(name = "quinto_superior_facultad_nivel")
    private Integer quintoSuperiorFacultadNivel;

    @Column(name = "quinto_superior_carrera_nivel")
    private Integer quintoSuperiorCarreraNivel;

    @Column(name = "tercio_superior_ciclo_nivel")
    private Integer tercioSuperiorCicloNivel;

    @Column(name = "tercio_superior_facultad_nivel")
    private Integer tercioSuperiorFacultadNivel;

    @Column(name = "tercio_superior_carrera_nivel")
    private Integer tercioSuperiorCarreraNivel;

    @Column(name = "ciclos_regulares_estudiados")
    private Integer ciclosRegularesEstudiados;

    @Column(name = "ciclos_consecutivos_sin_estudiar")
    private Integer ciclosConsecutivosSinEstudiar;

    @Column(name = "ciclos_alternos_sin_estudiar")
    private Integer ciclosAlternosSinEstudiar;

    @Column(name = "tipo_migracion")
    private String tipoMigracion;

    @Column(name = "user_migracion")
    private String userMigracion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @Column(name = "fecha_migracion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaMigracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orientacion_carrera")
    private OrientacionCarrera orientacionCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_inicio")
    private SituacionAcademica situacionInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_final")
    private SituacionAcademica situacionFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_ciclo")
    private ControlOrdenMerito controlMeritoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_facultad")
    private ControlOrdenMerito controlMeritoFacultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_carrera")
    private ControlOrdenMerito controlMeritoCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "alumnoCiclo", fetch = FetchType.LAZY)
    private List<AlumnoCicloCurso> alumnoCicloCurso;

    @Transient
    @JsonIgnore
    private boolean generarTrika;

    @Transient
    @JsonIgnore
    private boolean trikaSeparado;

    @Transient
    @JsonIgnore
    private int columnOrdenMeritoNivel;

    @Transient
    @JsonIgnore
    private int numeroOrden;

    @Transient
    @JsonIgnore
    private boolean registroValido;

    @Transient
    @JsonIgnore
    private boolean registroXReincorporacion;

    @Transient
    @JsonIgnore
    private SituacionAcademica situacionAlterna;

    public AlumnoCiclo() {
        this.registroValido = false;
    }

    public AlumnoCiclo(Alumno alumno, CicloAcademico ciclo) {
        this.alumno = alumno;
        this.cicloAcademico = ciclo;
        this.registroValido = false;
    }

    public AlumnoCiclo(AlumnoCiclo alumnoCicloOrigen) {
        this.registroValido = false;
        if (alumnoCicloOrigen == null) {
            return;
        }
        this.id = alumnoCicloOrigen.id;
        this.estado = alumnoCicloOrigen.estado;
        this.creditosCursadosCiclo = alumnoCicloOrigen.creditosCursadosCiclo;
        this.creditosAcumulados = alumnoCicloOrigen.creditosAcumulados;
        this.creditosAprobadosCiclo = alumnoCicloOrigen.creditosAprobadosCiclo;
        this.creditosAprobadosAcumulados = alumnoCicloOrigen.creditosAprobadosAcumulados;
        this.creditosConvalidados = alumnoCicloOrigen.creditosConvalidados;
        this.puntajeCiclo = alumnoCicloOrigen.puntajeCiclo;
        this.puntajeAcumulado = alumnoCicloOrigen.puntajeAcumulado;
        this.promedioCiclo = alumnoCicloOrigen.promedioCiclo;
        this.promedioAcumulado = alumnoCicloOrigen.promedioAcumulado;
        this.nivel = alumnoCicloOrigen.nivel;
        this.cursosInscritos = alumnoCicloOrigen.cursosInscritos;
        this.cursosAprobados = alumnoCicloOrigen.cursosAprobados;
        this.estaAprobado = alumnoCicloOrigen.estaAprobado;
        this.tercioSuperiorCarrera = alumnoCicloOrigen.tercioSuperiorCarrera;
        this.tercioSuperiorFacultad = alumnoCicloOrigen.tercioSuperiorFacultad;
        this.tercioSuperiorCiclo = alumnoCicloOrigen.tercioSuperiorCiclo;
        this.quintoSuperiorCarrera = alumnoCicloOrigen.quintoSuperiorCarrera;
        this.quintoSuperiorFacultad = alumnoCicloOrigen.quintoSuperiorFacultad;
        this.quintoSuperiorCiclo = alumnoCicloOrigen.quintoSuperiorCiclo;
        this.cuadroHonorCarrera = alumnoCicloOrigen.cuadroHonorCarrera;
        this.cuadroHonorFacultad = alumnoCicloOrigen.cuadroHonorFacultad;
        this.cuadroHonorCiclo = alumnoCicloOrigen.cuadroHonorCiclo;
        this.ordenMeritoCarrera = alumnoCicloOrigen.ordenMeritoCarrera;
        this.ordenMeritoFacultad = alumnoCicloOrigen.ordenMeritoFacultad;
        this.ordenMeritoCiclo = alumnoCicloOrigen.ordenMeritoCiclo;
        this.ordenMeritoCicloNivel = alumnoCicloOrigen.ordenMeritoCicloNivel;
        this.ordenMeritoFacultadNivel = alumnoCicloOrigen.ordenMeritoFacultadNivel;
        this.ordenMeritoCarreraNivel = alumnoCicloOrigen.ordenMeritoCarreraNivel;
        this.cuadroHonorCicloNivel = alumnoCicloOrigen.cuadroHonorCicloNivel;
        this.cuadroHonorFacultadNivel = alumnoCicloOrigen.cuadroHonorFacultadNivel;
        this.cuadroHonorCarreraNivel = alumnoCicloOrigen.cuadroHonorCarreraNivel;
        this.quintoSuperiorCicloNivel = alumnoCicloOrigen.quintoSuperiorCicloNivel;
        this.quintoSuperiorFacultadNivel = alumnoCicloOrigen.quintoSuperiorFacultadNivel;
        this.quintoSuperiorCarreraNivel = alumnoCicloOrigen.quintoSuperiorCarreraNivel;
        this.tercioSuperiorCicloNivel = alumnoCicloOrigen.tercioSuperiorCicloNivel;
        this.tercioSuperiorFacultadNivel = alumnoCicloOrigen.tercioSuperiorFacultadNivel;
        this.tercioSuperiorCarreraNivel = alumnoCicloOrigen.tercioSuperiorCarreraNivel;
        this.tipoMigracion = alumnoCicloOrigen.tipoMigracion;
        this.userMigracion = alumnoCicloOrigen.userMigracion;
        this.fechaRegistro = alumnoCicloOrigen.fechaRegistro;
        this.fechaModificacion = alumnoCicloOrigen.fechaModificacion;
        this.alumno = alumnoCicloOrigen.alumno;
        this.cicloAcademico = alumnoCicloOrigen.cicloAcademico;
        this.carrera = alumnoCicloOrigen.carrera;
        this.orientacionCarrera = alumnoCicloOrigen.orientacionCarrera;
        this.situacionInicio = alumnoCicloOrigen.situacionInicio;
        this.situacionFinal = alumnoCicloOrigen.situacionFinal;
        this.controlMeritoCiclo = alumnoCicloOrigen.controlMeritoCiclo;
        this.controlMeritoFacultad = alumnoCicloOrigen.controlMeritoFacultad;
        this.controlMeritoCarrera = alumnoCicloOrigen.controlMeritoCarrera;
        this.userRegistro = alumnoCicloOrigen.userRegistro;
        this.userModificacion = alumnoCicloOrigen.userModificacion;
    }

    public AlumnoCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
        this.registroValido = false;

    }

    public void defaultValuesToCreate(Alumno alumno, CicloAcademico cicloAcademico, Usuario usuario) {
        this.setAlumno(alumno);
        this.setCicloAcademico(cicloAcademico);
        this.setCarrera(alumno.getCarrera());
        this.setOrientacionCarrera(alumno.getOrientacionCarrera());
        //todos los ciclos

        this.setEstadoEnum(EstadoMatriculaEnum.MAT);
        this.setCreditosAcumulados(BigDecimal.ZERO.intValue());
        this.setCreditosAprobadosAcumulados(BigDecimal.ZERO.intValue());
        this.setCreditosAprobadosAcumuladosCurricula(BigDecimal.ZERO.intValue());
        this.setCreditosAprobadosCiclo(BigDecimal.ZERO.intValue());
        this.setCreditosCursadosCiclo(BigDecimal.ZERO.intValue());
        this.setCreditosConvalidados(BigDecimal.ZERO.intValue());
        this.setCreditosConvalidadosAcumulados(BigDecimal.ZERO.intValue());
        this.setCursosAprobados(BigDecimal.ZERO.intValue());
        this.setCursosInscritos(BigDecimal.ZERO.intValue());
        this.setPromedioAcumulado(BigDecimal.ZERO);
        this.setPromedioCiclo(BigDecimal.ZERO);
        this.setEstaAprobado(BigDecimal.ZERO.intValue());
        this.setCiclosAlternosSinEstudiar(BigDecimal.ZERO.intValue());
        this.setCiclosConsecutivosSinEstudiar(BigDecimal.ZERO.intValue());
        this.setCiclosRegularesEstudiados(BigDecimal.ZERO.intValue());

        //
        this.setUserRegistro(usuario);
        this.setFechaRegistro(new Date());

    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setTipoMigracionEnum(TipoMigracionEnum tipoMigracion) {
        if (tipoMigracion == null) {
            return;
        }
        this.tipoMigracion = tipoMigracion.name();
    }

    public TipoMigracionEnum getTipoMigracionEnum() {
        if (tipoMigracion == null) {
            return null;
        }
        return TipoMigracionEnum.valueOf(tipoMigracion);
    }

    public Integer getCreditosAprobadosConvalidadosAcumulados() {
        int convalidados = creditosConvalidadosAcumulados == null ? 0 : creditosConvalidadosAcumulados;
        int aprobados = creditosAprobadosAcumulados == null ? 0 : creditosAprobadosAcumulados;
        return convalidados + aprobados;
    }

    public Integer getEstaAprobado() {
        if (this.getCicloAcademico().getYear() <= AcademicoConstantine.YEAR_ALL_APPROVE) {
            return BigDecimal.ONE.intValue();
        }
        return estaAprobado;
    }

    public boolean isAprobado() {
        if (this.getEstaAprobado().equals(BigDecimal.ONE.intValue())
                || this.getCicloAcademico().getYear() <= AcademicoConstantine.YEAR_ALL_APPROVE
                || this.getCicloAcademico().isAmnistiado()) {
            return true;
        }
        return false;
    }

    public boolean isUltimoCiclo() {
        if (this.getCreditosAprobadosConvalidadosAcumulados() >= 180) {
            return true;
        }
        return false;
    }

    public boolean isEstadoInhabilitado() {
        if (EstadoMatriculaEnum.INH.equals(getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isNoMatriculado() {
        if (EstadoMatriculaEnum.NMAT.equals(getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isMatriculado() {
        if (EstadoMatriculaEnum.MAT.equals(getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRetiradoCiclo() {
        if (EstadoMatriculaEnum.RCI.equals(getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isCicloRetirado() {
        EstadoMatriculaEnum estadoEnum = EstadoMatriculaEnum.valueOf(this.getEstado());
        return estadoEnum == EstadoMatriculaEnum.RCI || estadoEnum == EstadoMatriculaEnum.ANCI;
    }

    public boolean isTrikaSeparado() {
        return trikaSeparado;
    }

    public boolean isRegistroXReinCicloActi() {
        return registroXReincorporacion;
    }

    public void setRegistroXReinCicloActi(boolean registroXReincorporacion) {
        this.registroXReincorporacion = registroXReincorporacion;
    }

    public void setCiclosSinEstudiar(int ciclosConsecutivosSinEstudiar, int ciclosAlternosSinEstudiar) {
        this.ciclosConsecutivosSinEstudiar = ciclosConsecutivosSinEstudiar;
        this.ciclosAlternosSinEstudiar = ciclosAlternosSinEstudiar;
    }

    public boolean isRegistroValido() {
        return registroValido;
    }

    public String getKey() {
        if (this.alumno == null) {
            return null;
        }
        if (this.cicloAcademico == null) {
            return null;
        }
        return this.alumno.getCodigo() + "-" + this.cicloAcademico.getCodigo();
    }

    public static class CompareCicloAsc implements Comparator<AlumnoCiclo> {

        @Override
        public int compare(AlumnoCiclo ac1, AlumnoCiclo ac2) {
            return ac1.getCicloAcademico().getCodigo().compareTo(ac2.getCicloAcademico().getCodigo());
        }
    }

    public static class CompareCicloDesc implements Comparator<AlumnoCiclo> {

        @Override
        public int compare(AlumnoCiclo ac1, AlumnoCiclo ac2) {
            return ac2.getCicloAcademico().getCodigo().compareTo(ac1.getCicloAcademico().getCodigo());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AlumnoCiclo)) {
            return false;
        }
        AlumnoCiclo other = (AlumnoCiclo) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    public Integer getComputadosCicloNivel() {
        Integer computados = 0;
        if (this.getNivel() == null) {
            return computados;
        }
        if (this.getNivel() == 1 && this.getControlMeritoCiclo().getComputadosNivel1() != null) {
            return this.getControlMeritoCiclo().getComputadosNivel1();
        } else if (this.getNivel() == 2 && this.getControlMeritoCiclo().getComputadosNivel2() != null) {
            return this.getControlMeritoCiclo().getComputadosNivel2();
        } else if (this.getNivel() == 3 && this.getControlMeritoCiclo().getComputadosNivel3() != null) {
            return this.getControlMeritoCiclo().getComputadosNivel3();
        } else if (this.getNivel() == 4 && this.getControlMeritoCiclo().getComputadosNivel4() != null) {
            return this.getControlMeritoCiclo().getComputadosNivel4();
        } else if (this.getNivel() == 5 && this.getControlMeritoCiclo().getComputadosNivel5() != null) {
            return this.getControlMeritoCiclo().getComputadosNivel5();
        }
        return computados;
    }

    public Integer getComputadosFacultadNivel() {
        Integer computados = 0;
        if (this.getNivel() == null) {
            return computados;
        }
        if (this.getNivel() == 1 && this.getControlMeritoFacultad().getComputadosNivel1() != null) {
            return this.getControlMeritoFacultad().getComputadosNivel1();
        } else if (this.getNivel() == 2 && this.getControlMeritoFacultad().getComputadosNivel2() != null) {
            return this.getControlMeritoFacultad().getComputadosNivel2();
        } else if (this.getNivel() == 3 && this.getControlMeritoFacultad().getComputadosNivel3() != null) {
            return this.getControlMeritoFacultad().getComputadosNivel3();
        } else if (this.getNivel() == 4 && this.getControlMeritoFacultad().getComputadosNivel4() != null) {
            return this.getControlMeritoFacultad().getComputadosNivel4();
        } else if (this.getNivel() == 5 && this.getControlMeritoFacultad().getComputadosNivel5() != null) {
            return this.getControlMeritoFacultad().getComputadosNivel5();
        }
        return computados;
    }

    public Integer getComputadosCarreraNivel() {
        Integer computados = 0;
        if (this.getNivel() == null) {
            return computados;
        }
        if (this.getNivel() == 1 && this.getControlMeritoCarrera().getComputadosNivel1() != null) {
            return this.getControlMeritoCarrera().getComputadosNivel1();
        } else if (this.getNivel() == 2 && this.getControlMeritoCarrera().getComputadosNivel2() != null) {
            return this.getControlMeritoCarrera().getComputadosNivel2();
        } else if (this.getNivel() == 3 && this.getControlMeritoCarrera().getComputadosNivel3() != null) {
            return this.getControlMeritoCarrera().getComputadosNivel3();
        } else if (this.getNivel() == 4 && this.getControlMeritoCarrera().getComputadosNivel4() != null) {
            return this.getControlMeritoCarrera().getComputadosNivel4();
        } else if (this.getNivel() == 5 && this.getControlMeritoCarrera().getComputadosNivel5() != null) {
            return this.getControlMeritoCarrera().getComputadosNivel5();
        }
        return computados;
    }

    public static class CompareReverseCiclo implements Comparator<AlumnoCiclo> {

        @Override
        public int compare(AlumnoCiclo ac1, AlumnoCiclo ac2) {
            CicloAcademico ca1 = ac1.getCicloAcademico();
            CicloAcademico ca2 = ac2.getCicloAcademico();
            int comparacion = ca2.getCodigo().compareTo(ca1.getCodigo());
            return comparacion;
        }
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "AlumnoCiclo{" + "id=" + id + ", estado=" + estado + ", ciclo=" + ObjectUtil.getParentTree(this, "cicloAcademico.codigo") + "}";
    }

}
