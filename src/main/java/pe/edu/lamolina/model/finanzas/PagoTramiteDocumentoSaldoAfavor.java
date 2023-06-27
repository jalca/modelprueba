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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.ItemSaldoAfavor;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.TramiteDocumentoAcademico;

@Getter
@Setter
@Entity
@Table(name = "fin_pago_tramite_documento_saldo_afavor")
public class PagoTramiteDocumentoSaldoAfavor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_documento_academico")
    private TramiteDocumentoAcademico tramiteDocumentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_saldo_afavor")
    private ItemSaldoAfavor itemSaldoAfavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    public PagoTramiteDocumentoSaldoAfavor() {
    }

    public PagoTramiteDocumentoSaldoAfavor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
