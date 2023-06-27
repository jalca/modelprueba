package pe.edu.lamolina.model.posgrado.boleta;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemBoletaPosgrado {

    private String ciclo;
    private String concepto;
    private BigDecimal monto;

    public ItemBoletaPosgrado() {
    }

    public ItemBoletaPosgrado(String ciclo, String concepto, BigDecimal monto) {
        this.ciclo = ciclo;
        this.concepto = concepto;
        this.monto = monto;
    }

}
