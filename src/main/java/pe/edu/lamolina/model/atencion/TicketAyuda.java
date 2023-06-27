package pe.edu.lamolina.model.atencion;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoTicketAyudaEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "atc_ticket_ayuda")
public class TicketAyuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_colaborador")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaColaborador;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_respuesta")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_ticket_ayuda")
    private CategoriaTicketAyuda categoriaTicketAyuda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_ayuda_prioridad")
    private TicketAyudaPrioridad ticketAyudaPrioridad;

    @OneToMany(mappedBy = "ticketAyuda", fetch = FetchType.LAZY)
    private List<MensajeTicketAyuda> mensajesTicketAyuda;

    @Transient
    private List<Archivo> archivos;

    public TicketAyuda() {
    }

    public TicketAyuda(Long id) {
        this.id = id;
    }

    public EstadoTicketAyudaEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoTicketAyudaEnum.valueOf(this.estado);
    }

    public String getFechaRegistroStr() {
        if (this.fechaRegistro == null) {
            return null;
        }
        return TypesUtil.getStringDateLongFormat(this.fechaRegistro);
    }

    public String getFechaAtencionStr() {
        if (this.fechaRespuesta == null) {
            return null;
        }
        return TypesUtil.getStringDateLongFormat(this.fechaRespuesta);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoTicketAyudaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaColaborador() {
        return fechaColaborador;
    }

    public void setFechaColaborador(Date fechaColaborador) {
        this.fechaColaborador = fechaColaborador;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public CategoriaTicketAyuda getCategoriaTicketAyuda() {
        return categoriaTicketAyuda;
    }

    public void setCategoriaTicketAyuda(CategoriaTicketAyuda categoriaTicketAyuda) {
        this.categoriaTicketAyuda = categoriaTicketAyuda;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public TicketAyudaPrioridad getTicketAyudaPrioridad() {
        return ticketAyudaPrioridad;
    }

    public void setTicketAyudaPrioridad(TicketAyudaPrioridad ticketAyudaPrioridad) {
        this.ticketAyudaPrioridad = ticketAyudaPrioridad;
    }

    public List<MensajeTicketAyuda> getMensajesTicketAyuda() {
        return mensajesTicketAyuda;
    }

    public void setMensajesTicketAyuda(List<MensajeTicketAyuda> mensajesTicketAyuda) {
        this.mensajesTicketAyuda = mensajesTicketAyuda;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

}
