package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "med_historia_enfermedad")
public class HistoriaEnfermedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otra_enfermedad")
    private String otraEnfermedad;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "es_actual")
    private Boolean esActual;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "gasto_mensual")
    private BigDecimal gastoMensual;

    @Column(name = "lugar_atencion")
    private String lugarAtencion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_enfermedad")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnfermedad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enfermedad")
    private Enfermedad enfermedad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private HistoriaAntecedente historiaAntecedente;

    @Transient
    private List<HistoriaEnfermedad> historiaEnfermedades;

    public HistoriaEnfermedad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean getEsActual() {
        if (esActual == null) {
            return Boolean.FALSE;
        }
        return esActual;
    }

    public Boolean getEliminable() {
        if (fechaRegistro == null) {
            return true;
        }

        Date today = new LocalDate().toDate();
        return today.compareTo(fechaRegistro) < 0;
    }

}
