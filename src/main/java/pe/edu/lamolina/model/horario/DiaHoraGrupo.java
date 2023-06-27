package pe.edu.lamolina.model.horario;

import java.io.Serializable;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Dia;

@Entity
@Table(name = "hor_dia_hora_grupo")
public class DiaHoraGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horario")
    private GrupoHoras grupoHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora")
    private Hora hora;

    @Transient
    private Boolean tieneCruce;

    @Transient
    private List<HorarioAula> horariosAula;

    public DiaHoraGrupo() {
    }

    public DiaHoraGrupo(CicloAcademico cicloAcademico, GrupoHoras grupoHorario, Dia dia, Hora hora) {
        this.cicloAcademico = cicloAcademico;
        this.grupoHorario = grupoHorario;
        this.dia = dia;
        this.hora = hora;
    }

    public DiaHoraGrupo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GrupoHoras getGrupoHorario() {
        return grupoHorario;
    }

    public void setGrupoHorario(GrupoHoras grupoHorario) {
        this.grupoHorario = grupoHorario;
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

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getKey() {
        return this.dia.getId() + "-" + this.hora.getId();
    }

    public String getIdDiaHora() {
        return this.dia.getId() + "_" + this.hora.getId();
    }

    public String getHoraDia() {
        return this.hora.getCodigo() + "-" + this.dia.getId();
    }

    public Boolean getTieneCruce() {
        return tieneCruce;
    }

    public void setTieneCruce(Boolean tieneCruce) {
        this.tieneCruce = tieneCruce;
    }

    public boolean isTieneHorarioSeccion(List<HorarioSeccion> horariosSecciones) {
        boolean found = false;
        for (HorarioSeccion horarioSeccionEach : horariosSecciones) {
            if (horarioSeccionEach.getDia().getId().compareTo(this.getDia().getId()) == 0
                    && horarioSeccionEach.getHora().getId().compareTo(this.getHora().getId()) == 0) {
                found = true;
            }
        }
        return found;
    }

    public List<HorarioAula> getHorariosAula() {
        return horariosAula;
    }

    public void setHorariosAula(List<HorarioAula> horariosAula) {
        this.horariosAula = horariosAula;
    }

}
