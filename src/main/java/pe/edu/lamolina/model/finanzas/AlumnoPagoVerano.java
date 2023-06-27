package pe.edu.lamolina.model.finanzas;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "fin_alumno_pago_verano")
public class AlumnoPagoVerano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "consumo")
    private BigDecimal consumo;

    @Column(name = "deuda")
    private BigDecimal deuda;

    @Column(name = "deuda_seccion")
    private BigDecimal deudaSeccion;

    @Column(name = "monto_devuelto")
    private BigDecimal montoDevuelto;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_saldo_negativo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSaldoNegativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Seccion seccion;

    public AlumnoPagoVerano() {
    }

    public AlumnoPagoVerano(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        if (saldo == null) {
            return BigDecimal.ZERO;
        }
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {

        this.saldo = saldo;
    }

    public BigDecimal getAbono() {
        if (abono == null) {
            return BigDecimal.ZERO;
        }
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public BigDecimal getConsumo() {
        if (consumo == null) {
            return BigDecimal.ZERO;
        }
        return consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public Date getFechaSaldoNegativo() {
        return fechaSaldoNegativo;
    }

    public void setFechaSaldoNegativo(Date fechaSaldoNegativo) {
        this.fechaSaldoNegativo = fechaSaldoNegativo;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public BigDecimal getMontoDevuelto() {
        return montoDevuelto;
    }

    public void setMontoDevuelto(BigDecimal montoDevuelto) {
        this.montoDevuelto = montoDevuelto;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public BigDecimal getDeudaSeccion() {
        return deudaSeccion;
    }

    public void setDeudaSeccion(BigDecimal deudaSeccion) {
        this.deudaSeccion = deudaSeccion;
    }

}
