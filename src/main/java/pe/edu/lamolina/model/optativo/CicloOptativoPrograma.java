package pe.edu.lamolina.model.optativo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.CicloOptativoProgramaEstadoEnum;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "opt_ciclo_optativo_programa")
public class CicloOptativoPrograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "trimestre")
    private Integer trimestre;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @JoinColumn(name = "id_ciclo_optativo")
    @ManyToOne(fetch = FetchType.LAZY)
    private CicloOptativo cicloOptativo;

    @JoinColumn(name = "id_ciclo_academico")
    @ManyToOne(fetch = FetchType.LAZY)
    private CicloAcademico cicloAcademico;

    @JoinColumn(name = "id_carrera")
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrera carrera;

    @JoinColumn(name = "id_user_modificacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userModificacion;

    @JoinColumn(name = "id_user_registro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userRegistro;

    @OneToMany(mappedBy = "cicloOptativoPrograma", fetch = FetchType.LAZY)
    private List<HorarioCicloPrograma> horarioCicloPrograma;

    @Transient
    private List<Hora> horas;

    public CicloOptativoPrograma(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CicloOptativoProgramaEstadoEnum getEstadoEnum() {
        try {
            return CicloOptativoProgramaEstadoEnum.valueOf(this.estado);
        } catch (Exception e) {
            return null;
        }

    }

    @JsonIgnore
    public void setEstadoEnum(CicloOptativoProgramaEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

}
