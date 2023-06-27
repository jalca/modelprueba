package pe.edu.lamolina.model.comedor;

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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_resumen_servicio_comedor")
public class ResumenServicioComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "raciones")
    private Integer raciones;

    @Column(name = "disponibles")
    private Integer disponibles;

    @Column(name = "disponibles_becados")
    private Integer disponiblesBecados;

    @Column(name = "becados")
    private Integer becados;

    @Column(name = "vendidas")
    private Integer vendidas;

    @Column(name = "venta_libre")
    private Integer ventaLibre;

    @Column(name = "reservados_acceso_libre")
    private Integer reservadosAccesoLibre;

    @Column(name = "consumidos")
    private Integer consumidos;

    @Column(name = "consumidos_becados")
    private Integer consumidosBecados;

    @Column(name = "consumidos_venta_libre")
    private Integer consumidosVentaLibre;

    @Column(name = "consumidos_acceso_libre")
    private Integer consumidosAccesoLibre;

    @Column(name = "presentes")
    private Integer presentes;

    @Column(name = "salientes")
    private Integer salientes;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio_comedor")
    private TipoServicioComedor tipoServicioComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private String disponibilidad;
    @Transient
    private String siguienteAlerta;

    public ResumenServicioComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
