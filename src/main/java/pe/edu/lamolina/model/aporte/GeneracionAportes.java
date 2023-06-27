package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.GeneracionAportesEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "apo_generacion_aportes")
public class GeneracionAportes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_generacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaGeneracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_generacion")
    private Usuario userGeneracion;

    @Column(name = "fecha_boleta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaBoleta;

    @Transient
    private Long matriculables;

    public GeneracionAportes(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public GeneracionAportesEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return GeneracionAportesEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(GeneracionAportesEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

}
