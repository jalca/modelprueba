package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.SeccionEstadoEnum;
import pe.edu.lamolina.model.enums.TipoCreditoEnum;
import pe.edu.lamolina.model.enums.TipoSeccionEvalEnum;
import pe.edu.lamolina.model.rrhh.ContratoDocente;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aca_docente_seccion")
public class DocenteSeccion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "principal")
    private Integer principal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "porcentaje_carga_fraccion")
    private String porcentajeCargaFraccion;

    @Column(name = "porcentaje_carga")
    private BigDecimal porcentajeCarga;

    @Column(name = "pago_verano")
    private BigDecimal pagoVerano;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFin;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaModifica;

    @Transient
    private String codigoDocente;
    @Transient
    private String codigoSeccion;
    @Transient
    private ModalidadEstudio encuestarModalidad;

    @Transient
    private ContratoDocente contratoDocente;

    public DocenteSeccion(Integer principal, String codigoDocente, String codigoSeccion, String carga) {
        this.principal = principal;
        this.codigoDocente = codigoDocente;
        this.codigoSeccion = codigoSeccion;
        if (!StringUtils.isEmpty(carga)) {
            this.porcentajeCarga = new BigDecimal(carga);
        }
    }

    public DocenteSeccion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean esDocentePrincipal() {
        if (principal != null) {
            if (BigDecimal.ONE.intValue() == principal.intValue()) {
                return true;
            }
        }
        return false;
    }

    public SeccionEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return SeccionEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(SeccionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public boolean isEstadoActivado() {
        if (EstadoEnum.ACT.name().equals(this.getEstado())) {
            return true;
        }
        return false;
    }

    public String getPagoVeranoFormato() {
        if (this.pagoVerano == null) {
            return null;
        }
        return NumberFormat.precio(this.pagoVerano);
    }

    public BigDecimal getCreditosCarga() {
        if (this.getEstadoEnum() != SeccionEstadoEnum.ACT) {
            return null;
        }
        Curso curso = (Curso) ObjectUtil.getParentTree(this, "seccion.grupoSeccion.curso");
        if (curso == null) {
            return null;
        }
        if (curso.getTipoCreditoEnum() != TipoCreditoEnum.FIJO) {
            return null;
        }
        if (this.getSeccion().getEstadoEnum() != SeccionEstadoEnum.ACT) {
            return null;
        }
        if (this.porcentajeCarga == null) {
            return null;
        }
        TipoSeccionEvalEnum tipoSecc = this.getSeccion().getTipoSeccionEnum().getTipoSeccionEvalEnum();
        Integer creditosSeccion = tipoSecc == TipoSeccionEvalEnum.TEO ? curso.getCreditosTeoria() : curso.getCreditosPractica();

        BigDecimal creditos = new BigDecimal(creditosSeccion);
        return this.porcentajeCarga.multiply(creditos).divide(new BigDecimal(100), 4, RoundingMode.HALF_UP);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DocenteSeccion)) {
            return false;
        }
        DocenteSeccion other = (DocenteSeccion) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return this.docente.getCodigo() + "-" + this.seccion.getCodigo3();
    }

    @Override
    public DocenteSeccion clone() {
        DocenteSeccion clone = null;
        try {
            clone = (DocenteSeccion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
