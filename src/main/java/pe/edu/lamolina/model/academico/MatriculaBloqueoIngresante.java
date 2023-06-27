package pe.edu.lamolina.model.academico;

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
import lombok.Data;
import pe.edu.lamolina.model.inscripcion.Ingresante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Data
@Entity
@Table(name = "aca_matricula_bloqueo_ingresante")
public class MatriculaBloqueoIngresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingresante")
    private Ingresante ingresante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @Column(name = "rm")
    private BigDecimal rm;

    @Column(name = "rv")
    private BigDecimal rv;

    @Column(name = "matematica")
    private BigDecimal matematica;

    @Column(name = "fisica")
    private BigDecimal fisica;

    @Column(name = "quimica")
    private BigDecimal quimica;

    @Column(name = "biologia")
    private BigDecimal biologia;

    @Column(name = "inscrito")
    private Boolean inscrito;

    @Column(name = "matricula")
    private Boolean matricula;
    
    @Column(name = "nota_rm")
    private BigDecimal notaRm;

    @Column(name = "nota_rv")
    private BigDecimal notaRv;

    @Column(name = "nota_matematica")
    private BigDecimal notaMatematica;

    @Column(name = "nota_fisica")
    private BigDecimal notaFisica;

    @Column(name = "nota_quimica")
    private BigDecimal notaQuimica;

    @Column(name = "nota_biologia")
    private BigDecimal notaBiologia;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuario;
    
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualiza")
    private Date fechaActualiza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_actualiza")
    private Usuario usuarioActualiza;

    public MatriculaBloqueoIngresante() {
    }

    public MatriculaBloqueoIngresante(Long id) {
        this.id = id;
    }

}
