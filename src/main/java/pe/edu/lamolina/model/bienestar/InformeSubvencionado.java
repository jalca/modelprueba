package pe.edu.lamolina.model.bienestar;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.contabilidad.OrdenSubvencionEconomia;
import pe.edu.lamolina.model.enums.EstadoInformeSubvencionEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_informe_subvencionado")
public class InformeSubvencionado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "informe")
    private String informe;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "motivo_cambio_importe")
    private String motivoCambioImporte;

    @Column(name = "importe_asignado")
    private BigDecimal importeAsignado;

    @Column(name = "fecha_informe")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInforme;

    @Column(name = "fecha_vobo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBo;

    @Column(name = "fecha_observaciones")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaObservaciones;

    @Column(name = "fecha_vobo_jefatura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoJefatura;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_vencio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVencio;

    @Column(name = "fecha_anulado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulado;

    @Column(name = "fecha_cambio_importe")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCambioImporte;

    @Column(name = "fecha_gasto_asignado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaGastoAsignado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_subvencion")
    private AlumnoSubvencionado alumnoSubvencionado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario_informe")
    private CalendarioInformeBolsista calendarioInforme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_subvencion_economia")
    private OrdenSubvencionEconomia ordenSubvencionEconomia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor_vobo")
    private Colaborador supervisorVoBo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_vobo_jefatura")
    private Colaborador colaboradorVoBoJefatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_informe")
    private Archivo archivoInforme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_vencio")
    private Usuario userVencio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulado")
    private Usuario userAnulado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cambio_importe")
    private Usuario userCambioImporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_gasto_asignado")
    private Usuario userGastoAsignado;

    @Transient
    private String tituloInvestigacion;

    public InformeSubvencionado() {
    }

    public InformeSubvencionado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoInformeSubvencionEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoInformeSubvencionEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoInformeSubvencionEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

}
