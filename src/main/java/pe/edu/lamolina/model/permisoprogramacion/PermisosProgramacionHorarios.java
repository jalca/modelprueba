package pe.edu.lamolina.model.permisoprogramacion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import pe.edu.lamolina.model.enums.PermisoProgramacionHorarioEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_permiso_programacion_horarios")
public class PermisosProgramacionHorarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "puede_agregar")
    private Integer puedeAgregar;

    @Column(name = "puede_eliminar")
    private Integer puedeEliminar;

    @Column(name = "puede_modificar")
    private Integer puedeModificar;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_anexo")
    private ColaboradorAnexo colaboradorAnexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permiso_programacion")
    private PermisoProgramacion permisoProgramacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public PermisosProgramacionHorarios() {
    }

    public PermisosProgramacionHorarios(Object id) {
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

    public PermisoProgramacionHorarioEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PermisoProgramacionHorarioEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PermisoProgramacionHorarioEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public Integer getPuedeAgregar() {
        if (puedeAgregar == null) {
            this.puedeAgregar = 0;
        }
        return puedeAgregar;
    }

    public void setPuedeAgregar(Integer puedeAgregar) {

        this.puedeAgregar = puedeAgregar;
    }

    public Integer getPuedeEliminar() {
        if (puedeEliminar == null) {
            this.puedeEliminar = 0;
        }
        return puedeEliminar;
    }

    public void setPuedeEliminar(Integer puedeEliminar) {
        this.puedeEliminar = puedeEliminar;
    }

    public Integer getPuedeModificar() {
        if (puedeModificar == null) {
            this.puedeModificar = 0;
        }
        return puedeModificar;
    }

    public void setPuedeModificar(Integer puedeModificar) {
        this.puedeModificar = puedeModificar;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public PermisoProgramacion getPermisoProgramacion() {
        return permisoProgramacion;
    }

    public void setPermisoProgramacion(PermisoProgramacion permisoProgramacion) {
        this.permisoProgramacion = permisoProgramacion;
    }

    public ColaboradorAnexo getColaboradorAnexo() {
        return colaboradorAnexo;
    }

    public void setColaboradorAnexo(ColaboradorAnexo colaboradorAnexo) {
        this.colaboradorAnexo = colaboradorAnexo;
    }

    public String getKey() {
        return colaboradorAnexo.getId() + "-" + permisoProgramacion.getNivel();
    }
}
