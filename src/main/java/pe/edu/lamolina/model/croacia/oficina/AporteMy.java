package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aporte", catalog = "croacia")
public class AporteMy implements Serializable, Cloneable {

    @Id
    @Column(name = "APORTE")
    private String aporte;

    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MONTO")
    private Integer monto;

    @Column(name = "REP")
    private String rep;

    @Column(name = "NIVEL")
    private String nivel;

    @Column(name = "ACTIVO")
    private String activo;

    @Column(name = "ORDEN")
    private BigDecimal orden;

    @Column(name = "OFICINA")
    private String oficina;

    @Column(name = "ENCARGADO")
    private String encargado;

    @Column(name = "EXONERABLE")
    private String exonerable;

    public String getAporte() {
        return aporte;
    }

    public void setAporte(String aporte) {
        this.aporte = aporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public BigDecimal getOrden() {
        return orden;
    }

    public void setOrden(BigDecimal orden) {
        this.orden = orden;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getExonerable() {
        return exonerable;
    }

    public void setExonerable(String exonerable) {
        this.exonerable = exonerable;
    }

}
