package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.opensagres.xdocreport.utils.StringUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import pe.edu.lamolina.model.almacen.Producto;
import pe.edu.lamolina.model.almacen.ReservaProducto;
import pe.edu.lamolina.model.general.UnidadMedida;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "med_receta_detalle")
public class RecetaDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad_receta")
    private BigDecimal cantidadReceta;

    @Column(name = "cantidad_entregada")
    private BigDecimal cantidadEntregada;

    @Column(name = "dosis")
    private BigDecimal dosis;

    @Column(name = "tipo_dosis")
    private String tipoDosis;

    @Column(name = "frecuencia_horas")
    private Integer frecuenciaHoras;

    @Column(name = "periodo_dias")
    private Integer periodoDias;

    @Column(name = "otra_forma_medicamento")
    private String otraFormaMedicamento;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_entrega")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receta")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_forma_medicamento")
    private FormaMedicamento formaMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_entrega")
    private Usuario userEntrega;

    @Transient
    private ReservaProducto reservaProducto;

    @Transient
    private List<ReservaProducto> reservas;

    public RecetaDetalle() {

    }

    public RecetaDetalle(Long id) {
        this.id = id;
    }

    public String getProcedimiento() {
        if (this.dosis == null) {
            return null;
        }
        if (this.frecuenciaHoras == null) {
            return null;
        }
        if (this.periodoDias == null) {
            return null;
        }
        if (this.tipoDosis == null) {
            return null;
        }

        BigDecimal dosisFix = this.dosis.setScale(2, BigDecimal.ROUND_DOWN);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        String proc = df.format(dosisFix) + " " + this.tipoDosis + " cada " + this.frecuenciaHoras + " ";
        proc += this.frecuenciaHoras > 1 ? "horas" : "hora";
        proc += " durante " + this.periodoDias + " ";
        proc += this.periodoDias > 1 ? "días." : "día.";

        if (!StringUtils.isEmpty(this.comentario)) {
            proc += " " + this.comentario;
            if (!this.comentario.endsWith(".")) {
                proc += ".";
            }
        }

        return proc;
    }

}
