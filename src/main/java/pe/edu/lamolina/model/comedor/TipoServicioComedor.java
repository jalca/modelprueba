package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.comedor.TipoServicioEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_tipo_servicio_comedor")
public class TipoServicioComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "hora_alerta")
    private String horaAlerta;

    @Column(name = "hora_fin_venta")
    private String horaFinVenta;

    @Column(name = "hora_inicio_atencion")
    private String horaInicioAtencion;

    @Column(name = "hora_fin_atencion")
    private String horaFinAtencion;

    @Column(name = "hora_inicio_publico")
    private String horaInicioPublico;

    @Column(name = "hora_fin_publico")
    private String horaFinPublico;

    @Column(name = "hora_liberacion")
    private String horaLiberacion;

    @Column(name = "hora_liberacion_becado")
    private String horaLiberacionBecado;

    @Column(name = "orden")
    private Integer orden;

    @Transient
    private String estado;
    @Transient
    private Long racionesDiarias;
    @Transient
    private ControlVentaTramo controlVentaTramo;

    public TipoServicioComedor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoServicioEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoServicioEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoServicioEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public TipoServicioComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getHoraFinVentaNumber() {
        if (this.horaFinVenta == null) {
            return null;
        }
        return new Integer(this.horaFinVenta.replace(":", ""));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TipoServicioComedor)) {
            return false;
        }

        TipoServicioComedor other = (TipoServicioComedor) obj;
        if (this.id == null && other.getId() == null) {
            return true;
        }

        if ((this.id == null && other.getId() != null)
                || (this.id != null && other.getId() == null)
                || (this.id.compareTo(other.getId()) != 0)) {
            return false;
        }
        return true;
    }
}
