package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "med_historia_odontograma")
public class HistoriaOdontograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "especificacion")
    private String especificacion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "piezas_curar")
    private Integer piezasCurar;

    @Column(name = "piezas_extraer")
    private Integer piezasExtraer;

    @Column(name = "limpieza_dental")
    private Boolean limpiezaDental;

    @Column(name = "prioritario")
    private Boolean prioritario;

    @Column(name = "fecha_odontograma")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaOdontograma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @Column(name = "fecha_atencion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAtencion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @Transient
    private List<PiezaDentalHallazgo> hallazgos;

    public HistoriaOdontograma() {
    }

    public HistoriaOdontograma(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getPiezasCurar() {
        return piezasCurar;
    }

    public void setPiezasCurar(Integer piezasCurar) {
        this.piezasCurar = piezasCurar;
    }

    public Integer getPiezasExtraer() {
        return piezasExtraer;
    }

    public void setPiezasExtraer(Integer piezasExtraer) {
        this.piezasExtraer = piezasExtraer;
    }

    public Boolean getLimpiezaDental() {
        return limpiezaDental;
    }

    public void setLimpiezaDental(Boolean limpiezaDental) {
        this.limpiezaDental = limpiezaDental;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Date getFechaOdontograma() {
        return fechaOdontograma;
    }

    public void setFechaOdontograma(Date fechaOdontograma) {
        this.fechaOdontograma = fechaOdontograma;
    }

    public List<PiezaDentalHallazgo> getHallazgos() {
        return hallazgos;
    }

    public void setHallazgos(List<PiezaDentalHallazgo> hallazgos) {
        this.hallazgos = hallazgos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Boolean getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(Boolean prioritario) {
        this.prioritario = prioritario;
    }

}
