package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "med_ingreso_atencion_externa")
public class IngresoAtencionExterna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_atencion")
    private HistoriaAtencion historiaAtencion;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atencion_externa")
    private AtencionExterna atencionExterna;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoriaAtencion getHistoriaAtencion() {
        return historiaAtencion;
    }

    public void setHistoriaAtencion(HistoriaAtencion historiaAtencion) {
        this.historiaAtencion = historiaAtencion;
    }

    public AtencionExterna getAtencionExterna() {
        return atencionExterna;
    }

    public void setAtencionExterna(AtencionExterna atencionExterna) {
        this.atencionExterna = atencionExterna;
    }
    
    
    
}
