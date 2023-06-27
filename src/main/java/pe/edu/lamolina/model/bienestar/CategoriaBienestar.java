package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.math.BigDecimal;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
@Table(name = "obu_categoria_bienestar")
public class CategoriaBienestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "escala")
    private String escala;

    @Column(name = "monto")
    private BigDecimal monto;

    @OneToMany(mappedBy = "categoriaBienestar", fetch = FetchType.LAZY)
    private List<CategoriaBienestarCiclo> categoriaBienestar;

    @Transient
    private Long cantidad;

    public CategoriaBienestar(Long id, String escala, Long cantidad) {
        this.id = id;
        this.escala = escala;
        this.cantidad = cantidad;
    }

    public CategoriaBienestar() {
    }

    public CategoriaBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEscala() {
        return escala;
    }

    public String getEscalaTexto() {
        if (escala == null) {
            return null;
        }
        if (escala.equals("S/E")) {
            return "Sin escala";
        }
        return "Escala " + escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<CategoriaBienestarCiclo> getCategoriaBienestar() {
        return categoriaBienestar;
    }

    public void setCategoriaBienestar(List<CategoriaBienestarCiclo> categoriaBienestar) {
        this.categoriaBienestar = categoriaBienestar;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public ObjectNode toJson() {

        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance, true);

        return json;
    }
}
