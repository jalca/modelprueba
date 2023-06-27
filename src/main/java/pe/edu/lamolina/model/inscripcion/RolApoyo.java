package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Archivo;

@Entity
@Table(name = "sip_rol_apoyo")
public class RolApoyo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "fecha_hora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHora;

    @OneToMany(mappedBy = "rolApoyo", fetch = FetchType.LAZY)
    private List<RequerimientoApoyo> requerimientoApoyo;

    @Transient
    List<Archivo> guias;

    @Transient
    private String hora;

    public RolApoyo() {
    }

    public RolApoyo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<RequerimientoApoyo> getRequerimientoApoyo() {
        return requerimientoApoyo;
    }

    public void setRequerimientoApoyo(List<RequerimientoApoyo> requerimientoApoyo) {
        this.requerimientoApoyo = requerimientoApoyo;
    }

    public List<Archivo> getGuias() {
        return guias;
    }

    public void setGuias(List<Archivo> guias) {
        this.guias = guias;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
