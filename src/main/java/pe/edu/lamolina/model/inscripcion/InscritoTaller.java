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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.EstadoInscritoEnum;

@Entity
@Table(name = "sip_inscrito_taller")
public class InscritoTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inscripcion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller")
    private Taller taller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inscripcion")
    private Usuario userInscripcion;

    public InscritoTaller() {
    }

    public InscritoTaller(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public String getEstado() {
        return estado;
    }

    public EstadoInscritoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoInscritoEnum.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUserIncripcion() {
        return userInscripcion;
    }

    public void setUserIncripcion(Usuario userIncripcion) {
        this.userInscripcion = userIncripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

}
