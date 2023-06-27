package pe.edu.lamolina.model.seguridad;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seg_tabla_cambios")
public class TablaCambios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tabla")
    private String tabla;

    @Column(name = "columna")
    private String columna;

    @Column(name = "id_registro")
    private Long idRegistro;

    @Column(name = "valor_antes")
    private String valorAntes;

    @Column(name = "valor_ahora")
    private String valorAhora;

    @Column(name = "user_basedatos")
    private String userBasedatos;

    @Column(name = "fecha_antes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAntes;

    @Column(name = "fecha_ahora")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAhora;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public TablaCambios(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tabla", tabla, false);
        ModelUtils.getDataByAttr(join, "columna", columna, false);
        ModelUtils.getDataByAttr(join, "idRegistro", idRegistro, false);
        ModelUtils.getDataByAttr(join, "valorAntes", valorAntes, false);
        ModelUtils.getDataByAttr(join, "valorAhora", valorAhora, false);
        ModelUtils.getDataByAttr(join, "userBasedatos", userBasedatos, false);
        ModelUtils.getDataByAttr(join, "fechaAntes", fechaAntes, false);
        ModelUtils.getDataByAttr(join, "fechaAhora", fechaAhora, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
