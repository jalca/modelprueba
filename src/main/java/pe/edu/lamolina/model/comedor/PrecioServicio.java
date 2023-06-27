package pe.edu.lamolina.model.comedor;

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
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "com_precio_servicio")
public class PrecioServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "raciones_diarias")
    private Integer racionesDiarias;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio_comedor")
    private TipoServicioComedor tipoServicioComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public PrecioServicio() {
    }

    public PrecioServicio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCostoStr() {
        if (costo != null) {
            return NumberFormat.precio(costo);
        }
        return "0.00";
    }

    public String getPrecioStr() {
        if (precio != null) {
            return NumberFormat.precio(precio);
        }
        return "0.00";
    }

    public String getFechaInicioStr() {
        if (fechaInicio != null) {
            return new DateTime(fechaInicio).toString("dd/MM/yyyy");
        }
        return "";
    }

    public String getFechaFinStr() {
        if (fechaFin != null) {
            return new DateTime(fechaFin).toString("dd/MM/yyyy");
        }
        return "";
    }

}
