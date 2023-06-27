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
@Table(name = "sip_requerimiento_apoyo")
public class RequerimientoApoyo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apoyo")
    private Apoyo apoyo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_apoyo")
    private RolApoyo rolApoyo;

    public RequerimientoApoyo() {
    }

    public RequerimientoApoyo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apoyo getApoyo() {
        return apoyo;
    }

    public void setApoyo(Apoyo apoyo) {
        this.apoyo = apoyo;
    }

    public RolApoyo getRolApoyo() {
        return rolApoyo;
    }

    public void setRolApoyo(RolApoyo rolApoyo) {
        this.rolApoyo = rolApoyo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

