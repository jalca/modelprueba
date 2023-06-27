package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.edu.lamolina.model.rrhh.CategoriaDocente;
import pe.edu.lamolina.model.rrhh.SituacionDocente;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_docente_ciclo")
public class DocenteCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "promedio_alumnos")
    private BigDecimal promedioAlumnos;

    @Column(name = "creditos_total")
    private BigDecimal creditosTotal;

    @Column(name = "creditos_exceso")
    private BigDecimal creditosExceso;

    @Column(name = "factor1")
    private BigDecimal factor1;

    @Column(name = "factor2")
    private BigDecimal factor2;

    @Column(name = "monto")
    private BigDecimal monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_docente")
    private CategoriaDocente categoriaDocente;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_docente")
    private SituacionDocente situacionDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public ModalidadEstudio getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(ModalidadEstudio modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public BigDecimal getPromedioAlumnos() {
        return promedioAlumnos;
    }

    public void setPromedioAlumnos(BigDecimal promedioAlumnos) {
        this.promedioAlumnos = promedioAlumnos;
    }

    public BigDecimal getCreditosTotal() {
        return creditosTotal;
    }

    public void setCreditosTotal(BigDecimal creditosTotal) {
        this.creditosTotal = creditosTotal;
    }

    public BigDecimal getCreditosExceso() {
        return creditosExceso;
    }

    public void setCreditosExceso(BigDecimal creditosExceso) {
        this.creditosExceso = creditosExceso;
    }

    public BigDecimal getFactor1() {
        return factor1;
    }

    public void setFactor1(BigDecimal factor1) {
        this.factor1 = factor1;
    }

    public BigDecimal getFactor2() {
        return factor2;
    }

    public void setFactor2(BigDecimal factor2) {
        this.factor2 = factor2;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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

    public CategoriaDocente getCategoriaDocente() {
        return categoriaDocente;
    }

    public void setCategoriaDocente(CategoriaDocente categoriaDocente) {
        this.categoriaDocente = categoriaDocente;
    }

    public SituacionDocente getSituacionDocente() {
        return situacionDocente;
    }

    public void setSituacionDocente(SituacionDocente situacionDocente) {
        this.situacionDocente = situacionDocente;
    }

}
