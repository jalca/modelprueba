package pe.edu.lamolina.model.contabilidad;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import pe.edu.lamolina.model.bienestar.EventoAgrupacionAlumnos;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.bienestar.ViajeCurso;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "cont_orden_subvencion_economia")
public class OrdenSubvencionEconomia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private Long serie;
    
    @Column(name = "numero")
    private Long numero;
    
    @Column(name = "importe_total")
    private BigDecimal importeTotal;

    @Column(name = "numero_tramite_economia")
    private String numeroTramiteEconomia;

    @Column(name = "orden_servicio")
    private String ordenServicio;

    @Column(name = "responsable_tesoreria")
    private String responsableTesoreria;

    @Column(name = "fecha_tramite_economia")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaTramiteEconomia;

    @Column(name = "fecha_deposito")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeposito;

    @Column(name = "fecha_orden_servicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaOrdenServicio;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_registro_tramite")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroTramite;

    @Column(name = "fecha_registro_orden_servicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroOrdenServicio;

    @Column(name = "fecha_registro_deposito")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroDeposito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_viaje_curso")
    private ViajeCurso viajeCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_agrupacion_alumnos")
    private EventoAgrupacionAlumnos eventoAgrupacionAlumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_generacion_gasto_subvencion")
    private GeneracionGastoSubvencion generacionGastoSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_tramite")
    private Usuario userRegistroTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_orden_servicio")
    private Usuario userRegistroOrdenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro_deposito")
    private Usuario userRegistroDeposito;

    @Transient
    private Integer alumnos;
    @Transient
    private BigDecimal importeAlumno;
    @Transient
    private List<ItemOrdenSubvencion> itemsOrdenSubvencion;

    public OrdenSubvencionEconomia() {
    }

    public OrdenSubvencionEconomia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
