package pe.edu.lamolina.model.auditoria;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.academico.GrupoSeccion;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aud_control_de_actas")
public class ControlDeActas implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_seccion")
    private GrupoSeccion grupoSeccion;

    @NotNull
    @Column(name = "version")
    private String version;

    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierre_acta")
    private Usuario usuarioCierraActa;

    @Column(name = "fecha_cierre_acta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreActa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlDeActas", fetch = FetchType.LAZY)
    private List<ControlDeActasDet> controlDeActasDets;

    public ControlDeActas() {
    }

    public ControlDeActas(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public GrupoSeccion getGrupoSeccion() {
        return grupoSeccion;
    }

    public void setGrupoSeccion(GrupoSeccion grupoSeccion) {
        this.grupoSeccion = grupoSeccion;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public List<ControlDeActasDet> getControlDeActasDets() {
        return controlDeActasDets;
    }

    public void setControlDeActasDets(List<ControlDeActasDet> controlDeActasDets) {
        this.controlDeActasDets = controlDeActasDets;
    }

    public Usuario getUsuarioCierraActa() {
        return usuarioCierraActa;
    }

    public void setUsuarioCierraActa(Usuario usuarioCierraActa) {
        this.usuarioCierraActa = usuarioCierraActa;
    }

    public Date getFechaCierreActa() {
        return fechaCierreActa;
    }

    public void setFechaCierreActa(Date fechaCierreActa) {
        this.fechaCierreActa = fechaCierreActa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ControlDeActas)) {
            return false;
        }
        ControlDeActas other = (ControlDeActas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.auditoria.ControlDeActas[ id=" + id + " ]";
    }

}
