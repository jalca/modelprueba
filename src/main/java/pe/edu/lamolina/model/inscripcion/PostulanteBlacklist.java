package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TipoCastigoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Resolucion;

@Entity
@Table(name = "sip_postulante_blacklist")
public class PostulanteBlacklist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_castigo")
    private String tipoCastigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_inicio")
    private CicloPostula cicloInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_fin")
    private CicloPostula cicloFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    public PostulanteBlacklist() {
    }

    public PostulanteBlacklist(Object id) {
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoEnum() {
        EstadoEnum st = EstadoEnum.valueOf(estado);
        if (st == null) {
            return "Error";
        }
        return st.getValue();
    }

    public String getTipoCastigo() {
        return tipoCastigo;
    }

    public void setTipoCastigo(String tipoCastigo) {
        this.tipoCastigo = tipoCastigo;
    }

    @JsonIgnore
    public String getTipoCastigoEnum() {
        TipoCastigoEnum tipo = TipoCastigoEnum.valueOf(tipoCastigo);
        if (tipo == null) {
            return "Error";
        }
        return tipo.getValue();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public CicloPostula getCicloInicio() {
        return cicloInicio;
    }

    public void setCicloInicio(CicloPostula cicloInicio) {
        this.cicloInicio = cicloInicio;
    }

    public CicloPostula getCicloFin() {
        return cicloFin;
    }

    public void setCicloFin(CicloPostula cicloFin) {
        this.cicloFin = cicloFin;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public ObjectNode toJson() {

        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory, true);

        ObjectNode cicloInicio = JsonHelper.createJson(this.getCicloInicio(), factory);
        ObjectNode cicloFin = JsonHelper.createJson(this.getCicloFin() != null ? this.getCicloFin() : new CicloPostula(), factory);
        CicloAcademico ciclo1 = this.getCicloInicio().getCicloAcademico() != null ? this.getCicloInicio().getCicloAcademico() : new CicloAcademico();
        CicloAcademico ciclo2 = this.getCicloFin() != null ? this.getCicloFin().getCicloAcademico() : new CicloAcademico();
        cicloInicio.set("cicloAcademico", JsonHelper.createJson(ciclo1, factory));
        cicloFin.set("cicloAcademico", JsonHelper.createJson(ciclo2, factory));

        json.set("persona", JsonHelper.createJson(this.getPersona(), factory));
        json.set("cicloInicio", cicloInicio);
        json.set("cicloFin", cicloFin);

        return json;
    }

}
