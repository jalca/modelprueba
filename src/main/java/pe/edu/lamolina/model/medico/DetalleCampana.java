package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Colaborador;

@Entity
@Table(name = "med_detalle_campana")
public class DetalleCampana implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario_campana")
    private CalendarioCampana calendarioCampana;

    public DetalleCampana() {
    }

    public DetalleCampana(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public CalendarioCampana getCalendarioCampana() {
        return calendarioCampana;
    }

    public void setCalendarioCampana(CalendarioCampana calendarioCampana) {
        this.calendarioCampana = calendarioCampana;
    }

    public ObjectNode toJson() {

        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory, true);

        Colaborador colaborador = this.colaborador != null ? this.colaborador : new Colaborador();
        Consultorio consultorio = this.consultorio != null ? this.consultorio : new Consultorio();

        json.set("colaborador", JsonHelper.createJson(colaborador, factory));
        json.set("consultorio", JsonHelper.createJson(consultorio, factory));

        return json;
    }
}
