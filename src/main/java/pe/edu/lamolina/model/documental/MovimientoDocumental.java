package pe.edu.lamolina.model.documental;

import java.util.Date;
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.io.Serializable;
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
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;

@Entity
@Table(name = "doc_movimiento")
public class MovimientoDocumental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column(name = "estado")
    private String estado;

    @Column(name = "forma")
    private String forma;

    @Column(name = "nota_interna")
    private String notaInterna;

    @Column(name = "oficina_registro")
    private String oficinaRegistroOtro;

    @Column(name = "oficina_destino")
    private String oficinaDestinoOtro;

    @Column(name = "persona_destino")
    private String personaDestinoOtro;

    @Column(name = "estado_registro")
    private String estadoRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento")
    private Documento documento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_registro")
    private Oficina oficinaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_destino")
    private Persona personaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_registro")
    private Persona personaRegistro;

    @Column(name = "id_user_modificacion")
    private Long userModificacion;

    public MovimientoDocumental() {
    }

    public MovimientoDocumental(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getNotaInterna() {
        return notaInterna;
    }

    public void setNotaInterna(String notaInterna) {
        this.notaInterna = notaInterna;
    }

    public String getOficinaDestinoOtro() {
        return oficinaDestinoOtro;
    }

    public void setOficinaDestinoOtro(String oficinaDestinoOtro) {
        this.oficinaDestinoOtro = oficinaDestinoOtro;
    }

    public String getPersonaDestinoOtro() {
        return personaDestinoOtro;
    }

    public void setPersonaDestinoOtro(String personaDestinoOtro) {
        this.personaDestinoOtro = personaDestinoOtro;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getOficinaRegistroOtro() {
        return oficinaRegistroOtro;
    }

    public void setOficinaRegistroOtro(String oficinaRegistroOtro) {
        this.oficinaRegistroOtro = oficinaRegistroOtro;
    }

    public Oficina getOficinaRegistro() {
        return oficinaRegistro;
    }

    public void setOficinaRegistro(Oficina oficinaRegistro) {
        this.oficinaRegistro = oficinaRegistro;
    }

    public Oficina getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(Oficina oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public Persona getPersonaDestino() {
        return personaDestino;
    }

    public void setPersonaDestino(Persona personaDestino) {
        this.personaDestino = personaDestino;
    }

    public Persona getPersonaRegistro() {
        return personaRegistro;
    }

    public void setPersonaRegistro(Persona personaRegistro) {
        this.personaRegistro = personaRegistro;
    }

    public Long getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Long userModificacion) {
        this.userModificacion = userModificacion;
    }

}
