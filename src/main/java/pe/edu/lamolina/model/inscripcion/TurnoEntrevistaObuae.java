package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.EventoCicloAcademico;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sip_turno_entrevista_obuae")
public class TurnoEntrevistaObuae implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "turno_inicio")
    private String turnoInicio;

    @Column(name = "turno_fin")
    private String turnoFin;

    @Column(name = "es_extemporaneo")
    private Integer esExtemporaneo;

    @Column(name = "alumnos")
    private Integer alumnos;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_ciclo")
    private EventoCiclo eventoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_ciclo_academico")
    private EventoCicloAcademico eventoCicloAcademico;

    @Transient
    private Integer registrados;
    @Transient
    private Integer tipoAlumnos;
    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFin;

    public TurnoEntrevistaObuae(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public DateTime getFechaDatetime() {
        return new DateTime(this.fecha);
    }

    public boolean contieneOrden(String ordenAtencion) {
        int orden = Integer.valueOf(ordenAtencion);
        int inicio = Integer.valueOf(turnoInicio);
        int fin = Integer.valueOf(turnoFin);

        return (inicio <= orden && orden <= fin);
    }

    public static class CompareFechas implements Comparator<TurnoEntrevistaObuae> {

        @Override
        public int compare(TurnoEntrevistaObuae te1, TurnoEntrevistaObuae te2) {
            return te1.getFecha().compareTo(te2.getFecha());
        }
    }

    public static class CompareTurno implements Comparator<TurnoEntrevistaObuae> {

        @Override
        public int compare(TurnoEntrevistaObuae te1, TurnoEntrevistaObuae te2) {
            return te1.getTurnoInicio().compareTo(te2.getTurnoInicio());
        }
    }

    @Override
    public String toString() {
        return "TurnoEntrevistaObuae{" + "id=" + id + ", grupo=" + grupo + ", fecha=" + fecha + '}';
    }

}
