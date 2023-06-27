package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.PostulanteApoyoEstadoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_postulante_apoyo")
public class PostulanteApoyo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cargo_unalm")
    private String cargoUnalm;

    @Column(name = "cargo_admision")
    private String cargoAdmision;

    @Column(name = "estado")
    private String estado;

    @Column(name = "aleatorio")
    private Integer aleatorio;

    @Column(name = "con_experiencia")
    private String conExperiencia;

    @Column(name = "pre_seleccionado")
    private Integer preSeleccionado;

    @Column(name = "motivo_cambio")
    private String motivoCambio;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_eleccion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEleccion;

    @Column(name = "fecha_cambio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apoyo")
    private Apoyo apoyo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_apoyo")
    private RolApoyo rolApoyo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_eleccion")
    private Usuario userEleccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cambio")
    private Usuario userCambio;

    @Transient
    private List<ExperienciaApoyo> experienciaApoyo;

    @Transient
    private String constancia;

    @Transient
    private String departamento;

    @Transient
    private List<Archivo> archivos;

    public PostulanteApoyo() {
    }

    public PostulanteApoyo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apoyo getApoyo() {
        return apoyo;
    }

    public void setApoyo(Apoyo apoyo) {
        this.apoyo = apoyo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCargoUnalm() {
        return cargoUnalm;
    }

    public void setCargoUnalm(String cargoUnalm) {
        this.cargoUnalm = cargoUnalm;
    }

    public String getCargoAdmision() {
        return cargoAdmision;
    }

    public void setCargoAdmision(String cargoAdmision) {
        this.cargoAdmision = cargoAdmision;
    }

    public String getEstado() {
        return estado;
    }

    public PostulanteApoyoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PostulanteApoyoEstadoEnum.valueOf(estado);
    }

    public void setEstado(PostulanteApoyoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Integer getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(Integer aleatorio) {
        this.aleatorio = aleatorio;
    }

    public String getConExperiencia() {
        return conExperiencia;
    }

    public void setConExperiencia(String conExperiencia) {
        this.conExperiencia = conExperiencia;
    }

    public RolApoyo getRolApoyo() {
        return rolApoyo;
    }

    public void setRolApoyo(RolApoyo rolApoyo) {
        this.rolApoyo = rolApoyo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaEleccion() {
        return fechaEleccion;
    }

    public void setFechaEleccion(Date fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
    }

    public Integer getPreSeleccionado() {
        return preSeleccionado;
    }

    public void setPreSeleccionado(Integer preSeleccionado) {
        this.preSeleccionado = preSeleccionado;
    }

    public Usuario getUserEleccion() {
        return userEleccion;
    }

    public void setUserEleccion(Usuario userEleccion) {
        this.userEleccion = userEleccion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

    public List<ExperienciaApoyo> getExperienciaApoyo() {
        return experienciaApoyo;
    }

    public void setExperienciaApoyo(List<ExperienciaApoyo> experienciaApoyo) {
        this.experienciaApoyo = experienciaApoyo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Usuario getUserCambio() {
        return userCambio;
    }

    public void setUserCambio(Usuario userCambio) {
        this.userCambio = userCambio;
    }

    public static class CompareToAleatorio implements Comparator<PostulanteApoyo> {

        @Override
        public int compare(PostulanteApoyo p1, PostulanteApoyo p2) {
            int preSelect = p2.getPreSeleccionado().compareTo(p1.getPreSeleccionado());
            return (preSelect == 0) ? p2.getAleatorio().compareTo(p1.getAleatorio()) : preSelect;

        }
    }

}
