package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.enums.EstadoAcreenciaTramiteEnum;
import pe.edu.lamolina.model.enums.TipoAbonoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.TramiteDocumentoAcademico;

@Getter
@Setter
@Entity
@Table(name = "fin_acreencia_tramite_documento")
public class AcreenciaTramiteDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAnulacion;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_documento")
    private TramiteDocumentoAcademico tramiteDocumentoAcademico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_abono")
    private Usuario userAbono;

    public AcreenciaTramiteDocumento() {
    }

    public AcreenciaTramiteDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAcreenciaTramiteEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoAcreenciaTramiteEnum getEstadoEnum() {
        return EstadoAcreenciaTramiteEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoAbonoEnum tipoAbono) {
        if (tipoAbono == null) {
            return;
        }
        this.tipoAbono = tipoAbono.name();
    }

    public TipoAbonoEnum getTipoAbonoEnum() {
        return TipoAbonoEnum.valueOf(this.tipoAbono);
    }

}
