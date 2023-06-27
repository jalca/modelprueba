package pe.edu.lamolina.model.inscripcion;

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
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.InteresadoEstadoEnum;
import pe.edu.lamolina.model.enums.PostulanteEstadoEnum;
import pe.edu.lamolina.model.general.TipoDocIdentidad;

@Entity
@Table(name = "sip_interesado")
public class Interesado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_postulante")
    private String estadoPostulante;

    @Column(name = "email")
    private String email;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "facebook_link")
    private String facebookLink;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "codigo_verificacion")
    private String codigoVerificacion;
    
    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "es_administrador")
    private Integer esAdministrador;

    @Column(name = "contingecia")
    private Integer contingecia;

    @Column(name = "otra_carrera")
    private String otraCarrera;

    @Column(name = "avatar_color")
    private String avatarColor;

    @Column(name = "nota_interna")
    private String notaInterna;

    @Column(name = "exonerado_extemporaneo")
    private Boolean exoneradoExtemporaneo;

    @Column(name = "player_celular")
    private String playerCelular;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_interesado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInteresado;

    @Column(name = "fecha_postulante")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPostulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocIdentidad tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_nueva")
    private CarreraNueva carreraNueva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_interes")
    private Carrera carreraInteres;

    @OneToMany(mappedBy = "interesado", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @Transient
    private Long idTaller;

    public Interesado() {
        esAdministrador = 0;
    }

    public Interesado(Object id) {
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

    public InteresadoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return InteresadoEstadoEnum.valueOf(estado);
    }

    public void setEstado(InteresadoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getEstadoPostulante() {
        return estadoPostulante;
    }

    public PostulanteEstadoEnum getEstadoPostulanteEnum() {
        if (estadoPostulante == null) {
            return null;
        }
        return PostulanteEstadoEnum.valueOf(estadoPostulante);
    }

    public void setEstadoPostulante(PostulanteEstadoEnum estado) {
        this.estadoPostulante = estado.name();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaPostulante() {
        return fechaPostulante;
    }

    public void setFechaPostulante(Date fechaPostulante) {
        this.fechaPostulante = fechaPostulante;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Date getFechaInteresado() {
        return fechaInteresado;
    }

    public TipoDocIdentidad getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocIdentidad tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocIdentidad() {
        return numeroDocIdentidad;
    }

    public void setNumeroDocIdentidad(String numeroDocIdentidad) {
        this.numeroDocIdentidad = numeroDocIdentidad;
    }

    public String getNotaInterna() {
        return notaInterna;
    }

    public void setNotaInterna(String notaInterna) {
        this.notaInterna = notaInterna;
    }

    public CarreraNueva getCarreraNueva() {
        return carreraNueva;
    }

    public void setCarreraNueva(CarreraNueva carreraNueva) {
        this.carreraNueva = carreraNueva;
    }

    public Carrera getCarreraInteres() {
        return carreraInteres;
    }

    public void setCarreraInteres(Carrera carreraInteres) {
        this.carreraInteres = carreraInteres;
    }

    public void setFechaInteresado(Date fechaInteresado) {
        this.fechaInteresado = fechaInteresado;
    }

    public List<Postulante> getPostulante() {
        return postulante;
    }

    public void setPostulante(List<Postulante> postulante) {
        this.postulante = postulante;
    }

    public Long getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(Long idTaller) {
        this.idTaller = idTaller;
    }

    public Integer getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(Integer esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public String getOtraCarrera() {
        return otraCarrera;
    }

    public void setOtraCarrera(String otraCarrera) {
        this.otraCarrera = otraCarrera;
    }

    public String getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(String avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getPlayerCelular() {
        return playerCelular;
    }

    public void setPlayerCelular(String playerCelular) {
        this.playerCelular = playerCelular;
    }

    public Integer getContingecia() {
        return contingecia;
    }

    public void setContingecia(Integer contingecia) {
        this.contingecia = contingecia;
    }

    public Boolean getExoneradoExtemporaneo() {
        if (exoneradoExtemporaneo == null) {
            return false;
        }
        return exoneradoExtemporaneo;
    }

    public void setExoneradoExtemporaneo(Boolean exoneradoExtemporaneo) {
        this.exoneradoExtemporaneo = exoneradoExtemporaneo;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public String getApellidosNombres() {
        return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno) + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno)) + ", " + this.nombres;
    }

    public String getPaternoNombre() {
        String nom = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno);
        if (StringUtils.isEmpty(nom)) {
            nom = (StringUtils.isEmpty(this.materno) ? "" : this.materno);
        }

        return this.nombres.split(" ")[0] + " " + nom;
    }

    public String getNombrePaterno() {
        String pat = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno);
        if (StringUtils.isEmpty(pat)) {
            pat = (StringUtils.isEmpty(this.materno) ? "" : this.materno);
        }

        return this.nombres.split(" ")[0] + " " + pat;
    }

    public String getApellidos() {
        return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno) + (StringUtils.isEmpty(this.materno) ? "" : " " + this.materno);
    }

    public String getNombreCompleto() {
        return this.nombres + (StringUtils.isEmpty(this.paterno) ? "" : (" " + this.paterno)) + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno));
    }
    
    public String documentoContingencia(){
        
        return this.getNumeroDocIdentidad() + "-" + this.getCodigoVerificacion();
    }

    public String getAvatar() {
        int loop = 0;
        String avatar = "";
        if (!StringUtils.isBlank(this.nombres)) {
            avatar += this.nombres.substring(0, 1).toUpperCase();
            loop++;
        }
        if (!StringUtils.isBlank(this.paterno)) {
            avatar += this.paterno.substring(0, 1).toUpperCase();
            loop++;
        }

        if (loop < 2) {
            if (!StringUtils.isBlank(this.materno)) {
                avatar += this.materno.substring(0, 1).toUpperCase();
                loop++;
            }
        }
        return avatar;
    }

}
