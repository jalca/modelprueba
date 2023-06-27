package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.edu.lamolina.model.enums.AspectoEvaluacionEnum;

@Entity
@Table(name = "epg_aspecto_evaluacion")
public class AspectoEvaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "obligatorio")
    private Boolean obligatorio;

    @Column(name = "es_maestria")
    private Boolean esMaestria;

    @Column(name = "es_doctorado")
    private Boolean esDoctorado;

    @Column(name = "porcentaje_maestria")
    private Integer porcentajeMaestria;

    @Column(name = "porcentaje_doctorado")
    private Integer porcentajeDoctorado;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "aspectoEvaluacion", fetch = FetchType.LAZY)
    private List<PesoAspectoEvaluacion> pesoAspectoEvaluacion;

    @Transient
    private PuntajePostulanteAspecto puntajePostulanteAspecto;

    @Transient
    private BigDecimal peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public AspectoEvaluacionEnum getCodigoEnum() {
        return AspectoEvaluacionEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(AspectoEvaluacionEnum codigo) {
        this.codigo = codigo.getValue();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public List<PesoAspectoEvaluacion> getPesoAspectoEvaluacion() {
        return pesoAspectoEvaluacion;
    }

    public void setPesoAspectoEvaluacion(List<PesoAspectoEvaluacion> pesoAspectoEvaluacion) {
        this.pesoAspectoEvaluacion = pesoAspectoEvaluacion;
    }

    public PuntajePostulanteAspecto getPuntajePostulanteAspecto() {
        return puntajePostulanteAspecto;
    }

    public void setPuntajePostulanteAspecto(PuntajePostulanteAspecto puntajePostulanteAspecto) {
        this.puntajePostulanteAspecto = puntajePostulanteAspecto;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Boolean getEsMaestria() {
        return esMaestria;
    }

    public void setEsMaestria(Boolean esMaestria) {
        this.esMaestria = esMaestria;
    }

    public Boolean getEsDoctorado() {
        return esDoctorado;
    }

    public void setEsDoctorado(Boolean esDoctorado) {
        this.esDoctorado = esDoctorado;
    }

    public Integer getPorcentajeMaestria() {
        return porcentajeMaestria;
    }

    public void setPorcentajeMaestria(Integer porcentajeMaestria) {
        this.porcentajeMaestria = porcentajeMaestria;
    }

    public Integer getPorcentajeDoctorado() {
        return porcentajeDoctorado;
    }

    public void setPorcentajeDoctorado(Integer porcentajeDoctorado) {
        this.porcentajeDoctorado = porcentajeDoctorado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
