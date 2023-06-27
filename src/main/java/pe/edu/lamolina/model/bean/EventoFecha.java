package pe.edu.lamolina.model.bean;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventoFecha {

    private Integer id;
    private String fecha;
    private List<EventoHora> eventoHora;

}
