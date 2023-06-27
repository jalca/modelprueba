package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
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
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.enums.AmbitoTarifaEnum;
import pe.edu.lamolina.model.enums.persona.PersonaEstadoEnum;
import pe.edu.lamolina.model.enums.SexoEnum;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.misc.FotoHelper;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.social.EducacionPersona;
import pe.edu.lamolina.model.social.OcupacionPersona;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;
import pe.edu.lamolina.model.constantines.AcademicoConstantine;
import pe.edu.lamolina.model.enums.persona.OrigenValidacionEnum;
import pe.edu.lamolina.model.enums.persona.ValidacionEstadoEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@Entity
@Table(name = "gen_persona")
public class Persona implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "email")
    private String email;

    @Column(name = "email_compania")
    private String emailCompania;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "numero_doc_identidad2")
    private String numeroDocIdentidad2;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "titulo_academico")
    private String tituloAcademico;

    @Column(name = "foto")
    private String foto;

    @Column(name = "ruta_foto_postulante")
    private String rutaFotoPostulante;

    @Column(name = "ruta_foto_documento")
    private String rutaFotoDocumento;

    @Column(name = "ruta_foto_temporal")
    private String rutaFotoTemporal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_validacion")
    private String estadoValidacion;

    @Column(name = "origen_validacion")
    private String origenValidacion;

    @Column(name = "talla")
    private String talla;

    @Column(name = "otra_lengua")
    private String otraLengua;

    @Column(name = "coordenada_lima")
    private String coordenadaLima;

    @Column(name = "pov_lima")
    private String povLima;

    @Column(name = "url_foto_fachada_lima")
    private String urlFotoFachadaLima;

    @Column(name = "enviar_recauda")
    private Integer enviarRecauda;

    @Column(name = "con_discapacidad")
    private Integer conDiscapacidad;

    @Column(name = "fecha_envio_recauda")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnvioRecauda;

    @Column(name = "fecha_nacer")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacer;

    @Column(name = "fecha_traslado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaTraslado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_validacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacion;

    @Column(name = "fecha_validacion_reniec")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacionReniec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_nacer")
    private Ubicacion ubicacionNacer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocIdentidad tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_nacer")
    private Pais paisNacer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacionalidad")
    private Pais nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacionalidad2")
    private Pais nacionalidad2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_domicilio")
    private Pais paisDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_domicilio")
    private Ubicacion ubicacionDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_traslado")
    private Persona personaTraslado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion")
    private Usuario userValidacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion_reniec")
    private Usuario userValidacionReniec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lengua_materna")
    private Idioma lenguaMaterna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_traslado")
    private Usuario userTraslado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vacuna")
    private Archivo vacuna;

    @Column(name = "fecha_foto")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFoto;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Alumno> alumno;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Docente> docente;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Colaborador> colaborador;

    @OneToMany(mappedBy = "coordinador", fetch = FetchType.LAZY)
    private List<CoordinadorAmbientes> coordinadorAmbientes;

    @OneToMany(mappedBy = "personaJefe", fetch = FetchType.LAZY)
    private List<Oficina> oficina;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<PersonaCargo> personaPerfil;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Usuario> usuario;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Tramite> tramite;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<EducacionPersona> educacionPersona;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<OcupacionPersona> ocupacionPersona;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<PersonaIdioma> personaIdioma;

    @Transient
    private String codigoTipoDocumento;
    @Transient
    private String ubigeoNacer;
    @Transient
    private String ubigeoDomicilio;
    @Transient
    private String codigoPaisNacer;
    @Transient
    private String codigoNacionalidad;
    @Transient
    private String codigoEstadoCivil;
    @Transient
    private String ocupacion;
    @Transient
    private String fotoUpload;
    @Transient
    private String rutaArchivo;

    @Transient
    private OcupacionPersona transientOcupacionPersona;

    @Transient
    private EducacionPersona transientEducacionPersona;

    @Transient
    private List<TurnoAtencionAula> turnosAtencionAulas;

    public Persona() {
        this.estadoValidacion = ValidacionEstadoEnum.PENDIENTE.name();
    }

    public Persona(Persona tempo) {
        paterno = tempo.getPaterno();
        materno = tempo.getMaterno();
        nombres = tempo.getNombres();
        sexo = tempo.getSexo();
        email = tempo.getEmail();
        emailCompania = tempo.getEmailCompania();
        telefono = tempo.getTelefono();
        celular = tempo.getCelular();
        tipoDocumento = tempo.getTipoDocumento();
        numeroDocIdentidad = tempo.getNumeroDocIdentidad();
        direccion = tempo.getDireccion();
        tituloAcademico = tempo.getTituloAcademico();
        foto = tempo.getFoto();
        rutaFotoDocumento = tempo.getRutaFotoDocumento();
        rutaFotoPostulante = tempo.getRutaFotoPostulante();
        fechaNacer = tempo.getFechaNacer();
        ubicacionNacer = tempo.getUbicacionNacer();
        paisNacer = tempo.getPaisNacer();
        nacionalidad = tempo.getNacionalidad();
        ubicacionDomicilio = tempo.getUbicacionDomicilio();
        estadoValidacion = ValidacionEstadoEnum.PENDIENTE.name();
    }

    public Persona(String paterno, String materno, String nombres, String numeroDocIdentidad, String codigoTipoDocumento) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.numeroDocIdentidad = numeroDocIdentidad;
        this.codigoTipoDocumento = codigoTipoDocumento;
        this.estadoValidacion = ValidacionEstadoEnum.PENDIENTE.name();
    }

    public Persona(Object id) {
        this.id = TypesUtil.getLong(id);
        this.estadoValidacion = ValidacionEstadoEnum.PENDIENTE.name();
    }

    public Persona(TipoDocIdentidad tipo, String numeroDocIdentidad) {
        this.tipoDocumento = tipo;
        this.numeroDocIdentidad = numeroDocIdentidad;
        this.estadoValidacion = ValidacionEstadoEnum.PENDIENTE.name();
    }

    public String getCodigoPago() {
        if (this.tipoDocumento == null) {
            return this.numeroDocIdentidad;
        }

        String simbolo = this.tipoDocumento.getSimbolo();
        if (simbolo.equals("DNI")) {
            return this.numeroDocIdentidad;
        }
        return simbolo.substring(0, 1) + this.numeroDocIdentidad;
    }

    @JsonIgnore
    public SexoEnum getSexoEnum() {
        if (sexo == null || sexo.isEmpty()) {
            return null;
        }
        return SexoEnum.valueOf(sexo);
    }

    public boolean esFemenino() {
        if (this.sexo == null || sexo.isEmpty()) {
            return false;
        }
        return this.sexo.equals("F");
    }

    public boolean esMasculino() {
        if (this.sexo == null || this.sexo.isEmpty()) {
            return false;
        }
        return this.sexo.equals("M");
    }

    public String getEstimado() {
        return getEstimado("alter");
    }

    public String getEstimado(String formato) {
        String rpta = "Estimado(a)";
        if (sexo != null && !sexo.isEmpty() && getSexoEnum() == SexoEnum.F) {
            rpta = "Estimada";
        } else if (sexo != null && !sexo.isEmpty() && getSexoEnum() == SexoEnum.M) {
            rpta = "Estimado";
        }
        if (formato.equalsIgnoreCase("upper")) {
            return rpta.toUpperCase();
        }
        if (formato.equalsIgnoreCase("lower")) {
            return rpta.toLowerCase();
        }
        if (formato.equalsIgnoreCase("alter")) {
            return rpta;
        }
        return null;
    }

    public String getGeneroAlumno() {
        return getEstimado("alter");
    }

    public String getGeneroAlumno(String formato) {
        String rpta = "Alumno(a)";
        if (sexo != null && !sexo.isEmpty() && getSexoEnum() == SexoEnum.F) {
            rpta = "Alumna";
        } else if (sexo != null && !sexo.isEmpty() && getSexoEnum() == SexoEnum.M) {
            rpta = "Alumno";
        }
        if (formato.equalsIgnoreCase("upper")) {
            return rpta.toUpperCase();
        }
        if (formato.equalsIgnoreCase("lower")) {
            return rpta.toLowerCase();
        }
        if (formato.equalsIgnoreCase("alter")) {
            return rpta;
        }
        return null;
    }

    public PersonaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PersonaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PersonaEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public ValidacionEstadoEnum getEstadoValidacionEnum() {
        if (estadoValidacion == null) {
            return null;
        }
        return ValidacionEstadoEnum.valueOf(estadoValidacion);
    }

    @JsonIgnore
    public void setEstadoValidacionEnum(ValidacionEstadoEnum estadoValidacion) {
        if (estadoValidacion == null) {
            return;
        }
        this.estadoValidacion = estadoValidacion.name();
    }

    public OrigenValidacionEnum getOrigenValidacionEnum() {
        if (origenValidacion == null) {
            return null;
        }
        return OrigenValidacionEnum.valueOf(origenValidacion);
    }

    @JsonIgnore
    public void setOrigenValidacionEnum(OrigenValidacionEnum origenValidacion) {
        if (origenValidacion == null) {
            return;
        }
        this.origenValidacion = origenValidacion.name();
    }

    public Integer getMesesValidacion() {
        if (this.fechaValidacion == null) {
            return 100000;
        }

        DateTime f1 = new DateTime();
        DateTime f2 = new DateTime(this.fechaValidacion);
        return Months.monthsBetween(f2, f1).getMonths();
    }

    public Integer getEdad() {
        if (this.fechaNacer == null) {
            return null;
        }
        DateTime nac = new DateTime(this.fechaNacer);
        return Years.yearsBetween(nac, new DateTime()).getYears();
    }

    @JsonIgnore
    public String getNombreCompleto() {
        if (tieneNombre()) {
            return this.nombres
                    + (StringUtils.isEmpty(this.paterno) ? "" : (" " + this.paterno))
                    + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno));
        } else {
            return null;
        }
    }

    @JsonIgnore
    public String getNomPaternoMat() {
        String nom = this.nombres.substring(0, 1);
        String paterno = this.paterno;
        String materno = StringUtils.isEmpty(this.materno) ? "" : this.materno.substring(0, 1);
        return nom + ". " + paterno + " " + materno + ".";
    }

    @JsonIgnore
    public String getApellidosNombres() {
        if (tieneNombre()) {
            return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno)
                    + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno))
                    + ", " + this.nombres;
        } else {
            return null;
        }
    }

    @JsonIgnore
    public String getApellidosNombres30() {
        if (tieneNombre()) {
            String apellidosNombres = this.getApellidosNombres();

            if (apellidosNombres.length() > 30) {
                apellidosNombres = apellidosNombres.substring(0, 30) + "...";
            }

            return apellidosNombres;
        } else {
            return null;
        }
    }

    public String getNombreConTitulo() {
        if (tieneNombre()) {
            return (StringUtils.isEmpty(this.tituloAcademico) ? "" : (this.tituloAcademico + " ")) + getNombreCompleto();
        } else {
            return null;
        }
    }

    public String getPaternoNombre() {
        if (tieneNombre()) {
            String pat = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno);
            if (StringUtils.isEmpty(pat)) {
                pat = (StringUtils.isEmpty(this.materno) ? "" : this.materno);
            }

            return pat + " " + this.nombres.split(" ")[0];
        } else {
            return null;
        }
    }

    public String getNombrePaterno() {
        if (tieneNombre()) {
            String pat = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno);
            if (StringUtils.isEmpty(pat)) {
                pat = (StringUtils.isEmpty(this.materno) ? "" : this.materno);
            }

            return this.nombres.split(" ")[0] + " " + pat;
        } else {
            return null;
        }
    }

    public String getApellidos() {
        if (tieneNombre()) {
            return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno)
                    + (StringUtils.isEmpty(this.materno) ? "" : " " + this.materno);
        } else {
            return null;
        }
    }

    public void unirNombres() {
        if (StringUtils.isEmpty(this.primerNombre)) {
            return;
        }
        this.nombres = this.primerNombre + (StringUtils.isEmpty(this.segundoNombre) ? "" : " " + this.segundoNombre);
    }

    public String getNombrePaternoMat() {
        if (tieneNombre()) {
            String pat = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno);
            String mat = "";
            if (StringUtils.isEmpty(pat)) {
                pat = (StringUtils.isEmpty(this.materno) ? "" : this.materno);
            } else {
                mat = (StringUtils.isEmpty(this.materno) ? "" : " " + this.materno.toUpperCase().substring(0, 1) + ".");
            }

            return this.nombres.split(" ")[0] + " " + pat + mat;
        } else {
            return null;
        }
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

    public String getKey() {
        if (tieneNombre()) {
            String key = (StringUtils.isEmpty(this.paterno) ? "" : this.paterno.replaceAll(" ", "-"));
            key += "/" + (StringUtils.isEmpty(this.materno) ? "" : this.materno.replaceAll(" ", "-"));
            key += "/" + this.nombres.replaceAll(" ", "-");
            key = StringUtils.stripAccents(key).toLowerCase();
            return key;
        } else {
            return "SIN-NOMBRE";
        }
    }

    public String getIdentificacion() {
        String identi = null;
        if (this.tipoDocumento != null) {
            identi = this.tipoDocumento.getSimbolo();
        }
        if (!StringUtils.isEmpty(this.numeroDocIdentidad)) {
            identi += "-" + this.numeroDocIdentidad;
        }
        return identi;
    }

    public String getLetraNomPaterno() {
        if (tieneNombre()) {
            return this.nombres.substring(0, 1) + ". " + this.paterno;
        } else {
            return null;
        }
    }

    public String getRutaFoto() {
        String ruta = null;
        if (!StringUtils.isEmpty(this.rutaFotoDocumento)) {
            ruta = this.rutaFotoDocumento;
        } else if (!StringUtils.isEmpty(this.foto)) {
            ruta = this.foto;
        } else if (!StringUtils.isEmpty(this.rutaFotoPostulante)) {
            ruta = this.rutaFotoPostulante;
        }

        return FotoHelper.getRutaFoto(ruta, sexo);
    }

    public String getTipoFoto() {
        if (!StringUtils.isEmpty(this.rutaFotoDocumento)) {
            return "COMUN";
        } else if (!StringUtils.isEmpty(this.foto)) {
            return "COMUN";
        } else if (!StringUtils.isEmpty(this.rutaFotoPostulante)) {
            return "POSTUL";
        }

        return "TEMPO";
    }

    public String getFullRutaFotoTemporal() {
        if (!Strings.isNullOrEmpty(this.getRutaFotoTemporal())) {
            StringBuilder sb = new StringBuilder();
            sb.append(AcademicoConstantine.S3_URL_ACADEMICO);
            sb.append(AcademicoConstantine.S3_DIR_FOTO_TMP);
            sb.append(this.getRutaFotoTemporal());
            return sb.toString();
        }
        return this.getRutaFoto();
    }

    public String getFullRutaFotoTemporalDocumento() {
        if (!Strings.isNullOrEmpty(this.getRutaFotoTemporal())) {
            StringBuilder sb = new StringBuilder();
            sb.append(AcademicoConstantine.S3_URL_ACADEMICO);
            sb.append(AcademicoConstantine.S3_DIR_FOTO_DOCUMENTO);
            sb.append(this.getRutaFotoTemporal());
            return sb.toString();
        }
        return this.getRutaFoto();
    }

    public String getFullRutaFotoDocumento() {
        if (!Strings.isNullOrEmpty(this.getRutaFotoDocumento())) {
            StringBuilder sb = new StringBuilder();
            sb.append(AcademicoConstantine.S3_URL_ACADEMICO);
            sb.append(AcademicoConstantine.S3_DIR_FOTO_DOCUMENTO);
            sb.append(this.getRutaFotoDocumento());
            return sb.toString();
        }
        if (!Strings.isNullOrEmpty(this.sexo)) {
            switch (sexo) {
                case "M":
                    return GlobalConstantine.AVATAR_MALE;
                case "F":
                    return GlobalConstantine.AVATAR_FEMALE;
            }
        }
        return GlobalConstantine.AVATAR_UNKNOWN;
    }

    public Integer getConDiscapacidad() {
        // INICIO CAMBIO HECHO POR DAVID PINEDA
        if (conDiscapacidad == null) {
            return 0;
        }
        // FIN CAMBIO HECHO POR DAVID PINEDA
        return conDiscapacidad;
    }

    public void setConDiscapacidad(Integer conDiscapacidad) {
        this.conDiscapacidad = conDiscapacidad;
    }

    public AmbitoTarifaEnum getAmbitoTarifaEnum() {
        AmbitoTarifaEnum ambitoEnum = null;
        if (this.nacionalidad == null || this.nacionalidad.esPeru()) {
            ambitoEnum = AmbitoTarifaEnum.NAC;
        } else if (this.nacionalidad.getConvenioAndresBello() != null && this.nacionalidad.getConvenioAndresBello().compareTo(BigDecimal.ONE.intValue()) == 0) {
            ambitoEnum = AmbitoTarifaEnum.CAN;
        } else {
            ambitoEnum = AmbitoTarifaEnum.EXT;
        }
        return ambitoEnum;
    }

    private boolean tieneNombre() {
        return !StringUtils.isEmpty(paterno)
                || !StringUtils.isEmpty(materno)
                || !StringUtils.isEmpty(nombres);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public Persona clone() {
        Persona clone = null;
        try {
            clone = (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public CharSequence getSenior() {
        if (StringUtils.isEmpty(this.sexo)) {
            return "";
        }
        if (this.sexo.equals("M")) {
            return "Sra. ";
        }
        return "Sr. ";
    }

    public CharSequence getSeniorAll() {
        if (StringUtils.isEmpty(this.sexo)) {
            return "";
        }
        if (this.sexo.equals("M")) {
            return "Señorita ";
        }
        return "Señor ";
    }

    public String getRutaFotoPublic() {
        String ruta = null;
        if (!StringUtils.isEmpty(this.rutaFotoDocumento)) {
            ruta = this.rutaFotoDocumento;
        } else if (!StringUtils.isEmpty(this.foto)) {
            ruta = this.foto;
        } else if (!StringUtils.isEmpty(this.rutaFotoPostulante)) {
            ruta = this.rutaFotoPostulante;
        }

        return ruta == null ? this.getClass().getResource("/public" + FotoHelper.getRutaFoto(ruta, sexo)).toString() : ruta;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "paterno", paterno);
        ModelUtils.getDataByAttr(join, "materno", materno);
        ModelUtils.getDataByAttr(join, "nombres", nombres);
        ModelUtils.getDataByAttr(join, "primerNombre", primerNombre, false);
        ModelUtils.getDataByAttr(join, "segundoNombre", segundoNombre, false);
        ModelUtils.getDataByAttr(join, "observacion", observacion, false);
        ModelUtils.getDataByAttr(join, "sexo", sexo, false);
        ModelUtils.getDataByAttr(join, "email", email, false);
        ModelUtils.getDataByAttr(join, "emailCompania", emailCompania, false);
        ModelUtils.getDataByAttr(join, "celular", celular, false);
        ModelUtils.getDataByAttr(join, "telefono", telefono, false);
        ModelUtils.getDataByAttr(join, "numeroDocIdentidad", numeroDocIdentidad);
        ModelUtils.getDataByAttr(join, "numeroDocIdentidad2", numeroDocIdentidad2, false);
        ModelUtils.getDataByAttr(join, "direccion", direccion, false);
        ModelUtils.getDataByAttr(join, "tituloAcademico", tituloAcademico);
        ModelUtils.getDataByAttr(join, "foto", foto, false);
        ModelUtils.getDataByAttr(join, "rutaFotoPostulante", rutaFotoPostulante, false);
        ModelUtils.getDataByAttr(join, "rutaFotoTemporal", rutaFotoTemporal, false);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "estadoValidacion", estadoValidacion, false);
        ModelUtils.getDataByAttr(join, "origenValidacion", origenValidacion, false);
        ModelUtils.getDataByAttr(join, "talla", talla, false);
        ModelUtils.getDataByAttr(join, "otraLengua", otraLengua, false);
        ModelUtils.getDataByAttr(join, "coordenadaLima", coordenadaLima, false);
        ModelUtils.getDataByAttr(join, "povLima", povLima, false);
        ModelUtils.getDataByAttr(join, "urlFotoFachadaLima", urlFotoFachadaLima, false);
        ModelUtils.getDataByAttr(join, "conDiscapacidad", conDiscapacidad, false);
        ModelUtils.getDataByAttr(join, "enviarRecauda", enviarRecauda, false);
        ModelUtils.getDataByAttr(join, "fechaEnvioRecauda", fechaEnvioRecauda, false);
        ModelUtils.getDataByAttr(join, "fechaNacer", fechaNacer, false);
        ModelUtils.getDataByAttr(join, "fechaTraslado", fechaTraslado, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttr(join, "fechaValidacion", fechaValidacion, false);
        ModelUtils.getDataByAttr(join, "fechaValidacionReniec", fechaValidacionReniec, false);
        ModelUtils.getDataByAttr(join, "fechaFoto", fechaFoto, false);
        ModelUtils.getDataByAttrObject(join, "ubicacionNacer", ubicacionNacer, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "tipoDocumento", tipoDocumento, "id", "simbolo");
        ModelUtils.getDataByAttrObject(join, "paisNacer", paisNacer, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "nacionalidad", nacionalidad, "id", "codigo", "nacionalidad");
        ModelUtils.getDataByAttrObject(join, "paisDomicilio", paisDomicilio, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "ubicacionDomicilio", ubicacionDomicilio, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "personaTraslado", personaTraslado, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userValidacion", userValidacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userValidacionReniec", userValidacionReniec, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userTraslado", userTraslado, "id", "google");
        ModelUtils.getDataByAttr(join, "lenguaMaterna", lenguaMaterna, false);
        ModelUtils.getDataByAttr(join, "estadoCivil", estadoCivil, false);

        return join.toString();
    }
}
