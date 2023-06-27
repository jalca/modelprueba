package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import pe.edu.lamolina.model.enums.CodigoValidacionSubvencionEnum;

@Entity
@Table(name = "tram_validacion_subvencion")
public class ValidacionSubvencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "obligatorio")
    private Boolean obligatorio;

    public ValidacionSubvencion(Long id) {
        this.id = id;
    }

    public ValidacionSubvencion() {
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

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public CodigoValidacionSubvencionEnum getCodigoEnum() {
        return CodigoValidacionSubvencionEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(CodigoValidacionSubvencionEnum codigo) {
        this.codigo = codigo.name();
    }

}
