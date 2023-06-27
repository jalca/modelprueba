package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.edu.lamolina.model.enums.AmbitoReporteEnum;
import pe.edu.lamolina.model.enums.ModalidadEstudioEnum;
import pe.edu.lamolina.model.enums.TipoCicloEnum;

@Entity
@Table(name = "gen_reporte_oficina")
public class ReporteOficina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ambito")
    private String ambito;

    @Column(name = "parametros")
    private String parametros;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @Column(name = "tipo_modalidad")
    private String tipoModalidad;

    public ReporteOficina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public AmbitoReporteEnum getAmbitoEnum() {
        if (ambito == null) {
            return null;
        }
        return AmbitoReporteEnum.valueOf(ambito);
    }

    @JsonIgnore
    public void setAmbitoEnum(AmbitoReporteEnum ambito) {
        if (ambito == null) {
            return;
        }
        this.ambito = ambito.name();
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public TipoCicloEnum getTipoCicloEnum() {
        if (this.tipoCiclo == null) {
            return null;
        }
        return TipoCicloEnum.valueOf(this.tipoCiclo);
    }

    @JsonIgnore
    public void setTipoCiclo(TipoCicloEnum tipoCiclo) {
        if (tipoCiclo == null) {
            return;
        }
        this.tipoCiclo = tipoCiclo.name();
    }

    public String getTipoModalidad() {
        return tipoModalidad;
    }

    public void setTipoModalidad(String tipoModalidad) {
        this.tipoModalidad = tipoModalidad;
    }

    public ModalidadEstudioEnum getTipoModalidadEnum() {
        if (tipoModalidad == null) {
            return null;
        }
        return ModalidadEstudioEnum.valueOf(tipoModalidad);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonIgnore
    public void setTipoModalidad(ModalidadEstudioEnum tipoModalidad) {
        if (tipoModalidad == null) {
            return;
        }
        this.tipoModalidad = tipoModalidad.name();
    }

}
