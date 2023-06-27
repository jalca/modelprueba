package pe.edu.lamolina.model.cifras;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Data
@Table(name = "cifra_alumnos_matriculados", catalog = GlobalConstantine.SCHEMA_CIFRAS)
public class AlumnoMatriculado implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "codigo_programa")
    private String codigoPrograma;

    @NotNull
    @Column(name = "modalidad")
    private String modalidad;

    @NotNull
    @Column(name = "periodo_academico")
    private String periodoAcademico;

    @Column(name = "total")
    private Long total;

    public AlumnoMatriculado() {
    }

    public AlumnoMatriculado(Long id) {
        this.id = id;
    }

}
