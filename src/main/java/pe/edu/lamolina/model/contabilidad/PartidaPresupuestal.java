package pe.edu.lamolina.model.contabilidad;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.bienestar.TipoEventoAgrupacion;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "cont_partida_presupuestal")
public class PartidaPresupuestal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo2")
    private String codigo2;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_nombre")
    private String tipoNombre;

    @Column(name = "importe_inicial")
    private BigDecimal importeInicial;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @Column(name = "importe_presupuestado")
    private BigDecimal importePresupuestado;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento_agrupacion")
    private TipoEventoAgrupacion tipoEventoAgrupacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida_superior")
    private PartidaPresupuestal partidaSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private Integer nivel;

    @Transient
    private String motivo;

    @Transient
    private BigDecimal importeConsumir;

    @Transient
    private List<PartidaPresupuestal> partidaHijas;

    public PartidaPresupuestal() {
    }

    public PartidaPresupuestal(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean haySaldoDisponible() {
        if (this.saldo == null) {
            return false;
        }
        return saldo.compareTo(BigDecimal.ZERO) > 0;
    }

    public String getDescripcion() {
        if (this.oficina != null) {
            return "Oficina: " + oficina.getNombre();
        }
        if (this.tipoSubvencion != null) {
            return "Subvención: " + tipoSubvencion.getNombre();
        }
        if (this.tipoEventoAgrupacion != null) {
            return "Tipo Evento: " + tipoEventoAgrupacion.getNombre();
        }
        return this.tipoNombre + ": " + this.nombre;
    }

    public BigDecimal getTotalUtilizado() {
        return importeUtilizado.add(importePresupuestado);
    }

}
