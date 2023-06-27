package pe.edu.lamolina.model.posgrado.admision;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.edu.lamolina.model.finanzas.Moneda;

@Getter
@Setter
public class BoletaPagoAdmisionEPG {

    private String empresa;

    private String banco;
    private String numeroCuenta;
    private String numeroCCI;
    private String ruc;

    private Moneda moneda;

    private String nombreCuenta;
    private String nombreCliente;
    private String numeroIdentificacion;

    private BigDecimal monto;
    private String codigoSwift;
    private String numeroBoleta;

    private String concepto;

    public String getMontoImpresion() {

        return NumberFormat.precio(monto);
    }
}
