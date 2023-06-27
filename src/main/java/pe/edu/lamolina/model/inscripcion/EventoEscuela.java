package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EventoEscuelaEnum;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "epg_evento_escuela")
public class EventoEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "veces")
    private Integer veces;

    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
    private List<EventoCiclo> eventoCiclo;

    public EventoEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EventoEscuelaEnum getCodigoEnum() {
        if (this.codigo == null) {
            return null;
        }
        return EventoEscuelaEnum.valueOf(this.codigo);
    }

}
