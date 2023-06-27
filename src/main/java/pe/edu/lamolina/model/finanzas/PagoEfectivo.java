package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.NombreTablasEnum;
import pe.edu.lamolina.model.enums.TipoEfectivoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.medico.ExamenMedico;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "fin_pago_efectivo")
public class PagoEfectivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tabla")
    private String tabla;

    @Column(name = "instancia")
    private Long instancia;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "utilizado")
    private BigDecimal utilizado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "fecha_abono")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAbono;

    @Column(name = "numero_operacion")
    private String numeroOperacion;

    @Column(name = "id_user_registro")
    private Long usuarioRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Transient
    private ExamenMedico examenMedico;

    public PagoEfectivo() {
    }

    public PagoEfectivo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public NombreTablasEnum getTablaEnum() {
        if (tabla == null) {
            return null;
        }
        return NombreTablasEnum.valueOf(tabla);
    }

    @JsonIgnore
    public void setTablaEnum(NombreTablasEnum tablaEnum) {
        if (tablaEnum == null) {
            return;
        }
        tabla = tablaEnum.name();
    }

    public Long getInstancia() {
        return instancia;
    }

    public void setInstancia(Long instancia) {
        this.instancia = instancia;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public BigDecimal getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(BigDecimal utilizado) {
        this.utilizado = utilizado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(String tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public TipoEfectivoEnum getTipoAbonoEnum() {
        if (tipoAbono == null) {
            return null;
        }
        return TipoEfectivoEnum.valueOf(tipoAbono);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoEfectivoEnum efectivoEnum) {
        if (efectivoEnum == null) {
            return;
        }
        tipoAbono = efectivoEnum.name();
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Long usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ExamenMedico getExamenMedico() {
        return examenMedico;
    }

    public void setExamenMedico(ExamenMedico examenMedico) {
        this.examenMedico = examenMedico;
    }

}
