package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_turno_atencion")
public class TurnoAtencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_final")
    private String horaFinal;

    @Column(name = "turno")
    private Integer turno;

    @Column(name = "alumnos")
    private Integer alumnos;

    @Column(name = "prioridad_inicio")
    private BigDecimal prioridadInicio;

    @Column(name = "prioridad_fin")
    private BigDecimal prioridadFin;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_hora_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHoraFin;

    @Column(name = "fecha_hora_espera")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHoraEspera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_configuracion_turnos_atencion")
    private ConfiguracionTurnosAtencion configuracionTurnosAtencion;

    public TurnoAtencion() {
    }

    public Date getFechaHoraEspera() {
        return fechaHoraEspera;
    }

    public void setFechaHoraEspera(Date fechaHoraEspera) {
        this.fechaHoraEspera = fechaHoraEspera;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public TurnoAtencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Integer getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Integer alumnos) {
        this.alumnos = alumnos;
    }

    public BigDecimal getPrioridadInicio() {
        return prioridadInicio;
    }

    public void setPrioridadInicio(BigDecimal prioridadInicio) {
        this.prioridadInicio = prioridadInicio;
    }

    public BigDecimal getPrioridadFin() {
        return prioridadFin;
    }

    public void setPrioridadFin(BigDecimal prioridadFin) {
        this.prioridadFin = prioridadFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getIsGenerado() {
        return configuracionTurnosAtencion.getIsGenerado();
    }

    public ConfiguracionTurnosAtencion getConfiguracionTurnosAtencion() {
        return configuracionTurnosAtencion;
    }

    public void setConfiguracionTurnosAtencion(ConfiguracionTurnosAtencion configuracionTurnosAtencion) {
        this.configuracionTurnosAtencion = configuracionTurnosAtencion;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory, true);
        return json;
    }

    public ArrayNode toJsonArray(List<TurnoAtencion> lstTurnos) {
        ArrayNode lstTurno = new ArrayNode(JsonNodeFactory.instance);
        JsonNodeFactory factory = JsonNodeFactory.instance;

        for (TurnoAtencion turnos : lstTurnos) {

            lstTurno.add(JsonHelper.createJson(turnos, factory, new String[]{
                "*"
            }));
        }

        return lstTurno;
    }
}
