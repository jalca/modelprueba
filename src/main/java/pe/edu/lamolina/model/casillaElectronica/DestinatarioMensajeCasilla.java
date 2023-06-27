package pe.edu.lamolina.model.casillaElectronica;

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
import org.joda.time.DateTime;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "ce_destinatario_mensaje", catalog = GlobalConstantine.SCHEMA_CASILLA)
public class DestinatarioMensajeCasilla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "leido")
    private Long leido;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mensaje")
    private MensajeCasilla mensajeCasilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_destinatario")
    private UsuarioCasilla destinatario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @Column(name = "fecha_leido")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaLeido;

    public DestinatarioMensajeCasilla() {
    }

}
