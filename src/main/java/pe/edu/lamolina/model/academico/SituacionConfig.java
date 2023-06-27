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

@Entity
@Table(name = "aca_situacion_config")
public class SituacionConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_inicial")
    public SituacionAcademica situacionInicial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_final")
    public SituacionAcademica situacionFinal;

    @Column(name = "aprobado")
    private Integer aprobado;

    @Column(name = "ciclos_estudiados")
    private Integer ciclosEstudiados;

    @Column(name = "autorizado")
    private Integer autorizado;

    @Column(name = "capa")
    private Integer capa;

    @Column(name = "capa_mayore")
    private Integer capaMayore;

    @Column(name = "siguiente_ciclo")
    private Integer siguienteCiclo;

    @Column(name = "tramite")
    private Integer tramite;

    @Column(name = "ciclo_regular")
    private Integer cicloRegular;

    public SituacionConfig() {
    }

    public SituacionConfig(Object situacionInicial, Object situacionFinal) {
        this.situacionInicial = new SituacionAcademica(TypesUtil.getLong(situacionInicial));
        this.situacionFinal = new SituacionAcademica(TypesUtil.getLong(situacionFinal));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SituacionAcademica getSituacionInicial() {
        return situacionInicial;
    }

    public void setSituacionInicial(SituacionAcademica situacionInicial) {
        this.situacionInicial = situacionInicial;
    }

    public SituacionAcademica getSituacionFinal() {
        return situacionFinal;
    }

    public void setSituacionFinal(SituacionAcademica situacionFinal) {
        this.situacionFinal = situacionFinal;
    }

    public Integer getAprobado() {
        return aprobado;
    }

    public void setAprobado(Integer aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getCiclosEstudiados() {
        return ciclosEstudiados;
    }

    public void setCiclosEstudiados(Integer ciclosEstudiados) {
        this.ciclosEstudiados = ciclosEstudiados;
    }

    public Integer getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Integer autorizado) {
        this.autorizado = autorizado;
    }

    public Integer getCapa() {
        return capa;
    }

    public void setCapa(Integer capa) {
        this.capa = capa;
    }

    public Integer getCapaMayore() {
        return capaMayore;
    }

    public void setCapaMayore(Integer capaMayore) {
        this.capaMayore = capaMayore;
    }

    public Integer getSiguienteCiclo() {
        return siguienteCiclo;
    }

    public void setSiguienteCiclo(Integer siguienteCiclo) {
        this.siguienteCiclo = siguienteCiclo;
    }

    public Integer getTramite() {
        return tramite;
    }

    public void setTramite(Integer tramite) {
        this.tramite = tramite;
    }

    public Integer getCicloRegular() {
        return cicloRegular;
    }

    public void setCicloRegular(Integer cicloRegular) {
        this.cicloRegular = cicloRegular;
    }

}
