package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ConsultorioEnum;

@Entity
@Table(name = "med_especialidad_medica")
public class EspecialidadMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "es_tecnico")
    private Boolean esTecnico;

    public EspecialidadMedica() {
    }

    public EspecialidadMedica(ConsultorioEnum consultorioEnum) {
        this.id = consultorioEnum.getId();
        this.codigo = consultorioEnum.name();
        this.nombre = consultorioEnum.getValue();
    }

    public EspecialidadMedica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ConsultorioEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return ConsultorioEnum.valueOf(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEsTecnico() {
        return esTecnico;
    }

    public void setEsTecnico(Boolean esTecnico) {
        this.esTecnico = esTecnico;
    }

    public ObjectNode ToJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }
}
