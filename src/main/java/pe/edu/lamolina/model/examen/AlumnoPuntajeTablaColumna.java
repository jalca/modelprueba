package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_alumno_puntaje_tabla_columna")
public class AlumnoPuntajeTablaColumna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resumen_alumno")
    private ResumenAlumnoTablaColumna resumenAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_puntaje_tabla_columna")
    private PuntajeEncuestaTablaColumna puntajeTablaColumna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public AlumnoPuntajeTablaColumna(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "puntaje", puntaje, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "resumenAlumno", resumenAlumno, "id");
        ModelUtils.getDataByAttrObject(join, "puntajeTablaColumna", puntajeTablaColumna, "id");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
