package pe.edu.lamolina.model.consejeria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Data
@Table(name = "aca_consejeria_historial")
public class ConsejeriaHistorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_actualizacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "fecha_creacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;
    
    public static enum ConsejeriaHistorialEstado { ACTIVO, ELIMINADO }

    public ConsejeriaHistorial() {
    }

    public ConsejeriaHistorial(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public void setEstadoEnum(ConsejeriaHistorialEstado estado) {
        if(estado==null){
            return;
        }
        this.estado = estado.name();
    }
    
}
