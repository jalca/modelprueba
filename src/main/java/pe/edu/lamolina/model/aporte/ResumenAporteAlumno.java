package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.MatriculaResumen;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "apo_resumen_aporte_alumno", catalog = GlobalConstantine.SCHEMA_OCTOPUS)
public class ResumenAporteAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "monto_inicial")
    private BigDecimal montoInicial;

    @Column(name = "monto_fraccionado")
    private BigDecimal montoFraccionado;

    @Column(name = "monto_pendiente")
    private BigDecimal montoPendiente;

    @Column(name = "monto_cancelado")
    private BigDecimal montoCancelado;

    @Column(name = "monto_exonerado")
    private BigDecimal montoExonerado;

    @Column(name = "monto_afavor")
    private BigDecimal montoAFavor;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula_resumen")
    private MatriculaResumen matriculaResumen;

    @OneToMany(mappedBy = "resumenAporteAlumno", fetch = FetchType.LAZY)
    private List<AporteAlumnoCiclo> aporteAlumnoCiclo;

    public ResumenAporteAlumno(MatriculaResumen resumen, Usuario user) {
        this.matriculaResumen = resumen;
        this.userRegistro = user;
        this.fechaRegistro = new Date();
        this.montoTotal = BigDecimal.ZERO;
        this.montoInicial = BigDecimal.ZERO;
        this.montoFraccionado = BigDecimal.ZERO;
        this.montoPendiente = BigDecimal.ZERO;
        this.montoCancelado = BigDecimal.ZERO;
        this.montoExonerado = BigDecimal.ZERO;
        this.montoAFavor = BigDecimal.ZERO;
    }

    public ResumenAporteAlumno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResumenAporteAlumno other = (ResumenAporteAlumno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
