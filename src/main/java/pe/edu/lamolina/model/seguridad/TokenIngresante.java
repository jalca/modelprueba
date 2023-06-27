package pe.edu.lamolina.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.OrigenTokenEnum;
import pe.edu.lamolina.model.enums.TokenEstadoEnum;
import pe.edu.lamolina.model.general.Persona;

@Getter
@Setter
@Entity
@Table(name = "seg_token_ingresante")
public class TokenIngresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor")
    private String valor;

    @Column(name = "estado")
    private String estado;

    @Column(name = "origen")
    private String origen;

    @Column(name = "fecha_uso")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaUso;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVencimiento;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_registro")
    private Usuario userRegistro;

    public TokenIngresante() {
    }

    public TokenIngresante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TokenEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return TokenEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TokenEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public OrigenTokenEnum getOrigenEnum() {
        if (origen == null) {
            return null;
        }
        return OrigenTokenEnum.valueOf(origen);
    }

    @JsonIgnore
    public void setOrigenEnum(OrigenTokenEnum origen) {
        if (origen == null) {
            return;
        }
        this.origen = origen.name();
    }

}
