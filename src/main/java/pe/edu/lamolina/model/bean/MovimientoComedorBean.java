package pe.edu.lamolina.model.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.comedor.AlumnoAbono;
import pe.edu.lamolina.model.comedor.AlumnoComedor;
import pe.edu.lamolina.model.comedor.ComensalGenerico;
import pe.edu.lamolina.model.comedor.TicketComedor;
import pe.edu.lamolina.model.comedor.TipoServicioComedor;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
public class MovimientoComedorBean {

    private Alumno alumno;
    private ComensalGenerico comensal;
    private AlumnoComedor alumnoComedor;
    private TicketComedor ticketComedor;
    private TipoServicioComedor servicioComedor;
    private AlumnoAbono alumnoAbono;
    private BigDecimal monto;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date fecha;

    public MovimientoComedorBean() {
    }

    @Override
    public String toString() {
        return JaneHelper.from(this)
                .only("fecha,monto")
                .join("alumnoComedor", "id")
                .join("alumnoComedor.alumno", "id")
                .join("alumnoComedor.comensalGenerico", "id")
                .join("alumno", "id")
                .join("comensal", "id")
                .join("ticketComedor", "id")
                .join("servicioComedor", "id")
                .join("alumnoAbono", "id")
                .json().toString();
    }

}
