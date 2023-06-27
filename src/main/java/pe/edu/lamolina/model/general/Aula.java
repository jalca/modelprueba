package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.almacen.ResumenInventario;
import pe.edu.lamolina.model.horario.HorarioReservaAula;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TipoAmbienteEnum;
import pe.edu.lamolina.model.horario.HorarioAula;
import pe.edu.lamolina.model.inscripcion.AulaExamen;
import pe.edu.lamolina.model.inscripcion.PabellonExamen;
import pe.edu.lamolina.model.rolexamen.CursoMasivoExamen;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "gen_aula")
public class Aula implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "aforo")
    private Integer aforo;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "aforo_examen")
    private Integer aforoExamen;

    @Column(name = "capacidad_aula")
    private Integer capacidadAula;

    @Column(name = "capacidad_extra")
    private Integer capacidadExtra;

    @Column(name = "permite_cruce")
    private Integer permiteCruce;

    @Column(name = "tipo_ambiente")
    private String tipoAmbiente;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "pisos")
    private Integer pisos;

    @Column(name = "subdivisiones")
    private Integer subdivisiones;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "usuario_zoom")
    private String usuarioZoom;

    @Column(name = "pass_zoom")
    private String passZoom;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAnulacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula_superior")
    private Aula aulaSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede")
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_aula")
    private TipoAula tipoAula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_supervisora")
    private Oficina oficinaSupervisora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta")
    private TipoCarpeta tipoCarpeta;

    @OneToMany(mappedBy = "aulaSuperior", fetch = FetchType.LAZY)
    private List<Aula> aulasContenido;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY)
    private List<Seccion> seccion;

    @OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
    private List<PabellonExamen> pabellonesExamen;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY)
    private List<HorarioAula> horariosAula;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY)
    private List<HorarioReservaAula> horarioReservaAula;

    @Transient
    private AulaExamen aulaExamen;
    @Transient
    private Integer postulantes;
    @Transient
    private Boolean disponible;
    @Transient
    private List<ResumenInventario> inventario;

    @Transient
    private CursoMasivoExamen cursoMasivo;
    @Transient
    private Boolean tieneCruces;
    @Transient
    private List<String> observaciones;

    @Transient
    private Date fechaInicio;
    @Transient
    private Date fechaFin;

    public Aula() {
        postulantes = 0;
    }

    public Aula(Long id, Integer aforo, Integer prioridad, Integer aforoExamen, Integer capacidadAula, Integer capacidadExtra, Integer permiteCruce, String tipoAmbiente, Integer piso, Integer pisos, Sede sede, TipoAula tipoAula, Oficina oficinaSupervisora, TipoCarpeta tipoCarpeta) {
        this.id = id;
        this.aforo = aforo;
        this.prioridad = prioridad;
        this.aforoExamen = aforoExamen;
        this.capacidadAula = capacidadAula;
        this.capacidadExtra = capacidadExtra;
        this.permiteCruce = permiteCruce;
        this.tipoAmbiente = tipoAmbiente;
        this.piso = piso;
        this.pisos = pisos;
        this.sede = sede;
        this.tipoAula = tipoAula;
        this.oficinaSupervisora = oficinaSupervisora;
        this.tipoCarpeta = tipoCarpeta;
    }

    public Aula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getNombrePublico() {
        if (!StringUtils.isEmpty(nombre)) {
            return nombre;
        }
        return codigo;
    }

    public Integer getCapacidadTotal() {
        int capacidadExtra = TypesUtil.getInt(this.capacidadExtra, 0);
        int capacidadAula = TypesUtil.getInt(this.capacidadAula, 0);
        return capacidadAula + capacidadExtra;
    }

    public Integer getPermiteCruce() {
        if (permiteCruce == null) {
            return 0;
        }
        return permiteCruce;
    }

    public boolean getPermiteCruceBoolean() {
        if (this.permiteCruce == null) {
            return false;
        }
        return this.permiteCruce == BigInteger.ONE.intValue();
    }

    public TipoAmbienteEnum getTipoAmbienteEnum() {
        if (tipoAmbiente == null) {
            return null;
        }
        return TipoAmbienteEnum.valueOf(tipoAmbiente);
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public String getColorModulo() {
        if (this.nombre == null) {
            return null;
        }

        if (this.nombre.startsWith("Módulo") || this.nombre.startsWith("Modulo")) {
            String color = this.nombre;
            color = color.replaceAll("Módulo", "");
            color = color.replaceAll("Modulo", "").trim();
            return color;
        }

        return null;
    }

    public ObjectNode toJson() {
        JsonNodeFactory jc = JsonNodeFactory.instance;
        ObjectNode node = JsonHelper.createJson(this, jc);
        node.put("tipoAmbienteValue", StringUtils.isBlank(this.tipoAmbiente) ? null : this.getTipoAmbienteEnum().getValue());

        node.putPOJO("aulaSuperior", this.aulaSuperior == null ? null : this.aulaSuperior.toJson());
        node.putPOJO("tipoAula", this.tipoAula == null ? null : this.tipoAula.toJson());
        return node;
    }

    public List<String> getDiaHoraList() {
        if (this.horariosAula == null || this.horariosAula.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = this.getHorariosAula()
                .stream().map(x -> x.getDia().getNumeroDia() + "-" + x.getHora().getNumero()).collect(Collectors.toList());
        return result;
    }

    public String getDescripcionConcat() {
        String descrip = this.codigo;
        if (StringUtils.isNotBlank(this.nombre)) {
            descrip += " " + this.nombre;
        }
        return descrip;
    }

    @Override
    public Aula clone() {
        Aula clone = null;
        try {
            clone = (Aula) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    public Boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
