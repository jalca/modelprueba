package pe.edu.lamolina.model.almacen;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoPrestamoInventarioEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "alm_estado_inventario")
public class EstadoInventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_registrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inventario")
    private Inventario inventario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public EstadoInventario() {
    }

    public EstadoInventario(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoPrestamoInventarioEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoPrestamoInventarioEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoPrestamoInventarioEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistrado() {
        return fechaRegistrado;
    }

    public void setFechaRegistrado(Date fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

}
