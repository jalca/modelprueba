package pe.edu.lamolina.model.aporte;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.tramite.TramiteFraccionamiento;

@Entity
@Table(name = "apo_fraccionamiento_aporte")
public class FraccionamientoAporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cuotas")
    private Integer cuotas;

    @Column(name = "cuota_inicial")
    private BigDecimal cuotaInicial;

    @Column(name = "monto_fraccionado")
    private BigDecimal montoFraccionado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_fraccionamiento")
    private TramiteFraccionamiento tramiteFraccionamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aporte_fraccionar")
    private AporteAlumnoCiclo aporteAlumnoCiclo;

    @OneToMany(mappedBy = "fraccionamientoAporte", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AporteAlumnoCiclo> aportesFraccionados;

    public FraccionamientoAporte() {
    }

    public FraccionamientoAporte(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontoFraccionado() {
        return montoFraccionado;
    }

    public void setMontoFraccionado(BigDecimal montoFraccionado) {
        this.montoFraccionado = montoFraccionado;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(BigDecimal cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public TramiteFraccionamiento getTramiteFraccionamiento() {
        return tramiteFraccionamiento;
    }

    public void setTramiteFraccionamiento(TramiteFraccionamiento tramiteFraccionamiento) {
        this.tramiteFraccionamiento = tramiteFraccionamiento;
    }

    public AporteAlumnoCiclo getAporteAlumnoCiclo() {
        return aporteAlumnoCiclo;
    }

    public void setAporteAlumnoCiclo(AporteAlumnoCiclo aporteAlumnoCiclo) {
        this.aporteAlumnoCiclo = aporteAlumnoCiclo;
    }

    public List<AporteAlumnoCiclo> getAportesFraccionados() {
        return aportesFraccionados;
    }

    public void setAportesFraccionados(List<AporteAlumnoCiclo> aportesFraccionados) {
        this.aportesFraccionados = aportesFraccionados;
    }
}
