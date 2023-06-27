package pe.edu.lamolina.model.social;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.SocTipoEmpleo;
import pe.edu.lamolina.model.general.Cargo;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Rubro;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "soc_ocupacion_persona")
public class OcupacionPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cargo_text")
    private String cargoText;

    @Column(name = "ubicacion")
    private String ubicacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "labora_aqui")
    private Integer laboraAqui;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "otras_actividades")
    private String otrasActividades;

    @Column(name = "id_user_registro")
    private Long idUserRegistro;

    @Column(name = "otra_empresa")
    private String otraEmpresa;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_empresa")
    private AreaEmpresa areaEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_posicion")
    private NivelPosicion nivelPosicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_soc_tipo_empleo")
    private SocTipoEmpleo socTipoEmpleo;

    public OcupacionPersona() {
    }

    public OcupacionPersona(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public Integer getLaboraAqui() {
        return laboraAqui;
    }

    public void setLaboraAqui(Integer laboraAqui) {
        this.laboraAqui = laboraAqui;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getCargoText() {
        return cargoText;
    }

    public void setCargoText(String cargoText) {
        this.cargoText = cargoText;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getOtrasActividades() {
        return otrasActividades;
    }

    public void setOtrasActividades(String otrasActividades) {
        this.otrasActividades = otrasActividades;
    }

    public String getOtraEmpresa() {
        return otraEmpresa;
    }

    public void setOtraEmpresa(String otraEmpresa) {
        this.otraEmpresa = otraEmpresa;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public AreaEmpresa getAreaEmpresa() {
        return areaEmpresa;
    }

    public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
    }

    public NivelPosicion getNivelPosicion() {
        return nivelPosicion;
    }

    public void setNivelPosicion(NivelPosicion nivelPosicion) {
        this.nivelPosicion = nivelPosicion;
    }

    public SocTipoEmpleo getSocTipoEmpleo() {
        return socTipoEmpleo;
    }

    public void setSocTipoEmpleo(SocTipoEmpleo socTipoEmpleo) {
        this.socTipoEmpleo = socTipoEmpleo;
    }

}
