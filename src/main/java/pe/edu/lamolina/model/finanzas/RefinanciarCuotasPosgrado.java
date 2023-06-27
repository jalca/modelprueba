package pe.edu.lamolina.model.finanzas;

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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.posgrado.AlumnoTarifa;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "fin_refinanciar_cuotas_posgrado")
public class RefinanciarCuotasPosgrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe_total_capital")
    private BigDecimal importeTotalCapital;

    @Column(name = "importe_total_mora")
    private BigDecimal importeTotalMora;

    @Column(name = "importe_descuento_mora")
    private BigDecimal importeDescuentoMora;

    @Column(name = "importe_final")
    private BigDecimal importeFinal;

    @Column(name = "cuotas_nuevas")
    private Integer cuotasNuevas;

    @Column(name = "numero_cuota_inicio")
    private Integer numeroCuotaInicio;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_corte")
    private Date fechaCorte;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_tarifa")
    private AlumnoTarifa alumnoTarifa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public RefinanciarCuotasPosgrado() {
    }

    public RefinanciarCuotasPosgrado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
