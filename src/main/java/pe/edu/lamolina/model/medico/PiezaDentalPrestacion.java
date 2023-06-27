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
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "med_pieza_dental_prestacion")
public class PiezaDentalPrestacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cuadrante_dental")
    private Integer cuadranteDental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_odontograma")
    private HistoriaOdontograma historiaOdontograma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pieza_dental")
    private PiezaDental piezaDental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestacion_dental")
    private PrestacionDental prestacionDental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Transient
    private Boolean estilo = Boolean.FALSE;
    
    public PiezaDentalPrestacion() {
    }

    public PiezaDentalPrestacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PiezaDental getPiezaDental() {
        return piezaDental;
    }

    public void setPiezaDental(PiezaDental piezaDental) {
        this.piezaDental = piezaDental;
    }

    public Integer getCuadranteDental() {
        return cuadranteDental;
    }

    public void setCuadranteDental(Integer cuadranteDental) {
        this.cuadranteDental = cuadranteDental;
    }

    public HistoriaOdontograma getHistoriaOdontograma() {
        return historiaOdontograma;
    }

    public void setHistoriaClinica(HistoriaOdontograma historiaOdontograma) {
        this.historiaOdontograma = historiaOdontograma;
    }

    public PrestacionDental getPrestacionDental() {
        return prestacionDental;
    }

    public void setPrestacionDental(PrestacionDental prestacionDental) {
        this.prestacionDental = prestacionDental;
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

    public Boolean getEstilo() {
        return estilo;
    }

    public void setEstilo(Boolean estilo) {
        this.estilo = estilo;
    }

}
