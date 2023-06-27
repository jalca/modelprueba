package pe.edu.lamolina.model.tramite;

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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.AporteAlumnoCiclo;
import pe.edu.lamolina.model.aporte.ResumenAporteAlumno;
import pe.edu.lamolina.model.bean.FraccionamientoCuotasBean;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_tramite_fraccionamiento")
public class TramiteFraccionamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "cuotas")
    private Integer cuotas;

    @Column(name = "importe_fraccionado")
    private BigDecimal importeFraccionado;

    @Column(name = "importe_total")
    private BigDecimal importeTotal;

    @Column(name = "cuota_inicial")
    private BigDecimal cuotaInicial;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resumen_aporte_alumno")
    private ResumenAporteAlumno resumenAporteAlumno;

    @Transient
    private List<AporteAlumnoCiclo> aporteAlumnoCiclo;

    @Transient
    private List<FraccionamientoCuotasBean> fraccionamientoCuotas;

    public TramiteFraccionamiento() {
    }

    public TramiteFraccionamiento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
