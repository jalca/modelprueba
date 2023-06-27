package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.bienestar.DiaHora;
import pe.edu.lamolina.model.enums.ReservaAulaEstadoEnum;
import pe.edu.lamolina.model.enums.TipoReservaEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_reserva_aula")
public class ReservaAula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_reserva")
    private String tipoReserva;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Column(name = "cantidad_ambiente")
    private Integer cantidadAmbiente;

    @Column(name = "aforo")
    private Integer aforo;

    @Column(name = "varios_ambientes")
    private Boolean variosAmbientes;

    @Column(name = "capacidad_solicitada")
    private Integer capacidadSolicitada;

    @Column(name = "capacidad_ambiente_min")
    private Integer capacidadMinimaAmbiente;

    @Column(name = "capacidad_ambiente_max")
    private Integer capacidadMaximaAmbiente;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "visible_horario")
    private Boolean visibleHorario;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @OneToMany(mappedBy = "reservaAula")
    private List<AulaReservada> aulaReservada;

    @Transient
    private List<Aula> reservados;

    @Transient
    private List<DiaHora> diahora;

    public ReservaAula() {
        this.visibleHorario = Boolean.FALSE;
    }

    public ReservaAula(Object id) {
        this();
        this.id = TypesUtil.getLong(id);
    }

    public ReservaAula(Long id, String estado, Tramite tramite, String tipoReserva, Curso curso, Date fechaInicio, Date fechaFin) {
        this();
        this.id = id;
        this.estado = estado;
        this.tramite = tramite;
        this.tipoReserva = tipoReserva;
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ReservaAulaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ReservaAulaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(ReservaAulaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoReservaEnum getTipoReservaEnum() {
        if (this.tipoReserva == null) {
            return null;
        }
        return TipoReservaEnum.valueOf(this.tipoReserva);
    }

    @JsonIgnore
    public void setTipoReservaEnum(TipoReservaEnum tipoReserva) {
        if (tipoReserva == null) {
            return;
        }
        this.tipoReserva = tipoReserva.name();
    }

}
