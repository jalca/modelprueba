package pe.edu.lamolina.model.atencion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoTrasladoTicketEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "atc_traslado_atecion_ticket")
public class TrasladoAtencionTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_traslado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaTraslado;

    @Column(name = "fecha_recepcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRecepcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_origen")
    private Oficina oficinaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_origen")
    private Colaborador colaboradorOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_destino")
    private Colaborador colaboradorDestino;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_ayuda")
    private TicketAyuda ticketAyuda;
    
    public TrasladoAtencionTicket() {
    }

    public TrasladoAtencionTicket(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaTraslado() {
        return fechaTraslado;
    }

    public void setFechaTraslado(Date fechaTraslado) {
        this.fechaTraslado = fechaTraslado;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Oficina getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(Oficina oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public Oficina getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(Oficina oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public Colaborador getColaboradorOrigen() {
        return colaboradorOrigen;
    }

    public void setColaboradorOrigen(Colaborador colaboradorOrigen) {
        this.colaboradorOrigen = colaboradorOrigen;
    }

    public Colaborador getColaboradorDestino() {
        return colaboradorDestino;
    }

    public void setColaboradorDestino(Colaborador colaboradorDestino) {
        this.colaboradorDestino = colaboradorDestino;
    }

    public TicketAyuda getTicketAyuda() {
        return ticketAyuda;
    }

    public void setTicketAyuda(TicketAyuda ticketAyuda) {
        this.ticketAyuda = ticketAyuda;
    }
    
    public TipoTrasladoTicketEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoTrasladoTicketEnum.valueOf(this.tipo);
    }
    
    @JsonIgnore
    public void setTipoEnum(TipoTrasladoTicketEnum tipoEnum) {
        if (tipoEnum == null) {
            return;
        }
        this.tipo = tipoEnum.name();
    }
   
}
