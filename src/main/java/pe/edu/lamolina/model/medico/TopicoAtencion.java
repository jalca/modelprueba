package pe.edu.lamolina.model.medico;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Persona;

@Entity
@Table(name = "med_topico_atencion")
public class TopicoAtencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hora")
    private String hora;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "inyectable")
    private String inyectable;

    @Column(name = "curacion")
    private Boolean curacion;

    @Column(name = "presion_arterial")
    private String presionArterial;

    @Column(name = "funcion_cardiaca")
    private String funcionCardiaca;

    @Column(name = "temperatura")
    private String temperatura;

    @Column(name = "sao2")
    private String sao2;

    @Column(name = "nebulizacion")
    private Boolean nebulizacion;

    @Column(name = "otras_atenciones")
    private String otrasAtenciones;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atencion_consultorio")
    private AtencionConsultorio atencionConsultorio;

    public TopicoAtencion() {
    }

    public TopicoAtencion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public AtencionConsultorio getAtencionConsultorio() {
        return atencionConsultorio;
    }

    public void setAtencionConsultorio(AtencionConsultorio atencionConsultorio) {
        this.atencionConsultorio = atencionConsultorio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInyectable() {
        return inyectable;
    }

    public void setInyectable(String inyectable) {
        this.inyectable = inyectable;
    }

    public Boolean getCuracion() {
        return curacion;
    }

    public void setCuracion(Boolean curacion) {
        this.curacion = curacion;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getFuncionCardiaca() {
        return funcionCardiaca;
    }

    public void setFuncionCardiaca(String funcionCardiaca) {
        this.funcionCardiaca = funcionCardiaca;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getSao2() {
        return sao2;
    }

    public void setSao2(String sao2) {
        this.sao2 = sao2;
    }

    public Boolean getNebulizacion() {
        return nebulizacion;
    }

    public void setNebulizacion(Boolean nebulizacion) {
        this.nebulizacion = nebulizacion;
    }

    public String getOtrasAtenciones() {
        return otrasAtenciones;
    }

    public void setOtrasAtenciones(String otrasAtenciones) {
        this.otrasAtenciones = otrasAtenciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
