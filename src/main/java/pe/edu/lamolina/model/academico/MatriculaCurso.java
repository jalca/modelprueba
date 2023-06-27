package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import static pe.edu.lamolina.model.enums.EstadoMatriculaEnum.RCI;
import static pe.edu.lamolina.model.enums.EstadoMatriculaEnum.RCU;
import static pe.edu.lamolina.model.enums.EstadoMatriculaEnum.RET;
import pe.edu.lamolina.model.matricula.MatriculaSimultaneo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "aca_matricula_curso")
public class MatriculaCurso implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_aprobados")
    private Integer creditosAprobados;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nota_avance")
    private String notaAvance;

    @Column(name = "nota_acumulada")
    private String notaAcumulada;

    @Column(name = "nota_final")
    private String notaFinal;

    @Column(name = "nota_avance_full")
    private String notaAvanceFull;

    @Column(name = "nota_acumulada_full")
    private String notaAcumuladaFull;

    @Column(name = "color_semaforo")
    private String colorSemaforo;

    @Column(name = "porcentaje_avance_nota")
    private Integer porcentajeAvanceNota;

    @Column(name = "inasistencias")
    private Integer inasistencias;

    @Column(name = "inasistencias_exoneradas")
    private Integer inasistenciasExoneradas;

    @Column(name = "oculto_maipi")
    private Integer ocultoMaipi;

    @Column(name = "fecha_prematricula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaPrematricula;

    @Column(name = "fecha_matricula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaMatricula;

    @Column(name = "fecha_anula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAnula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_resumen")
    private MatriculaResumen matriculaResumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_prematricula")
    private Usuario userPrematricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_matricula")
    private Usuario userMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anula")
    private Usuario userAnula;

    @OneToMany(mappedBy = "matriculaCurso", fetch = FetchType.LAZY)
    private List<MatriculaSimultaneo> matriculaSimultaneo;

    @Transient
    boolean seleccionado;
    @Transient
    boolean barrido;
    @Transient
    private Integer cargado;
    @Transient
    private List<MatriculaSeccion> matriculaSeccion;
    @Transient
    private GrupoSeccion grupoSeccion;
    @Transient
    private Seccion seccion;
    @Transient
    private String notaExamenFinal;

    public MatriculaCurso() {
        this.inasistencias = BigDecimal.ZERO.intValue();
        cargado = 0;
        this.inasistenciasExoneradas = BigDecimal.ZERO.intValue();
        this.ocultoMaipi = 0;
    }

    public MatriculaCurso(Curso curso, MatriculaResumen matriculaResumen, EstadoMatriculaEnum estadoMatriculaEnum) {
        this();
        this.creditos = curso.getCreditos();
        this.creditosAprobados = 0;
        this.curso = curso;
        //   matriculaCurso.setEstadoEnum(EstadoMatriculaEnum.MAT);
        this.matriculaResumen = matriculaResumen;
        this.notaAcumulada = "0";
        this.notaAcumuladaFull = "0";
        this.notaAvance = "0";
        this.notaAvanceFull = "0";
        this.notaFinal = "0";
        this.porcentajeAvanceNota = 0;
        this.setEstadoEnum(estadoMatriculaEnum);
    }

    public MatriculaCurso(Object id) {
        this.id = TypesUtil.getLong(id);
        cargado = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatriculaResumen getMatriculaResumen() {
        return matriculaResumen;
    }

    public void setMatriculaResumen(MatriculaResumen matriculaResumen) {
        this.matriculaResumen = matriculaResumen;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getEstado() {
        return estado;
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public String getNotaAvance() {
        return notaAvance;
    }

    public void setNotaAvance(String notaAvance) {
        this.notaAvance = notaAvance;
    }

    public String getNotaAcumulada() {
        return notaAcumulada;
    }

    public void setNotaAcumulada(String notaAcumulada) {
        this.notaAcumulada = notaAcumulada;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Integer getPorcentajeAvanceNota() {
        return porcentajeAvanceNota;
    }

    public void setPorcentajeAvanceNota(Integer porcentajeAvanceNota) {
        this.porcentajeAvanceNota = porcentajeAvanceNota;
    }

    public String getNotaAvanceFull() {
        return notaAvanceFull;
    }

    public void setNotaAvanceFull(String notaAvanceFull) {
        this.notaAvanceFull = notaAvanceFull;
    }

    public String getNotaAcumuladaFull() {
        return notaAcumuladaFull;
    }

    public void setNotaAcumuladaFull(String notaAcumuladaFull) {
        this.notaAcumuladaFull = notaAcumuladaFull;
    }

    public Integer getCreditosAprobados() {
        if (Arrays.asList(RET, RCI, RCU).contains(getEstadoEnum())) {
            return 0;
        }
        return creditosAprobados;
    }

    public void setCreditosAprobados(Integer creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }

    public List<MatriculaSeccion> getMatriculaSeccion() {
        return matriculaSeccion;
    }

    public void setMatriculaSeccion(List<MatriculaSeccion> matriculaSeccion) {
        this.matriculaSeccion = matriculaSeccion;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Integer getCargado() {
        return cargado;
    }

    public void setCargado(Integer cargado) {
        this.cargado = cargado;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(TipoCursoCurricula tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

    public Integer getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(Integer inasistencias) {
        this.inasistencias = inasistencias;
    }

    public Integer getInasistenciasExoneradas() {
        return inasistenciasExoneradas;
    }

    public void setInasistenciasExoneradas(Integer inasistenciasExoneradas) {
        this.inasistenciasExoneradas = inasistenciasExoneradas;
    }

    public String getColorSemaforo() {
        return colorSemaforo;
    }

    public void setColorSemaforo(String colorSemaforo) {
        this.colorSemaforo = colorSemaforo;
    }

    public GrupoSeccion getGrupoSeccion() {
        return grupoSeccion;
    }

    public void setGrupoSeccion(GrupoSeccion grupoSeccion) {
        this.grupoSeccion = grupoSeccion;
    }

    public List<MatriculaSimultaneo> getMatriculaSimultaneo() {
        return matriculaSimultaneo;
    }

    public void setMatriculaSimultaneo(List<MatriculaSimultaneo> matriculaSimultaneo) {
        this.matriculaSimultaneo = matriculaSimultaneo;
    }

    public Date getFechaPrematricula() {
        return fechaPrematricula;
    }

    public void setFechaPrematricula(Date fechaPrematricula) {
        this.fechaPrematricula = fechaPrematricula;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Date getFechaAnula() {
        return fechaAnula;
    }

    public void setFechaAnula(Date fechaAnula) {
        this.fechaAnula = fechaAnula;
    }

    public Usuario getUserPrematricula() {
        return userPrematricula;
    }

    public void setUserPrematricula(Usuario userPrematricula) {
        this.userPrematricula = userPrematricula;
    }

    public Usuario getUserMatricula() {
        return userMatricula;
    }

    public void setUserMatricula(Usuario userMatricula) {
        this.userMatricula = userMatricula;
    }

    public Usuario getUserAnula() {
        return userAnula;
    }

    public void setUserAnula(Usuario userAnula) {
        this.userAnula = userAnula;
    }

    public Integer getOcultoMaipi() {
        return ocultoMaipi;
    }

    public void setOcultoMaipi(Integer ocultoMaipi) {
        this.ocultoMaipi = ocultoMaipi;
    }

    public Integer getOrdenTipoCurso() {
        Integer ordenTipoCurso = null;
        switch (this.tipoCursoCurricula.getCodigoEnum()) {
            case OBL:
            case GEN:
            case ELC:
            case ELE:
            case PROD:
            case CULT:
            case TECIND:
                ordenTipoCurso = 1;
            case EEP:
                ordenTipoCurso = 2;

        }
        return ordenTipoCurso;
    }

    public boolean isEstadoMAT() {
        if (EstadoMatriculaEnum.MAT.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoPMAT() {
        if (EstadoMatriculaEnum.PMAT.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRCU() {
        if (EstadoMatriculaEnum.RCU.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRCI() {
        if (EstadoMatriculaEnum.RCI.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRET() {
        if (EstadoMatriculaEnum.RET.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoSOL() {
        if (EstadoMatriculaEnum.SOL.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public String getKey() {

        return this.matriculaResumen.getId() + "-" + this.curso.getId();
    }

    public boolean isConVacante() {
        if (EstadoMatriculaEnum.MAT.name().equals(this.estado)) {
            return true;
        }
        if (EstadoMatriculaEnum.PMAT.name().equals(this.estado)) {
            return true;
        }
        if (EstadoMatriculaEnum.SOL.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public static class CompareTipoCurricula implements Comparator<MatriculaCurso> {

        @Override
        public int compare(MatriculaCurso p1, MatriculaCurso p2) {
            return p2.getOrdenTipoCurso().compareTo(p1.getOrdenTipoCurso());
        }
    }

    public static class CompareGrupoSeccion implements Comparator<MatriculaCurso> {

        @Override
        public int compare(MatriculaCurso p1, MatriculaCurso p2) {
            return p2.getGrupoSeccion().getId().compareTo(p1.getGrupoSeccion().getId());
        }
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public String getNotaExamenFinal() {
        return notaExamenFinal;
    }

    public void setNotaExamenFinal(String notaExamenFinal) {
        this.notaExamenFinal = notaExamenFinal;
    }

    public boolean isBarrido() {
        return barrido;
    }

    public void setBarrido(boolean barrido) {
        this.barrido = barrido;
    }

    @Override
    public MatriculaCurso clone() {
        MatriculaCurso clone = null;
        try {
            clone = (MatriculaCurso) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
