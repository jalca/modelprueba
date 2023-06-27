package pe.edu.lamolina.model.academico;

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
import pe.edu.lamolina.model.general.TipoAula;

@Entity
@Table(name = "aca_formato_curso")
public class FormatoCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @Column(name = "horas_teoria")
    private Integer horasTeoria;

    @Column(name = "creditos_teoria")
    private Integer creditosTeoria;

    @Column(name = "horas_practica")
    private Integer horasPractica;

    @Column(name = "creditos_practica")
    private Integer creditosPractica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_aula_teoria")
    private TipoAula tipoAulaTeoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_aula_practica")
    private TipoAula tipoAulaPractica;

    public FormatoCurso() {
    }

    public FormatoCurso(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public TipoAula getTipoAulaTeoria() {
        return tipoAulaTeoria;
    }

    public void setTipoAulaTeoria(TipoAula tipoAulaTeoria) {
        this.tipoAulaTeoria = tipoAulaTeoria;
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public Integer getHorasTeoria() {
        return horasTeoria;
    }

    public void setHorasTeoria(Integer horasTeoria) {
        this.horasTeoria = horasTeoria;
    }

    public Integer getCreditosTeoria() {
        return creditosTeoria;
    }

    public void setCreditosTeoria(Integer creditosTeoria) {
        this.creditosTeoria = creditosTeoria;
    }

    public Integer getHorasPractica() {
        return horasPractica;
    }

    public void setHorasPractica(Integer horasPractica) {
        this.horasPractica = horasPractica;
    }

    public Integer getCreditosPractica() {
        return creditosPractica;
    }

    public void setCreditosPractica(Integer creditosPractica) {
        this.creditosPractica = creditosPractica;
    }

    public TipoAula getTipoAulaPractica() {
        return tipoAulaPractica;
    }

    public void setTipoAulaPractica(TipoAula tipoAulaPractica) {
        this.tipoAulaPractica = tipoAulaPractica;
    }

}
