package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "extn_item_deuda_taller")
public class ItemDeudaTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deuda")
    private BigDecimal deuda;

    @Column(name = "monto_descuento")
    private BigDecimal montoDescuento;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller_verano")
    private TallerVerano tallerVerano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda_taller_verano")
    private DeudaTallerVerano deudaTallerVerano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_descuento_taller")
    private DescuentoTaller descuentoTallerVerano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public ItemDeudaTaller(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getKey() {
        if (this.tallerVerano == null || this.alumno == null || this.tallerVerano.getTallerCiclo() == null) {
            return "";
        }
        return this.tallerVerano.getTallerCiclo().getId() + "-" + this.alumno.getId();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "deuda", deuda, false);
        ModelUtils.getDataByAttr(join, "montoDescuento", montoDescuento, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttrObject(join, "tallerVerano", tallerVerano, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "deudaTallerVerano", deudaTallerVerano, "id", "estado", "monto");
        ModelUtils.getDataByAttrObject(join, "descuentoTallerVerano", descuentoTallerVerano, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
