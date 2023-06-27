package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.NumeroCicloCepreEnum;
import pe.edu.lamolina.model.enums.PostulanteEstadoEnum;
import pe.edu.lamolina.model.enums.SexoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.TipoDocIdentidad;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_prelamolina")
public class Prelamolina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "es_ingresante")
    private Integer esIngresante;

    @Column(name = "descuento")
    private Integer descuento;

    @Column(name = "ciclo_regular")
    private Integer cicloRegular;

    @Column(name = "year")
    private Integer year;

    @Column(name = "numero_ciclo")
    private Integer numeroCiclo;

    @Column(name = "orden_merito")
    private Integer ordenMerito;

    @Column(name = "puntaje_final")
    private BigDecimal puntajeFinal;

    @Column(name = "puntaje_rm")
    private BigDecimal puntajeRm;

    @Column(name = "puntaje_rv")
    private BigDecimal puntajeRv;

    @Column(name = "puntaje_matematicas")
    private BigDecimal puntajeMatematicas;

    @Column(name = "puntaje_fisica")
    private BigDecimal puntajeFisica;

    @Column(name = "puntaje_quimica")
    private BigDecimal puntajeQuimica;

    @Column(name = "puntaje_biologia")
    private BigDecimal puntajeBiologia;

    @Column(name = "puntaje_algebra")
    private BigDecimal puntajeAlgebra;

    @Column(name = "puntaje_geometria")
    private BigDecimal puntajeGeometria;

    @Column(name = "puntaje_aritmetica")
    private BigDecimal puntajeAritmetica;

    @Column(name = "puntaje_trigonometria")
    private BigDecimal puntajeTrigonometria;

    @Column(name = "fecha_inscripcion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_validado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_postula")
    private CarreraPostula carreraPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_doc_identidad")
    private TipoDocIdentidad tipoDocIdentidad;

    @Transient
    private Boolean verificado;

    public Prelamolina() {
        verificado = false;
    }

    public Prelamolina(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCicloCepre() {
        String ciclo = this.year + " ";
        if (null != numeroCiclo) {
            switch (numeroCiclo) {
                case 0:
                    ciclo += " Intensivo";
                    break;
                case 1:
                    ciclo += " I Regular";
                    break;
                case 2:
                    ciclo += " II Regular";
                    break;
                default:
                    break;
            }
        }
        return ciclo;
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

    public void setEstado(PostulanteEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public CarreraPostula getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(CarreraPostula carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public void setEstadoEnum(PostulanteEstadoEnum estadoFactura) {
        this.estado = estadoFactura.name();
    }

    public PostulanteEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PostulanteEstadoEnum.valueOf(estado);
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getEsIngresante() {
        return esIngresante;
    }

    public void setEsIngresante(Integer esIngresante) {
        this.esIngresante = esIngresante;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getNumeroDocIdentidad() {
        return numeroDocIdentidad;
    }

    public void setNumeroDocIdentidad(String numeroDocIdentidad) {
        this.numeroDocIdentidad = numeroDocIdentidad;
    }

    public Date getFechaValidado() {
        return fechaValidado;
    }

    public void setFechaValidado(Date fechaValidado) {
        this.fechaValidado = fechaValidado;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(Integer numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public BigDecimal getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(BigDecimal puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public BigDecimal getPuntajeRm() {
        return puntajeRm;
    }

    public void setPuntajeRm(BigDecimal puntajeRm) {
        this.puntajeRm = puntajeRm;
    }

    public BigDecimal getPuntajeRv() {
        return puntajeRv;
    }

    public void setPuntajeRv(BigDecimal puntajeRv) {
        this.puntajeRv = puntajeRv;
    }

    public BigDecimal getPuntajeMatematicas() {
        return puntajeMatematicas;
    }

    public void setPuntajeMatematicas(BigDecimal puntajeMatematicas) {
        this.puntajeMatematicas = puntajeMatematicas;
    }

    public BigDecimal getPuntajeFisica() {
        return puntajeFisica;
    }

    public void setPuntajeFisica(BigDecimal puntajeFisica) {
        this.puntajeFisica = puntajeFisica;
    }

    public BigDecimal getPuntajeQuimica() {
        return puntajeQuimica;
    }

    public void setPuntajeQuimica(BigDecimal puntajeQuimica) {
        this.puntajeQuimica = puntajeQuimica;
    }

    public BigDecimal getPuntajeBiologia() {
        return puntajeBiologia;
    }

    public void setPuntajeBiologia(BigDecimal puntajeBiologia) {
        this.puntajeBiologia = puntajeBiologia;
    }

    public BigDecimal getPuntajeAlgebra() {
        return puntajeAlgebra;
    }

    public void setPuntajeAlgebra(BigDecimal puntajeAlgebra) {
        this.puntajeAlgebra = puntajeAlgebra;
    }

    public BigDecimal getPuntajeGeometria() {
        return puntajeGeometria;
    }

    public void setPuntajeGeometria(BigDecimal puntajeGeometria) {
        this.puntajeGeometria = puntajeGeometria;
    }

    public BigDecimal getPuntajeAritmetica() {
        return puntajeAritmetica;
    }

    public void setPuntajeAritmetica(BigDecimal puntajeAritmetica) {
        this.puntajeAritmetica = puntajeAritmetica;
    }

    public BigDecimal getPuntajeTrigonometria() {
        return puntajeTrigonometria;
    }

    public void setPuntajeTrigonometria(BigDecimal puntajeTrigonometria) {
        this.puntajeTrigonometria = puntajeTrigonometria;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoDocIdentidad getTipoDocIdentidad() {
        return tipoDocIdentidad;
    }

    public void setTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad) {
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public String getNombreCompleto() {
        return this.nombres + (StringUtils.isEmpty(this.paterno) ? "" : (" " + this.paterno)) + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno));
    }

    public String getApellidosNombres() {
        return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno) + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno)) + ", " + this.nombres;
    }

    public NumeroCicloCepreEnum getNumeroCepreEnum() {
        return NumeroCicloCepreEnum.getByNumeroCiclo(this.getNumeroCiclo());
    }

    public boolean isEstadoCreado() {
        if (PostulanteEstadoEnum.valueOf(estado).equals(PostulanteEstadoEnum.CRE)) {
            return true;
        }
        return false;

    }

    public Integer getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(Integer ordenMerito) {
        this.ordenMerito = ordenMerito;
    }

    public Integer getCicloRegular() {
        return cicloRegular;
    }

    public void setCicloRegular(Integer cicloRegular) {
        this.cicloRegular = cicloRegular;
    }

    public static class CompareOrdenMerito implements Comparator<Prelamolina> {

        @Override
        public int compare(Prelamolina pl1, Prelamolina pl2) {
            return pl2.getOrdenMerito().compareTo(pl1.getOrdenMerito());
        }
    }

    public static class CompareDescuento implements Comparator<Prelamolina> {

        @Override
        public int compare(Prelamolina cepre1, Prelamolina cepre2) {
            return cepre2.getDescuento().compareTo(cepre1.getDescuento());
        }
    }

    @JsonIgnore
    public SexoEnum getSexoEnum() {
        if (sexo == null) {
            return null;
        }
        return SexoEnum.valueOf(sexo);
    }

}
