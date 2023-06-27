package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "apo_item_subvencion_injustificada")
public class ItemSubvencionInjustificada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subvencion_injustificada")
    private SubvencionInjustificada subvencionInjustificada;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aporte_alumno_ciclo")
    private AporteAlumnoCiclo aporteAlumnoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario usuarioAnulacion;

    public ItemSubvencionInjustificada(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum deudaEstadoEnum) {
        this.estado = deudaEstadoEnum.name();
    }

}
