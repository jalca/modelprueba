package pe.edu.lamolina.model.general;

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
import pe.edu.lamolina.model.enums.EstadoEnum;
 
@Entity
@Table(name = "gen_contacto_empresa")
public class ContactoEmpresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo_validacion")
    private String codigoValidacion;

    @Column(name = "codigo_usado")
    private Integer codigoUsado;

    @Column(name = "fecha_validacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacion;

    @Column(name = "fecha_codigo_vence")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacionVence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public ContactoEmpresa() {
    }

    public ContactoEmpresa(Object id) {
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Integer getCodigoUsado() {
        return codigoUsado;
    }

    public void setCodigoUsado(Integer codigoUsado) {
        this.codigoUsado = codigoUsado;
    }

    public Date getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(Date fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }

    public Date getFechaValidacionVence() {
        return fechaValidacionVence;
    }

    public void setFechaValidacionVence(Date fechaValidacionVence) {
        this.fechaValidacionVence = fechaValidacionVence;
    }

    public ObjectNode toJson() {

        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory, true);

        Persona perso = this.getPersona() == null ? new Persona() : this.getPersona();
        Empresa emp = this.getEmpresa() == null ? new Empresa() : this.getEmpresa();

        json.set("persona", JsonHelper.createJson(perso, factory));
        json.set("empresa", JsonHelper.createJson(emp, factory));

        return json;
    }

}
