package pe.edu.lamolina.model.academico;

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
import javax.persistence.Transient;
import lombok.Data;
import pe.edu.lamolina.model.enums.SilaboCursoEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Data
@Entity
@Table(name = "aca_silabo_curso")
public class SilaboCurso implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_vigencia_inicio")
    private CicloAcademico cicloVigenciaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_vigencia_fin")
    private CicloAcademico cicloVigenciaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento_academico")
    private DepartamentoAcademico departamentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Integer fileUpdated;

    public SilaboCurso() {
    }

    public SilaboCurso(Long id) {
        this.id = id;
    }

    public SilaboCursoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return SilaboCursoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(SilaboCursoEstadoEnum estado) {
        this.estado = estado.name();
    }

}
