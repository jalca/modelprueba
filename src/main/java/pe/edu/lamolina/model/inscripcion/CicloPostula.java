package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.CicloAcademicoEstadoEnum;
import pe.edu.lamolina.model.enums.VacanteEstadoEnum;
import pe.edu.lamolina.model.finanzas.CargaAbonos;
import pe.edu.lamolina.model.finanzas.ConceptoPrecio;
import pe.edu.lamolina.model.finanzas.CostoModalidad;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.vacantes.ConfiguraVacanteModalidad;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "sip_ciclo_postula")
public class CicloPostula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_vacantes")
    private String estadoVacantes;

    @Column(name = "ruta_prospecto")
    private String rutaProspecto;

    @Column(name = "vacantes_base")
    private Integer vacantesBase;

    @Column(name = "vacantes_supernumerario")
    private Integer vacantesSupernumerario;

    @Column(name = "vacantes_total")
    private Integer vacantesTotal;

    @Column(name = "es_virtual")
    private Integer esVirtual;

    @Column(name = "es_simulacro")
    private Integer esSimulacro;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_asigna_vacantes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAsignaVacantes;

    @Column(name = "fecha_cierra_vacantes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierraVacantes;

    @Column(name = "fecha_activa_ciclo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActivaCiclo;

    @Column(name = "fecha_cierra_ciclo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierraCiclo;

    @Column(name = "fecha_distribuye_postulantes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDistribuyePostulantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_asigna_vacantes")
    private Usuario usuarioAsignaVacantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierra_vacantes")
    private Usuario usuarioCierraVacantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activa_ciclo")
    private Usuario usuarioActivaCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierra_ciclo")
    private Usuario usuarioCierraCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_distribuye_postulantes")
    private Usuario usuarioDistribuyePostulantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<CargaAbonos> cargaAbonos;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<ConceptoPrecio> conceptoPrecio;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<CostoModalidad> costoModalidad;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<CarreraPostula> carreraPostula;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<EventoCiclo> eventoCiclo;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<Prospecto> prospecto;

    @OneToMany(mappedBy = "cicloPostula", fetch = FetchType.LAZY)
    private List<ConfiguraVacanteModalidad> configuraVacanteModalidad;

    @Transient
    Integer esVirtualInt;

    @Transient
    Integer esSimulacroInt;

    @Transient
    String descripcion;

    @Transient
    String descripcion2;

    public CicloPostula() {
        this.esVirtual = 0;
        this.esSimulacro = 0;
    }

    public CicloPostula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public CicloAcademicoEstadoEnum getEstadoEnum() {
        return CicloAcademicoEstadoEnum.valueOf(estado);
    }

    public void setEstado(CicloAcademicoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getEstado() {
        return estado;
    }

    public String getEstadoVacantes() {
        return estadoVacantes;
    }

    public VacanteEstadoEnum getEstadoVacantesEnum() {
        if (StringUtils.isBlank(estadoVacantes)) {
            return null;
        }
        return VacanteEstadoEnum.valueOf(estadoVacantes);
    }

    public void setEstadoVacantes(VacanteEstadoEnum estado) {
        this.estadoVacantes = estado.name();
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<CargaAbonos> getCargaAbonos() {
        return cargaAbonos;
    }

    public void setCargaAbonos(List<CargaAbonos> cargaAbonos) {
        this.cargaAbonos = cargaAbonos;
    }

    public List<CarreraPostula> getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(List<CarreraPostula> carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    public List<Postulante> getPostulante() {
        return postulante;
    }

    public void setPostulante(List<Postulante> postulante) {
        this.postulante = postulante;
    }

    public List<ConceptoPrecio> getConceptoPrecio() {
        return conceptoPrecio;
    }

    public void setConceptoPrecio(List<ConceptoPrecio> conceptoPrecio) {
        this.conceptoPrecio = conceptoPrecio;
    }

    public List<CostoModalidad> getCostoModalidad() {
        return costoModalidad;
    }

    public void setCostoModalidad(List<CostoModalidad> costoModalidad) {
        this.costoModalidad = costoModalidad;
    }

    public List<EventoCiclo> getEventoCiclo() {
        return eventoCiclo;
    }

    public void setEventoCiclo(List<EventoCiclo> eventoCiclo) {
        this.eventoCiclo = eventoCiclo;
    }

    public List<Prospecto> getProspecto() {
        return prospecto;
    }

    public void setProspecto(List<Prospecto> prospecto) {
        this.prospecto = prospecto;
    }

    public List<ConfiguraVacanteModalidad> getConfiguraVacanteModalidad() {
        return configuraVacanteModalidad;
    }

    public void setConfiguraVacanteModalidad(List<ConfiguraVacanteModalidad> configuraVacanteModalidad) {
        this.configuraVacanteModalidad = configuraVacanteModalidad;
    }

    public Integer getVacantesBase() {
        return vacantesBase;
    }

    public void setVacantesBase(Integer vacantesBase) {
        this.vacantesBase = vacantesBase;
    }

    public Integer getVacantesTotal() {
        return vacantesTotal;
    }

    public void setVacantesTotal(Integer vacantesTotal) {
        this.vacantesTotal = vacantesTotal;
    }

    public Integer getVacantesSupernumerario() {
        return vacantesSupernumerario;
    }

    public void setVacantesSupernumerario(Integer vacantesSupernumerario) {
        this.vacantesSupernumerario = vacantesSupernumerario;
    }

    public Date getFechaAsignaVacantes() {
        return fechaAsignaVacantes;
    }

    public void setFechaAsignaVacantes(Date fechaAsignaVacantes) {
        this.fechaAsignaVacantes = fechaAsignaVacantes;
    }

    public Usuario getUsuarioAsignaVacantes() {
        return usuarioAsignaVacantes;
    }

    public void setUsuarioAsignaVacantes(Usuario usuarioAsignaVacantes) {
        this.usuarioAsignaVacantes = usuarioAsignaVacantes;
    }

    public Date getFechaCierraVacantes() {
        return fechaCierraVacantes;
    }

    public void setFechaCierraVacantes(Date fechaCierraVacantes) {
        this.fechaCierraVacantes = fechaCierraVacantes;
    }

    public Date getFechaActivaCiclo() {
        return fechaActivaCiclo;
    }

    public void setFechaActivaCiclo(Date fechaActivaCiclo) {
        this.fechaActivaCiclo = fechaActivaCiclo;
    }

    public Date getFechaCierraCiclo() {
        return fechaCierraCiclo;
    }

    public void setFechaCierraCiclo(Date fechaCierraCiclo) {
        this.fechaCierraCiclo = fechaCierraCiclo;
    }

    public Usuario getUsuarioCierraVacantes() {
        return usuarioCierraVacantes;
    }

    public void setUsuarioCierraVacantes(Usuario usuarioCierraVacantes) {
        this.usuarioCierraVacantes = usuarioCierraVacantes;
    }

    public Usuario getUsuarioActivaCiclo() {
        return usuarioActivaCiclo;
    }

    public void setUsuarioActivaCiclo(Usuario usuarioActivaCiclo) {
        this.usuarioActivaCiclo = usuarioActivaCiclo;
    }

    public Usuario getUsuarioCierraCiclo() {
        return usuarioCierraCiclo;
    }

    public void setUsuarioCierraCiclo(Usuario usuarioCierraCiclo) {
        this.usuarioCierraCiclo = usuarioCierraCiclo;
    }

    public Date getFechaDistribuyePostulantes() {
        return fechaDistribuyePostulantes;
    }

    public void setFechaDistribuyePostulantes(Date fechaDistribuyePostulantes) {
        this.fechaDistribuyePostulantes = fechaDistribuyePostulantes;
    }

    public Usuario getUsuarioDistribuyePostulantes() {
        return usuarioDistribuyePostulantes;
    }

    public void setUsuarioDistribuyePostulantes(Usuario usuarioDistribuyePostulantes) {
        this.usuarioDistribuyePostulantes = usuarioDistribuyePostulantes;
    }

    public String getRutaProspecto() {
        return rutaProspecto;
    }

    public void setRutaProspecto(String rutaProspecto) {
        this.rutaProspecto = rutaProspecto;
    }

    public Boolean getEsVirtual() {
        return esVirtual == 1;
    }

    public void setEsVirtual(Integer esVirtual) {
        this.esVirtual = esVirtual;
    }

    public Boolean getEsSimulacro() {
        return esSimulacro == 1;
    }

    public void setEsSimulacro(Integer esSimulacro) {
        this.esSimulacro = esSimulacro;
    }

    public Integer getEsVirtualInt() {
        return esVirtualInt = esVirtual;
    }

    public void setEsVirtualInt(Integer esVirtualInt) {
        this.esVirtualInt = esVirtualInt;
    }

    public Integer getEsSimulacroInt() {
        return esSimulacroInt = esSimulacro;
    }

    public void setEsSimulacroInt(Integer esSimulacroInt) {
        this.esSimulacroInt = esSimulacroInt;
    }

    public String getDescripcion() {
        if (this.getEsSimulacro()) {
            return this.getCicloAcademico().getDescripcion2() + " Simulacro Virtual";
        } else if (this.getEsVirtual()) {
            return this.getCicloAcademico().getDescripcion2() + " Virtual";
        }
        return this.getCicloAcademico().getDescripcion2();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion2() {
        if (this.getEsSimulacro()) {
            return this.getCicloAcademico().getDescripcion() + " Simulacro Virtual";
        } else if (this.getEsVirtual()) {
            return this.getCicloAcademico().getDescripcion() + " Virtual";
        }
        return this.getCicloAcademico().getDescripcion();
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        CicloAcademico ca = this.cicloAcademico == null ? new CicloAcademico() : this.cicloAcademico;

        ObjectNode jsonCa = JsonHelper.createJson(ca, JsonNodeFactory.instance);
        json.set("cicloAcademico", jsonCa);

        return json;
    }
}
