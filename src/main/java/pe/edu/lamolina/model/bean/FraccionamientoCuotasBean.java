package pe.edu.lamolina.model.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Date;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

public class FraccionamientoCuotasBean {

    Integer numero;
    @JsonDeserialize(using = DateDeserializer.class)
    Date fecha;
    BigDecimal monto;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
