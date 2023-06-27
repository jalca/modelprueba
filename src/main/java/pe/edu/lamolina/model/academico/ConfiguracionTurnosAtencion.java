package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.enums.TipoMatriculaEnum;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_configuracion_turnos_atencion")
public class ConfiguracionTurnosAtencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "turnos_dia")
    private Integer turnosDia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "espera")
    private Integer espera;

    @Column(name = "alumnos")
    private Integer alumnos;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "es_generado")
    private Boolean isGenerado;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @JoinColumn(name = "id_evento_ciclo_academico")
    @ManyToOne(fetch = FetchType.LAZY)
    private EventoCicloAcademico eventoCicloAcademico;

    @OneToMany(mappedBy = "configuracionTurnosAtencion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TurnoAtencion> turnoAtencion;

    public ConfiguracionTurnosAtencion() {
    }

    public ConfiguracionTurnosAtencion(Long id) {
        this.id = id;
    }

    public List<TurnoAtencion> getTurnoAtencion() {
        return turnoAtencion;
    }

    public void setTurnoAtencion(List<TurnoAtencion> turnoAtencion) {
        this.turnoAtencion = turnoAtencion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getTurnosDia() {
        return turnosDia;
    }

    public void setTurnosDia(Integer turnosDia) {
        this.turnosDia = turnosDia;
    }

    public TipoMatriculaEnum getTipoEnum() {
        return TipoMatriculaEnum.valueOf(this.getTipo());
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getEspera() {
        return espera;
    }

    public void setEspera(Integer espera) {
        this.espera = espera;
    }

    public Integer getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Integer alumnos) {
        this.alumnos = alumnos;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public EventoCicloAcademico getEventoCicloAcademico() {
        return eventoCicloAcademico;
    }

    public void setEventoCicloAcademico(EventoCicloAcademico eventoCicloAcademico) {
        this.eventoCicloAcademico = eventoCicloAcademico;
    }

    public Boolean getIsGenerado() {
        return isGenerado;
    }

    public void setIsGenerado(Boolean isGenerado) {
        this.isGenerado = isGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ConfiguracionTurnosAtencion)) {
            return false;
        }
        ConfiguracionTurnosAtencion other = (ConfiguracionTurnosAtencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agrariaBd.AcaConfiguracionTurnosAtencion[ id=" + id + " ]";
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory, true);

        EventoCicloAcademico eventoCiclo = this.eventoCicloAcademico == null ? new EventoCicloAcademico() : this.eventoCicloAcademico;
        EventoAcademico eventoAca = eventoCiclo.getEventoAcademico() == null ? new EventoAcademico() : eventoCiclo.getEventoAcademico();

        json.set("eventos", JsonHelper.createJson(eventoAca, factory));
        return json;
    }

    public ArrayNode toJsonArray(List<ConfiguracionTurnosAtencion> lstconfig) {
        ArrayNode lstConfig = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objNode = new ObjectNode(JsonNodeFactory.instance);

        for (ConfiguracionTurnosAtencion config : lstconfig) {

            lstConfig.add(config.toJson());
        }

        return lstConfig;
    }
}
