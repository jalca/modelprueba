package pe.edu.lamolina.model.posgrado.concepto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
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
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoDeudaPostulanteEscuelaEnum;
import pe.edu.lamolina.model.enums.TipoAbonoEnum;
import pe.edu.lamolina.model.finanzas.Acreencia;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.posgrado.admision.PostulanteEscuela;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "fin_deuda_postulante_escuela")
public class DeudaPostulanteEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_abono")
    private Usuario userAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transferencia_swift")
    private TransferenciaSwift transferenciaSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_admision_escuela")
    private ConceptoAdmisionEscuela conceptoAdmisionEscuela;

    @Transient
    private Acreencia acreencia;

    public DeudaPostulanteEscuela() {
    }

    public DeudaPostulanteEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public DateTime getFechaAbonoDatetime() {
        return new DateTime(this.getFechaAbono());
    }

    public void setTipoAbonoEnum(TipoAbonoEnum tipoAbonoEnum) {
        if (tipoAbonoEnum == null) {
            this.tipoAbono = null;
        }
        this.tipoAbono = tipoAbonoEnum.name();
    }

    @JsonIgnore
    public TipoAbonoEnum getTipoAbonoEnum() {
        if (Strings.isNullOrEmpty(this.tipoAbono)) {
            return null;
        }
        return TipoAbonoEnum.valueOf(this.tipoAbono);
    }

    public void setEstadoEnum(EstadoDeudaPostulanteEscuelaEnum estadoEnum) {
        if (estadoEnum == null) {
            this.estado = null;
        }
        this.estado = estadoEnum.name();
    }

    @JsonIgnore
    public EstadoDeudaPostulanteEscuelaEnum getEstadoEnum() {
        if (Strings.isNullOrEmpty(this.estado)) {
            return null;
        }
        return EstadoDeudaPostulanteEscuelaEnum.valueOf(estado);
    }

}
