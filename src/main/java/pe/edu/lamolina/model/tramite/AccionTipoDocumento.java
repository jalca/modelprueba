package pe.edu.lamolina.model.tramite;

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
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoOficina;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_accion_tipo_documento")
public class AccionTipoDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "solicita_motivo")
    private Integer solicitaMotivo;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "es_final")
    private Integer esFinal;

    @Column(name = "puede_verse")
    private Integer puedeVerse;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_inicio")
    private EstadoTramite estadoInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_final")
    private EstadoTramite estadoFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_emisora")
    private Oficina oficinaEmisora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_origen")
    private Oficina oficinaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina_origen")
    private TipoOficina tipoOficinaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina_destino")
    private TipoOficina tipoOficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AccionTipoDocumento() {
    }

    public AccionTipoDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
