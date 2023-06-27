package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoSubvencionEnum;

@Getter
@Setter
@Entity
@Table(name = "obu_tipo_subvencion")
public class TipoSubvencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "tramite_unico")
    private Boolean tramiteUnico;
    
    @Column(name = "inicia_alumno")
    private Boolean iniciaAlumno;

    @Column(name = "permite_menores")
    private Boolean permiteMenores;

    @Column(name = "requiere_lugar")
    private Boolean requiereLugar;

    @Column(name = "requiere_labor_realizar")
    private Boolean requiereLaborRealizar;

    @Column(name = "requiere_horas")
    private Boolean requiereHoras;

    @Column(name = "requiere_supervisor")
    private Boolean requiereSupervisor;

    @Column(name = "requiere_ficha_socioeconomica")
    private Boolean requiereFichaSocioeconomica;

    @Column(name = "horas_laborales")
    private Integer horasLaborales;

    public TipoSubvencion() {
    }

    public TipoSubvencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoSubvencionEnum getCodigoEnum() {
        if (this.codigo == null) {
            return null;
        }
        return TipoSubvencionEnum.valueOf(this.codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoSubvencionEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }
}
