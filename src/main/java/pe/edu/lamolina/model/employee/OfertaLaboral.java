package pe.edu.lamolina.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import static org.apache.commons.lang3.StringUtils.isBlank;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.OfertaEstadoEnum;
import pe.edu.lamolina.model.enums.TipoOfertaLaboralEnum;
import pe.edu.lamolina.model.finanzas.Moneda;
import pe.edu.lamolina.model.general.ClaseLicenciaConducir;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.social.AreaEmpresa;
import pe.edu.lamolina.model.social.NivelPosicion;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "empy_oferta_laboral")
public class OfertaLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "trabajo_remoto")
    private Integer trabajoRemoto;

    @Column(name = "ver_sueldo")
    private Integer verSueldo;

    @Column(name = "vacantes")
    private Integer vacantes;

    @Column(name = "experiencia_desde")
    private Integer experienciaDesde;

    @Column(name = "experiencia_hasta")
    private Integer experienciaHasta;

    @Column(name = "para_estudiantes")
    private Integer paraEstudiantes;

    @Column(name = "para_egresados")
    private Integer paraEgresados;

    @Column(name = "edad_desde")
    private Integer edadDesde;

    @Column(name = "edad_hasta")
    private Integer edadHasta;

    @Column(name = "disponibilidad_inmediata")
    private Integer disponibilidadInmediata;

    @Column(name = "disponible_viajes")
    private Integer disponibleViajes;

    @Column(name = "disponible_cambio_residencia")
    private Integer disponibleCambioResidencia;

    @Column(name = "curriculum_documentado")
    private Integer curriculumDocumentado;

    @Column(name = "visitantes")
    private Integer visitantes;

    @Column(name = "inscritos")
    private Integer inscritos;

    @Column(name = "sueldo_desde")
    private BigDecimal sueldoDesde;

    @Column(name = "sueldo_hasta")
    private BigDecimal sueldoHasta;

    @Column(name = "id_user_registro")
    private Long idUserRegistro;

    @Column(name = "beneficios")
    private String beneficios;

    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "requisitos")
    private String requisitos;
    
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_oferta")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaOferta;

    @Column(name = "fecha_inicia")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicia;

    @Column(name = "fecha_caduca")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCaduca;

    @Column(name = "fecha_contrato")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaContrato;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrato_laboral")
    private ContratoLaboral contratoLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jornada_laboral")
    private JornadaLaboral jornadaLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_oferta")
    private Pais paisOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_oferta")
    private Ubicacion ubicacionOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda_sueldo")
    private Moneda monedaSueldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_frecuencia_sueldo")
    private FrecuenciaSueldo frecuenciaSueldo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_posicion")
    private NivelPosicion nivelPosicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clase_licencia_conducir")
    private ClaseLicenciaConducir claseLicenciaConducir;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_empresa")
    private AreaEmpresa areaEmpresa;

    @OneToMany(mappedBy = "ofertaLaboral", fetch = FetchType.LAZY)
    private List<CarreraOfertaLaboral> carreraOfertaLaboral;

    @OneToMany(mappedBy = "ofertaLaboral", fetch = FetchType.LAZY)
    private List<IdiomaOfertaLaboral> idiomaOfertaLaboral;

    @Transient
    private List<TagEmpleabilidad> tags;

    @Transient
    private List<OfertaLaboral> otrasOfertas;

    @Transient
    private List<Carrera> carreras;

    public OfertaLaboral() {
    }

    public OfertaLaboral(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public OfertaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return OfertaEstadoEnum.valueOf(estado);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaOferta() {
        return fechaOferta;
    }

    public void setFechaOferta(Date fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public Date getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(Date fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public Long getIdUserRegistro() {
        return idUserRegistro;
    }

    public void setIdUserRegistro(Long idUserRegistro) {
        this.idUserRegistro = idUserRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getTrabajoRemoto() {
        return trabajoRemoto;
    }

    public void setTrabajoRemoto(Integer trabajoRemoto) {
        this.trabajoRemoto = trabajoRemoto;
    }

    public Integer getVerSueldo() {
        return verSueldo;
    }

    public void setVerSueldo(Integer verSueldo) {
        this.verSueldo = verSueldo;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public Integer getExperienciaDesde() {
        return experienciaDesde;
    }

    public void setExperienciaDesde(Integer experienciaDesde) {
        this.experienciaDesde = experienciaDesde;
    }

    public Integer getExperienciaHasta() {
        return experienciaHasta;
    }

    public void setExperienciaHasta(Integer experienciaHasta) {
        this.experienciaHasta = experienciaHasta;
    }

    public Integer getParaEstudiantes() {
        return paraEstudiantes;
    }

    public void setParaEstudiantes(Integer paraEstudiantes) {
        this.paraEstudiantes = paraEstudiantes;
    }

    public Integer getParaEgresados() {
        return paraEgresados;
    }

    public void setParaEgresados(Integer paraEgresados) {
        this.paraEgresados = paraEgresados;
    }

    public Integer getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(Integer edadDesde) {
        this.edadDesde = edadDesde;
    }

    public Integer getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(Integer edadHasta) {
        this.edadHasta = edadHasta;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Integer getDisponibilidadInmediata() {
        return disponibilidadInmediata;
    }

    public void setDisponibilidadInmediata(Integer disponibilidadInmediata) {
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    public Integer getDisponibleViajes() {
        return disponibleViajes;
    }

    public void setDisponibleViajes(Integer disponibleViajes) {
        this.disponibleViajes = disponibleViajes;
    }

    public Integer getDisponibleCambioResidencia() {
        return disponibleCambioResidencia;
    }

    public void setDisponibleCambioResidencia(Integer disponibleCambioResidencia) {
        this.disponibleCambioResidencia = disponibleCambioResidencia;
    }

    public Integer getCurriculumDocumentado() {
        return curriculumDocumentado;
    }

    public void setCurriculumDocumentado(Integer curriculumDocumentado) {
        this.curriculumDocumentado = curriculumDocumentado;
    }

    public Integer getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(Integer visitantes) {
        this.visitantes = visitantes;
    }

    public Integer getInscritos() {
        return inscritos;
    }

    public void setInscritos(Integer inscritos) {
        this.inscritos = inscritos;
    }

    public BigDecimal getSueldoDesde() {
        return sueldoDesde;
    }

    public void setSueldoDesde(BigDecimal sueldoDesde) {
        this.sueldoDesde = sueldoDesde;
    }

    public BigDecimal getSueldoHasta() {
        return sueldoHasta;
    }

    public void setSueldoHasta(BigDecimal sueldoHasta) {
        this.sueldoHasta = sueldoHasta;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public ContratoLaboral getContratoLaboral() {
        return contratoLaboral;
    }

    public void setContratoLaboral(ContratoLaboral contratoLaboral) {
        this.contratoLaboral = contratoLaboral;
    }

    public JornadaLaboral getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(JornadaLaboral jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public Pais getPaisOferta() {
        return paisOferta;
    }

    public void setPaisOferta(Pais paisOferta) {
        this.paisOferta = paisOferta;
    }

    public Ubicacion getUbicacionOferta() {
        return ubicacionOferta;
    }

    public void setUbicacionOferta(Ubicacion ubicacionOferta) {
        this.ubicacionOferta = ubicacionOferta;
    }

    public Moneda getMonedaSueldo() {
        return monedaSueldo;
    }

    public void setMonedaSueldo(Moneda monedaSueldo) {
        this.monedaSueldo = monedaSueldo;
    }

    public FrecuenciaSueldo getFrecuenciaSueldo() {
        return frecuenciaSueldo;
    }

    public void setFrecuenciaSueldo(FrecuenciaSueldo frecuenciaSueldo) {
        this.frecuenciaSueldo = frecuenciaSueldo;
    }

    public ClaseLicenciaConducir getClaseLicenciaConducir() {
        return claseLicenciaConducir;
    }

    public void setClaseLicenciaConducir(ClaseLicenciaConducir claseLicenciaConducir) {
        this.claseLicenciaConducir = claseLicenciaConducir;
    }

    public List<TagEmpleabilidad> getTags() {
        if (tags == null) {
            return new ArrayList();
        }

        return tags;
    }

    public void setTags(List<TagEmpleabilidad> tags) {
        this.tags = tags;
    }

    public List<IdiomaOfertaLaboral> getIdiomaOfertaLaboral() {
        if (idiomaOfertaLaboral == null) {
            return new ArrayList();
        }
        return idiomaOfertaLaboral;
    }

    public void setIdiomaOfertaLaboral(List<IdiomaOfertaLaboral> idiomaOfertaLaboral) {
        this.idiomaOfertaLaboral = idiomaOfertaLaboral;
    }

    public List<CarreraOfertaLaboral> getCarreraOfertaLaboral() {
        if (carreraOfertaLaboral == null) {
            return new ArrayList();
        }
        return carreraOfertaLaboral;
    }

    public void setCarreraOfertaLaboral(List<CarreraOfertaLaboral> carreraOfertaLaboral) {
        this.carreraOfertaLaboral = carreraOfertaLaboral;
    }

    public String getFechaOfertaStr() {
        if (fechaOferta == null) {
            return "";
        }
        return TypesUtil.getStringDateLongFormat(fechaOferta);
    }

    public String getFechaContratoStr() {
        if (fechaContrato == null) {
            return "";
        }
        return TypesUtil.getStringDateLongFormat(fechaContrato);
    }

    public List<OfertaLaboral> getOtrasOfertas() {
        return otrasOfertas;
    }

    public void setOtrasOfertas(List<OfertaLaboral> otrasOfertas) {
        this.otrasOfertas = otrasOfertas;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Date getFechaInicia() {
        return fechaInicia;
    }

    public void setFechaInicia(Date fechaInicia) {
        this.fechaInicia = fechaInicia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoOfertaLaboralEnum getTipoEnum() {
        if (isBlank(tipo)) {
            return null;
        }
        return TipoOfertaLaboralEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoOfertaLaboralEnum tipoOfertaLaboralEnum) {
        this.tipo = tipoOfertaLaboralEnum.name();
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public NivelPosicion getNivelPosicion() {
        return nivelPosicion;
    }

    public void setNivelPosicion(NivelPosicion nivelPosicion) {
        this.nivelPosicion = nivelPosicion;
    }

    public AreaEmpresa getAreaEmpresa() {
        return areaEmpresa;
    }

    public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
    }
    
}
