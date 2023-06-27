package pe.edu.lamolina.model.rrhh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.enums.ContratoDocenteEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Resolucion;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rrhh_contrato_docente")
public class ContratoDocente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_inicio_contrato")
    private CicloAcademico cicloInicioContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_fin_contrato")
    private CicloAcademico cicloFinContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaDocente categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dedicacion")
    private DedicacionDocente dedicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion")
    private SituacionDocente situacion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_vobo")
    private Usuario userVobo;

    @Column(name = "fecha_vobo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVobo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion_facultad")
    private Resolucion resolucionFacultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_facultad")
    private Usuario userFacultad;

    @Column(name = "fecha_facultad")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFacultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion_consejo")
    private Resolucion resolucionConsejo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_consejo")
    private Usuario userConsejo;

    @Column(name = "fecha_consejo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaConsejo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    public ContratoDocente() {
    }

    public ContratoDocente(Long id) {
        this.id = id;
    }

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

    public CategoriaDocente getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDocente categoria) {
        this.categoria = categoria;
    }

    public DedicacionDocente getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(DedicacionDocente dedicacion) {
        this.dedicacion = dedicacion;
    }

    public SituacionDocente getSituacion() {
        return situacion;
    }

    public void setSituacion(SituacionDocente situacion) {
        this.situacion = situacion;
    }

    public ContratoDocenteEstadoEnum getEstadoEnum() {
        return ContratoDocenteEstadoEnum.valueOf(estado);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(ContratoDocenteEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Usuario getUserVobo() {
        return userVobo;
    }

    public void setUserVobo(Usuario userVobo) {
        this.userVobo = userVobo;
    }

    public Date getFechaVobo() {
        return fechaVobo;
    }

    public void setFechaVobo(Date fechaVobo) {
        this.fechaVobo = fechaVobo;
    }

    public Resolucion getResolucionFacultad() {
        return resolucionFacultad;
    }

    public void setResolucionFacultad(Resolucion resolucionFacultad) {
        this.resolucionFacultad = resolucionFacultad;
    }

    public Usuario getUserFacultad() {
        return userFacultad;
    }

    public void setUserFacultad(Usuario userFacultad) {
        this.userFacultad = userFacultad;
    }

    public Date getFechaFacultad() {
        return fechaFacultad;
    }

    public void setFechaFacultad(Date fechaFacultad) {
        this.fechaFacultad = fechaFacultad;
    }

    public Resolucion getResolucionConsejo() {
        return resolucionConsejo;
    }

    public void setResolucionConsejo(Resolucion resolucionConsejo) {
        this.resolucionConsejo = resolucionConsejo;
    }

    public Usuario getUserConsejo() {
        return userConsejo;
    }

    public void setUserConsejo(Usuario userConsejo) {
        this.userConsejo = userConsejo;
    }

    public Date getFechaConsejo() {
        return fechaConsejo;
    }

    public void setFechaConsejo(Date fechaConsejo) {
        this.fechaConsejo = fechaConsejo;
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

    public CicloAcademico getCicloInicioContrato() {
        return cicloInicioContrato;
    }

    public void setCicloInicioContrato(CicloAcademico cicloInicioContrato) {
        this.cicloInicioContrato = cicloInicioContrato;
    }

    public CicloAcademico getCicloFinContrato() {
        return cicloFinContrato;
    }

    public void setCicloFinContrato(CicloAcademico cicloFinContrato) {
        this.cicloFinContrato = cicloFinContrato;
    }
}
