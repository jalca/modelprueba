package pe.edu.lamolina.model.medico;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoTratamientoEnum;
import pe.edu.lamolina.model.enums.TipoEdadEnum;
import pe.edu.lamolina.model.enums.TipoPeriodoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "med_antecedente_siquiatrico")
public class AntecedentePsiquiatrico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tiene")
    private Boolean tiene;

    @Column(name = "edad")
    private String edad;

    @Column(name = "cuanto_tiempo")
    private String cuantoTiempo;

    @Column(name = "estado_tratamiento")
    private String estadoTratamiento;

    @Column(name = "medicacion")
    private String medicacion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private HistoriaAntecedente historiaAntecedente;

    public AntecedentePsiquiatrico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoEdadEnum getEdadEnum() {
        if (edad == null) {
            return null;
        }
        return TipoEdadEnum.valueOf(edad);
    }

    @JsonIgnore
    public void setEdadEnum(TipoEdadEnum edadEnum) {
        if (edadEnum == null) {
            return;
        }
        this.edad = edadEnum.name();
    }

    public TipoPeriodoEnum getCuantoTiempoEnum() {
        if (cuantoTiempo == null) {
            return null;
        }
        return TipoPeriodoEnum.valueOf(cuantoTiempo);
    }

    @JsonIgnore
    public void setCuantoTiempoEnum(TipoPeriodoEnum cuantoTiempoEnum) {
        if (cuantoTiempoEnum == null) {
            return;
        }
        this.cuantoTiempo = cuantoTiempoEnum.name();
    }

    public EstadoTratamientoEnum getEstadoTratamientoEnum() {
        if (estadoTratamiento == null) {
            return null;
        }
        return EstadoTratamientoEnum.valueOf(estadoTratamiento);
    }

    @JsonIgnore
    public void setEstadoTratamientoEnum(EstadoTratamientoEnum estadoTratamientoEnum) {
        if (estadoTratamientoEnum == null) {
            return;
        }
        this.estadoTratamiento = estadoTratamientoEnum.name();
    }

}
