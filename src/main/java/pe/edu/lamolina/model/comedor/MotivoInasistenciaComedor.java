package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EstadoMotivoInasistenciaEnum;
import pe.edu.lamolina.model.enums.TipoMotivoInasistenciaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "com_motivo_inasistencia_comedor")
public class MotivoInasistenciaComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_becado_comedor")
    private BecadoComedor becadoComedor;

    public MotivoInasistenciaComedor() {
    }

    public MotivoInasistenciaComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BecadoComedor getBecadoComedor() {
        return becadoComedor;
    }

    public void setBecadoComedor(BecadoComedor becadoComedor) {
        this.becadoComedor = becadoComedor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ObjectNode Json(MotivoInasistenciaComedor comedor) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Alumno alumno = comedor.getBecadoComedor().getAlumno();
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("id", comedor.getId());
        node.put("alumno", alumno.getId());
        node.put("nombre", alumno.getPersona().getNombreCompleto());
        node.put("codigo", alumno.getCodigo());
        node.put("motivo", comedor.getMotivo());
        node.put("fechaInicio", format.format(comedor.getFechaInicio()));
        node.put("fechaFin", format.format(comedor.getFechaFin()));
        node.put("estado", EstadoMotivoInasistenciaEnum.getNombre(comedor.getEstado()));
        node.put("tipo", TipoMotivoInasistenciaEnum.getNombre(comedor.getTipo()));
        node.put("rango", format.format(comedor.getFechaInicio()) + " - " + format.format(comedor.getFechaFin()));

        return node;
    }
}
