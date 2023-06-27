package pe.edu.lamolina.model.horario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.PhobosException;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.tramite.ReservaAula;
import pe.edu.lamolina.model.enums.EstadoHorarioAulaEnum;
import pe.edu.lamolina.model.enums.TipoHorarioAulaEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.rolexamen.CursoMasivoExamen;
import pe.edu.lamolina.model.rolexamen.FechaHoraGrupoExamen;
import pe.edu.lamolina.model.rolexamen.RolExamenes;
import pe.edu.lamolina.model.rolexamen.SeccionGrupoEspecial;
import pe.edu.lamolina.model.rolexamen.SeccionGrupoRegular;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "hor_horario_aula")
public class HorarioAula implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "reservado")
    private String reservado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tipo_modificacion")
    private String tipoModificacion;

    @Column(name = "fecha_ini")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_ini_anterior")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicioAnterior;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_fin_anterior")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora")
    private Hora hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva_aula")
    private ReservaAula reservaAula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion_grupo_regular")
    private SeccionGrupoRegular seccionGrupoRegular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion_grupo_especial")
    private SeccionGrupoEspecial seccionGrupoEspecial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_masivo_examen")
    private CursoMasivoExamen cursoMasivoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes_modificador")
    private RolExamenes rolExamenesModificador;

    @Transient
    private Boolean tieneCruce;

    public HorarioAula() {
    }

    public HorarioAula(Seccion seccion, Dia dia, Hora hora, Aula aula) {
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
        this.seccion = seccion;
    }

    public HorarioAula(FechaHoraGrupoExamen fechaHoraGrupoExamen, Seccion seccion) {
        // HorarioAula horarioAula = new HorarioAula();
        this.seccion = seccion;
        this.aula = seccion.getAula();
        this.dia = fechaHoraGrupoExamen.getDia();
        this.hora = fechaHoraGrupoExamen.getHora();
        this.estado = EstadoHorarioAulaEnum.ACT.name();
        this.setFechaInicio(fechaHoraGrupoExamen.getSemanaExamen().getFechaInicio());
        this.setFechaFin(fechaHoraGrupoExamen.getSemanaExamen().getFechaFin());
        this.tipo = TipoHorarioAulaEnum.EXAM.name();

        System.out.print("aula.id=" + this.aula.getId() + "/dia.id=" + this.dia.getId() + "/hora.id=" + this.hora.getId());
        System.out.print("/fecha.inicio=" + new DateTime(this.fechaInicio).toString("yyyy-MM-dd"));
        System.out.print("/seccion.id=" + seccion.getId());
        System.out.println("/fecha.fin=" + new DateTime(this.fechaFin).toString("yyyy-MM-dd"));
    }

    public HorarioAula(FechaHoraGrupoExamen fechaHoraGrupoExamen, Aula aula) {
        // HorarioAula horarioAula = new HorarioAula();
        this.aula = aula;
        this.dia = fechaHoraGrupoExamen.getDia();
        this.hora = fechaHoraGrupoExamen.getHora();
        this.setFechaFin(fechaHoraGrupoExamen.getSemanaExamen().getFechaFin());
        this.setFechaInicio(fechaHoraGrupoExamen.getSemanaExamen().getFechaInicio());
        this.estado = EstadoHorarioAulaEnum.ACT.name();
        this.tipo = TipoHorarioAulaEnum.EXAM.name();
    }

    public HorarioAula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public void setFechaInicio(Date fechaInicio) {
        if (fechaInicio == null) {
            this.fechaInicio = null;
            return;
        }
        this.fechaInicio = fechaInicio;
        if (this.fechaFin == null) {
            return;
        }
        if (this.fechaInicio.after(this.fechaFin)) {
            throw new PhobosException("Fecha en orden incorrectas para definir horario de aulas");
        }
    }

    public void setFechaFin(Date fechaFin) {
        if (fechaFin == null) {
            this.fechaFin = null;
            return;
        }
        this.fechaFin = fechaFin;
        if (this.fechaInicio == null) {
            return;
        }
        if (this.fechaInicio.after(this.fechaFin)) {
            throw new PhobosException("Fecha en orden incorrectas para definir horario de aulas");
        }
    }

    @JsonIgnore
    public DateTime getFechaInicioDateTime() {
        return new DateTime(this.fechaInicio);
    }

    @JsonIgnore
    public DateTime getFechaFinDateTime() {
        return new DateTime(this.fechaFin);
    }

    public EstadoHorarioAulaEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoHorarioAulaEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoHorarioAulaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public void setTipoEnum(TipoHorarioAulaEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.name();
        }
    }

    public TipoHorarioAulaEnum getTipoEnum() {
        if (StringUtils.isBlank(this.tipo)) {
            return null;
        }
        return TipoHorarioAulaEnum.valueOf(this.tipo);
    }

    public boolean isTipoExamen() {
        if (StringUtils.isBlank(this.tipo)) {
            return false;
        }
        return TipoHorarioAulaEnum.EXAM.equals(this.getTipoEnum());
    }

    public String getPeriodo() {
        String periodo = new DateTime(this.fechaInicio).toString("yyyy-MM-dd") + " - "
                + new DateTime(this.fechaFin).toString("yyyy-MM-dd");
        return periodo;
    }

    public boolean isEstadoActivo() {
        return EstadoHorarioAulaEnum.ACT == this.getEstadoEnum();
    }

    public String getHoraDiaDescripcion() {
        return dia.getSimbolo() + " - " + hora.getDescripcion();
    }

    public String getKey() {
        return this.aula.getId() + "-" + this.dia.getId() + "-" + this.hora.getId();
    }

    public String getIdDiaHora() {
        return this.dia.getId() + "_" + this.hora.getId();
    }

    public String getHoraDia() {
        return this.hora.getCodigo() + "-" + this.dia.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof HorarioAula)) {
            return false;
        }
        HorarioAula other = (HorarioAula) obj;
        if (id != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public HorarioAula clone() {
        HorarioAula clone = null;
        try {
            clone = (HorarioAula) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "{ aula:" + this.aula.getCodigo()
                + ", dia:" + this.dia.getId()
                + ", hora:" + this.hora.getCodigo()
                + ", fecha.ini:" + new DateTime(this.fechaInicio).toString("dd/MM/yyyy")
                + ", fecha.fin:" + new DateTime(this.fechaFin).toString("dd/MM/yyyy")
                + ", seccion:" + this.seccion.getId()
                + " }";
    }
}
