package pe.edu.lamolina.model.medico;

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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "med_historia_vacuna")
public class HistoriaVacuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otra_vacuna")
    private String otraVacuna;

    @Column(name = "dosis")
    private String dosis;

    @Column(name = "lote_vacuna")
    private String lote;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "antecedente")
    private Boolean antecedente;

    @Column(name = "primera_visita")
    private Boolean primeraVisita;

    @Column(name = "tiene_efecto_adverso")
    private Boolean tieneEfectoAdverso;

    @Column(name = "efecto_adverso")
    private String efectoAdverso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vacuna")
    private Vacuna vacuna;

    @Column(name = "fecha_vacuna")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVacuna;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    HistoriaAntecedente historiaAntecedente;

    public HistoriaVacuna() {
    }

    public HistoriaVacuna(Object id) {
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

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
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

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getOtraVacuna() {
        return otraVacuna;
    }

    public void setOtraVacuna(String otraVacuna) {
        this.otraVacuna = otraVacuna;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(Boolean antecedente) {
        this.antecedente = antecedente;
    }

    public HistoriaAntecedente getHistoriaAntecedente() {
        return historiaAntecedente;
    }

    public void setHistoriaAntecedente(HistoriaAntecedente historiaAntecedente) {
        this.historiaAntecedente = historiaAntecedente;
    }

    public Boolean getTieneEfectoAdverso() {
        return tieneEfectoAdverso;
    }

    public void setTieneEfectoAdverso(Boolean tieneEfectoAdverso) {
        this.tieneEfectoAdverso = tieneEfectoAdverso;
    }

    public String getEfectoAdverso() {
        return efectoAdverso;
    }

    public void setEfectoAdverso(String efectoAdverso) {
        this.efectoAdverso = efectoAdverso;
    }

    public Boolean getPrimeraVisita() {
        return primeraVisita;
    }

    public void setPrimeraVisita(Boolean primeraVisita) {
        this.primeraVisita = primeraVisita;
    }
    
}
