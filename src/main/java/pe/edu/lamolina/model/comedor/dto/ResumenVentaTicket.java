package pe.edu.lamolina.model.comedor.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.comedor.ResumenServicioComedor;
import pe.edu.lamolina.model.enums.comedor.TipoServicioEnum;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
public class ResumenVentaTicket {

    private Long desayunoDisponible;
    private Long desayunoDisponibleBecados;
    private Long desayunoBecados;
    private Long desayunoVendidos;
    private Long desayunoVentaLibre;
    private Long desayunoIngresoLibre;
    private Long desayunoAtendidos;
    private Long desayunoAtendidosBecados;
    private Long desayunoAtendidosVentaLibre;
    private Long desayunoAtendidosIngresoLibre;

    private Long almuerzoDisponible;
    private Long almuerzoDisponibleBecados;
    private Long almuerzoBecados;
    private Long almuerzoVendidos;
    private Long almuerzoVentaLibre;
    private Long almuerzoIngresoLibre;
    private Long almuerzoAtendidos;
    private Long almuerzoAtendidosBecados;
    private Long almuerzoAtendidosVentaLibre;
    private Long almuerzoAtendidosIngresoLibre;

    private Long cenaDisponible;
    private Long cenaDisponibleBecados;
    private Long cenaBecados;
    private Long cenaVendidos;
    private Long cenaVentaLibre;
    private Long cenaIngresoLibre;
    private Long cenaAtendidos;
    private Long cenaAtendidosBecados;
    private Long cenaAtendidosVentaLibre;
    private Long cenaAtendidosIngresoLibre;

    private String cenaHoraInicio;
    private String cenaHoraFin;
    private String almuerzoHoraInicio;
    private String almuerzoHoraFin;
    private String desayunoHoraInicio;
    private String desayunoHoraFin;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date fecha;
    private String tipoServicio;
    private String fechaString;

    public ResumenVentaTicket(Long desayunoDisponible, Long desayunoDisponibleBecados, Long desayunoBecados, Long desayunoVendidos, Long desayunoAtendidos, Long desayunoAtendidosBecados, Long almuerzoDisponible, Long almuerzoDisponibleBecados, Long almuerzoBecados, Long almuerzoVendidos, Long almuerzoAtendidos, Long almuerzoAtendidosBecados, Long cenaDisponible, Long cenaDisponibleBecados, Long cenaBecados, Long cenaVendidos, Long cenaAtendidos, Long cenaAtendidosBecados) {
        this.desayunoDisponible = desayunoDisponible;
        this.desayunoDisponibleBecados = desayunoDisponibleBecados;
        this.desayunoBecados = desayunoBecados;
        this.desayunoVendidos = desayunoVendidos;
        this.desayunoAtendidos = desayunoAtendidos;
        this.desayunoAtendidosBecados = desayunoAtendidosBecados;

        this.almuerzoDisponible = almuerzoDisponible;
        this.almuerzoDisponibleBecados = almuerzoDisponibleBecados;
        this.almuerzoBecados = almuerzoBecados;
        this.almuerzoVendidos = almuerzoVendidos;
        this.almuerzoAtendidos = almuerzoAtendidos;
        this.almuerzoAtendidosBecados = almuerzoAtendidosBecados;

        this.cenaDisponible = cenaDisponible;
        this.cenaDisponibleBecados = cenaDisponibleBecados;
        this.cenaBecados = cenaBecados;
        this.cenaVendidos = cenaVendidos;
        this.cenaAtendidos = cenaAtendidos;
        this.cenaAtendidosBecados = cenaAtendidosBecados;
    }

    public ResumenVentaTicket(ResumenServicioComedor resumenOrigen) {
        this.fechaString = new DateTime(resumenOrigen.getFecha()).toString("dd/MM/yyyy");

        if (resumenOrigen.getTipoServicioComedor().getCodigoEnum() == TipoServicioEnum.DESA) {
            this.desayunoDisponible = resumenOrigen.getDisponibles().longValue();
            this.desayunoDisponibleBecados = resumenOrigen.getDisponiblesBecados().longValue();
            this.desayunoBecados = resumenOrigen.getBecados().longValue();
            this.desayunoVendidos = resumenOrigen.getVendidas().longValue();
            this.desayunoAtendidos = resumenOrigen.getConsumidos().longValue();
            this.desayunoAtendidosBecados = resumenOrigen.getConsumidosBecados().longValue();
            this.tipoServicio = TipoServicioEnum.DESA.name();
        }

        if (resumenOrigen.getTipoServicioComedor().getCodigoEnum() == TipoServicioEnum.ALMU) {
            this.almuerzoDisponible = resumenOrigen.getDisponibles().longValue();
            this.almuerzoDisponibleBecados = resumenOrigen.getDisponiblesBecados().longValue();
            this.almuerzoBecados = resumenOrigen.getBecados().longValue();
            this.almuerzoVendidos = resumenOrigen.getVendidas().longValue();
            this.almuerzoAtendidos = resumenOrigen.getConsumidos().longValue();
            this.almuerzoAtendidosBecados = resumenOrigen.getConsumidosBecados().longValue();
            this.tipoServicio = TipoServicioEnum.ALMU.name();
        }

        if (resumenOrigen.getTipoServicioComedor().getCodigoEnum() == TipoServicioEnum.CENA) {
            this.cenaDisponible = resumenOrigen.getDisponibles().longValue();
            this.cenaDisponibleBecados = resumenOrigen.getDisponiblesBecados().longValue();
            this.cenaBecados = resumenOrigen.getBecados().longValue();
            this.cenaVendidos = resumenOrigen.getVendidas().longValue();
            this.cenaAtendidos = resumenOrigen.getConsumidos().longValue();
            this.cenaAtendidosBecados = resumenOrigen.getConsumidosBecados().longValue();
            this.tipoServicio = TipoServicioEnum.CENA.name();
        }
    }

    public void revisarValores() {
        this.desayunoDisponible = this.getValueDefault(this.desayunoDisponible);
        this.desayunoDisponibleBecados = this.getValueDefault(this.desayunoDisponibleBecados);
        this.desayunoBecados = this.getValueDefault(this.desayunoBecados);
        this.desayunoVendidos = this.getValueDefault(this.desayunoVendidos);
        this.desayunoVentaLibre = this.getValueDefault(this.desayunoVentaLibre);
        this.desayunoIngresoLibre = this.getValueDefault(this.desayunoIngresoLibre);
        this.desayunoAtendidos = this.getValueDefault(this.desayunoAtendidos);
        this.desayunoAtendidosBecados = this.getValueDefault(this.desayunoAtendidosBecados);
        this.desayunoAtendidosVentaLibre = this.getValueDefault(this.desayunoAtendidosVentaLibre);
        this.desayunoAtendidosIngresoLibre = this.getValueDefault(this.desayunoAtendidosIngresoLibre);

        this.almuerzoDisponible = this.getValueDefault(this.almuerzoDisponible);
        this.almuerzoDisponibleBecados = this.getValueDefault(this.almuerzoDisponibleBecados);
        this.almuerzoBecados = this.getValueDefault(this.almuerzoBecados);
        this.almuerzoVendidos = this.getValueDefault(this.almuerzoVendidos);
        this.almuerzoVentaLibre = this.getValueDefault(this.almuerzoVentaLibre);
        this.almuerzoIngresoLibre = this.getValueDefault(this.almuerzoIngresoLibre);
        this.almuerzoAtendidos = this.getValueDefault(this.almuerzoAtendidos);
        this.almuerzoAtendidosBecados = this.getValueDefault(this.almuerzoAtendidosBecados);
        this.almuerzoAtendidosVentaLibre = this.getValueDefault(this.almuerzoAtendidosVentaLibre);
        this.almuerzoAtendidosIngresoLibre = this.getValueDefault(this.almuerzoAtendidosIngresoLibre);

        this.cenaDisponible = this.getValueDefault(this.cenaDisponible);
        this.cenaDisponibleBecados = this.getValueDefault(this.cenaDisponibleBecados);
        this.cenaBecados = this.getValueDefault(this.cenaBecados);
        this.cenaVendidos = this.getValueDefault(this.cenaVendidos);
        this.cenaVentaLibre = this.getValueDefault(this.cenaVentaLibre);
        this.cenaIngresoLibre = this.getValueDefault(this.cenaIngresoLibre);
        this.cenaAtendidos = this.getValueDefault(this.cenaAtendidos);
        this.cenaAtendidosBecados = this.getValueDefault(this.cenaAtendidosBecados);
        this.cenaAtendidosVentaLibre = this.getValueDefault(this.cenaAtendidosVentaLibre);
        this.cenaAtendidosIngresoLibre = this.getValueDefault(this.cenaAtendidosIngresoLibre);
    }

    private Long getValueDefault(Long value) {
        if (value == null) {
            return 0L;
        }
        return value;
    }

    public ObjectNode toJson() {
        return JaneHelper.from(this).json();
    }

    @Override
    public String toString() {
        return this.toJson().toString();
    }
}
