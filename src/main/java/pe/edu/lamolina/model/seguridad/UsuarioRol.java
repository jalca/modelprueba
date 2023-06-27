package pe.edu.lamolina.model.seguridad;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.UserEstadoEnum;
import pe.edu.lamolina.model.general.Oficina;

@Entity
@Getter
@Setter
@Table(name = "seg_usuario_rol")
public class UsuarioRol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_finaliza")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFinaliza;

    @Column(name = "id_instancia")
    private Long idInstancia;

    @Column(name = "tipo_oficina")
    private String tipoOficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_finaliza")
    private Usuario userFinaliza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    public UsuarioRol() {
    }

    public UsuarioRol(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public UserEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }

        return UserEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(UserEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getKeyOficinaUserRol() {
        if (oficina == null) {
            return null;
        }
        if (usuario == null) {
            return null;
        }
        if (rol == null) {
            return null;
        }
        return oficina.getId() + "-" + usuario.getId() + "-" + rol.getId();
    }

}
