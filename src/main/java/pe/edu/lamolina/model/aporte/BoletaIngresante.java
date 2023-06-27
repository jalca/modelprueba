package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.NumberFormat;

public class BoletaIngresante {

    private Long cuentaId;
    private Integer numero;
    private String cuentaNombre;
    private String cuentaNumero;
    private String cuentaBanco;
    private BigDecimal monto;
    private List<AporteAlumnoCiclo> aportesAlumno;

    public BoletaIngresante() {
    }

    public BoletaIngresante(Long cuentaId, Integer numero, String cuentaNombre, String cuentaNumero, String cuentaBanco, BigDecimal monto) {
        this.cuentaId = cuentaId;
        this.numero = numero;
        this.cuentaNombre = cuentaNombre;
        this.cuentaNumero = cuentaNumero;
        this.cuentaBanco = cuentaBanco;
        this.monto = monto;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCuentaNombre() {
        return cuentaNombre;
    }

    public void setCuentaNombre(String cuentaNombre) {
        this.cuentaNombre = cuentaNombre;
    }

    public String getCuentaNumero() {
        return cuentaNumero;
    }

    public void setCuentaNumero(String cuentaNumero) {
        this.cuentaNumero = cuentaNumero;
    }

    public String getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(String cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMontoString() {
        return "S/ " + NumberFormat.precio(monto);
    }

    public List<AporteAlumnoCiclo> getAportesAlumno() {
        return aportesAlumno;
    }

    public void setAportesAlumno(List<AporteAlumnoCiclo> aportesAlumno) {
        this.aportesAlumno = aportesAlumno;
    }

    public ObjectNode toJson() {
        ObjectNode json2 = JsonHelper.createJson(this, JsonNodeFactory.instance, true,
                new String[]{
                    "*"
                });
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        List<AporteAlumnoCiclo> aportesAlumno = this.getAportesAlumno() != null ? this.getAportesAlumno() : new ArrayList();
        for (AporteAlumnoCiclo aporteAlumnoCiclo : aportesAlumno) {
            ObjectNode objAporte = JsonHelper.createJson(aporteAlumnoCiclo, JsonNodeFactory.instance, new String[]{
                "*",
                "aporteCiclo.*",
                "aporteCiclo.aporte.*",});
            arrayNode.add(objAporte);
        }
        json2.set("aportesAlumno", arrayNode);
        return json2;
    }

}
