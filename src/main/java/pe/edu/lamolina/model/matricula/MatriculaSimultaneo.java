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
import pe.edu.lamolina.model.academico.MatriculaCurso;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_matricula_simultaneo")
public class MatriculaSimultaneo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_curso")
    private MatriculaCurso matriculaCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_curso_simultaneo")
    private MatriculaCurso matriculaCursoSimultaneo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public MatriculaSimultaneo() {
    }

    public MatriculaSimultaneo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public MatriculaCurso getMatriculaCurso() {
        return matriculaCurso;
    }

    public void setMatriculaCurso(MatriculaCurso matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }

    public MatriculaCurso getMatriculaCursoSimultaneo() {
        return matriculaCursoSimultaneo;
    }

    public void setMatriculaCursoSimultaneo(MatriculaCurso matriculaCursoSimultaneo) {
        this.matriculaCursoSimultaneo = matriculaCursoSimultaneo;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

}
