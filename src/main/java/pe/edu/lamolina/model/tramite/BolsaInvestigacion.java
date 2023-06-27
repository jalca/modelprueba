package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.enums.BolsaInvestigacionEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@Table(name = "obu_bolsa_investigacion")
public class BolsaInvestigacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "becados")
    private Integer becados;

    @Column(name = "postulantes")
    private Integer postulantes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_envio")
    private Date fechaEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_aplicacion")
    private CicloAcademico cicloAplicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_envio")
    private Usuario userEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public BolsaInvestigacionEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return BolsaInvestigacionEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(BolsaInvestigacionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "becados", becados, false);
        ModelUtils.getDataByAttr(join, "postulantes", postulantes, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaEnvio", fechaEnvio, false);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "cicloAplicacion", cicloAplicacion, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "facultad", facultad, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userEnvio", userEnvio, "id", "google");

        return join.toString();
    }

}
