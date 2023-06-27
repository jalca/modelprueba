package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ciclo.ProcesoCicloEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "aca_proceso_ciclo_academico")
public class ProcesoCicloAcademico implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "proceso")
    private String proceso;

    @Column(name = "ultima_accion")
    private Boolean ultimaAccion;

    @Column(name = "fecha_proceso")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaProceso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_proceso")
    private Usuario userProceso;

    public ProcesoCicloAcademico() {
    }

    public ProcesoCicloAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ProcesoCicloEnum getProcesoEnum() {
        if (proceso == null) {
            return null;
        }
        return ProcesoCicloEnum.valueOf(proceso);
    }

    @JsonIgnore
    public void setProcesoEnum(ProcesoCicloEnum proceso) {
        if (proceso == null) {
            return;
        }
        this.proceso = proceso.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "proceso", proceso);
        ModelUtils.getDataByAttr(join, "ultimaAccion", ultimaAccion);
        ModelUtils.getDataByAttr(join, "fechaProceso", fechaProceso);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "userProceso", userProceso, "id", "google");

        return join.toString();
    }

}
