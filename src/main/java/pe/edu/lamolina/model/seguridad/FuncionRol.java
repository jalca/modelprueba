package pe.edu.lamolina.model.seguridad;

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
import pe.edu.lamolina.model.general.PerfilCompania;

@Entity
@Table(name = "seg_funcion_rol")
public class FuncionRol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcion")
    private PerfilCompania perfilCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActivacion;

    @Column(name = "fecha_desactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activacion")
    private Usuario usuarioActivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desactivacion")
    private Usuario usuarioDesactivacion;

    public FuncionRol() {
    }

    public FuncionRol(Object id) {
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

    public PerfilCompania getPerfilCompania() {
        return perfilCompania;
    }

    public void setPerfilCompania(PerfilCompania perfilCompania) {
        this.perfilCompania = perfilCompania;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

    public Usuario getUsuarioActivacion() {
        return usuarioActivacion;
    }

    public void setUsuarioActivacion(Usuario usuarioActivacion) {
        this.usuarioActivacion = usuarioActivacion;
    }

    public Usuario getUsuarioDesactivacion() {
        return usuarioDesactivacion;
    }

    public void setUsuarioDesactivacion(Usuario usuarioDesactivacion) {
        this.usuarioDesactivacion = usuarioDesactivacion;
    }
 
}
