package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.enums.VariableContenidoEnum;
import pe.edu.lamolina.model.enums.VariableGenericaEnum;
import pe.edu.lamolina.model.general.Oficina;

@Entity
@Table(name = "tram_variable_generica")
public class VariableGenerica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_enum")
    private String codigoEnum;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "variableGenerica", fetch = FetchType.LAZY)
    private List<VariablePlantilla> tramiteVariablePlantilla;

    public VariableGenerica() {
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

    public String getCodigoEnum() {
        return codigoEnum;
    }

    public void setCodigoEnum(String codigoEnum) {
        this.codigoEnum = codigoEnum;
    }

    public VariableGenericaEnum getCodigoVaribleEnum() {
        if (StringUtils.isBlank(this.getCodigoEnum())) {
            return null;
        }
        return VariableGenericaEnum.valueOf(codigoEnum);
    }

    @JsonIgnore
    public void setCodigoVariableEnum(VariableContenidoEnum tipoEnum) {
        this.codigoEnum = tipoEnum.getValue();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VariablePlantilla> getTramiteVariablePlantilla() {
        return tramiteVariablePlantilla;
    }

    public void setTramiteVariablePlantilla(List<VariablePlantilla> tramiteVariablePlantilla) {
        this.tramiteVariablePlantilla = tramiteVariablePlantilla;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

}
