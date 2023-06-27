package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ConceptoPosgradoEnum;
import pe.edu.lamolina.model.enums.EstadoConceptoPosgradoEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.finanzas.Moneda;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_concepto_posgrado")
public class ConceptoPosgrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_fda")
    private String codigoFda;

    @Column(name = "nombre_fda")
    private String nombreFda;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private BigDecimal monto;

    @NotNull
    @Column(name = "grupo_matricula")
    private Integer grupoMatricula;

    @Column(name = "codigo_economia")
    private String codigoEconomia;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "nombre_economia")
    private String nombreEconomia;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @OneToMany(mappedBy = "conceptoPosgrado", fetch = FetchType.LAZY)
    private List<AlumnoConceptoMatricula> alumnoConceptoMatricula;

    public ConceptoPosgrado() {
    }

    public ConceptoPosgrado(ConceptoPosgradoEnum conceptoPosgradoEnum) {
        this.id = conceptoPosgradoEnum.getId();
        this.codigo = conceptoPosgradoEnum.name();
    }

    public ConceptoPosgrado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCodigoEconomia() {
        return codigoEconomia;
    }

    public void setCodigoEconomia(String codigoEconomia) {
        this.codigoEconomia = codigoEconomia;
    }

    public Integer getGrupoMatricula() {
        return grupoMatricula;
    }

    public void setGrupoMatricula(Integer grupoMatricula) {
        this.grupoMatricula = grupoMatricula;
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

    public List<AlumnoConceptoMatricula> getAlumnoConceptoMatricula() {
        return alumnoConceptoMatricula;
    }

    public void setAlumnoConceptoMatricula(List<AlumnoConceptoMatricula> alumnoConceptoMatricula) {
        this.alumnoConceptoMatricula = alumnoConceptoMatricula;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @JsonIgnore
    public void setCodigoEnum(ConceptoPosgradoEnum codigoEnum) {
        if (codigoEnum != null) {
            this.estado = codigoEnum.name();
        }
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoConceptoPosgradoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public ConceptoPosgradoEnum getCodigoEnum() {
        if (StringUtils.isBlank(this.codigo)) {
            return null;
        }
        return ConceptoPosgradoEnum.valueOf(this.codigo);
    }

    public EstadoConceptoPosgradoEnum getEstadoEnum() {
        if (StringUtils.isBlank(this.codigo)) {
            return null;
        }
        return EstadoConceptoPosgradoEnum.valueOf(this.codigo);
    }

    public boolean getEsDerechoMatricula() {
        if (ConceptoPosgradoEnum.MAT.name().equals(this.codigo)) {
            return true;
        }
        return false;
    }

    public boolean getEsDerechoEnzenanza() {
        if (ConceptoPosgradoEnum.ENZ.name().equals(this.codigo)) {
            return true;
        }
        return false;
    }

    public String getNombreEconomia() {
        return nombreEconomia;
    }

    public void setNombreEconomia(String nombreEconomia) {
        this.nombreEconomia = nombreEconomia;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ConceptoPosgrado)) {
            return false;
        }
        ConceptoPosgrado other = (ConceptoPosgrado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getCodigoFda() {
        return codigoFda;
    }

    public void setCodigoFda(String codigoFda) {
        this.codigoFda = codigoFda;
    }

    public String getNombreFda() {
        return nombreFda;
    }

    public void setNombreFda(String nombreFda) {
        this.nombreFda = nombreFda;
    }

}
