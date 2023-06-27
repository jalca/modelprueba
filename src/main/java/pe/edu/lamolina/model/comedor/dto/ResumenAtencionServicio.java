package pe.edu.lamolina.model.comedor.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.comedor.ConfiguracionComedor;
import pe.edu.lamolina.model.comedor.ResumenServicioComedor;
import pe.edu.lamolina.model.comedor.TipoServicioComedor;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
public class ResumenAtencionServicio {

    private Long raciones;
    private Long disponibles;
    private Long disponiblesBecados;

    private Long vendidas;
    private Long becados;
    private Long ventaLibre;
    private Long reservadosAccesoLibre;

    private Long consumidos;
    private Long consumidosBecados;
    private Long consumidosVentaLibre;
    private Long consumidosAccesoLibre;

    private Long presentes;
    private Long salientes;
    private Long cantidad;

    private Long idServicio;
    private String fechaString;
    private String servicio;
    private String codigo;
    private String horaInicio;
    private String horaFin;
    private String horaInicioPublico;
    private String horaFinPublico;
    private String siguienteAlerta;
    private Boolean reloadData;

    private String uuid;

    private Boolean cambiarLetra;
    private Integer sizeLetraServicio;
    private Integer sizeLetraHora;
    private Integer sizeLetraCantidad;
    private Integer sizeLetraTipoComensal;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date fecha;

    public ResumenAtencionServicio(
            Long idServicio, Long raciones,
            Long disponibles, Long disponiblesBecados,
            Long becados, Long vendidas, Long pasesLibres, Long ventasLibres,
            Long consumidos, Long consumidosBecados, Long consumosPasesLibre, Long consumosVentaLibre,
            Long presentes, Long salientes) {

        this.loadData();

        this.idServicio = idServicio;
        this.raciones = getValueDefault(raciones);
        this.disponibles = getValueDefault(disponibles);
        this.disponiblesBecados = getValueDefault(disponiblesBecados);
        this.becados = getValueDefault(becados);
        this.vendidas = getValueDefault(vendidas);
        this.reservadosAccesoLibre = getValueDefault(pasesLibres);
        this.ventaLibre = getValueDefault(ventasLibres);
        this.consumidos = getValueDefault(consumidos);
        this.consumidosBecados = getValueDefault(consumidosBecados);
        this.consumidosAccesoLibre = getValueDefault(consumosPasesLibre);
        this.consumidosVentaLibre = getValueDefault(consumosVentaLibre);
        this.presentes = getValueDefault(presentes);
        this.salientes = getValueDefault(salientes);
    }

    public ResumenAtencionServicio() {
        this.loadData();
    }

    public ResumenAtencionServicio(TipoServicioComedor servicio, Date fecha) {
        this.loadData();

        this.fecha = fecha;
        this.fechaString = new LocalDate(fecha).toString("dd/MM/yyyy");

        this.codigo = servicio.getCodigo();
        this.servicio = servicio.getNombre();
        this.idServicio = servicio.getId();
        this.horaInicio = servicio.getHoraInicioAtencion();
        this.horaFin = servicio.getHoraFinAtencion();
        this.horaInicioPublico = servicio.getHoraInicioPublico();
        this.horaFinPublico = servicio.getHoraFinPublico();
    }

    public ResumenAtencionServicio(ResumenServicioComedor resumen, String uuid) {
        this.raciones = getValueDefault(resumen.getRaciones());
        this.disponibles = getValueDefault(resumen.getDisponibles());
        this.disponiblesBecados = getValueDefault(resumen.getDisponiblesBecados());

        this.becados = getValueDefault(resumen.getBecados());
        this.vendidas = getValueDefault(resumen.getVendidas());
        this.ventaLibre = getValueDefault(resumen.getVentaLibre());
        this.reservadosAccesoLibre = getValueDefault(resumen.getReservadosAccesoLibre());

        this.consumidos = getValueDefault(resumen.getConsumidos());
        this.consumidosBecados = getValueDefault(resumen.getConsumidosBecados());
        this.consumidosVentaLibre = getValueDefault(resumen.getConsumidosVentaLibre());
        this.consumidosAccesoLibre = getValueDefault(resumen.getConsumidosAccesoLibre());

        this.presentes = getValueDefault(resumen.getPresentes());
        this.salientes = getValueDefault(resumen.getSalientes());

        this.fecha = resumen.getFecha();
        this.fechaString = new LocalDate(resumen.getFecha()).toString("dd/MM/yyyy");
        this.siguienteAlerta = resumen.getSiguienteAlerta();

        TipoServicioComedor servicio = resumen.getTipoServicioComedor();
        this.codigo = servicio.getCodigo();
        this.servicio = servicio.getNombre();
        this.idServicio = servicio.getId();
        this.horaInicio = servicio.getHoraInicioAtencion();
        this.horaFin = servicio.getHoraFinAtencion();
        this.horaInicioPublico = servicio.getHoraInicioPublico();
        this.horaFinPublico = servicio.getHoraFinPublico();

        this.uuid = uuid;
        this.cambiarLetra = false;
        this.reloadData = false;
    }

    public void setSizeLetras(ConfiguracionComedor config) {
        this.sizeLetraServicio = config.getSizeLetraServicio();
        this.sizeLetraHora = config.getSizeLetraHora();
        this.sizeLetraCantidad = config.getSizeLetraCantidad();
        this.sizeLetraTipoComensal = config.getSizeLetraTipoComensal();
        this.cambiarLetra = true;
    }

    private void loadData() {
        this.raciones = 0L;
        this.disponibles = 0L;
        this.disponiblesBecados = 0L;

        this.becados = 0L;
        this.vendidas = 0L;
        this.ventaLibre = 0L;
        this.reservadosAccesoLibre = 0L;

        this.consumidos = 0L;
        this.consumidosBecados = 0L;
        this.consumidosVentaLibre = 0L;
        this.consumidosAccesoLibre = 0L;

        this.presentes = 0L;
        this.salientes = 0L;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
        if (fecha != null) {
            this.fechaString = new DateTime(this.fecha).toString("dd/MM/yyyy");
        }
    }

    public void setServicioComedor(TipoServicioComedor servicio, Date fecha) {
        this.fecha = fecha;
        this.fechaString = new LocalDate(fecha).toString("dd/MM/yyyy");

        this.codigo = servicio.getCodigo();
        this.servicio = servicio.getNombre();
        this.idServicio = servicio.getId();
        this.horaInicio = servicio.getHoraInicioAtencion();
        this.horaFin = servicio.getHoraFinAtencion();
        this.horaInicioPublico = servicio.getHoraInicioPublico();
        this.horaFinPublico = servicio.getHoraFinPublico();
    }

    private Long getValueDefault(Long value) {
        if (value == null) {
            return 0L;
        }
        return value;
    }

    private Long getValueDefault(Integer value) {
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public ObjectNode toJson() {
        return JaneHelper.from(this).json();
    }

}
