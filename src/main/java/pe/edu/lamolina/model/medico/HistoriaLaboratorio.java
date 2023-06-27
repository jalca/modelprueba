package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.FactorRhEnum;
import pe.edu.lamolina.model.enums.TipoSangreEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "med_historia_laboratorio")
public class HistoriaLaboratorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_muestra")
    private Long numeroMuestra;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Column(name = "factor_rh")
    private String factorRH;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estandar")
    private BigDecimal estandar;

    @Column(name = "hemoglobina")
    private BigDecimal hemoglobina;

    @Column(name = "valor_muestra")
    private BigDecimal valorMuestra;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_muestra")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaMuestra;

    @Column(name = "fecha_analisis")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnalisis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_diario_laboratorio")
    private DiarioLaboratorio diarioLaboratorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_analisis")
    private Usuario userAnalisis;

    @Transient
    private Long idRecorridoIngresante;

    public HistoriaLaboratorio() {
    }

    public HistoriaLaboratorio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoSangreEnum getTipoSangreEnum() {
        return tipoSangre != null ? TipoSangreEnum.valueOf(tipoSangre) : null;
    }

    @JsonIgnore
    public void setTipoSangreEnum(TipoSangreEnum tipoSangre) {
        if (tipoSangre == null) {
            return;
        }
        this.tipoSangre = tipoSangre.name();
    }

    public FactorRhEnum getFactorRHEnum() {
        return factorRH != null ? FactorRhEnum.valueOf(factorRH) : null;
    }

    @JsonIgnore
    public void setFactorRHEnum(FactorRhEnum factorRH) {
        if (factorRH == null) {
            return;
        }
        this.factorRH = factorRH.name();
    }

}
