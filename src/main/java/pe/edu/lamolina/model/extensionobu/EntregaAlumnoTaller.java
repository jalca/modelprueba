package pe.edu.lamolina.model.extensionobu;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.tallerverano.TipoEntregaTallerEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "extn_entrega_alumno_taller")
public class EntregaAlumnoTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_ciclo_taller")
    private AlumnoCicloTaller alumnoCicloTaller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    public EntregaAlumnoTaller(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado != null) {
            this.estado = estado.name();
        }
    }

    public EstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setTipoEnum(TipoEntregaTallerEnum tipo) {
        if (tipo != null) {
            this.tipo = tipo.name();
        }
    }

    public TipoEntregaTallerEnum getTipoEnum() {
        if (StringUtils.isBlank(tipo)) {
            return null;
        }
        return TipoEntregaTallerEnum.valueOf(tipo);
    }

}
