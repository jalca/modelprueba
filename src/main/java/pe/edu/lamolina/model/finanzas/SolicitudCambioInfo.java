package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.enums.SexoEnum;
import pe.edu.lamolina.model.enums.SolicitudCambioInfoEstadoEnum;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.GradoSecundaria;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.TipoDocIdentidad;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "sip_solicitud_cambio_info")
public class SolicitudCambioInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "universidad_extranjera")
    private String universidadExtranjera;

    @Column(name = "universidad_extranjera_anterior")
    private String universidadExtranjeraAnterior;

    @Column(name = "colegio_extranjero")
    private String colegioExtranjero;

    @Column(name = "colegio_extranjero_anterior")
    private String colegioExtranjeroAnterior;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "paterno_anterior")
    private String paternoAnterior;

    @Column(name = "materno")
    private String materno;

    @Column(name = "materno_anterior")
    private String maternoAnterior;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "nombres_anterior")
    private String nombresAnterior;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "primer_nombre_anterior")
    private String primerNombreAnterior;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "segundo_nombre_anterior")
    private String segundoNombreAnterior;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "sexo_anterior")
    private String sexoAnterior;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "telefono_anterior")
    private String telefonoAnterior;

    @Column(name = "celular")
    private String celular;

    @Column(name = "celular_anterior")
    private String celularAnterior;

    @Column(name = "email")
    private String email;

    @Column(name = "email_anterior")
    private String emailAnterior;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "direccion_anterior")
    private String direccionAnterior;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "grado_titulo")
    private String gradoTitulo;

    @Column(name = "grado_titulo_anterior")
    private String gradoTituloAnterior;

    @Column(name = "year_egreso_colegio")
    private Integer yearEgresoColegio;

    @Column(name = "year_egreso_colegio_anterior")
    private Integer yearEgresoColegioAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocIdentidad tipoDocumento;

    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_nacer")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacer;

    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_nacer_anterior")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacerAnterior;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_desactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cambio_info")
    private TipoCambioInfo tipoCambioInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_nueva")
    private ModalidadIngreso modalidadIngresoNueva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_anterior")
    private ModalidadIngreso modalidadIngresoAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio_nuevo")
    private Colegio colegioNuevo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio_anterior")
    private Colegio colegioAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad_nueva")
    private Universidad universidadNueva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad_anterior")
    private Universidad universidadAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desactivacion")
    private Usuario userDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_nacer")
    private Pais paisNacer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_nacer_anterior")
    private Pais paisNacerAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacionalidad")
    private Pais nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacionalidad_anterior")
    private Pais nacionalidadAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_domicilio")
    private Pais paisDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_domicilio_anterior")
    private Pais paisDomicilioAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_domicilio")
    private Ubicacion ubicacionDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_domicilio_anterior")
    private Ubicacion ubicacionDomicilioAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_nacer")
    private Ubicacion ubicacionNacer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_nacer_anterior")
    private Ubicacion ubicacionNacerAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_colegio")
    private Pais paisColegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_colegio_anterior")
    private Pais paisColegioAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_universidad")
    private Pais paisUniversidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_universidad_anterior")
    private Pais paisUniversidadAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_simulacion")
    private ModalidadIngreso modalidadSimulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_simulacion_anterior")
    private ModalidadIngreso modalidadSimulacionAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado_secundaria")
    private GradoSecundaria gradoSecundaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado_secundaria_anterior")
    private GradoSecundaria gradoSecundariaAnterior;

    public SolicitudCambioInfo() {
    }

    public SolicitudCambioInfo(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public SolicitudCambioInfoEstadoEnum getEstadoEnum() {
        if(this.estado == null) {
            return null;
        }
        return SolicitudCambioInfoEstadoEnum.valueOf(nombres);
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setEstadoEnum(SolicitudCambioInfoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public TipoCambioInfo getTipoCambioInfo() {
        return tipoCambioInfo;
    }

    public void setTipoCambioInfo(TipoCambioInfo tipoCambioInfo) {
        this.tipoCambioInfo = tipoCambioInfo;
    }

    public ModalidadIngreso getModalidadIngresoNueva() {
        return modalidadIngresoNueva;
    }

    public void setModalidadIngresoNueva(ModalidadIngreso modalidadIngresoNueva) {
        this.modalidadIngresoNueva = modalidadIngresoNueva;
    }

    public Colegio getColegioNuevo() {
        return colegioNuevo;
    }

    public void setColegioNuevo(Colegio colegioNuevo) {
        this.colegioNuevo = colegioNuevo;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserDesactivacion() {
        return userDesactivacion;
    }

    public void setUserDesactivacion(Usuario userDesactivacion) {
        this.userDesactivacion = userDesactivacion;
    }

    public String getUniversidadExtranjera() {
        return universidadExtranjera;
    }

    public void setUniversidadExtranjera(String universidadExtranjera) {
        this.universidadExtranjera = universidadExtranjera;
    }

    public String getColegioExtranjero() {
        return colegioExtranjero;
    }

    public void setColegioExtranjero(String colegioExtranjero) {
        this.colegioExtranjero = colegioExtranjero;
    }

    public Universidad getUniversidadNueva() {
        return universidadNueva;
    }

    public void setUniversidadNueva(Universidad universidadNueva) {
        this.universidadNueva = universidadNueva;
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

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @JsonIgnore
    public SexoEnum getSexoEnum() {
        if (sexo == null) {
            return null;
        }
        return SexoEnum.valueOf(sexo);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacer() {
        return fechaNacer;
    }

    public void setFechaNacer(Date fechaNacer) {
        this.fechaNacer = fechaNacer;
    }

    public Pais getPaisNacer() {
        return paisNacer;
    }

    public void setPaisNacer(Pais paisNacer) {
        this.paisNacer = paisNacer;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Pais getPaisDomicilio() {
        return paisDomicilio;
    }

    public void setPaisDomicilio(Pais paisDomicilio) {
        this.paisDomicilio = paisDomicilio;
    }

    public Ubicacion getUbicacionDomicilio() {
        return ubicacionDomicilio;
    }

    public void setUbicacionDomicilio(Ubicacion ubicacionDomicilio) {
        this.ubicacionDomicilio = ubicacionDomicilio;
    }

    public Ubicacion getUbicacionNacer() {
        return ubicacionNacer;
    }

    public void setUbicacionNacer(Ubicacion ubicacionNacer) {
        this.ubicacionNacer = ubicacionNacer;
    }

    public String getNumeroDocIdentidad() {
        return numeroDocIdentidad;
    }

    public void setNumeroDocIdentidad(String numeroDocIdentidad) {
        this.numeroDocIdentidad = numeroDocIdentidad;
    }

    public TipoDocIdentidad getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocIdentidad tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Pais getPaisColegio() {
        return paisColegio;
    }

    public void setPaisColegio(Pais paisColegio) {
        this.paisColegio = paisColegio;
    }

    public Pais getPaisUniversidad() {
        return paisUniversidad;
    }

    public void setPaisUniversidad(Pais paisUniversidad) {
        this.paisUniversidad = paisUniversidad;
    }

    public String getUniversidadExtranjeraAnterior() {
        return universidadExtranjeraAnterior;
    }

    public void setUniversidadExtranjeraAnterior(String universidadExtranjeraAnterior) {
        this.universidadExtranjeraAnterior = universidadExtranjeraAnterior;
    }

    public String getColegioExtranjeroAnterior() {
        return colegioExtranjeroAnterior;
    }

    public void setColegioExtranjeroAnterior(String colegioExtranjeroAnterior) {
        this.colegioExtranjeroAnterior = colegioExtranjeroAnterior;
    }

    public String getPaternoAnterior() {
        return paternoAnterior;
    }

    public void setPaternoAnterior(String paternoAnterior) {
        this.paternoAnterior = paternoAnterior;
    }

    public String getMaternoAnterior() {
        return maternoAnterior;
    }

    public void setMaternoAnterior(String maternoAnterior) {
        this.maternoAnterior = maternoAnterior;
    }

    public String getNombresAnterior() {
        return nombresAnterior;
    }

    public void setNombresAnterior(String nombresAnterior) {
        this.nombresAnterior = nombresAnterior;
    }

    public String getPrimerNombreAnterior() {
        return primerNombreAnterior;
    }

    public void setPrimerNombreAnterior(String primerNombreAnterior) {
        this.primerNombreAnterior = primerNombreAnterior;
    }

    public String getSegundoNombreAnterior() {
        return segundoNombreAnterior;
    }

    public void setSegundoNombreAnterior(String segundoNombreAnterior) {
        this.segundoNombreAnterior = segundoNombreAnterior;
    }

    public String getSexoAnterior() {
        return sexoAnterior;
    }

    public void setSexoAnterior(String sexoAnterior) {
        this.sexoAnterior = sexoAnterior;
    }

    public String getTelefonoAnterior() {
        return telefonoAnterior;
    }

    public void setTelefonoAnterior(String telefonoAnterior) {
        this.telefonoAnterior = telefonoAnterior;
    }

    public String getCelularAnterior() {
        return celularAnterior;
    }

    public void setCelularAnterior(String celularAnterior) {
        this.celularAnterior = celularAnterior;
    }

    public String getEmailAnterior() {
        return emailAnterior;
    }

    public void setEmailAnterior(String emailAnterior) {
        this.emailAnterior = emailAnterior;
    }

    public String getDireccionAnterior() {
        return direccionAnterior;
    }

    public void setDireccionAnterior(String direccionAnterior) {
        this.direccionAnterior = direccionAnterior;
    }

    public Date getFechaNacerAnterior() {
        return fechaNacerAnterior;
    }

    public void setFechaNacerAnterior(Date fechaNacerAnterior) {
        this.fechaNacerAnterior = fechaNacerAnterior;
    }

    public ModalidadIngreso getModalidadIngresoAnterior() {
        return modalidadIngresoAnterior;
    }

    public void setModalidadIngresoAnterior(ModalidadIngreso modalidadIngresoAnterior) {
        this.modalidadIngresoAnterior = modalidadIngresoAnterior;
    }

    public Colegio getColegioAnterior() {
        return colegioAnterior;
    }

    public void setColegioAnterior(Colegio colegioAnterior) {
        this.colegioAnterior = colegioAnterior;
    }

    public Universidad getUniversidadAnterior() {
        return universidadAnterior;
    }

    public void setUniversidadAnterior(Universidad universidadAnterior) {
        this.universidadAnterior = universidadAnterior;
    }

    public Pais getPaisNacerAnterior() {
        return paisNacerAnterior;
    }

    public void setPaisNacerAnterior(Pais paisNacerAnterior) {
        this.paisNacerAnterior = paisNacerAnterior;
    }

    public Pais getNacionalidadAnterior() {
        return nacionalidadAnterior;
    }

    public void setNacionalidadAnterior(Pais nacionalidadAnterior) {
        this.nacionalidadAnterior = nacionalidadAnterior;
    }

    public Pais getPaisDomicilioAnterior() {
        return paisDomicilioAnterior;
    }

    public void setPaisDomicilioAnterior(Pais paisDomicilioAnterior) {
        this.paisDomicilioAnterior = paisDomicilioAnterior;
    }

    public Ubicacion getUbicacionDomicilioAnterior() {
        return ubicacionDomicilioAnterior;
    }

    public void setUbicacionDomicilioAnterior(Ubicacion ubicacionDomicilioAnterior) {
        this.ubicacionDomicilioAnterior = ubicacionDomicilioAnterior;
    }

    public Ubicacion getUbicacionNacerAnterior() {
        return ubicacionNacerAnterior;
    }

    public void setUbicacionNacerAnterior(Ubicacion ubicacionNacerAnterior) {
        this.ubicacionNacerAnterior = ubicacionNacerAnterior;
    }

    public Pais getPaisColegioAnterior() {
        return paisColegioAnterior;
    }

    public void setPaisColegioAnterior(Pais paisColegioAnterior) {
        this.paisColegioAnterior = paisColegioAnterior;
    }

    public Pais getPaisUniversidadAnterior() {
        return paisUniversidadAnterior;
    }

    public void setPaisUniversidadAnterior(Pais paisUniversidadAnterior) {
        this.paisUniversidadAnterior = paisUniversidadAnterior;
    }

    public ModalidadIngreso getModalidadSimulacion() {
        return modalidadSimulacion;
    }

    public void setModalidadSimulacion(ModalidadIngreso modalidadSimulacion) {
        this.modalidadSimulacion = modalidadSimulacion;
    }

    public String getGradoTitulo() {
        return gradoTitulo;
    }

    public void setGradoTitulo(String gradoTitulo) {
        this.gradoTitulo = gradoTitulo;
    }

    public Integer getYearEgresoColegio() {
        return yearEgresoColegio;
    }

    public void setYearEgresoColegio(Integer yearEgresoColegio) {
        this.yearEgresoColegio = yearEgresoColegio;
    }

    public GradoSecundaria getGradoSecundaria() {
        return gradoSecundaria;
    }

    public void setGradoSecundaria(GradoSecundaria gradoSecundaria) {
        this.gradoSecundaria = gradoSecundaria;
    }

    public String getGradoTituloAnterior() {
        return gradoTituloAnterior;
    }

    public void setGradoTituloAnterior(String gradoTituloAnterior) {
        this.gradoTituloAnterior = gradoTituloAnterior;
    }

    public Integer getYearEgresoColegioAnterior() {
        return yearEgresoColegioAnterior;
    }

    public void setYearEgresoColegioAnterior(Integer yearEgresoColegioAnterior) {
        this.yearEgresoColegioAnterior = yearEgresoColegioAnterior;
    }

    public ModalidadIngreso getModalidadSimulacionAnterior() {
        return modalidadSimulacionAnterior;
    }

    public void setModalidadSimulacionAnterior(ModalidadIngreso modalidadSimulacionAnterior) {
        this.modalidadSimulacionAnterior = modalidadSimulacionAnterior;
    }

    public GradoSecundaria getGradoSecundariaAnterior() {
        return gradoSecundariaAnterior;
    }

    public void setGradoSecundariaAnterior(GradoSecundaria gradoSecundariaAnterior) {
        this.gradoSecundariaAnterior = gradoSecundariaAnterior;
    }

}
