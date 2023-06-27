package pe.edu.lamolina.model.posgrado.concepto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;
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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoAbonoEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "fin_transferencia_swift")
public class TransferenciaSwift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "banco_origen")
    private String bancoOrigen;

    @Column(name = "operacion_origen_swift")
    private String operacionOrigenSwift;

    @Column(name = "operacion_destino_swift")
    private String operacionDestinoSwift;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "importe_pagar")
    private BigDecimal importePagar;

    @Column(name = "importe_abono")
    private BigDecimal importeAbono;

    @Column(name = "monto_origen_swift")
    private BigDecimal montoOrigenSwift;

    @Column(name = "monto_destino_swift")
    private BigDecimal montoDestinoSwift;

    @Column(name = "fecha_registra_swift")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistraSwift;

    @Column(name = "fecha_valida_swift")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaValidaSwift;

    @Column(name = "fecha_origen_swift")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaOrigenSwift;

    @Column(name = "fecha_destino_swift")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaDestinoSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_voucher_swift")
    private Archivo archivoVoucherSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_banco_swift")
    private CuentaBancaria cuentaBancoSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registra_swift")
    private Usuario userRegistroSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_valida_swift")
    private Usuario userValidaSwift;

    public TransferenciaSwift() {
    }

    public TransferenciaSwift(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoAbonoEnum getTipoAbonoEnum() {
        if (StringUtils.isBlank(tipoAbono)) {
            return null;
        }
        return TipoAbonoEnum.valueOf(tipoAbono);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoAbonoEnum tipoAbono) {
        if (tipoAbono == null) {
            return;
        }
        this.tipoAbono = tipoAbono.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "bancoOrigen", bancoOrigen, false);
        ModelUtils.getDataByAttr(join, "operacionOrigenSwift", operacionOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "tipoAbono", tipoAbono, false);
        ModelUtils.getDataByAttr(join, "importePagar", importePagar, false);
        ModelUtils.getDataByAttr(join, "importeAbono", importeAbono, false);
        ModelUtils.getDataByAttr(join, "montoOrigenSwift", montoOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "montoDestinoSwift", montoDestinoSwift, false);
        ModelUtils.getDataByAttr(join, "fechaRegistraSwift", fechaRegistraSwift, false);
        ModelUtils.getDataByAttr(join, "fechaValidaSwift", fechaValidaSwift, false);
        ModelUtils.getDataByAttr(join, "fechaOrigenSwift", fechaOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "fechaDestinoSwift", fechaDestinoSwift, false);
        ModelUtils.getDataByAttrObject(join, "archivoVoucherSwift", archivoVoucherSwift, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "cuentaBancoSwift", cuentaBancoSwift, "id", "numero");
        ModelUtils.getDataByAttrObject(join, "userRegistroSwift", userRegistroSwift, "id", "google");

        return join.toString();
    }
}
