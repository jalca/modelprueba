package pe.edu.lamolina.model.optativo;

import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.TemporalType;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "opt_horario_ciclo_programa")
public class HorarioCicloPrograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_programa")
    private CicloOptativoPrograma cicloOptativoPrograma;

    @OneToMany(mappedBy = "horarioCicloPrograma", fetch = FetchType.LAZY)
    private List<DiaHoraHorarioCiclo> diaHoraHorarioCiclo;

    public HorarioCicloPrograma() {
    }

    public HorarioCicloPrograma(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public CicloOptativoPrograma getCicloOptativoPrograma() {
        return cicloOptativoPrograma;
    }

    public void setCicloOptativoPrograma(CicloOptativoPrograma cicloOptativoPrograma) {
        this.cicloOptativoPrograma = cicloOptativoPrograma;
    }

    public List<DiaHoraHorarioCiclo> getDiaHoraHorarioCiclo() {
        return diaHoraHorarioCiclo;
    }

    public void setDiaHoraHorarioCiclo(List<DiaHoraHorarioCiclo> diaHoraHorarioCiclo) {
        this.diaHoraHorarioCiclo = diaHoraHorarioCiclo;
    }

    public static class CompareHorarioCicloPrograma implements Comparator<HorarioCicloPrograma> {

        @Override
        public int compare(HorarioCicloPrograma s1, HorarioCicloPrograma s2) {
            int rollno1 = s1.getDia().getNumeroDia();
            int rollno2 = s2.getDia().getNumeroDia();
            return rollno1 - rollno2;
        }
    }

}
