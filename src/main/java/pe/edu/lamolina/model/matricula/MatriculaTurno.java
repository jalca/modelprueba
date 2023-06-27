package pe.edu.lamolina.model.matricula;

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
import pe.edu.lamolina.model.academico.EventoAcademico;
import pe.edu.lamolina.model.academico.MatriculaResumen;
import pe.edu.lamolina.model.academico.TurnoAtencion;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_matricula_turno")
public class MatriculaTurno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "veces_ingreso")
    private Integer vecesIngreso;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "motivo")
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno_atencion")
    private TurnoAtencion turnoAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_resumen")
    private MatriculaResumen matriculaResumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_academico")
    private EventoAcademico eventoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public MatriculaTurno() {
    }

    public MatriculaTurno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVecesIngreso() {
        return vecesIngreso;
    }

    public void setVecesIngreso(Integer vecesIngreso) {
        this.vecesIngreso = vecesIngreso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TurnoAtencion getTurnoAtencion() {
        return turnoAtencion;
    }

    public void setTurnoAtencion(TurnoAtencion turnoAtencion) {
        this.turnoAtencion = turnoAtencion;
    }

    public MatriculaResumen getMatriculaResumen() {
        return matriculaResumen;
    }

    public void setMatriculaResumen(MatriculaResumen matriculaResumen) {
        this.matriculaResumen = matriculaResumen;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public EventoAcademico getEventoAcademico() {
        return eventoAcademico;
    }

    public void setEventoAcademico(EventoAcademico eventoAcademico) {
        this.eventoAcademico = eventoAcademico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
