package pe.edu.lamolina.model.rolexamen;

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
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_fecha_hora_grupo_examen")
public class FechaHoraGrupoExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_examen")
    private GrupoHorasExamen grupoHorasExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semana_examen")
    private SemanaExamen semanaExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora")
    private Hora hora;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public FechaHoraGrupoExamen() {
    }

    public FechaHoraGrupoExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GrupoHorasExamen getGrupoHorasExamen() {
        return grupoHorasExamen;
    }

    public void setGrupoHorasExamen(GrupoHorasExamen grupoHorasExamen) {
        this.grupoHorasExamen = grupoHorasExamen;
    }

    public SemanaExamen getSemanaExamen() {
        return semanaExamen;
    }

    public void setSemanaExamen(SemanaExamen semanaExamen) {
        this.semanaExamen = semanaExamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getHoraDia() {
        return this.hora.getCodigo() + "-" + this.dia.getId();
    }

    public String getIdDiaHora() {
        return this.dia.getId() + "_" + this.hora.getId();
    }

    public String getDiaHora() {
        return this.getDia().getNumeroDia() + "-" + this.getHora().getNumero();
    }

}
