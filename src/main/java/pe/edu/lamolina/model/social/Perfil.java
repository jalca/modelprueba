package pe.edu.lamolina.model.social;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "soc_perfil")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "experiencia")
    private String experiencia;

    @Column(name = "actualizado")
    private Integer actualizado;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "curriculum")
    private String curriculum;

    @Column(name = "ruta_avatar")
    private String rutaAvatar;

    @Column(name = "ruta_curriculum")
    private String rutaCurriculum;

    @Column(name = "website")
    private String website;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "privado")
    private Integer privado;

    @Column(name = "pretencion_salarial")
    private BigDecimal pretencionSalarial;

    @Column(name = "area_interes")
    private String areaInteres;

    @Temporal(DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Transient
    private List<OcupacionPersona> ocupaciones;

    @Transient
    private List<EducacionPersona> estudios;

    @Transient
    private String avatarImagen;

    @Transient
    private Integer avatarUpdate;

    @Transient
    private String curriculumUrl;

    @Transient
    private Integer curriUpdate;

    @Transient
    private Integer isContact;

    public Perfil() {
    }

    public Perfil(Object id) {
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

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getAvatarImagen() {
        return avatarImagen;
    }

    public void setAvatarImagen(String avatarImagen) {
        this.avatarImagen = avatarImagen;
    }

    public List<OcupacionPersona> getOcupaciones() {
        return ocupaciones;
    }

    public void setOcupaciones(List<OcupacionPersona> ocupaciones) {
        this.ocupaciones = ocupaciones;
    }

    public List<EducacionPersona> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<EducacionPersona> estudios) {
        this.estudios = estudios;
    }

    public Integer getActualizado() {
        return actualizado;
    }

    public void setActualizado(Integer actualizado) {
        this.actualizado = actualizado;
    }

    public Integer getAvatarUpdate() {
        return avatarUpdate;
    }

    public void setAvatarUpdate(Integer avatarUpdate) {
        this.avatarUpdate = avatarUpdate;
    }

    public String getCurriculumUrl() {
        return curriculumUrl;
    }

    public void setCurriculumUrl(String curriculumUrl) {
        this.curriculumUrl = curriculumUrl;
    }

    public Integer getCurriUpdate() {
        return curriUpdate;
    }

    public void setCurriUpdate(Integer curriUpdate) {
        this.curriUpdate = curriUpdate;
    }

    public Integer getIsContact() {
        return isContact;
    }

    public void setIsContact(Integer isContact) {
        this.isContact = isContact;
    }

    public String getRutaAvatar() {
        return rutaAvatar;
    }

    public void setRutaAvatar(String rutaAvatar) {
        this.rutaAvatar = rutaAvatar;
    }

    public String getRutaCurriculum() {
        return rutaCurriculum;
    }

    public void setRutaCurriculum(String rutaCurriculum) {
        this.rutaCurriculum = rutaCurriculum;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public ObjectNode toJson() {

        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory, true);

        Persona persona = this.getPersona() != null ? this.getPersona() : new Persona();
        Empresa empresa = this.getEmpresa() != null ? this.getEmpresa() : new Empresa();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        json.set("persona", JsonHelper.createJson(persona, factory));
        json.set("empresa", JsonHelper.createJson(empresa, factory));

        ArrayNode aEstudios = new ArrayNode(factory);
        for (EducacionPersona estudio : this.getEstudios()) {
            ObjectNode node = JsonHelper.createJson(estudio, JsonNodeFactory.instance);

            Universidad universidad = estudio.getUniversidad() == null ? new Universidad() : estudio.getUniversidad();
            Carrera carrera = estudio.getCarrera() == null ? new Carrera() : estudio.getCarrera();

            node.set("universidad", JsonHelper.createJson(universidad, factory));
            node.set("carrera", JsonHelper.createJson(carrera, factory));

            aEstudios.add(node);
        }
        json.set("estudios", aEstudios);

        ArrayNode aExperiencias = new ArrayNode(factory);
        for (OcupacionPersona ocupacion : this.getOcupaciones()) {
            ObjectNode node = JsonHelper.createJson(ocupacion, JsonNodeFactory.instance);

            Empresa empresaNode = ocupacion.getEmpresa() == null ? new Empresa() : ocupacion.getEmpresa();
            String fechaInicio = ocupacion.getFechaInicio() == null ? null : df.format(ocupacion.getFechaInicio());
            String fechaFin = ocupacion.getFechaFin() == null ? null : df.format(ocupacion.getFechaFin());

            node.put("fechaInicio", fechaInicio);
            node.put("fechaFin", fechaFin);
            node.set("empresa", JsonHelper.createJson(empresaNode, factory));

            aExperiencias.add(node);
        }
        json.set("ocupaciones", aExperiencias);

        return json;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public BigDecimal getPretencionSalarial() {
        return pretencionSalarial;
    }

    public void setPretencionSalarial(BigDecimal pretencionSalarial) {
        this.pretencionSalarial = pretencionSalarial;
    }

    public Integer getPrivado() {
        return privado;
    }

    public void setPrivado(Integer privado) {
        this.privado = privado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getAreaInteres() {
        return areaInteres;
    }

    public void setAreaInteres(String areaInteres) {
        this.areaInteres = areaInteres;
    }

}
