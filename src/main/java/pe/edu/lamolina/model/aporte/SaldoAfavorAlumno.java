package pe.edu.lamolina.model.aporte;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;

@Entity
@Table(name = "fin_saldo_afavor_alumno")
public class SaldoAfavorAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @Column(name = "saldo_contable")
    private BigDecimal saldoContable;

    @Column(name = "saldo_disponible")
    private BigDecimal saldoDisponible;

    @OneToMany(mappedBy = "saldoAfavorAlumno", fetch = FetchType.LAZY)
    private List<ItemSaldoAfavor> itemSaldoAfavor;

    @Transient
    private BigDecimal saldoNuevo;

    public SaldoAfavorAlumno() {
    }

    public SaldoAfavorAlumno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public SaldoAfavorAlumno(BigDecimal saldo, CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
        this.saldoDisponible = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public BigDecimal getSaldoContable() {
        return saldoContable;
    }

    public void setSaldoContable(BigDecimal saldoContable) {
        this.saldoContable = saldoContable;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public BigDecimal getSaldoNuevo() {
        return saldoNuevo;
    }

    public void setSaldoNuevo(BigDecimal saldoNuevo) {
        this.saldoNuevo = saldoNuevo;
    }

    public List<ItemSaldoAfavor> getItemSaldoAfavor() {
        return itemSaldoAfavor;
    }

    public void setItemSaldoAfavor(List<ItemSaldoAfavor> itemSaldoAfavor) {
        this.itemSaldoAfavor = itemSaldoAfavor;
    }

}
