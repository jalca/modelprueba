package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.social.Perfil;

@Entity
@Table(name = "aca_egresado")
public class Egresado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "es_principal")
    private Integer esPrincipal;

    @Column(name = "creditos_acumulados")
    private Integer creditosAcumulados;

    @Column(name = "creditos_aprobados_acumulados")
    private Integer creditosAprobadosAcumulados;

    @Column(name = "puntaje_acumulado")
    private Integer puntajeAcumulado;

    @Column(name = "promedio_acumulado")
    private BigDecimal promedioAcumulado;

    @Column(name = "promedio_acumulado_merito")
    private BigDecimal promedioAcumuladoMerito;

    @Column(name = "promedio_graduacion")
    private BigDecimal promedioGraduacion;

    @Column(name = "orden_merito_ciclo")
    private Integer ordenMeritoCiclo;

    @Column(name = "orden_merito_facultad")
    private Integer ordenMeritoFacultad;

    @Column(name = "orden_merito_carrera")
    private Integer ordenMeritoCarrera;

    @Column(name = "cuadro_honor_ciclo")
    private Integer cuadroHonorCiclo;

    @Column(name = "quinto_superior_ciclo")
    private Integer quintoSuperiorCiclo;

    @Column(name = "tercio_superior_ciclo")
    private Integer tercioSuperiorCiclo;

    @Column(name = "cuadro_honor_facultad")
    private Integer cuadroHonorFacultad;

    @Column(name = "quinto_superior_facultad")
    private Integer quintoSuperiorFacultad;

    @Column(name = "tercio_superior_facultad")
    private Integer tercioSuperiorFacultad;

    @Column(name = "cuadro_honor_carrera")
    private Integer cuadroHonorCarrera;

    @Column(name = "quinto_superior_carrera")
    private Integer quintoSuperiorCarrera;

    @Column(name = "tercio_superior_carrera")
    private Integer tercioSuperiorCarrera;

    @Column(name = "fecha_egresado")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEgresado;

    @Column(name = "fecha_graduacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaGraduacion;

    @Column(name = "fecha_titulacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaTitulacion;

    @Column(name = "fecha_registro_egresado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroEgresado;

    @Column(name = "fecha_registro_graduado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroGraduado;

    @Column(name = "fecha_registro_titulado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroTitulado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado")
    private GradoAcademico grado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_titulo")
    private GradoAcademico titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_ciclo")
    private ControlMeritoEgresado controlMeritoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_facultad")
    private ControlMeritoEgresado controlMeritoFacultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_merito_carrera")
    private ControlMeritoEgresado controlMeritoCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_egresado")
    private Usuario userRegistroEgresado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_graduado")
    private Usuario userRegistroGraduado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_titulado")
    private Usuario userRegistroTitulado;

    @Transient
    private Perfil perfil;

    public Egresado() {
    }

    public Egresado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Integer esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public Date getFechaEgresado() {
        return fechaEgresado;
    }

    public void setFechaEgresado(Date fechaEgresado) {
        this.fechaEgresado = fechaEgresado;
    }

    public GradoAcademico getGrado() {
        return grado;
    }

    public void setGrado(GradoAcademico grado) {
        this.grado = grado;
    }

    public Date getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(Date fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public GradoAcademico getTitulo() {
        return titulo;
    }

    public void setTitulo(GradoAcademico titulo) {
        this.titulo = titulo;
    }

    public Date getFechaTitulacion() {
        return fechaTitulacion;
    }

    public void setFechaTitulacion(Date fechaTitulacion) {
        this.fechaTitulacion = fechaTitulacion;
    }

    public Date getFechaRegistroEgresado() {
        return fechaRegistroEgresado;
    }

    public void setFechaRegistroEgresado(Date fechaRegistroEgresado) {
        this.fechaRegistroEgresado = fechaRegistroEgresado;
    }

    public Date getFechaRegistroGraduado() {
        return fechaRegistroGraduado;
    }

    public void setFechaRegistroGraduado(Date fechaRegistroGraduado) {
        this.fechaRegistroGraduado = fechaRegistroGraduado;
    }

    public Date getFechaRegistroTitulado() {
        return fechaRegistroTitulado;
    }

    public void setFechaRegistroTitulado(Date fechaRegistroTitulado) {
        this.fechaRegistroTitulado = fechaRegistroTitulado;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Integer getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public void setCreditosAcumulados(Integer creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public Integer getCreditosAprobadosAcumulados() {
        return creditosAprobadosAcumulados;
    }

    public void setCreditosAprobadosAcumulados(Integer creditosAprobadosAcumulados) {
        this.creditosAprobadosAcumulados = creditosAprobadosAcumulados;
    }

    public Integer getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    public void setPuntajeAcumulado(Integer puntajeAcumulado) {
        this.puntajeAcumulado = puntajeAcumulado;
    }

    public BigDecimal getPromedioAcumulado() {
        if (this.promedioAcumulado == null) {
            return BigDecimal.ZERO;
        }
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(BigDecimal promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public BigDecimal getPromedioAcumuladoMerito() {
        return promedioAcumuladoMerito;
    }

    public void setPromedioAcumuladoMerito(BigDecimal promedioAcumuladoMerito) {
        this.promedioAcumuladoMerito = promedioAcumuladoMerito;
    }

    public BigDecimal getPromedioGraduacion() {
        return promedioGraduacion;
    }

    public BigDecimal returnPromedioGraduacionTrunc(int decimales) {
        if (promedioGraduacion == null) {
            return BigDecimal.ZERO;
        }
        return promedioGraduacion.setScale(decimales, RoundingMode.FLOOR);
    }

    public void setPromedioGraduacion(BigDecimal promedioGraduacion) {
        this.promedioGraduacion = promedioGraduacion;
    }

    public Integer getOrdenMeritoCiclo() {
        return ordenMeritoCiclo;
    }

    public void setOrdenMeritoCiclo(Integer ordenMeritoCiclo) {
        this.ordenMeritoCiclo = ordenMeritoCiclo;
    }

    public Integer getOrdenMeritoFacultad() {
        return ordenMeritoFacultad;
    }

    public void setOrdenMeritoFacultad(Integer ordenMeritoFacultad) {
        this.ordenMeritoFacultad = ordenMeritoFacultad;
    }

    public Integer getOrdenMeritoCarrera() {
        return ordenMeritoCarrera;
    }

    public void setOrdenMeritoCarrera(Integer ordenMeritoCarrera) {
        this.ordenMeritoCarrera = ordenMeritoCarrera;
    }

    public Integer getCuadroHonorCiclo() {
        return cuadroHonorCiclo;
    }

    public void setCuadroHonorCiclo(Integer cuadroHonorCiclo) {
        this.cuadroHonorCiclo = cuadroHonorCiclo;
    }

    public Integer getQuintoSuperiorCiclo() {
        return quintoSuperiorCiclo;
    }

    public void setQuintoSuperiorCiclo(Integer quintoSuperiorCiclo) {
        this.quintoSuperiorCiclo = quintoSuperiorCiclo;
    }

    public Integer getTercioSuperiorCiclo() {
        return tercioSuperiorCiclo;
    }

    public void setTercioSuperiorCiclo(Integer tercioSuperiorCiclo) {
        this.tercioSuperiorCiclo = tercioSuperiorCiclo;
    }

    public Integer getCuadroHonorFacultad() {
        return cuadroHonorFacultad;
    }

    public void setCuadroHonorFacultad(Integer cuadroHonorFacultad) {
        this.cuadroHonorFacultad = cuadroHonorFacultad;
    }

    public Integer getQuintoSuperiorFacultad() {
        return quintoSuperiorFacultad;
    }

    public void setQuintoSuperiorFacultad(Integer quintoSuperiorFacultad) {
        this.quintoSuperiorFacultad = quintoSuperiorFacultad;
    }

    public Integer getCuadroHonorCarrera() {
        return cuadroHonorCarrera;
    }

    public void setCuadroHonorCarrera(Integer cuadroHonorCarrera) {
        this.cuadroHonorCarrera = cuadroHonorCarrera;
    }

    public Integer getQuintoSuperiorCarrera() {
        return quintoSuperiorCarrera;
    }

    public void setQuintoSuperiorCarrera(Integer quintoSuperiorCarrera) {
        this.quintoSuperiorCarrera = quintoSuperiorCarrera;
    }

    public Integer getTercioSuperiorCarrera() {
        return tercioSuperiorCarrera;
    }

    public void setTercioSuperiorCarrera(Integer tercioSuperiorCarrera) {
        this.tercioSuperiorCarrera = tercioSuperiorCarrera;
    }

    public Integer getTercioSuperiorFacultad() {
        return tercioSuperiorFacultad;
    }

    public void setTercioSuperiorFacultad(Integer tercioSuperiorFacultad) {
        this.tercioSuperiorFacultad = tercioSuperiorFacultad;
    }

    public ControlMeritoEgresado getControlMeritoCiclo() {
        return controlMeritoCiclo;
    }

    public void setControlMeritoCiclo(ControlMeritoEgresado controlMeritoCiclo) {
        this.controlMeritoCiclo = controlMeritoCiclo;
    }

    public ControlMeritoEgresado getControlMeritoFacultad() {
        return controlMeritoFacultad;
    }

    public void setControlMeritoFacultad(ControlMeritoEgresado controlMeritoFacultad) {
        this.controlMeritoFacultad = controlMeritoFacultad;
    }

    public ControlMeritoEgresado getControlMeritoCarrera() {
        return controlMeritoCarrera;
    }

    public void setControlMeritoCarrera(ControlMeritoEgresado controlMeritoCarrera) {
        this.controlMeritoCarrera = controlMeritoCarrera;
    }

    public Usuario getUserRegistroEgresado() {
        return userRegistroEgresado;
    }

    public void setUserRegistroEgresado(Usuario userRegistroEgresado) {
        this.userRegistroEgresado = userRegistroEgresado;
    }

    public Usuario getUserRegistroGraduado() {
        return userRegistroGraduado;
    }

    public void setUserRegistroGraduado(Usuario userRegistroGraduado) {
        this.userRegistroGraduado = userRegistroGraduado;
    }

    public Usuario getUserRegistroTitulado() {
        return userRegistroTitulado;
    }

    public void setUserRegistroTitulado(Usuario userRegistroTitulado) {
        this.userRegistroTitulado = userRegistroTitulado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
