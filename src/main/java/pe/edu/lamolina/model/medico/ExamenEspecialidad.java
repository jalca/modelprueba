package pe.edu.lamolina.model.medico;

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
import pe.edu.lamolina.model.enums.ExamenMedicoEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "med_examen_especialidad")
public class ExamenEspecialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden_atencion")
    private Integer ordenAtencion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_atencion")
    private Usuario userAtencion;

    @Column(name = "fecha_atencion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_medico")
    private ExamenMedico examenMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad_medica")
    private EspecialidadMedica especialidadMedica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    public ExamenEspecialidad() {
    }

    public ExamenEspecialidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdenAtencion() {
        return ordenAtencion;
    }

    public void setOrdenAtencion(Integer ordenAtencion) {
        this.ordenAtencion = ordenAtencion;
    }

    public String getEstado() {
        return estado;
    }

    public ExamenMedicoEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return ExamenMedicoEstadoEnum.valueOf(this.estado);
    }

    public void setEstado(ExamenMedicoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Usuario getUserAtencion() {
        return userAtencion;
    }

    public void setUserAtencion(Usuario userAtencion) {
        this.userAtencion = userAtencion;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
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

    public ExamenMedico getExamenMedico() {
        return examenMedico;
    }

    public void setExamenMedico(ExamenMedico examenMedico) {
        this.examenMedico = examenMedico;
    }

    public EspecialidadMedica getEspecialidadMedica() {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(EspecialidadMedica especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}
