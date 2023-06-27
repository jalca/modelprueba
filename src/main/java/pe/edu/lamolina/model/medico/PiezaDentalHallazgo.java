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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "med_pieza_dental_hallazgo")
public class PiezaDentalHallazgo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_odontograma")
    private HistoriaOdontograma historiaOdontograma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pieza_dental")
    private PiezaDental piezaDental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_odonto_hallazgo")
    private OdontoHallazgo hallazgo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hallazgo_estilo")
    private HallazgoEstilo hallazgoEstilo;

    @Column(name = "trazo")
    private String trazo;

    @Column(name = "numero_hallazgo")
    private Long numeroHallazgo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public PiezaDentalHallazgo() {
    }

    public PiezaDentalHallazgo(Object id) {
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

    public OdontoHallazgo getHallazgo() {
        return hallazgo;
    }

    public void setHallazgo(OdontoHallazgo hallazgo) {
        this.hallazgo = hallazgo;
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

    public HistoriaOdontograma getHistoriaOdontograma() {
        return historiaOdontograma;
    }

    public void setHistoriaOdontograma(HistoriaOdontograma historiaOdontograma) {
        this.historiaOdontograma = historiaOdontograma;
    }

    public HallazgoEstilo getHallazgoEstilo() {
        return hallazgoEstilo;
    }

    public void setHallazgoEstilo(HallazgoEstilo hallazgoEstilo) {
        this.hallazgoEstilo = hallazgoEstilo;
    }

    public String getTrazo() {
        return trazo;
    }

    public void setTrazo(String trazo) {
        this.trazo = trazo;
    }

    public Long getNumeroHallazgo() {
        return numeroHallazgo;
    }

    public void setNumeroHallazgo(Long numeroHallazgo) {
        this.numeroHallazgo = numeroHallazgo;
    }
}
