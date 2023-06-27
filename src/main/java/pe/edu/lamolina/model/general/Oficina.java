package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.oficina.OficinaEnum;
import pe.edu.lamolina.model.enums.oficina.OficinaEstadoEnum;
import pe.edu.lamolina.model.enums.oficina.TipoRegistroOficinaEnum;
import pe.edu.lamolina.model.seguridad.UsuarioRol;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "gen_oficina")
public class Oficina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_documento")
    private String codigoDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "instancia_oficina")
    private Long instanciaOficina;

    @Column(name = "motivo_ausencia_jefe")
    private String motivoAusenciaJefe;

    @Column(name = "email")
    private String email;

    @Column(name = "telefonos")
    private String telefonos;

    @Column(name = "anexos")
    private String anexos;

    @Column(name = "referencia_ubicacion")
    private String referenciaUbicacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "tipo_registro")
    private String tipoRegistro;

    @Column(name = "empleado_encargado")
    private Boolean empleadoEncargado;

    @Column(name = "fecha_inicio_jefatura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicioJefatura;

    @Column(name = "fecha_encargatura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEncargatura;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_superior")
    private Oficina oficinaSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_principal")
    private Oficina oficinaPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_jefe")
    private Persona personaJefe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jefe_encargado")
    private Persona jefeEncargado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo_jefe")
    private PerfilCompania cargoJefe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina")
    private TipoOficina tipoOficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "oficinaSupervisora", fetch = FetchType.LAZY)
    private List<Aula> aula;

    @OneToMany(mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<Colaborador> colaborador;

    @OneToMany(mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<CoordinadorAmbientes> coordinadorAmbientes;

    @OneToMany(mappedBy = "oficinaSuperior", fetch = FetchType.LAZY)
    private List<Oficina> oficinasDependientes;

    @OneToMany(mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<UsuarioRol> usuarioRol;

    @OneToMany(mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<InstanciaEntidad> instanciaEntidades;

    @OneToMany(mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<AusenciaJefe> ausenciasJefe;

    @Transient
    private String instanciaOficinaNombre;
    @Transient
    private String instanciaOficinaCodigo;
    @Transient
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFinJefatura;
    @Transient
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFinEncargatura;

    @Transient
    private Integer colaboradores;
    @Transient
    private Integer divisiones;

    public Oficina() {
        this.tipoRegistro = TipoRegistroOficinaEnum.OFICIAL.name();
    }

    public Oficina(OficinaEnum oficinaEnum) {
        this.id = oficinaEnum.getId();
        this.codigo = oficinaEnum.name();
        this.nombre = oficinaEnum.getValue();
    }

    public Oficina(Object id) {
        this.id = TypesUtil.getLong(id);
        this.tipoRegistro = TipoRegistroOficinaEnum.OFICIAL.name();
    }

    public OficinaEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        try {
            return OficinaEnum.valueOf(codigo);
        } catch (Exception e) {
            return null;
        }

    }

    public OficinaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return OficinaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(OficinaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoRegistroOficinaEnum getTipoRegistroEnum() {
        if (tipoRegistro == null) {
            return null;
        }
        return TipoRegistroOficinaEnum.valueOf(tipoRegistro);
    }

    @JsonIgnore
    public void setTipoRegistroEnum(TipoRegistroOficinaEnum tipoRegistro) {
        if (tipoRegistro == null) {
            return;
        }
        this.tipoRegistro = tipoRegistro.name();
    }

    public boolean isOficinaOera() {
        if (codigo == null) {
            return false;
        }
        return OficinaEnum.OERA.name().equals(this.codigo);
    }

    public boolean isOficinaCAP() {
        if (this.codigo == null) {
            return false;
        }
        return OficinaEnum.CAP.equals(this.getCodigoEnum());
    }

    public boolean isOficinaOBUAE() {
        if (this.codigo == null) {
            return false;
        }
        return OficinaEnum.OBUAE.equals(this.getCodigoEnum());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oficina other = (Oficina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "codigoDocumento", codigoDocumento, false);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "instanciaOficina", instanciaOficina, false);
        ModelUtils.getDataByAttr(join, "motivoAusenciaJefe", motivoAusenciaJefe, false);
        ModelUtils.getDataByAttr(join, "email", email, false);
        ModelUtils.getDataByAttr(join, "telefonos", telefonos, false);
        ModelUtils.getDataByAttr(join, "anexos", anexos, false);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "webSite", webSite, false);
        ModelUtils.getDataByAttr(join, "tipoRegistro", tipoRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaInicioJefatura", fechaInicioJefatura, false);
        ModelUtils.getDataByAttr(join, "fechaEncargatura", fechaEncargatura, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "compania", compania, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "oficinaSuperior", oficinaSuperior, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "oficinaPrincipal", oficinaPrincipal, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "personaJefe", personaJefe, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "jefeEncargado", jefeEncargado, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "cargoJefe", cargoJefe, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "tipoOficina", tipoOficina, "id", "nivel", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
