package pe.edu.lamolina.model.escalafon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.util.Date;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(catalog = "lamolina", name = "esc_escalafon")
public class Escalafon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "archivo_curriculum")
    private String archivoCurriculum;

    @Column(name = "codigo_dina")
    private String codigoDina;

    @Column(name = "codigo_scopus")
    private String codigoScopus;

    @Column(name = "codigo_orcid")
    private String codigoOrcid;

    @Column(name = "website")
    private String website;

    @Column(name = "email_personal")
    private String emailPersonal;

    @Column(name = "celular")
    private String celular;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActualizacion;

    @Column(name = "id_usuario_actualizacion")
    private Long usuarioActualizacion;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCreacion;

    @Column(name = "id_usuario_registro")
    private Long usuarioRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_nacimiento")
    private Pais paisNacimiento;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<IdiomaEscalafon> idiomaEscalafon;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<ProduccionEscalafon> produccionEscalafon;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<InvestigacionEscalafon> investigacionEscalafon;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<ExperienciaAsesor> experienciaAsesor;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<ExperienciaEscalafon> experienciaEscalafon;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<AcademicoEscalafon> academicoEscalafon;

    @OneToMany(mappedBy = "escalafon", fetch = FetchType.LAZY)
    private List<DistincionEscalafon> distincionEscalafon;

    public Escalafon() {
    }

    public Escalafon(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getArchivoCurriculum() {
        return archivoCurriculum;
    }

    public void setArchivoCurriculum(String archivoCurriculum) {
        this.archivoCurriculum = archivoCurriculum;
    }

    public String getCodigoDina() {
        return codigoDina;
    }

    public void setCodigoDina(String codigoDina) {
        this.codigoDina = codigoDina;
    }

    public String getCodigoScopus() {
        return codigoScopus;
    }

    public void setCodigoScopus(String codigoScopus) {
        this.codigoScopus = codigoScopus;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(Long usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Long usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getCodigoOrcid() {
        return codigoOrcid;
    }

    public void setCodigoOrcid(String codigoOrcid) {
        this.codigoOrcid = codigoOrcid;
    }

    public List<IdiomaEscalafon> getIdiomaEscalafon() {
        return idiomaEscalafon;
    }

    public void setIdiomaEscalafon(List<IdiomaEscalafon> idiomaEscalafon) {
        this.idiomaEscalafon = idiomaEscalafon;
    }

    public List<ProduccionEscalafon> getProduccionEscalafon() {
        return produccionEscalafon;
    }

    public void setProduccionEscalafon(List<ProduccionEscalafon> produccionEscalafon) {
        this.produccionEscalafon = produccionEscalafon;
    }

    public List<InvestigacionEscalafon> getInvestigacionEscalafon() {
        return investigacionEscalafon;
    }

    public void setInvestigacionEscalafon(List<InvestigacionEscalafon> investigacionEscalafon) {
        this.investigacionEscalafon = investigacionEscalafon;
    }

    public List<ExperienciaAsesor> getExperienciaAsesor() {
        return experienciaAsesor;
    }

    public void setExperienciaAsesor(List<ExperienciaAsesor> experienciaAsesor) {
        this.experienciaAsesor = experienciaAsesor;
    }

    public List<ExperienciaEscalafon> getExperienciaEscalafon() {
        return experienciaEscalafon;
    }

    public void setExperienciaEscalafon(List<ExperienciaEscalafon> experienciaEscalafon) {
        this.experienciaEscalafon = experienciaEscalafon;
    }

    public List<AcademicoEscalafon> getAcademicoEscalafon() {
        return academicoEscalafon;
    }

    public void setAcademicoEscalafon(List<AcademicoEscalafon> academicoEscalafon) {
        this.academicoEscalafon = academicoEscalafon;
    }

    public List<DistincionEscalafon> getDistincionEscalafon() {
        return distincionEscalafon;
    }

    public void setDistincionEscalafon(List<DistincionEscalafon> distincionEscalafon) {
        this.distincionEscalafon = distincionEscalafon;
    }

}
