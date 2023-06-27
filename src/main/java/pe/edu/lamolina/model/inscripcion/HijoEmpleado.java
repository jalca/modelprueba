package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CargoTrabajadorEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sip_hijo_empleado")
public class HijoEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cargo_padre")
    private String cargoPadre;

    @Column(name = "cantidad_descuentos")
    private Integer cantidadDescuentos;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @JoinColumn(name = "id_user_registro", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;

    @JoinColumn(name = "id_persona_hijo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona personaHijo;

    @JoinColumn(name = "id_persona_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Persona personaPadre;

    @OneToMany(mappedBy = "hijoEmpleado", fetch = FetchType.LAZY)
    private List<ResumenDescuentos> resumenDescuentos;

    @OneToMany(mappedBy = "hijoEmpleado", fetch = FetchType.LAZY)
    private List<HijoDescuento> hijosDescuentos;

    public HijoEmpleado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CargoTrabajadorEnum getCargoPadreEnum() {
        if (this.cargoPadre == null) {
            return null;
        }
        return CargoTrabajadorEnum.valueOf(this.cargoPadre);
    }

    public void setCargoPadre(CargoTrabajadorEnum cargoPadre) {
        if (cargoPadre == null) {
            return;
        }
        this.cargoPadre = cargoPadre.name();
    }

}
