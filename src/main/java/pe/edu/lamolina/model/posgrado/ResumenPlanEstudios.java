package pe.edu.lamolina.model.posgrado;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.TipoCursoCurricula;

@Entity
@Table(name = "tram_resumen_plan_estudios")
public class ResumenPlanEstudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_cumplidos")
    private Integer creditosCumplidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_plan_estudios")
    private AlumnoPlanEstudios alumnoPlanEstudios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    public ResumenPlanEstudios(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ResumenPlanEstudios() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCreditosCumplidos() {
        return creditosCumplidos;
    }

    public void setCreditosCumplidos(Integer creditosCumplidos) {
        this.creditosCumplidos = creditosCumplidos;
    }

    public AlumnoPlanEstudios getAlumnoPlanEstudios() {
        return alumnoPlanEstudios;
    }

    public void setAlumnoPlanEstudios(AlumnoPlanEstudios alumnoPlanEstudios) {
        this.alumnoPlanEstudios = alumnoPlanEstudios;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(TipoCursoCurricula tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

}
