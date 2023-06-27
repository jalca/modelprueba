package pe.edu.lamolina.model.horario;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.extensionobu.AsistenciaDocenteTaller;
import pe.edu.lamolina.model.extensionobu.TallerCiclo;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hor_horario_taller")
public class HorarioTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFin;

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
    @JoinColumn(name = "id_taller_ciclo")
    private TallerCiclo tallerCiclo;

    @Transient
    private Boolean seleccionado;
    
    @Transient
    private List<AsistenciaDocenteTaller> asistenciasDocentesTalleres;

    public HorarioTaller(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getKey() {
        return this.dia.getId() + "-" + this.hora.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof HorarioTaller)) {
            return false;
        }
        HorarioTaller other = (HorarioTaller) obj;
        if (id != other.getId()) {
            return false;
        }
        return true;
    }

}
