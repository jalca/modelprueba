package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.PlanCurricular;
import pe.edu.lamolina.model.enums.EstadoAlumnoPlanEstudioEnum;
import pe.edu.lamolina.model.matricula.AlumnoCursoCurricula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.EstadoTramite;
import pe.edu.lamolina.model.tramite.FlujoTramiteAcademico;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_alumno_plan_estudios")
public class AlumnoPlanEstudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_curricular")
    private PlanCurricular planCurricular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "alumnoPlanEstudios", fetch = FetchType.LAZY)
    private List<AlumnoCursoCurricula> alumnoCursoCurricula;

    @OneToMany(mappedBy = "alumnoPlanEstudios", fetch = FetchType.LAZY)
    private List<AprobacionComiteConsejero> aprobacionComiteConsejero;

    @OneToMany(mappedBy = "alumnoPlanEstudios", fetch = FetchType.LAZY)
    private List<ResumenPlanEstudios> resumenPlanEstudios;

    @Transient
    FlujoTramiteAcademico flujoTramiteAcademico;
    @Transient
    private String observacion;
    @Transient
    private List<AlumnoCursoCurricula> cursosCreditosVariables;

    public AlumnoPlanEstudios() {
    }

    public AlumnoPlanEstudios(Object id) {
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

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public EstadoTramite getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public List<AlumnoCursoCurricula> getAlumnoCursoCurricula() {
        return alumnoCursoCurricula;
    }

    public void setAlumnoCursoCurricula(List<AlumnoCursoCurricula> alumnoCursoCurricula) {
        this.alumnoCursoCurricula = alumnoCursoCurricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAlumnoPlanEstudioEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public EstadoAlumnoPlanEstudioEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoAlumnoPlanEstudioEnum.valueOf(estado);
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<AprobacionComiteConsejero> getAprobacionComiteConsejero() {
        return aprobacionComiteConsejero;
    }

    public void setAprobacionComiteConsejero(List<AprobacionComiteConsejero> aprobacionComiteConsejero) {
        this.aprobacionComiteConsejero = aprobacionComiteConsejero;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public List<ResumenPlanEstudios> getResumenPlanEstudios() {
        return resumenPlanEstudios;
    }

    public void setResumenPlanEstudios(List<ResumenPlanEstudios> resumenPlanEstudios) {
        this.resumenPlanEstudios = resumenPlanEstudios;
    }

    public List<AlumnoCursoCurricula> getCursosCreditosVariables() {
        return cursosCreditosVariables;
    }

    public void setCursosCreditosVariables(List<AlumnoCursoCurricula> cursosCreditosVariables) {
        this.cursosCreditosVariables = cursosCreditosVariables;
    }

    public PlanCurricular getPlanCurricular() {
        return planCurricular;
    }

    public void setPlanCurricular(PlanCurricular planCurricular) {
        this.planCurricular = planCurricular;
    }

    public FlujoTramiteAcademico getFlujoTramiteAcademico() {
        return flujoTramiteAcademico;
    }

    public void setFlujoTramiteAcademico(FlujoTramiteAcademico flujoTramiteAcademico) {
        this.flujoTramiteAcademico = flujoTramiteAcademico;
    }

}
