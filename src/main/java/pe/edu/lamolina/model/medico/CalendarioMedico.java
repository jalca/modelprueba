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
import pe.edu.lamolina.model.enums.CalendarioMedicoEstadoEnum;
import pe.edu.lamolina.model.general.Dia;

@Entity
@Table(name = "med_calendario_medico")
public class CalendarioMedico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_inicio")
    private Dia diaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_fin")
    private Dia diaFin;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    public CalendarioMedico() {
    }

    public CalendarioMedico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getEstado() {
        return estado;
    }

    public CalendarioMedicoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return CalendarioMedicoEstadoEnum.valueOf(estado);
    }

    public void setEstado(CalendarioMedicoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Dia getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(Dia diaInicio) {
        this.diaInicio = diaInicio;
    }

    public Dia getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(Dia diaFin) {
        this.diaFin = diaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode json = JsonHelper.createJson(this, factory);

        Dia diaInicio = this.getDiaInicio() != null ? this.getDiaInicio() : new Dia();
        Dia diaFin = this.getDiaFin() != null ? this.getDiaFin() : new Dia();
        Medico medico = this.getMedico() != null ? this.getMedico() : new Medico();
        ObjectNode medicoJson = new ObjectNode(factory);
        medicoJson.put("id", medico.getId());
        json.set("diaInicio", JsonHelper.createJson(diaInicio, factory));
        json.set("diaFin", JsonHelper.createJson(diaFin, factory));

        json.set("medico", medicoJson);
        return json;
    }

}
