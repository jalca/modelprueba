package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "med_tipo_apoyo_actividad")
public class TipoApoyoActividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "orden")
    private Integer orden;

    @Transient
    private Boolean estadoAntecedente;

    public Boolean getEstadoAntecedente() {
        if (estadoAntecedente == null) {
            return false;
        }
        return estadoAntecedente;
    }
    
}
