package pe.edu.lamolina.model.bean;

import java.math.BigDecimal;
import java.util.List;
import pe.edu.lamolina.model.extensionobu.TallerVerano;

public class TallerVeranoBean {

    List<TallerVerano> talleresVerano;
    BigDecimal descuento;
    BigDecimal total;

    public List<TallerVerano> getTalleresVerano() {
        return talleresVerano;
    }

    public void setTalleresVerano(List<TallerVerano> talleresVerano) {
        this.talleresVerano = talleresVerano;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
}
