package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Oficina;

@Entity
@Table(name = "aca_oficina_recorrido")
public class OficinaRecorrido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @Column(name = "orden")
    private Integer orden;

    @Transient
    @JsonIgnore
    private Date fechaTurno;

    @OneToMany(mappedBy = "oficinaRecorrido", fetch = FetchType.LAZY)
    private List<TipoActividadIngresante> tipoActividadadesIngresante;

    @Transient
    List<ConfigRecorridoIngresante> tipoActividadesConfiguradas;

    @Transient
    List<ActividadIngresante> actividadesIngresante;

    @Transient
    private Integer actividadesCompletadas;

    public OficinaRecorrido() {
    }

    public OficinaRecorrido(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<TipoActividadIngresante> getTipoActividadadesIngresante() {
        return tipoActividadadesIngresante;
    }

    public void setTipoActividadadesIngresante(List<TipoActividadIngresante> tipoActividadadesIngresante) {
        this.tipoActividadadesIngresante = tipoActividadadesIngresante;
    }

    public List<ConfigRecorridoIngresante> getTipoActividadesConfiguradas() {
        return tipoActividadesConfiguradas;
    }

    public void setTipoActividadesConfiguradas(List<ConfigRecorridoIngresante> tipoActividadesConfiguradas) {
        this.tipoActividadesConfiguradas = tipoActividadesConfiguradas;
    }

    public Integer getActividadesCompletadas() {
        return actividadesCompletadas;
    }

    public void setActividadesCompletadas(Integer actividadesCompletadas) {
        this.actividadesCompletadas = actividadesCompletadas;
    }

    public List<ActividadIngresante> getActividadesIngresante() {
        return actividadesIngresante;
    }

    public void setActividadesIngresante(List<ActividadIngresante> actividadesIngresante) {
        this.actividadesIngresante = actividadesIngresante;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

}
