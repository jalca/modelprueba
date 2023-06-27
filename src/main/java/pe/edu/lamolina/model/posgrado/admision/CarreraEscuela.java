package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.EstadoCarreraEscuelaEnum;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.posgrado.comite.comiteadmision.MiembroComiteAdmision;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_carrera_escuela")
public class CarreraEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cuenta_skype")
    private String cuentaSkype;

    @Column(name = "tiene_evaluacion")
    private Boolean tieneEvaluacion;

    @Column(name = "aula_examen")
    private String aulaExamen;

    @Column(name = "hora_examen")
    private String horaExamen;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "presentacion_html")
    private String presentacionHtml;

    @Column(name = "presentacion_lateral")
    private String presentacionLateral;

    @Column(name = "vacantes")
    private Integer vacantes;

    @Column(name = "ingresantes")
    private Integer ingresantes;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_escuela")
    private CicloEscuela cicloEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @OneToMany(mappedBy = "carreraEscuela", fetch = FetchType.LAZY)
    private List<DocumentoEspecialidad> documentoEspecialidad;

    @OneToMany(mappedBy = "carreraEscuela", fetch = FetchType.LAZY)
    private List<MiembroComiteAdmision> miembroComiteAdmision;

    @OneToMany(mappedBy = "carreraEscuela", fetch = FetchType.LAZY)
    private List<PesoAspectoEvaluacion> pesoAspectoEvaluacion;

    @Transient
    private Oficina oficina;

    @Transient
    private Integer postulantes;

    @Transient
    private Integer evaluados;

    @Transient
    private String search;

    @Transient
    private BigDecimal promedio;

    public CarreraEscuela() {
        this.ingresantes = 0;
    }

    public CarreraEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
        this.ingresantes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuentaSkype() {
        return cuentaSkype;
    }

    public void setCuentaSkype(String cuentaSkype) {
        this.cuentaSkype = cuentaSkype;
    }

    public Boolean getTieneEvaluacion() {
        if (this.tieneEvaluacion == null) {
            return Boolean.FALSE;
        }
        return tieneEvaluacion;
    }

    public void setTieneEvaluacion(Boolean tieneEvaluacion) {
        this.tieneEvaluacion = tieneEvaluacion;
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

    public CicloEscuela getCicloEscuela() {
        return cicloEscuela;
    }

    public void setCicloEscuela(CicloEscuela cicloEscuela) {
        this.cicloEscuela = cicloEscuela;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<DocumentoEspecialidad> getDocumentoEspecialidad() {
        return documentoEspecialidad;
    }

    public void setDocumentoEspecialidad(List<DocumentoEspecialidad> documentoEspecialidad) {
        this.documentoEspecialidad = documentoEspecialidad;
    }

    public List<MiembroComiteAdmision> getMiembroComiteAdmision() {
        return miembroComiteAdmision;
    }

    public void setMiembroComiteAdmision(List<MiembroComiteAdmision> miembroComiteAdmision) {
        this.miembroComiteAdmision = miembroComiteAdmision;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<PesoAspectoEvaluacion> getPesoAspectoEvaluacion() {
        return pesoAspectoEvaluacion;
    }

    public void setPesoAspectoEvaluacion(List<PesoAspectoEvaluacion> pesoAspectoEvaluacion) {
        this.pesoAspectoEvaluacion = pesoAspectoEvaluacion;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public Integer getEvaluados() {
        return evaluados;
    }

    public void setEvaluados(Integer evaluados) {
        this.evaluados = evaluados;
    }

    public EstadoCarreraEscuelaEnum getEstadoEnum() {
        if (Strings.isNullOrEmpty(this.estado)) {
            return null;
        }
        return EstadoCarreraEscuelaEnum.valueOf(this.estado);
    }

    public String getPresentacionHtml() {
        return presentacionHtml;
    }

    public void setPresentacionHtml(String presentacionHtml) {
        this.presentacionHtml = presentacionHtml;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoCarreraEscuelaEnum estado) {
        this.estado = estado.name();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getPresentacionLateral() {
        return presentacionLateral;
    }

    public void setPresentacionLateral(String presentacionLateral) {
        this.presentacionLateral = presentacionLateral;
    }

    public String getAulaExamen() {
        return aulaExamen;
    }

    public void setAulaExamen(String aulaExamen) {
        this.aulaExamen = aulaExamen;
    }

    public String getHoraExamen() {
        return horaExamen;
    }

    public void setHoraExamen(String horaExamen) {
        this.horaExamen = horaExamen;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public Integer getIngresantes() {
        return ingresantes;
    }

    public void setIngresantes(Integer ingresantes) {
        this.ingresantes = ingresantes;
    }

}
