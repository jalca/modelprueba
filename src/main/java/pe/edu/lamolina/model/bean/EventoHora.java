package pe.edu.lamolina.model.bean;

public class EventoHora {

    int id;
    String hora;
    int eventoFecha;
    boolean $isDisabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEventoFecha() {
        return eventoFecha;
    }

    public void setEventoFecha(int eventoFecha) {
        this.eventoFecha = eventoFecha;
    }

    public boolean is$isDisabled() {
        return $isDisabled;
    }

    public void set$isDisabled(boolean $isDisabled) {
        this.$isDisabled = $isDisabled;
    }

}
