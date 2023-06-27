package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "extn_responsable_pago")
public class ResponsablePago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto_afavor")
    private BigDecimal montoAFavor;

    @Column(name = "monto_devolucion")
    private BigDecimal montoDevolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_devolucion")
    private Usuario userDevolucion;

    @Column(name = "fecha_devolucion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDevolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "responsablePago", fetch = FetchType.LAZY)
    private List<TallerVerano> tallerVerano;

    @Transient
    Boolean esFactura;

    @Transient
    BigDecimal deuda;

    @Transient
    Integer cantidadAlumnos;

    @Transient
    Boolean talleresPreInscritos;

    @Transient
    Boolean talleresRetirosCancelados;

    public ResponsablePago() {
    }

    public ResponsablePago(Object id) {
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

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Boolean getEsFactura() {
        if (esFactura == null) {
            return false;
        }
        return esFactura;
    }

    public void setEsFactura(Boolean esFactura) {
        this.esFactura = esFactura;
    }

    public List<TallerVerano> getTallerVerano() {
        return tallerVerano;
    }

    public void setTallerVerano(List<TallerVerano> tallerVerano) {
        this.tallerVerano = tallerVerano;
    }

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public Integer getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Integer cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Boolean getTalleresPreInscritos() {
        return talleresPreInscritos;
    }

    public void setTalleresPreInscritos(Boolean talleresPreInscritos) {
        this.talleresPreInscritos = talleresPreInscritos;
    }

    public Boolean getTalleresRetirosCancelados() {
        return talleresRetirosCancelados;
    }

    public void setTalleresRetirosCancelados(Boolean talleresRetirosCancelados) {
        this.talleresRetirosCancelados = talleresRetirosCancelados;
    }

    public BigDecimal getMontoAFavor() {
        if (montoAFavor == null) {
            return BigDecimal.ZERO;
        }
        return montoAFavor;
    }

    public void setMontoAFavor(BigDecimal montoAFavor) {
        this.montoAFavor = montoAFavor;
    }

    public BigDecimal getMontoDevolucion() {
        if (montoDevolucion == null) {
            return BigDecimal.ZERO;
        }
        return montoDevolucion;
    }

    public void setMontoDevolucion(BigDecimal montoDevolucion) {
        this.montoDevolucion = montoDevolucion;
    }

    public Usuario getUserDevolucion() {
        return userDevolucion;
    }

    public void setUserDevolucion(Usuario userDevolucion) {
        this.userDevolucion = userDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
