package pe.edu.lamolina.model.horario;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.EstadoHorarioAulaEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "hor_horario_seccion")
public class HorarioSeccion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "reservado")
    private String reservado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora")
    private Hora hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @Column(name = "fecha_ini")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Transient
    boolean seleccionado;

    public HorarioSeccion() {
    }

    public HorarioSeccion(Seccion seccion, Dia dia, Hora hora, Aula aula) {
        this.seccion = seccion;
        this.dia = dia;
        this.hora = hora;
        this.aula = aula;
    }

    public HorarioSeccion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public EstadoHorarioAulaEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoHorarioAulaEnum.valueOf(this.estado);
    }

    public void setEstadoEnum(EstadoHorarioAulaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public String getIdDiaHora() {
        return this.dia.getId() + "_" + this.hora.getId();
    }

    public String getHoraDia() {
        return this.hora.getCodigo() + "-" + this.dia.getId();
    }

    public boolean isTieneDiaHoraGrupo(List<DiaHoraGrupo> diasHorasGrupo) {
        boolean found = false;
        for (DiaHoraGrupo diaHoraGrupoEach : diasHorasGrupo) {
            if (this.getDia().getId().compareTo(diaHoraGrupoEach.getDia().getId()) == 0
                    && this.getHora().getId().compareTo(diaHoraGrupoEach.getHora().getId()) == 0) {
                found = true;
            }
        }
        return found;
    }

    public String getKey() {
        return this.seccion.getId() + "-" + this.dia.getId() + "-" + this.hora.getId();
    }

    @Override
    public HorarioSeccion clone() {
        HorarioSeccion clone = null;
        try {
            clone = (HorarioSeccion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @JsonIgnore
    public Integer getDiaHoraInteger() {
        return dia.getNumeroDia() + hora.getNumero();
    }

    public String getHoraDiaDescripcion() {
        return dia.getSimbolo() + " - " + hora.getDescripcion();
    }

    public boolean isEstadoActivo() {
        return EstadoHorarioAulaEnum.ACT == this.getEstadoEnum();
    }

}
