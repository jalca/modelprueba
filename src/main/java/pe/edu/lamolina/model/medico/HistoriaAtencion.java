package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "med_historia_atencion")
public class HistoriaAtencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "medicacion")
    private String medicacion;

    @Column(name = "recomendaciones")
    private String recomendaciones;

    @Column(name = "procedimiento")
    private String procedimiento;

    @Column(name = "procedimientos_externos")
    private String procedimientosExternos;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "descanso_unalm")
    private Boolean descansoUnalm;

    @Column(name = "descanso_visado")
    private Boolean descansoVisado;

    @Column(name = "es_emergencia")
    private Boolean esEmergencia;

    @Column(name = "es_seguro_accidentes")
    private Boolean esSeguroAccidentes;

    @Column(name = "cantidad_dias_descanso")
    private Integer cantidadDiasDescanso;

    @Column(name = "consultorio_externo_descanso")
    private String consultorioExternoDescanso;

    @Column(name = "tipo_diagnostico")
    private String tipoDiagnostico;

    @Column(name = "fecha_inicio_descanso")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicioDescanso;

    @Column(name = "fecha_atencion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAtencion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_diagnostico_medico")
    private DiagnosticoMedico diagnosticoMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita_consultorio")
    private CitaConsultorio citaConsultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "historiaAtencion", fetch = FetchType.LAZY)
    private List<CuracionDental> curacionDental;

    @OneToMany(mappedBy = "historiaAtencion", fetch = FetchType.LAZY)
    private List<ExamenAuxiliar> examenesAuxiliares;

    @OneToMany(mappedBy = "historiaAtencion", fetch = FetchType.LAZY)
    private List<AtencionExterna> atencionExterna;

    @OneToMany(mappedBy = "historiaAtencion", fetch = FetchType.LAZY)
    private List<IngresoAtencionExterna> ingresoAtencionExterna;

    @Transient
    private Integer numeroCuraciones;
    @Transient
    private Integer numeroAtencionExterna;

    public HistoriaAtencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getProcedimientoAbreviado() {
        if (procedimiento.length() > 90) {
            return procedimiento.substring(0, 90).concat("...");
        }
        return "";
    }

    public Date getFechaFinDescanso() {
        if (this.fechaInicioDescanso == null) {
            return null;
        }
        if (this.cantidadDiasDescanso == null) {
            return null;
        }
        return new DateTime(this.fechaInicioDescanso).plusDays(this.cantidadDiasDescanso).toDate();
    }

}
