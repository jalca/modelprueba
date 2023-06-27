package pe.edu.lamolina.model.bean;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@NoArgsConstructor
public class EventoFullCalendar {

    private Long id;
    private String title;
    private String start;
    private String end;
    private String backgroundColor;
    private String borderColor;
    private String textColor;
    private Boolean disponible;
    private Boolean vencida;
    private List<EventoFecha> eventoFecha;
    private List<EventoHora> eventoHora;

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public EventoFullCalendar(String title) {
        this.title = title;

        this.backgroundColor = "#ddd";
        this.borderColor = "#ddd";
        this.textColor = "black";
    }

    public void setStart(Date fecha, String hora) {

        DateTime fechaDT = new DateTime(fecha);
        this.start = String.format("%sT%s", fechaDT.toString(DATE_FORMAT), hora);

    }

    public void setEnd(Date fecha, String hora) {

        DateTime fechaDT = new DateTime(fecha);
        this.end = String.format("%sT%s", fechaDT.toString(DATE_FORMAT), hora);
    }

}
