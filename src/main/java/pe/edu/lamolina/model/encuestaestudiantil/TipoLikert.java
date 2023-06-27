package pe.edu.lamolina.model.encuestaestudiantil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.encuesta.TipoPreguntaLikertEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_tipo_likert")
public class TipoLikert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "opciones")
    private Integer opciones;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<OpcionLikert> opcionesLikerts;

    public TipoLikert(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getNombre() {
        return this.grupo + " [" + this.opciones + "] - " + this.tipo;
    }

    public TipoPreguntaLikertEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoPreguntaLikertEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoPreguntaLikertEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

}
