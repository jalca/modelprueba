package pe.edu.lamolina.model.atencion;

public class TicketAtencionResumen {

    private Long activo;
    private Long respondido;
    private Long cerrado;

    public TicketAtencionResumen(Long activo, Long respondido, Long cerrado) {
        this.activo = activo;
        this.respondido = respondido;
        this.cerrado = cerrado;
    }
    
    public Long getActivo() {
        return activo;
    }

    public void setActivo(Long activo) {
        this.activo = activo;
    }

    public Long getRespondido() {
        return respondido;
    }

    public void setRespondido(Long respondido) {
        this.respondido = respondido;
    }

    public Long getCerrado() {
        return cerrado;
    }

    public void setCerrado(Long cerrado) {
        this.cerrado = cerrado;
    }

}
