package pe.edu.lamolina.model.contabilidad;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "cont_item_orden_subvencion")
public class ItemOrdenSubvencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_subvencion_economia")
    private OrdenSubvencionEconomia ordenSubvencionEconomia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public ItemOrdenSubvencion() {
    }

    public ItemOrdenSubvencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
