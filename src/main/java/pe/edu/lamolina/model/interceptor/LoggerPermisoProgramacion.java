package pe.edu.lamolina.model.interceptor;

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
import pe.edu.lamolina.model.academico.AnexoBoletin;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.permisoprogramacion.PermisoProgramacion;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_logger_permiso_programacion", catalog = GlobalConstantine.SCHEMA_AUDITOR)
public class LoggerPermisoProgramacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puede_agregar")
    private Integer puedeAgregar;

    @Column(name = "puede_eliminar")
    private Integer puedeEliminar;

    @Column(name = "puede_modificar")
    private Integer puedeModificar;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_permiso")
    private Date fechaPermiso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anexo_boletin")
    private AnexoBoletin anexoBoletin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permiso_programacion")
    private PermisoProgramacion permisoProgramacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_permiso")
    private Usuario userPermiso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuedeAgregar() {
        return puedeAgregar;
    }

    public void setPuedeAgregar(Integer puedeAgregar) {
        if (puedeAgregar == null) {
            this.puedeAgregar = 0;
        }
        this.puedeAgregar = puedeAgregar;
    }

    public Integer getPuedeEliminar() {
        return puedeEliminar;
    }

    public void setPuedeEliminar(Integer puedeEliminar) {
        if (puedeEliminar == null) {
            this.puedeEliminar = 0;
        }
        this.puedeEliminar = puedeEliminar;
    }

    public Integer getPuedeModificar() {
        return puedeModificar;
    }

    public void setPuedeModificar(Integer puedeModificar) {
        if (puedeModificar == null) {
            this.puedeModificar = 0;
        }
        this.puedeModificar = puedeModificar;
    }

    public Date getFechaPermiso() {
        return fechaPermiso;
    }

    public void setFechaPermiso(Date fechaPermiso) {
        this.fechaPermiso = fechaPermiso;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public AnexoBoletin getAnexoBoletin() {
        return anexoBoletin;
    }

    public void setAnexoBoletin(AnexoBoletin anexoBoletin) {
        this.anexoBoletin = anexoBoletin;
    }

    public PermisoProgramacion getPermisoProgramacion() {
        return permisoProgramacion;
    }

    public void setPermisoProgramacion(PermisoProgramacion permisoProgramacion) {
        this.permisoProgramacion = permisoProgramacion;
    }

    public Usuario getUserPermiso() {
        return userPermiso;
    }

    public void setUserPermiso(Usuario userPermiso) {
        this.userPermiso = userPermiso;
    }

}
