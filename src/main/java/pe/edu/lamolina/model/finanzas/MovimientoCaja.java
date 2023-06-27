package pe.edu.lamolina.model.finanzas;

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
import javax.persistence.TemporalType;
import pe.edu.lamolina.model.enums.MovimientoCajaEstadoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "fin_movimiento_caja")
public class MovimientoCaja implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private int serie;

    @Column(name = "numero")
    private long numero;

    @Column(name = "estado")
    private String estado;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "devolver")
    private boolean devolver;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_operacion")
    private Date fechaOperacion;

    @JoinColumn(name = "id_user_registro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @JoinColumn(name = "id_movimiento_devolucion")
    @ManyToOne(fetch = FetchType.LAZY)
    private MovimientoCaja movimientoDevolucion;

    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;

    @JoinColumn(name = "id_resumen_abonos", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ResumenMovimientoCaja resumenAbonos;

    @OneToMany(mappedBy = "movimientoDevolucion", fetch = FetchType.LAZY)
    private List<MovimientoCaja> movimientoCaja;

    @OneToMany(mappedBy = "movimientoCaja", fetch = FetchType.LAZY)
    private List<MovimientoCajaAcreencia> movimientoCajaAcreencia;

    public MovimientoCaja() {
    }

    public MovimientoCaja(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(MovimientoCajaEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        estado = estadoEnum.name();
    }

    public MovimientoCajaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return MovimientoCajaEstadoEnum.valueOf(estado);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isDevolver() {
        return devolver;
    }

    public void setDevolver(boolean devolver) {
        this.devolver = devolver;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getImporteUtilizado() {
        return importeUtilizado;
    }

    public void setImporteUtilizado(BigDecimal importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
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

    public MovimientoCaja getMovimientoDevolucion() {
        return movimientoDevolucion;
    }

    public void setMovimientoDevolucion(MovimientoCaja movimientoDevolucion) {
        this.movimientoDevolucion = movimientoDevolucion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ResumenMovimientoCaja getResumenAbonos() {
        return resumenAbonos;
    }

    public void setResumenAbonos(ResumenMovimientoCaja resumenAbonos) {
        this.resumenAbonos = resumenAbonos;
    }

    public List<MovimientoCaja> getMovimientoCaja() {
        return movimientoCaja;
    }

    public void setMovimientoCaja(List<MovimientoCaja> movimientoCaja) {
        this.movimientoCaja = movimientoCaja;
    }

    public List<MovimientoCajaAcreencia> getMovimientoCajaAcreencia() {
        return movimientoCajaAcreencia;
    }

    public void setMovimientoCajaAcreencia(List<MovimientoCajaAcreencia> movimientoCajaAcreencia) {
        this.movimientoCajaAcreencia = movimientoCajaAcreencia;
    }

}
