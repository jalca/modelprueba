package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.PostulanteEstadoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_evaluado")
public class Evaluado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje_final")
    private BigDecimal puntajeFinal;

    @Column(name = "puntaje_rm")
    private BigDecimal puntajeRm;

    @Column(name = "puntaje_rv")
    private BigDecimal puntajeRv;

    @Column(name = "puntaje_matematicas")
    private BigDecimal puntajeMatematicas;

    @Column(name = "puntaje_fisica")
    private BigDecimal puntajeFisica;

    @Column(name = "puntaje_quimica")
    private BigDecimal puntajeQuimica;

    @Column(name = "puntaje_biologia")
    private BigDecimal puntajeBiologia;

    @Column(name = "orden_merito")
    private Integer ordenMerito;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "orden_atencion")
    private String ordenAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_ingreso")
    private Carrera carreraIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuario;

    public Evaluado() {
    }

    public Evaluado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(BigDecimal puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public BigDecimal getPuntajeRm() {
        return puntajeRm;
    }

    public void setPuntajeRm(BigDecimal puntajeRm) {
        this.puntajeRm = puntajeRm;
    }

    public BigDecimal getPuntajeRv() {
        return puntajeRv;
    }

    public void setPuntajeRv(BigDecimal puntajeRv) {
        this.puntajeRv = puntajeRv;
    }

    public BigDecimal getPuntajeMatematicas() {
        return puntajeMatematicas;
    }

    public void setPuntajeMatematicas(BigDecimal puntajeMatematicas) {
        this.puntajeMatematicas = puntajeMatematicas;
    }

    public BigDecimal getPuntajeFisica() {
        return puntajeFisica;
    }

    public void setPuntajeFisica(BigDecimal puntajeFisica) {
        this.puntajeFisica = puntajeFisica;
    }

    public BigDecimal getPuntajeQuimica() {
        return puntajeQuimica;
    }

    public void setPuntajeQuimica(BigDecimal puntajeQuimica) {
        this.puntajeQuimica = puntajeQuimica;
    }

    public BigDecimal getPuntajeBiologia() {
        return puntajeBiologia;
    }

    public void setPuntajeBiologia(BigDecimal puntajeBiologia) {
        this.puntajeBiologia = puntajeBiologia;
    }

    public Integer getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(Integer ordenMerito) {
        this.ordenMerito = ordenMerito;
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

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Carrera getCarreraIngreso() {
        return carreraIngreso;
    }

    public void setCarreraIngreso(Carrera carreraIngreso) {
        this.carreraIngreso = carreraIngreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getOrdenAtencion() {
        return ordenAtencion;
    }

    public void setOrdenAtencion(String ordenAtencion) {
        this.ordenAtencion = ordenAtencion;
    }

    public PostulanteEstadoEnum getEstadoEnum() {
        return PostulanteEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(PostulanteEstadoEnum estado) {
        this.estado = estado.name();
    }

    public static class CompareNombres implements Comparator<Evaluado> {

        @Override
        public int compare(Evaluado eva1, Evaluado eva2) {
            Persona pe1 = eva1.getPostulante().getPersona();
            Persona pe2 = eva2.getPostulante().getPersona();
            return pe1.getApellidosNombres().compareTo(pe2.getApellidosNombres());
        }
    }

    public static class CompareOMG implements Comparator<Evaluado> {

        @Override
        public int compare(Evaluado eva1, Evaluado eva2) {
            Integer ord1 = eva1.getOrdenMerito();
            Integer ord2 = eva2.getOrdenMerito();
            return ord1.compareTo(ord2);
        }
    }

    @Override
    public String toString() {
        return "Evaluado{" + "id=" + id + ", puntajeFinal=" + puntajeFinal + ", puntajeRm=" + puntajeRm + ", puntajeRv=" + puntajeRv + ", puntajeMatematicas=" + puntajeMatematicas + ", puntajeFisica=" + puntajeFisica + ", puntajeQuimica=" + puntajeQuimica + ", puntajeBiologia=" + puntajeBiologia + ", ordenMerito=" + ordenMerito + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", ordenAtencion=" + ordenAtencion + ", postulante=" + postulante + ", carreraIngreso=" + carreraIngreso + ", usuario=" + usuario + '}';
    }

}
