package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_gestor_control_venta_tramos")
public class GestorControlVentaTramos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "uuid_activador")
    private String uuidActivador;
    
    @Column(name = "monto_maximo_recarga")
    private BigDecimal montoMaximoRecarga;

    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActivacion;

    @Column(name = "fecha_desactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activador")
    private Usuario userActivador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desactiva")
    private Usuario userDesactiva;

    @Transient
    private Boolean visorComedorCargado;

    public GestorControlVentaTramos(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    @JsonIgnore
    public EstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

}
