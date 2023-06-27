package pe.edu.lamolina.model.comedor;

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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_configuracion_comedor")
public class ConfiguracionComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto_maximo_recarga")
    private BigDecimal montoMaximoRecarga;

    @Column(name = "minutos_anular_recarga")
    private Integer minutosAnularRecarga;

    @Column(name = "alumnos_traslado_saldos")
    private Integer alumnosTrasladoSaldos;

    @Column(name = "importe_traslado_saldos")
    private BigDecimal importeTrasladoSaldos;

    @Column(name = "size_letra_servicio")
    private Integer sizeLetraServicio;

    @Column(name = "size_letra_hora")
    private Integer sizeLetraHora;

    @Column(name = "size_letra_cantidad")
    private Integer sizeLetraCantidad;

    @Column(name = "size_letra_tipo_comensal")
    private Integer sizeLetraTipoComensal;

    @Column(name = "fecha_traslado_saldos")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaTrasladoSaldos;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_traslado_saldos")
    private Usuario userTrasladoSaldos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cambio")
    private Usuario userCambio;

    public ConfiguracionComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "montoMaximoRecarga", montoMaximoRecarga, false);
        ModelUtils.getDataByAttr(join, "minutosAnularRecarga", minutosAnularRecarga, false);
        ModelUtils.getDataByAttr(join, "alumnosTrasladoSaldos", alumnosTrasladoSaldos, false);
        ModelUtils.getDataByAttr(join, "importeTrasladoSaldos", importeTrasladoSaldos, false);
        ModelUtils.getDataByAttr(join, "sizeLetraServicio", sizeLetraServicio, false);
        ModelUtils.getDataByAttr(join, "sizeLetraHora", sizeLetraHora, false);
        ModelUtils.getDataByAttr(join, "sizeLetraCantidad", sizeLetraCantidad, false);
        ModelUtils.getDataByAttr(join, "sizeLetraTipoComensal", sizeLetraTipoComensal, false);
        ModelUtils.getDataByAttr(join, "fechaTrasladoSaldos", fechaTrasladoSaldos, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "userTrasladoSaldos", userTrasladoSaldos, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userCambio", userCambio, "id", "google");

        return join.toString();
    }

}
