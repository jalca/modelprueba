package pe.edu.lamolina.model.tramite;

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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.FichaSocioeconomica;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tram_tramite_subvencion")
public class TramiteSubvencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "gozado")
    private Boolean gozado;

    @Column(name = "horas")
    private Integer horas;

    @Column(name = "lugar_labores")
    private String lugarLabores;

    @Column(name = "vobo_supervisor")
    private Boolean voboSupervisor;

    @Column(name = "labor_realizar")
    private String laborRealizar;
    
    @Column(name = "datos_adicionales")
    private String datosAdicionales;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_hora_entrevista")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHoraEntrevista;

    @Column(name = "fecha_vobo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caso_social")
    private CasoSocial casoSocial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private Colaborador supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ficha_socioeconomica")
    private FichaSocioeconomica fichaSocioeconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private String comentario;

    @Transient
    private String respuesta;

    public TramiteSubvencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "motivo", motivo, false);
        ModelUtils.getDataByAttr(join, "gozado", gozado, false);
        ModelUtils.getDataByAttr(join, "horas", horas, false);
        ModelUtils.getDataByAttr(join, "lugarLabores", lugarLabores, false);
        ModelUtils.getDataByAttr(join, "voboSupervisor", voboSupervisor, false);
        ModelUtils.getDataByAttr(join, "laborRealizar", laborRealizar, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaHoraEntrevista", fechaHoraEntrevista, false);
        ModelUtils.getDataByAttr(join, "fechaVoBo", fechaVoBo, false);
        ModelUtils.getDataByAttrObject(join, "casoSocial", casoSocial, "id");
        ModelUtils.getDataByAttrObject(join, "tramite", tramite, "id", "serie", "numero", "estado");
        ModelUtils.getDataByAttrObject(join, "supervisor", supervisor, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "tipoSubvencion", tipoSubvencion, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "fichaSocioeconomica", fichaSocioeconomica, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "personaCuentaBancaria", personaCuentaBancaria, "id", "estado", "numeroCuenta");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
