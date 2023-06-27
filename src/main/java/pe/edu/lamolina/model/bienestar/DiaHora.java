package pe.edu.lamolina.model.bienestar;

import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.horario.Hora;

public class DiaHora {

    private String id;
    private Dia dia;
    private Hora hora;

    public DiaHora() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

}
