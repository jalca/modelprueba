package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.horario.DiaHoraGrupo;
import pe.edu.lamolina.model.horario.GrupoHoras;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.horario.HorarioAula;
import pe.edu.lamolina.model.horario.HorarioSeccion;
import pe.edu.lamolina.model.optativo.DiaHoraHorarioCiclo;
import pe.edu.lamolina.model.optativo.HorarioCursoOptativo;

@Entity
@Table(name = "gen_dia")
public class Dia implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_dia")
    private Integer numeroDia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "simbolo")
    private String simbolo;

    @OneToMany(mappedBy = "dia", fetch = FetchType.LAZY)
    private List<DiaHoraGrupo> diaHoraGrupo;

    @OneToMany(mappedBy = "dia", fetch = FetchType.LAZY)
    private List<HorarioSeccion> horarioSeccion;

    @OneToMany(mappedBy = "dia", fetch = FetchType.LAZY)
    private List<HorarioCursoOptativo> horarioCursoOptativo;

    @Transient
    private String selecionado;

    @Transient
    private HorarioAula mainHorarioAula;

    @Transient
    private String seleccionable;

    @Transient
    private HorarioCursoOptativo mainHorarioCursoOptativo;

    @Transient
    private DiaHoraHorarioCiclo mainDiaHoraHorarioCiclo;

    @Transient
    private GrupoHoras grupohoras;

    @Transient
    private List<Hora> horas;

    public Dia() {
    }

    public Dia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(Integer numeroDia) {
        this.numeroDia = numeroDia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DiaHoraGrupo> getDiaHoraGrupo() {
        return diaHoraGrupo;
    }

    public void setDiaHoraGrupo(List<DiaHoraGrupo> diaHoraGrupo) {
        this.diaHoraGrupo = diaHoraGrupo;
    }

    public List<HorarioSeccion> getHorarioSeccion() {
        return horarioSeccion;
    }

    public void setHorarioSeccion(List<HorarioSeccion> horarioSeccion) {
        this.horarioSeccion = horarioSeccion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory);
        return json;
    }

    public String getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }

    public HorarioAula getMainHorarioAula() {
        return mainHorarioAula;
    }

    public void setMainHorarioAula(HorarioAula mainHorarioAula) {
        this.mainHorarioAula = mainHorarioAula;
    }

    @Override
    public Dia clone() {
        Dia clone = null;
        try {
            clone = (Dia) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getSeleccionable() {
        return seleccionable;
    }

    public void setSeleccionable(String seleccionable) {
        this.seleccionable = seleccionable;
    }

    public List<HorarioCursoOptativo> getHorarioCursoOptativo() {
        return horarioCursoOptativo;
    }

    public void setHorarioCursoOptativo(List<HorarioCursoOptativo> horarioCursoOptativo) {
        this.horarioCursoOptativo = horarioCursoOptativo;
    }

    public HorarioCursoOptativo getMainHorarioCursoOptativo() {
        return mainHorarioCursoOptativo;
    }

    public void setMainHorarioCursoOptativo(HorarioCursoOptativo mainHorarioCursoOptativo) {
        this.mainHorarioCursoOptativo = mainHorarioCursoOptativo;
    }

    public DiaHoraHorarioCiclo getMainDiaHoraHorarioCiclo() {
        return mainDiaHoraHorarioCiclo;
    }

    public void setMainDiaHoraHorarioCiclo(DiaHoraHorarioCiclo mainDiaHoraHorarioCiclo) {
        this.mainDiaHoraHorarioCiclo = mainDiaHoraHorarioCiclo;
    }

    public GrupoHoras getGrupohoras() {
        return grupohoras;
    }

    public void setGrupohoras(GrupoHoras grupohoras) {
        this.grupohoras = grupohoras;
    }

    public String getSimboloAbr() {
        String simboloAbr = "";
        switch (this.numeroDia) {
            case 1:
                simboloAbr = "L";
                break;
            case 2:
                simboloAbr = "Ma";
                break;
            case 3:
                simboloAbr = "Mi";
                break;
            case 4:
                simboloAbr = "J";
                break;
            case 5:
                simboloAbr = "V";
                break;
            case 6:
                simboloAbr = "S";
                break;
            case 7:
                simboloAbr = "D";
                break;
        }

        return simboloAbr;
    }

    public static class CompareNumero implements Comparator<Dia> {

        @Override
        public int compare(Dia d1, Dia d2) {
            return d1.numeroDia.compareTo(d2.numeroDia);
        }
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Dia{" + "id=" + id + ", numeroDia=" + numeroDia + ", nombre=" + nombre + ", simbolo=" + simbolo + ", selecionado=" + selecionado + ", mainHorarioAula=" + mainHorarioAula + ", seleccionable=" + seleccionable + ", mainHorarioCursoOptativo=" + mainHorarioCursoOptativo + ", mainDiaHoraHorarioCiclo=" + mainDiaHoraHorarioCiclo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dia other = (Dia) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}
