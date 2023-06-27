package pe.edu.lamolina.model.inscripcion;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "sip_agrupacion_aula_examen")
public class AgrupacionAulaExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula_examen")
    private AulaExamen aulaExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agrupacion_modalidades")
    private AgrupacionModalidades agrupacionModalidades;

    @Column(name = "aforo_utilizado")
    private Integer aforoUtilizado;

    public AgrupacionAulaExamen() {
    }

    public AgrupacionAulaExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AulaExamen getAulaExamen() {
        return aulaExamen;
    }

    public void setAulaExamen(AulaExamen aulaExamen) {
        this.aulaExamen = aulaExamen;
    }

    public AgrupacionModalidades getAgrupacionModalidades() {
        return agrupacionModalidades;
    }

    public void setAgrupacionModalidades(AgrupacionModalidades agrupacionModalidades) {
        this.agrupacionModalidades = agrupacionModalidades;
    }

    public Integer getAforoUtilizado() {
        return aforoUtilizado;
    }

    public void setAforoUtilizado(Integer aforoUtilizado) {
        this.aforoUtilizado = aforoUtilizado;
    }

}
