package pe.edu.lamolina.model.academico;

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

@Entity
@Table(name = "aca_curso_equivalente")
public class CursoEquivalente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_curricula")
    private CursoCurricula cursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_equivalente")
    private Curso cursoEquivalente;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_caduco")
    private CursoCurricula cursoCaduco;

    @Column(name = "grupo")
    private Integer grupo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public CursoEquivalente() {
    }

    public CursoEquivalente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoCurricula getCursoCurricula() {
        return cursoCurricula;
    }

    public void setCursoCurricula(CursoCurricula cursoCurricula) {
        this.cursoCurricula = cursoCurricula;
    }

    public Curso getCursoEquivalente() {
        return cursoEquivalente;
    }

    public void setCursoEquivalente(Curso cursoEquivalente) {
        this.cursoEquivalente = cursoEquivalente;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public CursoCurricula getCursoCaduco() {
        return cursoCaduco;
    }

    public void setCursoCaduco(CursoCurricula cursoCaduco) {
        this.cursoCaduco = cursoCaduco;
    }

}
