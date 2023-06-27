package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.horario.GrupoHoras;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_grupo_horas_examen")
public class GrupoHorasExamen implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "verificado")
    private Boolean verificado;

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora_inicio")
    private Hora horaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora_fin")
    private Hora horaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas")
    private GrupoHoras grupoHoras;

    @OneToMany(mappedBy = "grupoHorasExamen", fetch = FetchType.LAZY)
    List<FechaHoraGrupoExamen> fechasHorasGruposExamen;

    @Transient
    List<GrupoHorasExamen> grupoHorasExamens;

    @Transient
    private SemanaExamen semanaExamen;

    @Transient
    private String revisado;

    public GrupoHorasExamen() {
    }

    public GrupoHorasExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolExamenes getRolExamenes() {
        return rolExamenes;
    }

    public void setRolExamenes(RolExamenes rolExamenes) {
        this.rolExamenes = rolExamenes;
    }

    public GrupoHoras getGrupoHoras() {
        return grupoHoras;
    }

    public void setGrupoHoras(GrupoHoras grupoHoras) {
        this.grupoHoras = grupoHoras;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public List<FechaHoraGrupoExamen> getFechasHorasGruposExamen() {
        return fechasHorasGruposExamen;
    }

    public void setFechasHorasGruposExamen(List<FechaHoraGrupoExamen> fechasHorasGruposExamen) {
        this.fechasHorasGruposExamen = fechasHorasGruposExamen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public SemanaExamen getSemanaExamen() {
        return semanaExamen;
    }

    public void setSemanaExamen(SemanaExamen semanaExamen) {
        this.semanaExamen = semanaExamen;
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
        final GrupoHorasExamen other = (GrupoHorasExamen) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public List<String> getDiaHoraList() {
        List<String> result = this.getFechasHorasGruposExamen()
                .stream().map(x -> x.getDia().getNumeroDia() + "-" + x.getHora().getNumero()).collect(Collectors.toList());
        return result;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Hora getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public List<GrupoHorasExamen> getGrupoHorasExamens() {
        return grupoHorasExamens;
    }

    public void setGrupoHorasExamens(List<GrupoHorasExamen> grupoHorasExamens) {
        this.grupoHorasExamens = grupoHorasExamens;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public String getDescripcion() {
        List<FechaHoraGrupoExamen> fechaHoras = this.fechasHorasGruposExamen;
        if (fechaHoras == null) {
            return "Indefinido";
        }
        if (fechaHoras.isEmpty()) {
            return "Indefinido";
        }
        if (this.fecha == null) {
            return "Indefinido";
        }
        String describe = TypesUtil.getStringDate(this.fecha, "EEEE dd/MM/yyyy 'de' ", "es");
        Hora horaIni = fechaHoras.stream().map(x -> x.getHora()).min(Comparator.comparing(Hora::getCodigo)).get();
        Hora horaFin = fechaHoras.stream().map(x -> x.getHora()).max(Comparator.comparing(Hora::getCodigo)).get();
        describe += horaIni.getDescripcion() + " a " + horaFin.getDescripcionFin();
        describe = describe.substring(0, 1).toUpperCase() + describe.substring(1);
        return describe;
    }

    @Override
    public GrupoHorasExamen clone() {
        GrupoHorasExamen clone = null;
        try {
            clone = (GrupoHorasExamen) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
