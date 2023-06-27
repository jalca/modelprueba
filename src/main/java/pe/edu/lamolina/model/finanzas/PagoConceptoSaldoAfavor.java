package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.ItemSaldoAfavor;
import pe.edu.lamolina.model.posgrado.AlumnoConceptoMatricula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_pago_concepto_saldo_afavor")
public class PagoConceptoSaldoAfavor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_concepto_matricula")
    private AlumnoConceptoMatricula alumnoConceptoMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_saldo_afavor")
    private ItemSaldoAfavor itemSaldoAfavor ;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_modifico")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModifico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifico")
    private Usuario userModifico;

    public PagoConceptoSaldoAfavor() {
    }

    public PagoConceptoSaldoAfavor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public AlumnoConceptoMatricula getAlumnoConceptoMatricula() {
        return alumnoConceptoMatricula;
    }

    public void setAlumnoConceptoMatricula(AlumnoConceptoMatricula alumnoConceptoMatricula) {
        this.alumnoConceptoMatricula = alumnoConceptoMatricula;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public Usuario getUserModifico() {
        return userModifico;
    }

    public void setUserModifico(Usuario userModifico) {
        this.userModifico = userModifico;
    }


    public ItemSaldoAfavor getItemSaldoAfavor() {
        return itemSaldoAfavor;
    }

    public void setItemSaldoAfavor(ItemSaldoAfavor itemSaldoAfavor) {
        this.itemSaldoAfavor = itemSaldoAfavor;
    }

}
