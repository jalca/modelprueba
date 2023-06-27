package pe.edu.lamolina.model.cifras;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Data
@Table(name = "cifra_programas_estudio", catalog = GlobalConstantine.SCHEMA_CIFRAS)
public class ProgramaEstudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "modalidad")
    private String modalidad;

    public ProgramaEstudio() {
    }

    public ProgramaEstudio(Long id) {
        this.id = id;
    }

}
