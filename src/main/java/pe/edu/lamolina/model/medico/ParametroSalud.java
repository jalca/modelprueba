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

@Entity
@Table(name = "med_parametro_salud")
public class ParametroSalud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "historia_clinica")
    private Boolean historiaClinica;

    @Column(name = "atencion_topico")
    private Boolean atencionTopico;
    

    public ParametroSalud() {
    }

    public ParametroSalud(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(Boolean historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public Boolean getAtencionTopico() {
        return atencionTopico;
    }

    public void setAtencionTopico(Boolean atencionTopico) {
        this.atencionTopico = atencionTopico;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

 

}
