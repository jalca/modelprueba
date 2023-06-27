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
import pe.edu.lamolina.model.examen.ExamenVirtual;

@Entity
@Table(name = "sip_examen_vitual_interesados")
public class ExamenVitualInteresados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_user_creacion")
    private String idUserCreacion;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    public ExamenVitualInteresados() {
    }

    public ExamenVitualInteresados(Object id) {
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

    public ExamenVirtual getExamenVirtual() {
        return examenVirtual;
    }

    public void setExamenVirtual(ExamenVirtual examenVirtual) {
        this.examenVirtual = examenVirtual;
    }

    public String getIdUserCreacion() {
        return idUserCreacion;
    }

    public void setIdUserCreacion(String idUserCreacion) {
        this.idUserCreacion = idUserCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}

