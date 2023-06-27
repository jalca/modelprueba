package pe.edu.lamolina.model.bienestar;


import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "obu_calendario_bienestar_detalle")
public class CalendarioBienestarDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden_atencion")
    private String ordenAtencion;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "hora_inicial")
    private String horaInicial;
    
    @Column(name = "hora_final")
    private String horaFinal;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario")
    private CalendarioBienestar calendarioBienestar;   

    public CalendarioBienestarDetalle() {
    }

    public CalendarioBienestarDetalle(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdenAtencion() {
        return ordenAtencion;
    }

    public void setOrdenAtencion(String ordenAtencion) {
        this.ordenAtencion = ordenAtencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public CalendarioBienestar getCalendarioBienestar() {
        return calendarioBienestar;
    }

    public void setCalendarioBienestar(CalendarioBienestar calendarioBienestar) {
        this.calendarioBienestar = calendarioBienestar;
    }
    
    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        CalendarioBienestar cb = this.calendarioBienestar == null ? new CalendarioBienestar() : this.calendarioBienestar;

        json.set("calendarioBienestar", JsonHelper.createJson(cb, JsonNodeFactory.instance));

        return json;
    }
   
}

