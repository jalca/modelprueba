package pe.edu.lamolina.model.horario;

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

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hor_tipo_hora")
public class TipoHora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @Column(name = "hora_inicio")
    private Integer horaInicio;

    @Column(name = "minutos_inicio")
    private Integer minutosInicio;

    @Column(name = "turnos")
    private Integer turnos;

    @OneToMany(mappedBy = "tipoHora", fetch = FetchType.LAZY)
    private List<Hora> hora;

    public TipoHora(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
