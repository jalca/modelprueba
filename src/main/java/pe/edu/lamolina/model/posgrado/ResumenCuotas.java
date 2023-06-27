package pe.edu.lamolina.model.posgrado;

import java.math.BigDecimal;

public class ResumenCuotas {

    private BigDecimal matricula;
    private BigDecimal extemporaneo;
    private BigDecimal ensenanza;
    private BigDecimal total;

    public ResumenCuotas() {
        this.matricula = BigDecimal.ZERO;
        this.extemporaneo = BigDecimal.ZERO;
        this.ensenanza = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
    }

    public ResumenCuotas(BigDecimal matricula, BigDecimal extemporaneo, BigDecimal ensenanza, BigDecimal total) {
        this.matricula = matricula;
        this.extemporaneo = extemporaneo;
        this.ensenanza = ensenanza;
        this.total = total;
    }
    
    public BigDecimal getMatricula() {
        return matricula;
    }

    public void setMatricula(BigDecimal matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getExtemporaneo() {
        return extemporaneo;
    }

    public void setExtemporaneo(BigDecimal extemporaneo) {
        this.extemporaneo = extemporaneo;
    }

    public BigDecimal getEnsenanza() {
        return ensenanza;
    }

    public void setEnsenanza(BigDecimal ensenanza) {
        this.ensenanza = ensenanza;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
