package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.edu.lamolina.model.enums.CodigoContableEnum;

@Entity
@Table(name = "fin_concepto_contable")
public class ConceptoContable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_contable")
    private String codigoContable;

    public ConceptoContable() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CodigoContableEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }

        return CodigoContableEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigo(CodigoContableEnum codigo) {
        this.codigo = codigo.name();
    }

    public String getCodigoContable() {
        return codigoContable;
    }

    public void setCodigoContable(String codigoContable) {
        this.codigoContable = codigoContable;
    }

}
