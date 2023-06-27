package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoGestionEnum;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "gen_universidad")
public class Universidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "siglas")
    private String siglas;

    @Column(name = "gestion")
    private String gestion;

    @Column(name = "ruta_icono")
    private String rutaIcono;

    @Column(name = "logo")
    private String logo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "fecha_validacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion")
    private Usuario userValidacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "universidadProcedencia", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @Transient
    private String logoImagen;

    public Universidad() {
    }

    public Universidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoGestionEnum getTipoGestion() {
        if (StringUtils.isBlank(gestion)) {
            return TipoGestionEnum.INDEF;
        }
        if (gestion.equals("PUB")) {
            return TipoGestionEnum.PUB;
        } else if (gestion.equals("PRIV")) {
            return TipoGestionEnum.PRIV;
        }
        return TipoGestionEnum.INDEF;
    }

}
