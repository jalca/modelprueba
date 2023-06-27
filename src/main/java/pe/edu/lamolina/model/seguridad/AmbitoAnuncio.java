package pe.edu.lamolina.model.seguridad;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.dashboard.AmbitoAnuncioEnum;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "seg_ambito_anuncio")
public class AmbitoAnuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ambito")
    private String ambito;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anuncio_dashboard")
    private AnuncioDashboard anuncioDashboard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AmbitoAnuncio() {
    }

    public AmbitoAnuncio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AmbitoAnuncioEnum getAmbitoEnum() {
        if (ambito == null) {
            return null;
        }
        return AmbitoAnuncioEnum.valueOf(ambito);
    }

    @JsonIgnore
    public void setAmbitoEnum(AmbitoAnuncioEnum ambito) {
        if (ambito == null) {
            return;
        }
        this.ambito = ambito.name();
    }

}
