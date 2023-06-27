package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.TipoVerificacionEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "med_validacion_paciente")
public class ValidacionPaciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_paciente")
    private String tipoPaciente;

    @Column(name = "tipo_verificacion")
    private String tipoVerificacion;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inicio")
    private Usuario usuarioInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_fin")
    private Usuario usuarioFin;

    public ValidacionPaciente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoVerificacionEnum getTipoVerificacionEnum() {
        if (tipoVerificacion == null) {
            return null;
        }
        return TipoVerificacionEnum.valueOf(tipoVerificacion);
    }

    @JsonIgnore
    public void setTipoVerificacionEnum(String tipoVerificacion) {
        if (tipoVerificacion == null) {
            return;
        }
        this.tipoVerificacion = tipoVerificacion;
    }

    public static class ComparePrioridadValidacion implements Comparator<ValidacionPaciente> {

        @Override
        public int compare(ValidacionPaciente gs1, ValidacionPaciente gs2) {
            Integer p1 = gs1.getTipoVerificacionEnum().getPrioridad();
            Integer p2 = gs2.getTipoVerificacionEnum().getPrioridad();
            return p1.compareTo(p2);
        }
    }
}
