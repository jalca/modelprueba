package pe.edu.lamolina.model.posgrado.boleta;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.finanzas.Acreencia;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.posgrado.AlumnoConceptoMatricula;
import pe.edu.lamolina.model.posgrado.AlumnoCuotaMatricula;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
public class BoletaPosgrado {

    private Integer numeroCuota;
    private BigDecimal monto;
    private BigDecimal montoInicio;
    private BigDecimal mora;
    private CicloAcademico cicloAcademico;

    private CuentaBancaria cuentaBancaria;
    private Acreencia acreencia;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRecomendada;

    private int paraMatricula;

    private List<AlumnoConceptoMatricula> conceptos;
    private List<AlumnoCuotaMatricula> cuotas;
    private List<ItemBoletaPosgrado> detalle;

    public BoletaPosgrado() {
        detalle = new ArrayList();
    }

    public BoletaPosgrado(Acreencia acreencia) {
        this.acreencia = acreencia;
    }

    public BoletaPosgrado(Acreencia acreencia, BigDecimal mora, Integer numeroCuota) {
        this.acreencia = acreencia;
        this.cuentaBancaria = acreencia.getCuentaBancaria();
        this.numeroCuota = numeroCuota;

        this.montoInicio = acreencia.getMonto();
        this.mora = mora;
        this.monto = montoInicio.add(mora);

    }

    public Integer getTotalItems() {
        int total = 0;
        if (this.conceptos != null) {
            total += this.conceptos.size();
        }
        if (this.cuotas != null) {
            total += this.cuotas.size();
        }
        return total;
    }

}
