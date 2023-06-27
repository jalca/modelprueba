package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.SorteoEstadoEnum;

@Entity
@Table(name = "sip_apoyo")
public class Apoyo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_user_sorteo")
    private Long idUserSorteo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_sorteo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSorteo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    public Apoyo() {
    }

    public Apoyo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Long getIdUserSorteo() {
        return idUserSorteo;
    }

    public void setIdUserSorteo(Long idUserSorteo) {
        this.idUserSorteo = idUserSorteo;
    }

    public Date getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(Date fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public SorteoEstadoEnum getEstadoEnum() {
        return SorteoEstadoEnum.valueOf(estado);
    }

    public void setEstado(SorteoEstadoEnum estado) {
        this.estado = estado.name();
    }

}

